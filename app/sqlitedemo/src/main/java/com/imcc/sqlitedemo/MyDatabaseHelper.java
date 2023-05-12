
package com.imcc.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private final String TAG = MyDatabaseHelper.class.getSimpleName();

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "user_db";
    private static final String TABLE_USER = "user_details";
    private static final String ID = "id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String MOBILE = "mobile";


    //Create Tables
    String CREATE_USER_TABLE = "CREATE TABLE "
            + TABLE_USER
            + "("
            + ID
            + " INTEGER PRIMARY KEY,"
            + FIRST_NAME
            + " TEXT,"
            + LAST_NAME
            + " TEXT,"
            + MOBILE
            + " TEXT"
            + ")";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void saveIntoDatabase(UserDataModel userDataModel) {
        Log.e(TAG, "saveIntoDatabase: ");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FIRST_NAME, userDataModel.getFirstName());
        values.put(LAST_NAME, userDataModel.getLastName());
        values.put(MOBILE, userDataModel.getMobile());
        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public UserDataModel getUser(String firstName, String lastName) {
        UserDataModel userDataModel = new UserDataModel();
        SQLiteDatabase db = this.getReadableDatabase();
        String whereColumns = FIRST_NAME + "= ?" + " AND " + LAST_NAME + "= ?";
        String[] whereArguments = {firstName, lastName};
        Cursor cursor = db.query(TABLE_USER, null, whereColumns, whereArguments, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            userDataModel.setFirstName(cursor.getString(cursor.getColumnIndexOrThrow(FIRST_NAME)));
            userDataModel.setLastName(cursor.getString(cursor.getColumnIndexOrThrow(LAST_NAME)));
            userDataModel.setMobile(cursor.getString(cursor.getColumnIndexOrThrow(MOBILE)));
            cursor.close();
        }
        return userDataModel;
    }
}
