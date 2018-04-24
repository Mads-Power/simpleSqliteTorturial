package com.example.mad_s.savedatasqlite;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Mad-s on 24.04.2018.
 */

public class ListDataActivity  extends AppCompatActivity{

    private static final String TAG = "ListDataActivity";
    DataBaseHelper mDatabaseHelper;
    private ListView mlistView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

        mlistView = findViewById(R.id.listview);
        mDatabaseHelper = new DataBaseHelper(this);
        
        populateListView();
    }

    private void populateListView() {
        Log.d(TAG,"populateListView: displaying data int the List View");

        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()){
            listData.add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,listData);
        mlistView.setAdapter(adapter);

    }

    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();    }

}
