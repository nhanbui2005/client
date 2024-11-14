package com.example.client.ui.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.client.R;
import com.example.client.ui.auth.login.LoginActivity;
import com.example.client.ui.auth.register.RegisterActivity;

public class Activity extends AppCompatActivity {
    private Button btn_DN,btn_DK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_);
        btn_DN = findViewById(R.id.button);
        btn_DK = findViewById(R.id.button2);

        btn_DN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btn_DK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentt = new Intent( Activity.this, RegisterActivity.class);
                startActivity(intentt);
            }
        });
    }
}