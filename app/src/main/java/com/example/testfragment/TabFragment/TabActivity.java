package com.example.testfragment.TabFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.testfragment.R;
import com.google.android.material.tabs.TabLayout;

public class TabActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        tabLayout = findViewById(R.id.main_tabLayout);
        viewPager = findViewById(R.id.main_pager);

//      adapter.addTab(new MyTab("Jan",CategoryFragment.newInstance(1,"Jan")));
//      adapter.addTab(new MyTab("Fab",CategoryFragment.newInstance(2,"Fab")));
//      adapter.addTab(new MyTab("Mar",CategoryFragment.newInstance(3,"Mar")));
//      adapter.addTab(new MyTab("Apr",CategoryFragment.newInstance(4,"Apr")));



        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        Category category1 = new Category(1,"Food");
        adapter.addTab(new MyTab(category1,CategoryFragment.newInstance(1,"Food")));
        Category category2 = new Category(2,"Eat");
        adapter.addTab(new MyTab(category2,CategoryFragment.newInstance(1,"Eat")));
        viewPager.setAdapter(adapter);


        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(TabActivity.this, "selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Toast.makeText(TabActivity.this, "unselected", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Toast.makeText(TabActivity.this, "reselected", Toast.LENGTH_SHORT).show();

            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
