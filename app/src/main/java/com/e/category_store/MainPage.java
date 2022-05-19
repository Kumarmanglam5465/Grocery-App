package com.e.category_store;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;


import com.e.category_store.ui.home.HomeFragment;
import com.google.android.material.textfield.TextInputEditText;

public class MainPage extends AppCompatActivity {
    TextInputEditText email,pass;
    Button login,forget;
    CheckBox remember;
    TextView textView;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.email_id);
        pass=findViewById(R.id.password);
        login=findViewById(R.id.login);
        remember=findViewById(R.id.remember);
        textView=findViewById(R.id.textView);
        forget=findViewById(R.id.forget);

        preferences=getSharedPreferences("Customer_Details", Context.MODE_PRIVATE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String e=email.getText().toString();
                String p=pass.getText().toString();

                String E=preferences.getString("Email","");
                String P=preferences.getString("Password","");

                if(e.equalsIgnoreCase(E)  && p.equals(P))
                {
                    startActivity(new Intent(MainPage.this, HomeFragment.class));
                }
                else
                {
                    Toast.makeText(MainPage.this, "Data Not Found", Toast.LENGTH_SHORT).show();
                }


            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainPage.this,Registration.class));
            }
        });
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainPage.this,Forget.class));
            }
        });
        remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });

    }
}