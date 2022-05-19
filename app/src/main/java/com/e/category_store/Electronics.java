package com.e.category_store;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.e.category_store.ui.home.RecyclerItemClick;

public class Electronics extends AppCompatActivity {

    RecyclerView product;
    int[] image={R.drawable.e1,R.drawable.e2,R.drawable.e3,R.drawable.e4,R.drawable.e5,R.drawable.e6,R.drawable.e7,};
    String[] name={"Iron","Kettle","Bulb","Weighing Machine","Alarm Clock","Electronic Safe","Egg Boiler"};
    String[] price={"1500","700","90","400","150","5000","300"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);
        product=findViewById(R.id.RecyclerView2);
        ElectronicsAdapter e=new ElectronicsAdapter(this);
        product.setHasFixedSize(true);
        product.setLayoutManager(new LinearLayoutManager(this));
        product.setAdapter(e);

    }
}