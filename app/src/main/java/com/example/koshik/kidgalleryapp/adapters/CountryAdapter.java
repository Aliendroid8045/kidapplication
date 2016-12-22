package com.example.koshik.kidgalleryapp.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.test.SingleLaunchActivityTestCase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.koshik.kidgalleryapp.R;

import java.util.ArrayList;

/**
 * Created by koshik on 21-12-2016.
 */

public class CountryAdapter extends BaseAdapter {
    Context context;
    ArrayList<SingleRow> mySingleData;

    public CountryAdapter(Context context) {
        mySingleData = new ArrayList<>();
        this.context = context;
        Resources resources = context.getResources();
        String[] countryName = resources.getStringArray(R.array.country_name);
        String[] capitalName = resources.getStringArray(R.array.capital_name);
        int flags[] = {R.drawable.ic_next_arrow, R.drawable.ic_next_arrow, R.drawable.ic_next_arrow};
        for (int i = 0; i <=2; i++) {
            mySingleData.add(new SingleRow(countryName[i], capitalName[i], flags[i]));
        }
    }

    @Override
    public int getCount() {
        return mySingleData.size();
    }

    @Override
    public Object getItem(int position) {
        return mySingleData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.country_single_row, parent, false);
        TextView myCountry = (TextView) view.findViewById(R.id.myCountryName);
        TextView myCapital = (TextView) view.findViewById(R.id.myStateName);
        ImageView myFlag = (ImageView) view.findViewById(R.id.myCountryImage);

        SingleRow temp = mySingleData.get(position);

        myCountry.setText(temp.countryName);
        myCapital.setText(temp.capitalName);
            myFlag.setImageResource(temp.flagImage);

        return view;
        /*if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.country_single_row, parent, false);
            viewHolder.myCountryName = (TextView) convertView.findViewById(R.id.myCountryName);
            viewHolder.myStateName = (TextView) convertView.findViewById(R.id.myStateName);
            viewHolder.myCountryFlag = (ImageView) convertView.findViewById(R.id.myCountryImage);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (CountryAdapter.MyViewHolder) convertView.getTag();
        }
        viewHolder.myCountryFlag.setImageResource(flags[position]);
        viewHolder.myStateName.setText(capitalName[position]);
        viewHolder.myCountryName.setText(countryName[position]);

        return convertView;*/
    }

    class SingleRow {
        String capitalName;
        String countryName;
        int flagImage;

        SingleRow(String capitalName, String countryName, int flagImage) {
            this.capitalName = capitalName;
            this.countryName = countryName;
            this.flagImage = flagImage;
        }
    }
/*
    class MyViewHolder {
        ImageView myCountryFlag;
        TextView myStateName;
        TextView myCountryName;

    }*/
}