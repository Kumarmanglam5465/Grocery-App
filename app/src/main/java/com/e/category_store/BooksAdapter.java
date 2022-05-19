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

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {
    int[] image={R.drawable.b1,R.drawable.b2,R.drawable.b3,R.drawable.b4,R.drawable.b5,R.drawable.b6,R.drawable.b7,R.drawable.b8,};
    String[] name={"The Top Ten","The Notebooks","The Secret","Rohinton Mistry","Harry Potter","The Guest List","Royal Hoiday","The Kite Runner"};
    String[] price={"200","100","120","250","500","50","350","290"};
    Context c;
      int i;


    public BooksAdapter(FragmentActivity activity) {
        c=activity;
    }

    @NonNull
    @Override
    public BooksAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View v=inflater.inflate(R.layout.custom_computer_design,parent,false);
       ViewHolder vh=new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final BooksAdapter.ViewHolder holder, final int position) {
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
