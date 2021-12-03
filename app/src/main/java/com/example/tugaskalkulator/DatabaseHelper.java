package com.example.tugaskalkulator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public final static String db_name = "hasil.db";
    public final static String db_table = "Result";

    public final static String field_01 = "number1";
    public final static String field_02 = "number2";
    public final static String field_03 = "hasil";

    public DatabaseHelper(Context context) {
        super(context, db_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Result(number1 text, number2 text, hasil text, operand text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Result");
        onCreate(db);
    }


    public void add(double num1, double num2, double hasil, String operands) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(field_01, num1);
        contentValues.put(field_02, num2);
        contentValues.put(field_03, hasil);
        contentValues.put("operand", operands);
        database.insert(db_table,null, contentValues);
    }

    public Cursor read(){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.rawQuery("select * from "+db_table, null);
    }
}
