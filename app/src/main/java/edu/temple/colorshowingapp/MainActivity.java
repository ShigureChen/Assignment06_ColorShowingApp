package edu.temple.colorshowingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements GridFragment.GridFragmentListener{

    GridFragment gridFragment;
    ColorFragment colorFragment;
    TextView textView;
    FragmentManager fm;
    FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView.setText(getString(R.string.app_message));

        gridFragment = new GridFragment();

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.add(R.id.gridContainer, gridFragment);
        ft.commit();
    }

    @Override
    public void onDataSent(String string, int integer) {
        colorFragment = new ColorFragment();
        Bundle bundle = new Bundle();
        bundle.putString("String", string);
        bundle.putInt("Integer", integer);
        colorFragment.setArguments(bundle);

        ft = fm.beginTransaction();
        ft.replace(R.id.colorContainer, colorFragment);
        ft.commit();
    }
}