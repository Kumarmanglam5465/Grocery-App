package com.e.category_store;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class Forget extends AppCompatActivity {
    TextInputEditText phone,otp;
    Button send,submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        phone=findViewById(R.id.code);
        otp=findViewById(R.id.otp);
        send=findViewById(R.id.send);
        submit=findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent (Forget.this,MainActivity.class));
            }
        });

    }
}