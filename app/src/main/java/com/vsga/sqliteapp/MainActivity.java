package com.vsga.sqliteapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.vsga.sqliteapp.helper.DbHelper;
import com.vsga.sqliteapp.model.Data;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    AlertDialog.Builder dialog;
    List<Data> itemList = new ArrayList<Data>();
    Adapter adapter;
    DbHelper SQLite=new DbHelper(this);

    public static final String TAG_ID="id";
    public static final String TAG_NAME="name";
    public static final String TAG_ADDREES="addrees";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Tambah SQLite
        SQLite=new DbHelper(getApplicationContext());

        FloatingActionButton fab = findViewById(R.id.fab);

        //Tambah List View
        listView=(ListView) findViewById(R.id.list_view);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Tambah Intent untuk pindahnke halaman Add dan Edit
                Intent intent = new Intent(MainActivity.this, AddEdit.class);
                startActivity(intent);
            }
        });
        //Tambah adapter dan listview
        adapter=new Adapter(Activity MainActivity.this, itemList)
        listView.setAdapter((ListAdapter) adapter);


        //Tekan lama daftar listview untuk menampilkan edit dan hapus
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, View view,final int position, long id) {
                // TODO Auto-generated method stub
                final String idx=itemList.get(position).getId();
                final String name=itemList.get(position).getName();
                final String addrees=itemList.get(position).getAddrees();

                final CharSequence [] dialogitem={"Edit", "Delete"};
                dialog=new AlertDialog.Builder(MainActivity.this);
                dialog.setCancelable(true);
                dialog.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        switch (which){
                            case 0:
                                Intent intent=new Intent(MainActivity.this, AddEdit.class);
                                Intent.putExtra (TAG_ID, idx);
                                Intent.putExtra (TAG_NAME, name);
                                Intent.putExtra(TAG_ADDREES, addrees);
                                startActivity(intent);
                                break;
                            case 1:
                                SQLite.delete(Integer.parseInt(idx));
                                itemList.clear();
                                SQLite.getAllData();
                                break;

                    }
                }).show();
                return false;
            }
        });
        getAllData();
    }

    private void getAllData() {
            ArrayList<HashMap<String, String>> row = SQLite.getAllData();

            for (int i = 0; <row.size();
            1++){
                String id = row.get(i).get(TAG_ID);
                String poster = row.get(i).get(TAG_NAME);
                String title = row.get(i).get(TAG_ADDREES);

                Data data = new Data();

                data.setId(id);
                data.setName(poster);
                data.setAddrees(title);

                itemList.add(data);
            }
            adapter.notifyDataSetChanged();
        }

        @override
         protected void onResume(){
            super.onResume();
            itemList.clear();
            getAllData();
       }
        }
        }new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    }

}