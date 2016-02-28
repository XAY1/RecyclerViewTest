package com.xushuzhan.recyclerviewtest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Mr.Xu on 2016/2/21.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper{
    public static final String CREATE_USERINFORMATION = "create table user ("
            + "id integer primary key autoincrement, "
            + "name text, "
            + "account text, "
            + "password text, "
            +"note text, "
            + "time text)";
    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext=context;
    }

    private Context mContext;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USERINFORMATION);
        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
