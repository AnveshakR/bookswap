package com.example.bookswap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registerpage extends AppCompatActivity {

    databaseHelper myDB;
    private Button submit;
    private EditText name, email, password, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);
        myDB = new databaseHelper(this);
        name = (EditText)findViewById(R.id.etname);
        phone = (EditText)findViewById(R.id.etphone);
        email = (EditText)findViewById(R.id.etemail);
        password = (EditText)findViewById(R.id.etpassword);
        submit = (Button)findViewById(R.id.btsubmit);
        Submit();
    }

    public void Submit(){
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean submission = myDB.submit(name.getText().toString(),phone.getText().toString(),email.getText().toString(),password.getText().toString());
                if (submission){

                    Toast.makeText(registerpage.this, "Registration successful, login again",Toast.LENGTH_LONG).show();
                    Intent registertologin = new Intent(registerpage.this,MainActivity.class);
                    startActivity(registertologin);
                }

                else
                    Toast.makeText(registerpage.this, "Registration unsuccessful, try again",Toast.LENGTH_LONG).show();
            }
        });
    }
}
