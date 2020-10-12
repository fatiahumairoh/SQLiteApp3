package com.vsga.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vsga.sqliteapp.helper.DbHelper;

public class AddEditActivity extends AppCompatActivity {
    EditText txt_id, txt_name, txt_addrees;
    Button btn_submit;
    Button btn_cancel;
    DbHelper SQLite=new DbHelper(this);
    String id, name, addrees;
    private Log log;
    private Object Toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        txt_id=(EditText) findViewById(R.id.txt_id);
        txt_name=(EditText) findViewById(R.id.txt_name);
        txt_addrees=(EditText) findViewById(R.id.txt_addrees);
        btn_submit=(Button) findViewById(R.id.btn_submit);
        btn_cancel=(Button) findViewById(R.id.btn_cancel);

        id=getIntent().getStringExtra(MainActivity.TAG_ID);
        name=getIntent().getStringExtra(MainActivity.TAG_NAME);
        addrees=getIntent().getStringExtra(MainActivity.TAG_ADDREES);

        if (id== null || id == ""){
            setTitle("Add Data");
        } else{
            setTitle("Edit Data");
            txt_id.setText(id);
            txt_name.setText(name);
            txt_addrees.setText(addrees);
        }

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (txt_id.getText().toString().equals(""))
                        save();
                    } finally {

                     } else {
                        edit();
                    }
            } catch (Exception e){
                log.e("submit", e.toString());
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blank();
                finish();
            }
        });
    }

    @Override
    public  void onBackPressed(){
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem){
        switch (item.getItemIs()) {
            case android.R.id.home:
                blank();
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //kosongkan semua Edit Teks
    private void blank(){
        txt_name.requestFocus();
        txt_id.setText(null);
        txt_name.setText(null);
        txt_addrees.setText(null);
    }

    //Menyimpam Data ke Database SQLite
    private void save() {
        if (String.valueOf(txt_name.getText()).equals(null)|| String.valueOf(txt_name.getText()).equals("")||
                String.valueOf(txt_addrees.getText()).equals(null)|| String.valueOf(txt_addrees.getText()).equals("")){
            Toast = Toast.makeText(getApplicationContext()), "Please input name or addrees ... ", Toast.LENGTH_SHORT.show();

        } else {
            SQLite.insert(txt_name.getText().toString().trim(), txt_addrees.getText().toString().trim());
            blank();
            finish();
        }
    }

   // Update Data kedalam Database SQLite
    private void edit(){
        if (String.valueOf(txt_name.getText()).equals(null)|| String.valueOf(txt_name.getText()).equals("")||
                String.valueOf(txt_addrees.getText()).equals(null)|| String.valueOf(txt_addrees.getText()).equals("")){
            Toast = Toast.makeText(getApplicationContext()), "Please input name or addrees ... ", Toast.LENGTH_SHORT.show();

        } else {
            SQLite.insert(txt_name.getText().toString().trim(), txt_addrees.getText().toString().trim());
            blank();
            finish();
        }
    }
    }
    
}