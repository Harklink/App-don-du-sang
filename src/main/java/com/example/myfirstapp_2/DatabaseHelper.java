package com.example.myfirstapp_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * The type Database helper.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    /**
     * The constant DATABASE_NAME.
     */
    public static final String DATABASE_NAME = "Centres.db";
    /**
     * The constant TABLE_NAME.
     */
    public static final String TABLE_NAME = "centres_table";
    /**
     * The constant COL_1.
     */
    public static final String COL_1 = "ID";
    /**
     * The constant COL_2.
     */
    public static final String COL_2 = "DEPARTEMENT";
    /**
     * The constant COL_3.
     */
    public static final String COL_3= "VILLE";
    /**
     * The constant COL_4.
     */
    public static final String COL_4 = "CODEPOSTAL";
    /**
     * The constant COL_5.
     */
    public static final String COL_5 = "ADRESSE";
    /**
     * The constant COL_6.
     */
    public static final String COL_6 = "TELEPHONE";


    /**
     * Instantiates a new Database helper.
     *
     * @param context the context
     */
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, DEPARTEMENT TEXT, VILLE TEXT, CODEPOSTAL INTEGER, ADRESSE TEXT, TELEPHONE TEXT) ");
        //db.execSQL("INSERT INTO " + TABLE_NAME+ "(DEPARTEMENT, VILLE, CODEPOSTAL, ADRESSE, TELEPHONE) VALUES ('01', 'Bourg-en-Bresse', '01000', '900 Route de Paris', '0478656363')");
        //SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(COL_2, "Yvelines");
        //contentValues.put(COL_3, "Versailles");
        //contentValues.put(COL_4, "78000");
        //db.insert(TABLE_NAME, null, contentValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


}
