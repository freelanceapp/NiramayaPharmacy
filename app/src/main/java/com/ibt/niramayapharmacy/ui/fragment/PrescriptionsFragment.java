package com.ibt.niramayapharmacy.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ibt.niramayapharmacy.R;
import com.ibt.niramayapharmacy.adapter.tabs_adapter.PrescriptionPagerAdapter;
import com.ibt.niramayapharmacy.utils.BaseFragment;

import static com.ibt.niramayapharmacy.ui.activity.HomeActivity.imgSearch;
import static com.ibt.niramayapharmacy.ui.activity.HomeActivity.imgSort;


public class PrescriptionsFragment extends BaseFragment implements View.OnClickListener {

    private View rootView;
    private ViewPager viewPager;
    private TabLayout tab;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_prescription, container, false);
        init();
        return rootView;
    }

    private void init() {
        imgSearch.setVisibility(View.GONE);
        imgSort.setVisibility(View.VISIBLE);
        setViewPager();
    }

    private void setViewPager() {
        viewPager = rootView.findViewById(R.id.viewPager);
        tab = rootView.findViewById(R.id.tabs);
        if (viewPager != null) {
            PrescriptionPagerAdapter adapter = new PrescriptionPagerAdapter(getChildFragmentManager());
            viewPager.setAdapter(adapter);
            tab.setupWithViewPager(viewPager);
        }
    }


    @Override
    public void onClick(View v) {

    }
}
