package com.DiliGruop.Home;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.DiliGruop.After.fragment.AfterFragment;
import com.DiliGruop.Before.fragment.BeforeFragment;
import com.DiliGruop.Home.fragment.HomeFragment;
import com.DiliGruop.R;
import com.DiliGruop.UserSet.fragment.UserSetFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {
    public static final int NEWS_TYPE_TOP = 0;
    public static final int NEWS_TYPE_NBA = 1;
    public static final int NEWS_TYPE_CARS = 2;
    public static final int NEWS_TYPE_JOKES = 3;
    @Bind(R.id.viewpager)
    ViewPager mViewPager;
    @Bind(R.id.tab_layout)
    TabLayout mTablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mViewPager.setOffscreenPageLimit(3);
        setupViewPager(mViewPager);

        mTablayout.addTab(mTablayout.newTab().setText(R.string.home).setIcon(R.drawable.iv_computer));
        mTablayout.addTab(mTablayout.newTab().setText(R.string.before).setIcon(R.drawable.iv_computer));
        mTablayout.addTab(mTablayout.newTab().setText(R.string.after).setIcon(R.drawable.iv_computer));
        mTablayout.addTab(mTablayout.newTab().setText(R.string.user).setIcon(R.drawable.iv_computer));
//        mTablayout.addTab(mTablayout.newTab().setIcon(R.drawable.iv_computer));
//        mTablayout.addTab(mTablayout.newTab().setIcon(R.drawable.iv_computer));
//        mTablayout.addTab(mTablayout.newTab().setIcon(R.drawable.iv_computer));
//        mTablayout.addTab(mTablayout.newTab().setIcon(R.drawable.iv_computer));
        mTablayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager mViewPager) {
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment(), getString(R.string.home));
        adapter.addFragment(new BeforeFragment(), getString(R.string.before));
        adapter.addFragment(new AfterFragment(), getString(R.string.after));
        adapter.addFragment(new UserSetFragment(), getString(R.string.user));
        mViewPager.setAdapter(adapter);

    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

//        @Override
//        public CharSequence getPageTitle(int position) {
//            return mFragmentTitles.get(position);
//        }
    }
}
