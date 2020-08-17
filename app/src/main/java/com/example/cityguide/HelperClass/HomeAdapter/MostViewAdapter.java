package com.example.cityguide.HelperClass.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cityguide.R;

import java.util.ArrayList;

public class MostViewAdapter extends RecyclerView.Adapter<MostViewAdapter.MostViewHolder> {

    ArrayList<MostviewHelperClass> mostviewLocations;

    public MostViewAdapter(ArrayList<MostviewHelperClass> mostviewLocations) {
        this.mostviewLocations = mostviewLocations;
    }

    @NonNull
    @Override
    public MostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewed_card_design, parent, false);
        MostViewHolder mostViewHolder = new MostViewHolder(view);
        return mostViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewHolder holder, int position) {
        MostviewHelperClass mostviewHelperClass = mostviewLocations.get(position);

        holder.images.setImageResource(mostviewHelperClass.getImages());
        holder.mostViewTitle.setText(mostviewHelperClass.getTitle());
        holder.mostViewDesc.setText(mostviewHelperClass.getDescription());

    }

    @Override
    public int getItemCount() {
        return mostviewLocations.size();
    }

    public static class MostViewHolder extends RecyclerView.ViewHolder{
        ImageView images;
        TextView mostViewTitle, mostViewDesc;

        public MostViewHolder(@NonNull View itemView) {
            super(itemView);
            images = itemView.findViewById(R.id.mostviewdImageId);
            mostViewTitle = itemView.findViewById(R.id.mostviewHeadingId);
            mostViewDesc = itemView.findViewById(R.id.mostviewCardDescId);

        }


    }
}
