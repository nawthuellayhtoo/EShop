package com.example.thuellay.team2androidca;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ThueLlay on 12/20/2016.
 */

public class MyAdapter extends ArrayAdapter<Item> {

private List<Item> items;
        int resource;

public MyAdapter(Context context, int resource, List<Item> items) {
        super(context, resource, items);
        this.resource = resource;
        this.items = items;
        }

@Override
public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
        .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(resource, null);
        Item item = items.get(position);
        if (item != null) {
        TextView e = (TextView) v.findViewById(R.id.tvItem);
        TextView status=(TextView)v.findViewById(R.id.tvItemStatus);

        e.setText(item.get("Name"));
        status.setText(item.get("Status"));
        }
        return v;
        }
}
