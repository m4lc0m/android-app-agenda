package com.musto.agendatest;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.musto.agendatest.R;

public class CustomList extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] stringhe;
    private final Integer[] imageId;


    public CustomList(Activity context,
                      String[] stringhe, Integer[] imageId) {
        super(context, R.layout.list_single, stringhe);
        this.context = context;
        this.stringhe = stringhe;
        this.imageId = imageId;

    }


    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(stringhe[position]);

        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}
