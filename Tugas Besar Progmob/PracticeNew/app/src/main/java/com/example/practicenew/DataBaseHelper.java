package com.example.practicenew;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(Context context) {
        super(context, "db_tokosofa", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table user(username primary key,name text, email text, phone text, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists user");
    }

    public Boolean insertuserdata (String username, String name, String phone, String email, String password){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("phone", phone);
        contentValues.put("password", password);
        long result=DB.insert("user",null,contentValues);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public Boolean updateuserdata (String username, String name, String phone, String email, String password){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("phone", phone);
        contentValues.put("password", password);
        Cursor cursor=DB.rawQuery("select*from user where user_id=?", new String[]{username});
        if(cursor.getCount()>0){
            long result =DB.update("user",contentValues, "name=?", new String[] {username});
            if(result==-1){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    public Boolean deletetuserdata (String username, String name, String phone, String email, String password){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("phone", phone);
        contentValues.put("password", password);
        Cursor cursor=DB.rawQuery("select*from user where user_id=?", new String[]{username});
        if(cursor.getCount()>0){
            long result =DB.update("user",contentValues, "name=?", new String[] {username});
            if(result==-1){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
}
