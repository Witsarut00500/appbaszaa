package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;




public class MemOpenHelper<balance, primary> extends SQLiteOpenHelper{
    //ประกาศตัวแปร
    public static final String DBNAME = "my_calandburn.db";
    private static final int DBVERSION = 1;
    // กรณีสร้างตารางชื่อว่า tbmemory เพียง 1 ตาราง
    private static final String MEMORY_TABLE = "create table tbmemory (_id integer primary key, " +
            "title text, " +
            "detail text, " +
            "date text);";



    private SQLiteDatabase writeSQLite, readSQLite;
    // ประกาศตัวแปรสำหรับอ้างอิงเพื่อสะดวกในการจัดการกับตาราง tbmemory
    public static final String TBMEMORY = "tbmemory";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DETAIL = "detail";
    public static final String COLUMN_DATE = "date";

    public MemOpenHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
        writeSQLite = this.getWritableDatabase();
        readSQLite = this.getReadableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
// คำสั่งให้สร้างตารางและเพิ่มระเบียนในตาราง memory
        db.execSQL(MEMORY_TABLE);
        db.execSQL("INSERT INTO tbmemory(title,detail,date)VALUES('title๑','รายละเอียด','30-07-2017');");
        db.execSQL("INSERT INTO tbmemory(title, detail, date) VALUES ('ชื่อเรื่อง','รายละเอียด', '30-07-2017');");
        db.execSQL("INSERT INTO tbmemory(title, detail, date) VALUES('title2','รายละเอียด', '30-07-2017');");
        db.execSQL("INSERT INTO tbmemory(title, detail, date) VALUES ('ชื่อเรื่อง2','รายละเอียด', '30-07-2017');");
        db.execSQL("INSERT INTO tbmemory(title, detail, date) VALUES ('ชื่อเรื่อง3','รายละเอียด', '30-07-2017');");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public long addmemory(String strTitle,
                          String strDetail,
                          String strDate) {
        ContentValues objvalue = new ContentValues();
        objvalue.put(COLUMN_TITLE, strTitle);
        objvalue.put(COLUMN_DETAIL, strDetail);
        objvalue.put(COLUMN_DATE, strDate);
        return writeSQLite.insert(TBMEMORY, null, objvalue);
    }
}