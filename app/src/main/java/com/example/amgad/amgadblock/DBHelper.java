package com.example.amgad.amgadblock;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    DBHelper(Context ctx){
        super(ctx,"MyDB",null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table BlockedNumbers (id integer primary key , name text , phoneNumber text)");
        db.execSQL("create table BlockedKeywords (id integer primary key , keyword text)");
        db.execSQL("create table BlockedMessages (id integer primary key , message text, phoneNumber text , reason text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    void addMessage ( String Message, String phoneNumber, String reason){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("message",Message);
        cv.put("phoneNumber",phoneNumber);
        cv.put("reason",reason);
        db.insert("BlockedMessages",null,cv);
    }
    String readMessages (){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from BlockedMessages",null);
        String total="";
        while (c.moveToNext()){
            total += "Message: "+c.getString(1)+"\tfrom: "+c.getString(2)+"\tbecause: "+c.getString(3)+"\n";
        }
        return total;
    }
    void addNumber(String name, String phoneNumber){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("phoneNumber",phoneNumber);
        db.insert("BlockedNumbers",null,cv);
    }
    String readNumbers(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from BlockedNumbers",null);
        String total="";
        while (c.moveToNext()){
            total += c.getString(2)+"\n";
        }
        return total;
    }
    void addKeyword(String keyWord){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("keyword",keyWord);
        db.insert("BlockedKeywords",null,cv);
    }
    String readKeywords(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from BlockedKeywords",null);
        String total="";
        while (c.moveToNext()){
            total += c.getString(1)+"\n";
        }
        return total;
    }
}
