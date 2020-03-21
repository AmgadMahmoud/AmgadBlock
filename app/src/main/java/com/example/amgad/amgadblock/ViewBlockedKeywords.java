package com.example.amgad.amgadblock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ViewBlockedKeywords extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_blocked_keywords);
        String words="";
        words = getIntent().getStringExtra("keywords");
        TextView tv = findViewById(R.id.tvWords);
        if (words.equals("")){
            tv.setText("no Blocked Keywords yet");
        }
        else {
            tv.setText(words);
        }
    }
}
