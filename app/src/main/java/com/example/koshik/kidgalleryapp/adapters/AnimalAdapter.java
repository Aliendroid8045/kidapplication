package com.example.koshik.kidgalleryapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.koshik.kidgalleryapp.R;
import com.example.koshik.kidgalleryapp.models.AnimalImage;
import com.squareup.picasso.Picasso;

/**
 * Created by koshik on 27-11-2016.
 */

public class AnimalAdapter extends ArrayAdapter<AnimalImage> {
    public AnimalAdapter(Context context) {
        super(context, 0);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.animal_listitem_view, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.species = (TextView) convertView.findViewById(R.id.species);
            viewHolder.thumbNail = (ImageView) convertView.findViewById(R.id.thumbNail);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(getItem(position).getName());
        viewHolder.species.setText(getItem(position).getSpecies());
        Picasso.with(getContext()).load(getItem(position).getThumbnail()).into(viewHolder.thumbNail);
        return convertView;
    }

    class ViewHolder {
        TextView name;
        TextView species;
        ImageView thumbNail;
    }
}
