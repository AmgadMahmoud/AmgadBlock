package com.example.amgad.amgadblock;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BlockNumber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.block_number);
    }
    public void functionAddNumber(View v){
        DBHelper db = new DBHelper(this);
        EditText ename = findViewById(R.id.editText_Name);
        String name = ename.getText().toString();
        EditText enumber = findViewById(R.id.editText_Phone);
        String number = enumber.getText().toString();
        if (name.equals("") || number.equals("")){
            Toast.makeText(this,"Please enter a valid name and phone number",Toast.LENGTH_LONG).show();
        }
        else {
            db.addNumber(name,number);
            ename.setText("");
            enumber.setText("");
            Toast.makeText(this,"Number has added successfully",Toast.LENGTH_LONG).show();
        }
    }
    public void functionReadAllNumbers(View v){
        DBHelper db = new DBHelper(this);
        String numbers = db.readNumbers();
        Intent i = new Intent(this,ViewBlockedNumbers.class);
        i.putExtra("numbers",numbers);
        startActivity(i);
    }
}
