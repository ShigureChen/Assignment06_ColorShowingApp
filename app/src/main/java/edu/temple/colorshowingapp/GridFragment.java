package edu.temple.colorshowingapp;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

public class GridFragment extends Fragment {

    private GridFragmentListener listener;

    public interface GridFragmentListener{
        void onDataSent(String string, int integer);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final String[] colourStr = new String[9];
        colourStr[0] = getString(R.string.red);
        colourStr[1] = getString(R.string.yellow);
        colourStr[2] = getString(R.string.aqua);
        colourStr[3] = getString(R.string.lightGray);
        colourStr[4] = getString(R.string.magenta);
        colourStr[5] = getString(R.string.silver);
        colourStr[6] = getString(R.string.blue);
        colourStr[7] = getString(R.string.green);
        colourStr[8] = getString(R.string.darkGray);

        final int[] colourInt = new int[9];

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
        GridView gridView = view.findViewById(R.id.gridView);
        final GridAdapter adapter = new GridAdapter(this.getContext(), colourStr, colourInt);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                listener.onDataSent(colourStr[i], colourInt[i]);
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof GridFragmentListener){
            listener = (GridFragmentListener) context;
        }else{
            throw new RuntimeException(context.toString() + " Error");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}