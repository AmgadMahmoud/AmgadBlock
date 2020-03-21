package com.example.amgad.amgadblock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ViewBlockedNumbers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_blocked_numbers);
        String nums="";
        nums = getIntent().getStringExtra("numbers");
        TextView tv = findViewById(R.id.tvNumbers);
        if (nums.equals("")){
            tv.setText("no Blocked Numbers yet");
        }
        else {
            tv.setText(nums);
        }
    }
}
