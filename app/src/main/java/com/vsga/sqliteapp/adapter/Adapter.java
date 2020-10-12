package com.vsga.sqliteapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vsga.sqliteapp.R;
import com.vsga.sqliteapp.model.Data;

import java.util.List;

public class Adapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Data> items;
    private int i;


    public Adapter(Activity activity, List<Data> items) {
        this.activity=activity;
        this.items=items;

    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (inflater!=null)
            inflater=(LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view==null)
            view=inflater.inflate(R.layout.list_row, null);

        TextView id=view.findViewById(R.id.id);
        TextView name=view.findViewById(R.id.name);
        TextView addrees=view.findViewById(R.id.addrees);

        Data data=items.get(i);
        id.setText(data.getId());
        name.setText(data.getName());
        addrees.setText(data.getAddrees());


        return view;
    }
}
