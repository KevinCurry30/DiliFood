package com.DiliGruop.Home.fragment;

import android.widget.TextView;

import com.DiliGruop.R;
import com.DiliGruop.base.BaseFragment;

/**
 * Created by Kevin on 2016/7/4.
 */
public class HomeFragment extends BaseFragment {
    @Override
    public void setTv(TextView tv_fg) {
        tv_fg.setText("首页");
    }

    @Override
    public int getLayoutXml() {
        return R.layout.home_fragment;
    }
}
