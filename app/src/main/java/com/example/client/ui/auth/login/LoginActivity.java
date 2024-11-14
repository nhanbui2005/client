package com.example.client.ui.auth.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.client.R;
import com.example.client.ui.LandingActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText edt_email,edt_password;
    private Button btn_DN;
    private TextView txt_forgotter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        edt_email = findViewById(R.id.et_email);
        edt_password = findViewById(R.id.et_password);
        btn_DN = findViewById(R.id.btn_login);
        txt_forgotter = findViewById(R.id.textView2);

        btn_DN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edt_email.getText().toString();
                String password = edt_password.getText().toString();

                if(username.equals("admin") && password.equals("12345")){
                    Toast.makeText(LoginActivity.this, "dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, LandingActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this, "dang nhap that bai", Toast.LENGTH_SHORT).show();
                }
            }
        });

        txt_forgotter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}