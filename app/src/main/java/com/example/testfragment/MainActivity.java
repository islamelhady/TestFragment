package com.example.testfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.main_rv);

        ArrayList<Name> names = new ArrayList<>();
        names.add(new Name("islam"));
        names.add(new Name("Mohamed"));
        names.add(new Name("Jannat"));
        names.add(new Name("Ali"));
        names.add(new Name("ahmed"));
        names.add(new Name("sarah"));
        names.add(new Name("Mohamed"));
        names.add(new Name("Jannat"));
        names.add(new Name("Ali"));
        names.add(new Name("ahmed"));
        names.add(new Name("sarah"));

        NameAdapter nameAdapter = new NameAdapter(names, new ItemOnClickListener() {
            @Override
            public void onClick(Name name) {

                Bundle bundle = new Bundle();
                bundle.putString("NAME",name.getName());

                NameFragment nameFragment = new NameFragment();
                nameFragment.setArguments(bundle);

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_tv,nameFragment);
                ft.commit();
            }
        });

        rv.setAdapter(nameAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

    }
}
