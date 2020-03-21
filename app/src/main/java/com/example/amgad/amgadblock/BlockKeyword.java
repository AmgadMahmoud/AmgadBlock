package com.example.amgad.amgadblock;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BlockKeyword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.block_keyword);
    }
    public void functionAddKeyword(View v){
        DBHelper db = new DBHelper(this);
        EditText ekeyword = findViewById(R.id.editText_Keyword);
        String keyword = ekeyword.getText().toString();
        if (keyword.equals("")) {
            Toast.makeText(this, "Please enter a valid Keyword", Toast.LENGTH_LONG).show();
        }
        else {
            db.addKeyword(keyword);
                ekeyword.setText("");
                Toast.makeText(this,"Keyword has added successfully",Toast.LENGTH_LONG).show();
        }
    }
    public void functionReadAllKeywords(View v){
        DBHelper db = new DBHelper(this);
        String keywords = db.readKeywords();
        Intent i = new Intent(this,ViewBlockedKeywords.class);
        i.putExtra("keywords",keywords);
        startActivity(i);
    }
}
