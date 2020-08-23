package com.example.testfragment;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements NameFragment.OnFragmentClickListener {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.main_tv);

    }

    @Override
    public void onClickFragment(Name name) {
        textView.setText(name.getName());
    }
}
