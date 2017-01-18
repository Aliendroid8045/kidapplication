package com.example.koshik.kidgalleryapp.adapters;

/**
 * Created by koshik on 26-11-2016.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.koshik.kidgalleryapp.R;

public class DrawerNavigationListAdapter extends ArrayAdapter<String> {

    private final int[] navigationListItemImages =
            {R.drawable.ic_animal, R.drawable.ic_alphabet,
                    R.drawable.ic_color, R.drawable.ic_vegetables,
                    R.drawable.ic_countries, R.drawable.ic_privacy, R.drawable.ic_aboutus, R.drawable.profile};

    public DrawerNavigationListAdapter(Context context) {
        super(context, 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.navigationdrawer_listitem_view, parent, false);
            holder.myListIcon = (ImageView) convertView.findViewById(R.id.navigationListImage);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();

        }
        holder.title.setText(getItem(position));
        holder.myListIcon.setImageResource(navigationListItemImages[position]);

        return convertView;
    }

    class ViewHolder {
        TextView title;
        ImageView myListIcon;
    }
}