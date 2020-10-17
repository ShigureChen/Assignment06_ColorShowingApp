package edu.temple.colorshowingapp;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class GridFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String[] colourStr = new String[9];
        colourStr[0] = "Red";
        colourStr[1] = "Yellow";
        colourStr[2] = "Cyan";
        colourStr[3] = "Light Gray";
        colourStr[4] = "Magenta";
        colourStr[5] = "Silver";
        colourStr[6] = "Blue";
        colourStr[7] = "Green";
        colourStr[8] = "Dark Gray";

        int[] colourInt = new int[9];

        colourInt[0] = Color.RED;
        colourInt[1] = Color.YELLOW;
        colourInt[2] = Color.CYAN;
        colourInt[3] = Color.GRAY;
        colourInt[4] = Color.MAGENTA;
        colourInt[5] = Color.LTGRAY;
        colourInt[6] = Color.BLUE;
        colourInt[7] = Color.GREEN;
        colourInt[8] = Color.DKGRAY;
        View view = inflater.inflate(R.layout.fragment_grid, container, false);
        GridView gridView = (GridView)view.findViewById(R.id.gridView);
        final GridAdapter adapter = new GridAdapter(this.getContext(), colourStr, colourInt);
        gridView.setAdapter(adapter);

        return view;
    }
}