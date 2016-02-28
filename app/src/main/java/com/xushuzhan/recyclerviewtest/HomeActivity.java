package com.xushuzhan.recyclerviewtest;


import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class HomeActivity extends Activity
{

    static List datas = new ArrayList<HashMap<String, Object>>();
    //创建数据库
    private MyDatabaseHelper dbHelper;

    private RecyclerView mRecyclerView;
    private static List<String> mDatas;
    public static List<Integer> m2Datas;
    private HomeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SimpleDateFormat formatter   =   new   SimpleDateFormat   ("yyyy年MM月dd日 HH:mm:ss");
        Date curDate =  new Date(System.currentTimeMillis());//获取当前时间
        String   str   =   formatter.format(curDate);
        System.out.println(str+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    //-------------------------------------------------------------------------------
    try {
        try {
            //创建数据库
            dbHelper = new MyDatabaseHelper(HomeActivity.this, "UserInformation.db", null, 1);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "创建数据库创建失败",
                    Toast.LENGTH_LONG).show();
        }





        // 插入数据
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", "淘宝密码");
        values.put("account", "18512376975");
        values.put("password", "abc123");
        values.put("note", "无");
        values.put("time",str);

        db.insert("user", null, values);
//        values.clear();

        values.put("name", "QQ密码");
        values.put("account", "391830728");
        values.put("password", "abcd1234");
        values.put("note", "无");
        values.put("time",str);

        db.insert("user", null, values);
//        values.clear();

        values.put("name", "京东密码");
        values.put("account", "13220266725");
        values.put("password", "abcde12345");
        values.put("note", "无");
        values.put("time",str);
        db.insert("user", null, values);
//        values.clear();



        //查询表中所有数据
        Cursor cursor = db.query("user", null, null, null, null, null, null);
        int columnSize = cursor.getColumnCount();


        //获取表的内容
/*
        while (cursor.moveToNext()) {
            for (int i = 0; i < columnSize; i++) {
                datas.add(new Account(cursor.getInt(0),
                                    "cursor.getString(1)",
                                    "cursor.getString(2)",
                                    "cursor.getString(3)",
                                    "cursor.getString(4)"));

            }
        }
*/
//00<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


        while (cursor.moveToNext()) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            for (int i = 0; i < columnSize; i++) {
                map.put("id", cursor.getString(0));
                map.put("name", cursor.getString(1));
                map.put("account", cursor.getString(2));
                map.put("password", cursor.getString(3));
                map.put("note", cursor.getString(4));
                map.put("time", cursor.getString(5));
            }
            datas.add(map);
        }
    //**********************************测试线**********************************

        for(int j=0;j<=4;j++){
            System.out.println(datas.get(j)+"**************************************************************");
        }
        HashMap<String, Object> map = (HashMap<String, Object>) datas.get(2);
        System.out.println(map.get("name")+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<,");


    //**********************************测试线**********************************



//00<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    }catch (Exception e){
        System.out.println(e.getMessage()+"我找到错误啦 我找到错误啦 我找到错误啦 ");

    }
    //------------------------------------------------------------------------------------



        initData();

        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter = new HomeAdapter());
        mAdapter.setOnItemClickListener(new HomeAdapter.OnRecyclerViewItemClickListener(){

            @Override
            public void onItemClick(View view,HashMap data) {
                Intent intent=new Intent(HomeActivity.this,DetaiTest.class);
                startActivity(intent);
                DetaiTest.Datas=data;
                Toast.makeText(HomeActivity.this, data.toString(),Toast.LENGTH_SHORT).show();

            }
        });

    }






    protected void initData()
    {
        mDatas = new ArrayList<String>();
        for (int i = 'a'; i <= 'z'; i++)
        {
            mDatas.add("" + (char) i);
        }

        m2Datas=new ArrayList<Integer>();
            for (int j = 1; j <= 26; j++){
                m2Datas.add(j);
            }
    }


}