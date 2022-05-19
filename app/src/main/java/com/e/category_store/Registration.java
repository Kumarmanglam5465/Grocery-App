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

import com.google.android.material.textfield.TextInputEditText;

public class Registration extends AppCompatActivity {
    TextInputEditText email,password,name;
    Button register;
    TextView textView;
    CheckBox remember;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        preferences=getSharedPreferences("Customer_Details", Context.MODE_PRIVATE);

        email=findViewById(R.id.email_id);
        password=findViewById(R.id.password);
        name=findViewById(R.id.name);
        register=findViewById(R.id.login);
        remember=findViewById(R.id.remember);

        remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String n=name.getText().toString();
                String e=email.getText().toString();
                String p=password.getText().toString();

                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("Name",n);
                editor.putString("Email",e);
                editor.putString("Password",p);
                editor.commit();

                startActivity(new Intent(Registration.this,MainActivity.class));
            }
        });
    }
}