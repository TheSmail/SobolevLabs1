package com.example.sobolev7lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "MESSAGE";
    EditText editText;
    EditText editText2;
    Button button;


    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String message = editText.getText().toString()+ " " + editText2.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void sendMessage2(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        if (editText.getText().toString()=="" || editText2.getText().toString()=="") {
            Toast.makeText(this,"Input text", Toast.LENGTH_LONG).show();
        }
        else {
            String message = editText.getText().toString() + editText2.getText().toString();
            String message2 = message+"("+message.length()+")";

            intent.putExtra(EXTRA_MESSAGE, message2);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editMessage);
        editText2 = findViewById(R.id.editMessage2);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage2(v);
            }
        });
    }
}
