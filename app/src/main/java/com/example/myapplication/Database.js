const express = require('express');
const bodyParser = require('body-parser');
const { MongoClient, ObjectId } = require('mongodb');

const app = express();
const port = 3000;

app.use(bodyParser.json());

const url = 'mongodb://localhost:27017';
const dbName = 'plantsdb';

let db;
MongoClient.connect(url, { useNewUrlParser: true, useUnifiedTopology: true }, (err, client) => {
    if (err) {
        console.error('Failed to connect to MongoDB:', err);
        return;
    }
    console.log('Connected successfully to MongoDB');
    db = client.db(dbName);
});

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

app.listen(port, () => {
    console.log(`Server running at http://localhost:${port}`);
});
