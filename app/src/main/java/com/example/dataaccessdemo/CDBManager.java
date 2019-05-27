package com.example.dataaccessdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CDBManager extends SQLiteOpenHelper {

    public CDBManager(Context context) {
        super(context, "dbDemo.db", null   , 1);

    }

    //刪除資料表必須指定資料表＋指定primary key,才能刪除那一筆資料
    public void delete(String tableName, int id){
        getWritableDatabase().insert(tableName,"_id ="+String.valueOf(id),null);
    }

    //修改資料
    public void upodate(String tableName, ContentValues data,int id) {
        getWritableDatabase().update(tableName, data, "_id =" + String.valueOf(id), null);
    }

    //新增資料
    public void insert(String tableName, ContentValues data){
        getWritableDatabase().insert(tableName,null,data);
    }


    public Cursor getBySql (String sql){
        return getReadableDatabase().rawQuery(sql,null);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create table tCustomer ( _id integer primary key, fId text not null, fName text, fPhone  text, fEmail text, fAddress text)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
