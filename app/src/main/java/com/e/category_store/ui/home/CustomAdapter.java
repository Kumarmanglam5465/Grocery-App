package com.e.category_store.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.e.category_store.Computer;
import com.e.category_store.R;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    int[] image={R.drawable.cmain,R.drawable.emain,R.drawable.bmain,R.drawable.watermelon};
    String[] name={"Computer","Electronics","Books","Daily products"};
    Context c;


    public CustomAdapter(FragmentActivity activity) {
        c=activity;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View v=inflater.inflate(R.layout.custom_design,parent,false);
       ViewHolder vh=new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, final int position) {
        holder.img.setBackgroundResource(image[position]);
        holder.n.setText(name[position]);
    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView n;
        public ViewHolder(@NonNull View v) {
            super(v);
            img=v.findViewById(R.id.imageView2);
            n=v.findViewById(R.id.textView2);
        }
    }
}
