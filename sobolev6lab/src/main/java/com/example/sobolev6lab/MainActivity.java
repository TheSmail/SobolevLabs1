package com.example.sobolev6lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvOut;
    Button btnOk;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    tvOut = (TextView) findViewById(R.id.tvOut);
    btnCancel = (Button) findViewById(R.id.btnCancel);
    btnOk = (Button) findViewById(R.id.btnOk);

    /* View.OnClickListener oclBtnOk = new View.OnClickListener() {
        public void onClick(View v) {
            tvOut.setText("Нажата кнопка ОК");
        }
    };

    btnOk.setOnClickListener(oclBtnOk);

    View.OnClickListener oclBtnCancel = new View.OnClickListener() {
        public void onClick(View v) {
            tvOut.setText("Нажата кнопка Cancel");
        }
    };

    btnCancel.setOnClickListener(oclBtnCancel); */

        View.OnClickListener oclBtn = new View.OnClickListener() {
            public void onClick(View v) {

                switch (v.getId()){
                    case R.id.btnCancel:
                        tvOut.setText("Нажата кнопка Cancel");
                        break;
                    case R.id.btnOk:
                        tvOut.setText("Нажата кнопка OK");
                        break;
                }
            }
        };

        btnCancel.setOnClickListener(oclBtn);
        btnOk.setOnClickListener(oclBtn);

    }
}
