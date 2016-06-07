package com.wmz.wmz.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.wmz.wmz.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewWidgets extends AppCompatActivity {

    @BindView(R.id.id_drawerlayout)
    public DrawerLayout drawerLayout;
    @BindView(R.id.id_coordinatorlayout)
    public CoordinatorLayout coordinatorLayout;
    @BindView(R.id.id_appbarlayout)
    public AppBarLayout appBarLayout;
    @BindView(R.id.id_toolbar)
    public Toolbar toolbar;
    @BindView(R.id.id_tablayout)
    public TabLayout tabLayout;
    @BindView(R.id.id_viewpager)
    public ViewPager viewPager;
    @BindView(R.id.floatingactionbutton)
    public FloatingActionButton floatingActionButton;
    @BindView(R.id.id_navigationview)
    public NavigationView navigationView;

    private String[] titles = {"垂直List","水平List","垂直Grid","水平Grid","瀑布Staggered"};
    private List<Fragment> fragments;
    private MyViewPagerAdapter myViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_widgets);

        ButterKnife.bind(this);
        initDatas();
        configViews();
    }

    private void initDatas() {
        fragments = new ArrayList<>();
        for(int i=0;i<titles.length;i++){

        }
    }

    private void configViews() {

    }


    class MyViewPagerAdapter extends FragmentStatePagerAdapter{
        private String[] titles;
        private List<Fragment> fragments;

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public MyViewPagerAdapter(FragmentManager fm,String[] titles,List<Fragment> fragments){
            super(fm);
            this.titles = titles;
            this.fragments = fragments;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
