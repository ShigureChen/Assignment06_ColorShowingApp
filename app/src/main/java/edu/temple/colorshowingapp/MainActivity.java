package edu.temple.colorshowingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements GridFragment.GridFragmentListener{

    GridFragment gridFragment;
    ColorFragment colorFragment;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView.setText(getString(R.string.app_message).toString());

        gridFragment = new GridFragment();
        colorFragment = new ColorFragment();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.gridContainer, gridFragment);
        ft.replace(R.id.colorContainer, colorFragment);
        ft.commit();

    }

    @Override
    public void onDataSent(String Str, int Int) {
        Bundle bundle = new Bundle();
        bundle.putString("String", Str);
        bundle.putInt("Integer", Int);
        colorFragment.getBundle(bundle);
    }
}