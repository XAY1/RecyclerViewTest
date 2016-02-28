package com.xushuzhan.recyclerviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by Mr.Xu on 2016/2/26.
 */
public class DetaiTest extends Activity {
    public static HashMap<String, Object> Datas = new HashMap<String, Object>();
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        TextView tv1= (TextView) findViewById(R.id.text1);
        TextView tv2= (TextView) findViewById(R.id.text2);
        tv1.setText(Datas.get("name").toString());
        tv2.setText(Datas.get("time").toString());
    }
}
