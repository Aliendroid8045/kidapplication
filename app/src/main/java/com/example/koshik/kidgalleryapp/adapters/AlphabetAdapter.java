package com.example.koshik.kidgalleryapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.koshik.kidgalleryapp.R;
import com.example.koshik.kidgalleryapp.models.AlphabetImage;
import com.squareup.picasso.Picasso;

/**
 * Created by koshik on 02-12-2016.
 */

@SuppressWarnings("ALL")
public class AlphabetAdapter extends ArrayAdapter<AlphabetImage> {
    public AlphabetAdapter(Context context) {
        super(context, 0);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.alphabet_view_thumbnail, parent, false);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.gridImage);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Picasso.with( getContext() ).load( getItem( position ).getThumbnail() ).into( viewHolder.image );
        return convertView;
    }

    private class ViewHolder {
        ImageView image;
    }
}
