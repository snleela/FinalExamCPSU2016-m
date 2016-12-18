package com.example.finalexamcpsu2016.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import static com.example.finalexamcpsu2016.model.DatabaseHelper.TABLE_NAME;

/**
 * Created by TOSHIBA on 18/12/2559.
 */

public class loginDatabaseAdapter {
    static final String DATABASE_NAME = "login.db";
    static final int DATABASE_VERSION = 1;
    public static final int NAME_COLUMN = 1;


    public SQLiteDatabase db;

    private final Context context;
    private DatabaseHelper dbHelper;
    public  loginDatabaseAdapter(Context _context)
    {
        context = _context;
        dbHelper = new DatabaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public  loginDatabaseAdapter open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public void close()
    {
        db.close();
    }

    public  SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }

    public void insertEntry(String userName,String User,String password)
    {
        ContentValues newValues = new ContentValues();

        newValues.put("USERNAME", userName);
        newValues.put("USER", User);
        newValues.put("PASSWORD",password);


        db.insert(TABLE_NAME, null, newValues);

    }
    public int deleteEntry(String UserName)
    {

        String where="USERNAME=?";
        int numberOFEntriesDeleted= db.delete("LOGIN", where, new String[]{UserName}) ;
        return numberOFEntriesDeleted;
    }
    public String getSinlgeEntry(String userName)
    {
        Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);

        if(cursor.getCount()<1)
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }
    public void  updateEntry(String userName,String password)
    {

        ContentValues updatedValues = new ContentValues();

        updatedValues.put("USERNAME", userName);
        updatedValues.put("PASSWORD",password);

        String where="USERNAME = ?";
        db.update("LOGIN",updatedValues, where, new String[]{userName});
    }
}
