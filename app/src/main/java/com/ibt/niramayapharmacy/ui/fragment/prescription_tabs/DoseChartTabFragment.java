package com.ibt.niramayapharmacy.ui.fragment.prescription_tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ibt.niramayapharmacy.R;
import com.ibt.niramayapharmacy.utils.BaseFragment;

public class DoseChartTabFragment extends BaseFragment {

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_tab_dose_chart, container, false);
        init();
        return rootView;
    }

    private void init() {

    }
}
