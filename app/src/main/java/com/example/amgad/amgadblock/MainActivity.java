package com.example.amgad.amgadblock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void functionBlockPhoneNumber(View v){
        Intent i = new Intent(this,BlockNumber.class);
        startActivity(i);
    }
    public void functionBlockKeyword(View v){
        Intent i = new Intent(this,BlockKeyword.class);
        startActivity(i);
    }
    public void functionHistory(View v){
        Intent i = new Intent(this,History.class);
        startActivity(i);
    }
}
