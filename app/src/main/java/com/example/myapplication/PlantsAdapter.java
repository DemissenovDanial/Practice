package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class PlantsAdapter extends RecyclerView.Adapter<PlantsAdapter.ProductViewHolder> {
    private Context context;
    private ArrayList<Plants> plantsList;

    public PlantsAdapter(Context context, ArrayList<Plants> plantsList) {
        this.context = context;
        this.plantsList = plantsList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Plants plants = plantsList.get(position);
        holder.textViewName.setText(plants.getName());
        holder.textViewDescription.setText(plants.getDescription());
        holder.imageView.setImageResource(plants.getImageResource());
    }

    @Override
    public int getItemCount() {
        return plantsList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewDescription;
        ImageView imageView;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
