package com.paladino.favores.presentation;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.paladino.favores.R;

public class ConsultaFavorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_favor);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        TabsAdapter tabsAdapter = new TabsAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        ViewPager mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(tabsAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    public class TabsAdapter extends FragmentPagerAdapter {
        public TabsAdapter(FragmentManager fm) {
            super(fm);
        }



        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return MeuFavorFragment.newInstance(null);
                case 1:
                    return VoluntariosFragment.newInstance();
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Favor";
                case 1:
                    return "Voluntários";
            }
            return super.getPageTitle(position);
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
