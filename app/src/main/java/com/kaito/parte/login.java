package com.kaito.parte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login extends AppCompatActivity {

    Button crearcuenta;
    Button ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        crearcuenta = (Button) findViewById(R.id.crearcuenta);
        crearcuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(login.this, creacuenta.class);
                startActivity(login);
            }
        });

        ingresar = (Button) findViewById(R.id.ingresar);
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(login.this, MainActivity1.class);
                startActivity(login);
                finish();
            }
        });

    }
}
