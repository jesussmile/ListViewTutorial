package com.example.pannam.listviewtutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pannam on 5/27/2016.
 */
public class MySimpleArrayAdapter extends ArrayAdapter<String> {
    private final Context mContext;
    private final String[] values;


    public MySimpleArrayAdapter(Context context, String[] values) {
        super(context, R.layout.activity_main, values);
        mContext = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_images_text, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        textView.setText(values[position]);

        //change icon for windows and iphone

        String s = values[position];

        if (s.startsWith("Android") || s.startsWith("iPhone") || s.startsWith("Linux")) {
            imageView.setImageResource(android.R.drawable.alert_light_frame);
        } else {
            imageView.setImageResource(android.R.drawable.btn_minus);
        }

        return rowView;
    }
}
