package com.example.activityexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txtMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMessage = findViewById(R.id.btnMessage);
        Button btnSecond = findViewById(R.id.btnSecond);
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("btnSecond Click","successfull");
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("MESSAGE", txtMessage.getText().toString());
                startActivityForResult(intent,0);
            }
        });
        Button btnThird = findViewById(R.id.btnThird);
        btnThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("btnThird Click","successfull");
                Intent intent = new Intent(MainActivity.this,ThirdActivity.class);
                startActivityForResult(intent,1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0 ){
            Log.d("VALUE","" + data.getIntExtra("VALUE",0));
            txtMessage.setText("" + data.getIntExtra("VALUE",0));
        }
    }
}