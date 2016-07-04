package com.DiliGruop.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.DiliGruop.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Kevin on 2016/7/4.
 */
public abstract class BaseFragment extends Fragment {
    @Bind(R.id.tv_fg)
    TextView tv_fg;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutXml(), null);
        ButterKnife.bind(this, view);
        setTv(tv_fg);
        return view;
    }

    public abstract  void setTv(TextView tv_fg);

    public abstract int getLayoutXml();

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
