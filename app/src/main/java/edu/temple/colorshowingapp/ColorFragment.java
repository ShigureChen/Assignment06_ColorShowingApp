package edu.temple.colorshowingapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ColorFragment extends Fragment {

    private String colourStr;
    private int colourInt;

    public void getBundle(Bundle bundle)
    {
        colourStr = bundle.getString("String");
        colourInt = bundle.getInt("Integer");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_color, container, false);
        view.setBackgroundColor(colourInt);
        TextView textView = (TextView) view.findViewById(R.id.textView2);
        textView.setText(colourStr);
        return view;
    }



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}