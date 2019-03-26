package com.example.donskoy_lab8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvName;
    Button btnName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         tvName = (TextView) findViewById(R.id.tvName);
         btnName = (Button) findViewById(R.id.btnName);
        btnName.setOnClickListener(this);

    }

    public  void onClick(View v) {
        Intent intent = new Intent(this, NameActivity.class);
        startActivityForResult(intent,1);

       }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(data==null) {
            return;
        }
        if (TextUtils.isEmpty(data.getStringExtra("name")))
            tvName.setText("Ваше имя: Отсутсвует");
        else{
            String name = data.getStringExtra("name");
            tvName.setText("Ваше имя: " + name);
        }

        }


}

