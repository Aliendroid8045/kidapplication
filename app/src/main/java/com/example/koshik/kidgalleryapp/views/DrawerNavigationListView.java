package com.example.koshik.kidgalleryapp.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.koshik.kidgalleryapp.adapters.DrawerNavigationListAdapter;
import com.example.koshik.kidgalleryapp.events.DrawerSectionItemClickedEvent;
import com.example.koshik.kidgalleryapp.utils.EventBus;

/**
 * Created by koshik on 26-11-2016.
 */

public class DrawerNavigationListView extends ListView implements AdapterView.OnItemClickListener {
    public DrawerNavigationListView(Context context) {
        this(context, null);
    }

    public DrawerNavigationListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawerNavigationListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        DrawerNavigationListAdapter adapter = new DrawerNavigationListAdapter(getContext());
        adapter.add("Animal");
        adapter.add("Alphabet");
        adapter.add("Color");
        adapter.add("Vegetables");
        adapter.add("Countries");
        adapter.add("Privacy");
        adapter.add("About Us");
        adapter.add("MyProfile");

        setAdapter(adapter);
        setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        EventBus.getInstance().post(new DrawerSectionItemClickedEvent((String) parent.getItemAtPosition(i)));
    }
}