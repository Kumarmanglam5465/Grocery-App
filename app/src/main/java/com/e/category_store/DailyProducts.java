package com.e.category_store;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.e.category_store.ui.home.RecyclerItemClick;

public class DailyProducts extends AppCompatActivity {
    RecyclerView product;
    int[] image={R.drawable.discount,R.drawable.fruitsale};
    String[] name={"Banana","fruits"};
    String[] price={"50","100"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);
        product=findViewById(R.id.RecyclerView2);
        DailyProductsAdapter ca=new DailyProductsAdapter(this);
        product.setHasFixedSize(true);
        product.setLayoutManager(new LinearLayoutManager(this));
        product.setAdapter(ca);


    }
}