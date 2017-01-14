package com.example.koshik.kidgalleryapp.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.koshik.kidgalleryapp.R;
import com.example.koshik.kidgalleryapp.fragments.CountryFlagFragment;
import com.example.koshik.kidgalleryapp.models.CountryIModelPojo;
import com.squareup.picasso.Picasso;


/**
 * Created by koshik on 21-12-2016.
 */

public class CountryAdapter extends ArrayAdapter<CountryIModelPojo> implements Filterable {
    Typeface cfont;

    public CountryAdapter(Context context, int i) {
        super(context, 0);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            cfont = Typeface.createFromAsset(getContext().getAssets(), "fonts/Yahoo.ttf");
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.country_single_row, parent, false);
            viewHolder.countryName = (TextView) convertView.findViewById(R.id.myCountryName);
            viewHolder.capitalName = (TextView) convertView.findViewById(R.id.myCapitalName);
            viewHolder.thumbnail = (ImageView) convertView.findViewById(R.id.myCountryImage);
            viewHolder.capitalName.setTypeface(cfont);
            viewHolder.countryName.setTypeface(cfont);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.countryName.setText(getItem(position).getCountryName());
        viewHolder.capitalName.setText(getItem(position).getcapitalname());
        Picasso.with(getContext()).load(getItem(position).getThumbnail()).into(viewHolder.thumbnail);
        return convertView;
    }

    class ViewHolder {
        TextView countryName;
        TextView capitalName;
        ImageView thumbnail;
    }
}

    /* Context context;
    ArrayList<SingleRow> mySingleData;

    public CountryAdapter(Context context) {
        mySingleData = new ArrayList<>();
        this.context = context;
        Resources resources = context.getResources();
        String[] countryName = resources.getStringArray(R.array.country_name);
        String[] capitalname = resources.getStringArray(R.array.capital_name);
        int flags[] = {R.drawable.ic_next_arrow, R.drawable.ic_next_arrow, R.drawable.ic_next_arrow};
        for (int i = 0; i <=2; i++) {
            mySingleData.add(new SingleRow(countryName[i], capitalname[i], flags[i]));
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
        myCapital.setText(temp.capitalname);
            myFlag.setImageResource(temp.flagImage);

        return view;
        *//*if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.country_single_row, parent, false);
            viewHolder.myCountryName = (TextView) convertView.findViewById(R.id.myCountryName);
            viewHolder.myStateName = (TextView) convertView.findViewById(R.id.myStateName);
            viewHolder.myCountryFlag = (ImageView) convertView.findViewById(R.id.myCountryImage);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (CountryAdapter.MyViewHolder) convertView.getTag();
        }
        viewHolder.myCountryFlag.setImageResource(flags[position]);
        viewHolder.myStateName.setText(capitalname[position]);
        viewHolder.myCountryName.setText(countryName[position]);

        return convertView;*//*
    }

    class SingleRow {
        String capitalname;
        String countryName;
        int flagImage;

        SingleRow(String capitalname, String countryName, int flagImage) {
            this.capitalname = capitalname;
            this.countryName = countryName;
            this.flagImage = flagImage;
        }
    }
    class MyViewHolder {
        ImageView myCountryFlag;
        TextView myStateName;
        TextView myCountryName;

    }*/
