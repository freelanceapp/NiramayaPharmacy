package com.ibt.niramayapharmacy.ui.fragment.dashboard_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ibt.niramayapharmacy.R;
import com.ibt.niramayapharmacy.utils.BaseFragment;

import static com.ibt.niramayapharmacy.ui.activity.HomeActivity.txtTitle;

public class LatestExpensesFragment extends BaseFragment {

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_latest_expenses, container, false);
        init();
        return rootView;
    }

    private void init() {
        txtTitle.setText("Latest Expense");
    }
}
