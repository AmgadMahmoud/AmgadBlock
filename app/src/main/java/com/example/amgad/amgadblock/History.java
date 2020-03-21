package com.example.amgad.amgadblock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
        TextView tv = findViewById(R.id.tvhistory);
        DBHelper db = new DBHelper(this);
        String messages = db.readMessages();
        if (messages.equals("")){
            tv.setText("no Blocked Messages yet");
        }
        else {
            tv.setText(messages);
        }
    }
}