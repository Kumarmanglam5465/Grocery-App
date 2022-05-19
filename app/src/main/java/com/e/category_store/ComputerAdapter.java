package com.e.category_store;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

public class ComputerAdapter extends RecyclerView.Adapter<ComputerAdapter.ViewHolder> {
    int[] image={R.drawable.c,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,R.drawable.c6,R.drawable.c7,R.drawable.c1};
    String[] name={"Laptop","Moniter","Headphone","Wireless Earphone","Earphone","Desktop","Watches","Mouse"};
    String[] price={"50000","10000","2000","1500","500","15000","7000","250"};
    Context c;
      int i;


    public ComputerAdapter(FragmentActivity activity) {
        c=activity;
    }

    @NonNull
    @Override
    public ComputerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View v=inflater.inflate(R.layout.custom_computer_design,parent,false);
       ViewHolder vh=new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ComputerAdapter.ViewHolder holder, final int position) {
        holder.img.setBackgroundResource(image[position]);
        holder.n.setText(name[position]);
        holder.p.setText(price[position]);
        holder.b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c.startActivity(new Intent(c,Payment.class));
            }
        });

        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                Toast.makeText(c, i+"", Toast.LENGTH_SHORT).show();
                holder.q.setText(i+"");
                holder.p.setText((Integer.parseInt(price[position])*i)+"");
            }
        });
        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i>1) {
                    i--;
                    holder.q.setText(i + "");
                    holder.p.setText((Integer.parseInt(price[position])*i)+"");
                }
            }
        });
        holder.b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(c,Payment.class);
                i.putExtra("price",holder.p.getText().toString());
                i.putExtra("Name",name[position]+"");
                c.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView n,q;
        TextView p;
        Button b,plus,minus;
        public ViewHolder(@NonNull View v) {
            super(v);
            img=v.findViewById(R.id.imageView3);
            n=v.findViewById(R.id.textView3);
            p=v.findViewById(R.id.textView4);
            b=v.findViewById(R.id.button);
            plus=v.findViewById(R.id.plus);
            minus=v.findViewById(R.id.minus);
            q=v.findViewById(R.id.quantity);
        }
    }
}
