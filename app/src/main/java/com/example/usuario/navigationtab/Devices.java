package com.example.usuario.navigationtab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Devices extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devices);
        Button B_nav = (Button) findViewById(R.id.B_nav);
        B_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent draw = new Intent(Devices.this, MainActivity.class);
                startActivity(draw);

            }
        });
    }
}
