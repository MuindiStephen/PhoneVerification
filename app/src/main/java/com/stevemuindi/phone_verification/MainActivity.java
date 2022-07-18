package com.stevemuindi.phone_verification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText phone_number;
    Button login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone_number = findViewById(R.id.phoneNo);
        login_btn = findViewById(R.id.login);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                String number = phone_number.getText().toString().trim();

                if (number.isEmpty() || number.length()<9){
                    phone_number.setError("");
                    phone_number.requestFocus();
                    return;
                }
                else {

                    String phoneNumber = number;
                    Intent intent = new Intent(MainActivity.this, VerificationActivity.class);
                    intent.putExtra("phonenumber", phoneNumber);
                    startActivity(intent);
                }
            }
        });



    }
}