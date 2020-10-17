package edu.temple.colorshowingapp;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter
{
    Context context;
    String[] colourStr;
    int[] colourInt;
    public GridAdapter(Context context, String[] colourStr, int[] colourInt)
    {
        this.context = context;
        this.colourStr = colourStr;
        this.colourInt = colourInt;
    }

    @Override
    public int getCount() {
        return colourInt.length;
    }

    @Override
    public Object getItem(int i) {
        return colourStr[i];
    }

    @Override
    public long getItemId(int i) {
        return colourInt[i];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        TextView textView = new TextView(context);
        textView.setText(colourStr[position]);
        textView.setPadding(5, 5, 5, 5);
        textView.setTextSize(22);
        textView.setTextColor(Color.BLACK);
        textView.setBackgroundColor(colourInt[position]);
        textView.setHeight(220);
        return textView;
    }
}
