package com.latven.dbtest;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "numis.db";
    public static final String TABLE_COINS = "coins";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_COINS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT" +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_COINS);
        onCreate(db);
    }

    //Add new row to the database
    public void addCoin (Coins coin)
    {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, coin.getName());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_COINS, null, values);
        db.close();
    }

    //Delete a coin from the database
    public void deleteCoin (String coinName){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_COINS + " WHERE " + COLUMN_NAME + "=\"" + coinName + "\";" );
    }

    // this is goint in record_TextView in the Main activity.
    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_COINS + " WHERE 1;";// why not leave out the WHERE  clause?

        //Cursor points to a location in your results
        Cursor recordSet = db.rawQuery(query, null);
        //Move to the first row in your results
        recordSet.moveToFirst();

        //Position after the last row means the end of the results
        while (!recordSet.isAfterLast()) {
            // null could happen if we used our empty constructor
            if (recordSet.getString(recordSet.getColumnIndex("name")) != null) {
                dbString += recordSet.getString(recordSet.getColumnIndex("name"));
                dbString += "\n";
            }
            recordSet.moveToNext();
        }
        db.close();

        return dbString;
    }

}















