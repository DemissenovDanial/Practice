const express = require('express');
const bodyParser = require('body-parser');
const { MongoClient, ObjectId } = require('mongodb');

const app = express();
const port = 3000;

// Middleware
app.use(bodyParser.json());

// MongoDB Connection URL
const url = 'mongodb://localhost:27017';
const dbName = 'plantsdb';

// Connect to MongoDB
let db;
MongoClient.connect(url, { useNewUrlParser: true, useUnifiedTopology: true }, (err, client) => {
    if (err) {
        console.error('Failed to connect to MongoDB:', err);
        return;
    }
    console.log('Connected successfully to MongoDB');
    db = client.db(dbName);
});

// API routes
app.get('/plants', (req, res) => {
    db.collection('plants').find().toArray((err, result) => {
        if (err) {
            console.error('Error fetching plants:', err);
            res.status(500).send('Failed to fetch plants');
            return;
        }
        res.json(result);
    });
});

app.post('/plants', (req, res) => {
    const { name, description, imageUrl } = req.body;
    const newPlant = { name, description, imageUrl };

    db.collection('plants').insertOne(newPlant, (err, result) => {
        if (err) {
            console.error('Error inserting plant:', err);
            res.status(500).send('Failed to insert plant');
            return;
        }
        res.status(201).json(result.ops[0]);
    });
});

// Start server
app.listen(port, () => {
    console.log(`Server running at http://localhost:${port}`);
});
