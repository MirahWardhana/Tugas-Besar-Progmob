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
    public void onCreate(SQLiteDatabase db) {
        // Create the user table
        String createUserTable = "CREATE TABLE user (username TEXT PRIMARY KEY, name TEXT, email TEXT, phone TEXT, password TEXT)";
        db.execSQL(createUserTable);

        // Create the ordersofa table
        String createOrdersTable = "CREATE TABLE orders (order_id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, shape TEXT, color_red INTEGER, color_green INTEGER, color_blue INTEGER,color_alfa INTEGER, s1 TEXT, s2 TEXT, s3 TEXT, s4 TEXT, s5 TEXT, s6 TEXT, s7 TEXT, s8 TEXT, wood TEXT, fabric TEXT, order_date TEXT, order_status TEXT, price INTEGER, note TEXT)";
        db.execSQL(createOrdersTable);

    }


    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists user");
        DB.execSQL("drop table if exists orders");
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

    public Boolean checkusername (String username){
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor= DB.rawQuery("SELECT * FROM  user where username=?", new String[]{username});
        if (cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
    public Boolean checkuserdata (String username,String password){
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor= DB.rawQuery("SELECT * FROM  user where username=? AND password=?", new String[]{username, password});
        if (cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }


    Cursor readuserdata(){
        String query= "select username,name,email,phone from user";
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor= null;
        if (db!=null){
            cursor=db.rawQuery(query,null);
        }
        return cursor;
    }

    Cursor readallorder(){
        String query= "select order_id, username,order_date, order_status,shape from orders";
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor= null;
        if (db!=null){
            cursor=db.rawQuery(query,null);
        }
        return cursor;
    }

    public Cursor readuserdatadashboard(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"username", "name", "email"};
        String selection = "username = ?";
        String[] selectionArgs = {username};

        Cursor cursor = db.query("user", columns, selection, selectionArgs, null, null, null);
        return cursor;
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

    public boolean insertorderuser(String username, String shape, int color_red, int color_green, int color_blue,int color_alfa, String s1, String s2, String s3, String s4, String s5, String s6, String s7,String s8, String wood, String fabric, String order_date, String order_status, int price, String note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("shape", shape);
        contentValues.put("color_red", color_red);
        contentValues.put("color_green", color_green);
        contentValues.put("color_blue", color_blue);
        contentValues.put("color_alfa", color_alfa);
        contentValues.put("s1", s1);
        contentValues.put("s2", s2);
        contentValues.put("s3", s3);
        contentValues.put("s4", s4);
        contentValues.put("s5", s5);
        contentValues.put("s6", s6);
        contentValues.put("s7", s7);
        contentValues.put("s8", s8);
        contentValues.put("wood", wood);
        contentValues.put("fabric", fabric);
        contentValues.put("order_date", order_date);
        contentValues.put("order_status", order_status);
        contentValues.put("price", price);
        contentValues.put("note", note);
        long result = db.insert("orders", null, contentValues);
        return result != -1;
    }

    public boolean deleteOrder(int orderId) {
        SQLiteDatabase db = this.getWritableDatabase();
        int rowsAffected = db.delete("orders", "order_id = ?", new String[]{String.valueOf(orderId)});
        return rowsAffected > 0;
    }

    public Cursor readorderuserdashboard(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"username","order_id", "order_date", "order_status","shape"};
        String selection = "username = ?";
        String[] selectionArgs = {username};
        String orderBy = "order_id";

        Cursor cursor = db.query("orders", columns, selection, selectionArgs, null, null, orderBy);
        return cursor;
    }

    public boolean updateOrder(int orderId, String orderDate, String orderStatus, int orderPrice, String orderNote) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("order_date", orderDate);
        contentValues.put("order_status", orderStatus);
        contentValues.put("price", orderPrice);
        contentValues.put("note", orderNote);

        int rowsAffected = db.update("orders", contentValues, "order_id = ?", new String[]{String.valueOf(orderId)});
        return rowsAffected > 0;
    }


}