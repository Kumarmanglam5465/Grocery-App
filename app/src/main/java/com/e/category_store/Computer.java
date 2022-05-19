package com.e.category_store;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.e.category_store.ui.home.CustomAdapter;
import com.e.category_store.ui.home.RecyclerItemClick;

public class Computer extends AppCompatActivity {
 RecyclerView product;
    int[] image={R.drawable.c,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,R.drawable.c6,R.drawable.c7,R.drawable.c1};
    String[] name={"Laptop","Moniter","Headphone","Wireless Earphone","Earphone","Desktop","Watches","Mouse"};
    String[] price={"50000","10000","2000","1500","500","15000","7000","250"};

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);
      product=findViewById(R.id.RecyclerView2);
        ComputerAdapter ca=new ComputerAdapter(this);
        product.setHasFixedSize(true);
        product.setLayoutManager(new LinearLayoutManager(this));
        product.setAdapter(ca);


    }
}