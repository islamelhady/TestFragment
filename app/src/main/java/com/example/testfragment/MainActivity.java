package com.example.testfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnX, btnY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnX = findViewById(R.id.main_btnX);
        btnY = findViewById(R.id.main_btnY);

        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                FragmentX fragmentX = new FragmentX();
                ft.replace(R.id.main_fragment,fragmentX);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        btnY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                FragmentY fragmentY = new FragmentY();
                ft.replace(R.id.main_fragment,fragmentY);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
    }
}
