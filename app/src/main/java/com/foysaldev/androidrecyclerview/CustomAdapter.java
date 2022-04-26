package com.foysaldev.androidrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import de.hdodenhof.circleimageview.CircleImageView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private static ClickListener clickListener;
    Context context;
    String [] mymensinghDistrict , population;
    int [] icon;

    public CustomAdapter(Context context, String[] mymensinghDistrict, String[] population, int[] icon) {
        this.context = context;
        this.mymensinghDistrict = mymensinghDistrict;
        this.population = population;
        this.icon = icon;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.sample_layout,parent,false);
        return new MyViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.upazila.setText(mymensinghDistrict[position]);
        holder.population.setText(population[position]);

        Glide.with(holder.imageView.getContext())
                .load(icon[position])
                .placeholder(R.mipmap.ic_launcher_round)
                .centerCrop()
                .error(R.mipmap.ic_launcher_round)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return population.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        TextView upazila, population, description;
        CircleImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            upazila = itemView.findViewById(R.id.upazilaId);
            population = itemView.findViewById(R.id.populationId);
            description = itemView.findViewById(R.id.descriptionId);
            imageView = itemView.findViewById(R.id.imgId);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(getAdapterPosition(),view);
        }

        @Override
        public boolean onLongClick(View view) {
            clickListener.onItemLongClick(getAdapterPosition(),view);
            return false;
        }
    }

    public interface ClickListener {
        void onItemClick (int position , View view);
        void onItemLongClick (int position, View view);
    }
    public void setOnItemClickListener (ClickListener clickListener) {
        CustomAdapter.clickListener = clickListener;
    }

}
