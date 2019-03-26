package com.example.donskoy_lab9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textLive;
    Button btnAfterStart, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate()", Toast.LENGTH_LONG).show();

        textLive = (TextView) findViewById(R.id.textLive);
        btnAfterStart = (Button) findViewById(R.id.btnAfterStart);
        btnExit = (Button) findViewById(R.id.btnExit);


        View.OnClickListener oclBtn = new View.OnClickListener() {
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.btnAfterStart: textLive.setText("Приложение запущено впервые"); break;
                    case R.id.btnExit: finish(); break;
                }

            }
        };

        btnAfterStart.setOnClickListener(oclBtn);
        btnExit.setOnClickListener(oclBtn);

    }

    protected  void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy()", Toast.LENGTH_LONG).show();
    }

    protected  void onPause() {
        super.onPause();
        Toast.makeText(this,"onPause()", Toast.LENGTH_LONG).show();
    }

    protected  void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart()", Toast.LENGTH_LONG).show();
        textLive.setText("onRestart");

    }

    protected  void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart()", Toast.LENGTH_LONG).show();
    }

    protected  void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume()", Toast.LENGTH_LONG).show();
    }

    protected  void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop()", Toast.LENGTH_LONG).show();
    }



}
