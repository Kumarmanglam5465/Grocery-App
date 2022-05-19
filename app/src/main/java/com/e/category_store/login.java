package com.e.category_store;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class login extends AppCompatActivity {
 EditText phone;
 Button get_otp;
 FirebaseAuth mAuth;
    private String Id="";
    FirebaseUser user;
    SharedPreferences.Editor editor;
    String Mobilenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        phone=findViewById(R.id.editTextPhone);
        get_otp=findViewById(R.id.button2);
       mAuth=FirebaseAuth.getInstance();
       editor=getSharedPreferences("storage",MODE_PRIVATE).edit();
       try {
          SharedPreferences data =getSharedPreferences("storage",MODE_PRIVATE);
           String d=data.getString("key","");
           if(d!=null)
           {
               startActivity(new Intent(login.this,MainActivity.class));
           }
       }catch (Exception e){

       }

        
        get_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobile=phone.getText().toString();
                Mobilenumber=mobile;
              verification(mobile);
              phone.setText("");

            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code=phone.getText().toString();
                verifycode(code);
            }
        });
    }

    private void verifycode(String code) {
        PhoneAuthCredential credential=PhoneAuthProvider.getCredential(Id,code);
        signInWithPhoneAuthCredential(credential);
    }

    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

         @Override
         public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String code=phoneAuthCredential.getSmsCode();
             if(code!=null){
                 phone.setText(code);

             }
                 
         }

         @Override
         public void onVerificationFailed(FirebaseException e) {
            Log.d("Error",e+"");
         }

         @Override
         public void onCodeSent(@NonNull String verificationId,
                                @NonNull PhoneAuthProvider.ForceResendingToken token) {

           super.onCodeSent(verificationId,token);
           Id=verificationId;
         }
     };



    private void verification(String mobile) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91"+mobile,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks
    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("signInWithCredential","success");

                             user = task.getResult().getUser();
                            editor.putString("key",Mobilenumber);
                            editor.apply();
                            startActivity(new Intent(login.this,MainActivity.class));
                            finish();
                            // ...
                        } else {
                            // Sign in failed, display a message and update the UI
                            Log.w( "signInWithCredential","failure", task.getException());
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                            }
                        }
                    }
                });
    }

}