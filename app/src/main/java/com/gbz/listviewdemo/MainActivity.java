package com.gbz.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> arr_adapter;
    private SimpleAdapter simp_adapter;
    private List<Map<String,Object>> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        listView=(ListView) findViewById(R.id.listView);
        //1、新建一个数据适配器
        //2、适配器加载数据源
        String[] arr_data={"慕课网1","慕课网2","慕课网3","慕课网4"};
        dataList=new ArrayList<Map<String,Object>>();
        arr_adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr_data);
        simp_adapter=new SimpleAdapter(this,getData(),R.layout.item, new String[]{"pic","text"},new int[]{R.id.text});
        //3、视图（ListView)加载适配器
        //listView.setAdapter(arr_adapter);
        listView.setAdapter(simp_adapter);
    }

    private List<Map<String,Object>>getData(){
        for(int i=0; i<20; i++){
            Map<String,Object>map=new HashMap<String, Object>();
            map.put("pic",R.drawable.ic_launcher);
            map.put("text","慕课网"+i);
            dataList.add(map);
        }
        return dataList;
    }
}
