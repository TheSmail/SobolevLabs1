package com.example.donskoy_lab10;

import android.content.Intent;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2,btn3;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btnCall);
        btn2 = (Button) findViewById(R.id.btnLab);
        btn3 = (Button) findViewById(R.id.btnWeb);

        View.OnClickListener oclBtn = new View.OnClickListener() {
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.btnWeb:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://kubsau.ru"));
                        startActivity(intent);
                        break;

                    case R.id.btnLab:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=%D0%9A%D1%83%D0%B1%D0%93%D0%90%D0%A3&oq=%D0%9A%D1%83%D0%B1%D0%93%D0%90%D0%A3&aqs=chrome..69i57j0l5.5719j0j7&sourceid=chrome&ie=UTF-8"));
                        startActivity(intent);
                        break;

                    case R.id.btnCall:
                        intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:+79184567890"));
                        startActivity(intent);
                        break;
                }
            }
        };

        btn1.setOnClickListener(oclBtn);
        btn2.setOnClickListener(oclBtn);
        btn3.setOnClickListener(oclBtn);


    }


}
