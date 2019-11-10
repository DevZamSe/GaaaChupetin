package com.kaito.parte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class creacuenta extends AppCompatActivity {

    Button textView11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creacuenta);

        textView11 = (Button) findViewById(R.id.textView11);
        textView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(creacuenta.this, MainActivity1.class);
                startActivity(login);
                finish();
            }
        });
    }
}
