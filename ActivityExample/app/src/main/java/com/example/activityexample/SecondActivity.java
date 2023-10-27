package com.example.activityexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        TextView txt = findViewById(R.id.textView);
        if(intent != null){
            Log.d("Message",intent.getStringExtra("MESSAGE"));
            txt.setText(intent.getStringExtra("MESSAGE"));

        }
        Button btnClose = findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("VALUE",123);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}