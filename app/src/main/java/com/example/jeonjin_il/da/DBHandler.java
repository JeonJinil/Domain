package com.example.jeonjin_il.da;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by jeonjin-il on 2017. 5. 27..
 */

public class DBHandler extends SQLiteOpenHelper{
    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE LIFT( lift_id INTEGER PRIMARY KEY AUTOINCREMENT, lift_name TEXT," +
                " lift_level INTEGER, lift_length INTEGER, lift_speed INTEGER )");
        db.execSQL("CREATE TABLE TIMEBLOCK( lift_id INTEGER , time REAL, capacity INTEGER )");
        db.execSQL("CREATE TABLE TICKETPRICE( day TEXT PRIMARY KEY,price1 INTEGER, price2 INTEGER, price3 INTGER )");
//        db.execSQL("CREATE TABLE USER ( user_key INTEGER PRIMARAY KEY AUTOINCREMENT, user_id TEXT , user_pw TEXT )");
    }

    public void Lift_Insert(String liftname , int liftlevel,int liftlength,int liftspeed){
        SQLiteDatabase db = getReadableDatabase();
        db.execSQL("INSERT INTO LIFT VALUES (null, '" + liftname + "' , "+liftlevel + " , "+liftlength + " , "+ liftspeed+ ");");
        db.close();
    }

    public ArrayList<Lift> getLiftByLevel(int level){
        ArrayList<Lift> ret = new ArrayList<Lift>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM LIFT WHERE lift_level = "+level,null);
        while(cursor.moveToNext())
            ret.add( new Lift(cursor.getInt(0),cursor.getInt(2),cursor.getString(1),cursor.getInt(3),cursor.getInt(4),getTimeBlock(cursor.getInt(0))));
        return ret;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean needInti() {
        SQLiteDatabase db= getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM LIFT ",null);
        while(cursor.moveToNext())
            return false;
        return true;
    }

    public void TimeBlock_Insert(int i, float j, int capacity) {
        SQLiteDatabase db = getReadableDatabase();
        if((int)j != j) {
            int t= (int)j;
            j = (float)t + (float)0.30;
        }
        db.execSQL("INSERT INTO TIMEBLOCK VALUES ( "+ i + ", " + j +"," + capacity +")" );
        db.close();
    }
    public void ticketPrice_Insert(String day,int price1,int price2,int price3){
        SQLiteDatabase db = getReadableDatabase();
        db.execSQL("INSERT INTO TICKETPRICE VALUES ( '"+ day + "' , " + price1 +"," + price2 +", + "+price3+")" );
        db.close();
    }

    public ArrayList<TimeBlock> getTimeBlock(int liftNum) {
        ArrayList<TimeBlock> ret = new ArrayList<TimeBlock>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM TIMEBLOCK WHERE lift_id = "+ liftNum ,null);
        while(cursor.moveToNext())
            ret.add( new TimeBlock(cursor.getFloat(1),cursor.getInt(2)));
        return ret;
    }

    public void increase(int capacity,int liftNum, float time) {
        SQLiteDatabase db = getReadableDatabase();
        db.execSQL("UPDATE TIMEBLOCK SET capacity = "+ capacity+" WHERE lift_id = " +liftNum +" AND time="+time );
        db.close();
    }

    public ArrayList<TicketPrice> getTicketDescription() {
        ArrayList<TicketPrice> ret = new ArrayList<TicketPrice>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM TICKETPRICE " ,null);
        while(cursor.moveToNext())
            ret.add( new TicketPrice(cursor.getString(0),cursor.getInt(1),cursor.getInt(2),cursor.getInt(3)));
        db.close();
        return ret;
    }
}