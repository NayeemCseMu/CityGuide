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

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder> {

    ArrayList<FeaturedHelperClass> featureLocations;

    public FeaturedAdapter(ArrayList<FeaturedHelperClass> featuredHelper) {
        this.featureLocations = featuredHelper;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_design, parent, false);
        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);
        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {
        FeaturedHelperClass featuredHelperClass = featureLocations.get(position);

        holder.images.setImageResource(featuredHelperClass.getImages());
        holder.title.setText(featuredHelperClass.getTitle());
        holder.desc.setText(featuredHelperClass.getDescription());
    }

    @Override
    public int getItemCount() {
        return featureLocations.size();
    }

    public static class FeaturedViewHolder extends RecyclerView.ViewHolder{

        ImageView images;
        TextView title, desc;
        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);

            images = itemView.findViewById(R.id.featuredCardImageId);
            title = itemView.findViewById(R.id.featuredCardHeadingId);
            desc = itemView.findViewById(R.id.featuredCardDescId);
        }
    }
}
