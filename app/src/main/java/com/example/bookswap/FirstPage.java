package com.example.bookswap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        Button login = findViewById(R.id.btsignin);
        Button register = findViewById(R.id.btregister);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();
            }
        });
    }

    public void openLogin()
    {
        Intent login = new Intent(FirstPage.this,MainActivity.class);
        startActivity(login);
    }

    public void openRegister()
    {
        Intent register = new Intent(FirstPage.this,registerpage.class);
        startActivity(register);
    }
}
