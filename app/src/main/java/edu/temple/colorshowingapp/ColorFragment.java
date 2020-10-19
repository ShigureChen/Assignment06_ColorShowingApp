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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_color, container, false);
        TextView textView = view.findViewById(R.id.textView2);
        Bundle bundle = getArguments();
        if(bundle != null)
        {
            String colourStr = bundle.getString("String");
            int colourInt = bundle.getInt("Integer");

            textView.setText(colourStr);
            view.setBackgroundColor(colourInt);
        }

        else
        {
            textView.setText(R.string.color_fragment_message);
            view.setBackgroundColor(1);
        }

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