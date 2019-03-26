package com.example.donskoy_lab122;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textUrl = (TextView) findViewById(R.id.textUrl);

        (findViewById(R.id.btnWeb)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = textUrl.getText().toString();

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + url)));

            }
        });
    }
}
