package com.example.cityguide.HelperClass.HomeAdapter;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cityguide.R;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoiresViewHolder>{

    ArrayList<CategoiresHelperClass> categoriesLocations;

    public CategoriesAdapter(ArrayList<CategoiresHelperClass> categoriesLocations) {
        this.categoriesLocations = categoriesLocations;
    }

    @NonNull
    @Override
    public CategoiresViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design, parent, false);
        CategoiresViewHolder categoiresViewHolder = new CategoiresViewHolder(view);
        return categoiresViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoiresViewHolder holder, int position) {

        CategoiresHelperClass categoiresHelperClass = categoriesLocations.get(position);

        holder.relativeLayout.setBackground(categoiresHelperClass.getGradientDrawable());
        holder.images.setImageResource(categoiresHelperClass.getImages());
        holder.categoiresTitle.setText(categoiresHelperClass.getTitle());

    }

    @Override
    public int getItemCount() {
        return categoriesLocations.size();
    }

    public static class CategoiresViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout relativeLayout;
        ImageView images;
        TextView categoiresTitle;

        public CategoiresViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.categoriesLayoutId);
            images = itemView.findViewById(R.id.categoriesImagesId);
            categoiresTitle = itemView.findViewById(R.id.categoriesHeadingId);
        }
    }
}
