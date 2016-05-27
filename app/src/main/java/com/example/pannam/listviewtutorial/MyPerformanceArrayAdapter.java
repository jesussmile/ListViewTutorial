package com.example.pannam.listviewtutorial;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by pannam on 5/27/2016.
 */
public class MyPerformanceArrayAdapter extends ArrayAdapter<String> {
    private final Activity context;
    public final String[] names;


    static  class ViewHolder {
        public TextView text;
        public ImageView image;
    }
    public MyPerformanceArrayAdapter(Activity context, String[] names) {
        super(context, R.layout.activity_main,names);
        this.context = context;
        this.names = names;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;

        //reuse views

        if(rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.list_images_text,null);

            //configure view holder

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView)rowView.findViewById(R.id.label);
            viewHolder.image = (ImageView)rowView.findViewById(R.id.icon);
            rowView.setTag(viewHolder);

        }

        //fill data
        ViewHolder holder = (ViewHolder)rowView.getTag();
        String s = names[position];
        holder.text.setText(s);
        if (s.startsWith("Android") || s.startsWith("iPhone") || s.startsWith("Linux")) {
            holder.image.setImageResource(android.R.drawable.alert_light_frame);
        } else {
            holder.image.setImageResource(android.R.drawable.btn_minus);
        }

        return rowView;


    }
}
