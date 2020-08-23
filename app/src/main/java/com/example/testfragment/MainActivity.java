package com.example.testfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.net.FileNameMap;


public class MainActivity extends AppCompatActivity implements NameFragment.OnFragmentClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onClickFragment(Name name) {
        TextFragment textFragment = new TextFragment().newInstance(name.getName());
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.text_fragment,textFragment);
        ft.commit();
    }
}
