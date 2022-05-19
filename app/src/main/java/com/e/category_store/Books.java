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

public class Books extends AppCompatActivity {
    RecyclerView product;
    int[] image={R.drawable.b1,R.drawable.b2,R.drawable.b3,R.drawable.b4,R.drawable.b5,R.drawable.b6,R.drawable.b7,R.drawable.b8,};
    String[] name={"The Top Ten","The Notebooks","The Secret","Rohinton Mistry","Harry Potter","The Guest List","Royal Hoiday","The Kite Runner"};
    String[] price={"200","100","120","250","500","50","350","290"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);
        product=findViewById(R.id.RecyclerView2);
        BooksAdapter ca=new BooksAdapter(this);
        product.setHasFixedSize(true);
        product.setLayoutManager(new LinearLayoutManager(this));
        product.setAdapter(ca);

    }
}