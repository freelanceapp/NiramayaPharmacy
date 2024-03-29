package com.ibt.niramayapharmacy.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ibt.niramayapharmacy.R;
import com.ibt.niramayapharmacy.constant.Constant;
import com.ibt.niramayapharmacy.ui.fragment.dashboard_fragment.LatestExpensesFragment;
import com.ibt.niramayapharmacy.ui.fragment.dashboard_fragment.LatestMedicineFragment;
import com.ibt.niramayapharmacy.utils.BaseFragment;
import com.ibt.niramayapharmacy.utils.ConnectionDetector;

import static com.ibt.niramayapharmacy.ui.activity.HomeActivity.fragmentUtilsHome;
import static com.ibt.niramayapharmacy.ui.activity.HomeActivity.imgSearch;
import static com.ibt.niramayapharmacy.ui.activity.HomeActivity.imgSort;

public class DashboardFragment extends BaseFragment implements View.OnClickListener {

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);
        init();
        return rootView;
    }

    private void init() {
        imgSearch.setVisibility(View.VISIBLE);
        imgSort.setVisibility(View.GONE);

        activity = getActivity();
        mContext = getActivity();
        cd = new ConnectionDetector(mContext);

        rootView.findViewById(R.id.txtLatestSales).setOnClickListener(this);
        rootView.findViewById(R.id.txtLatestExpense).setOnClickListener(this);
        rootView.findViewById(R.id.txtLatestMedicine).setOnClickListener(this);
        rootView.findViewById(R.id.txtSalesGraph).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txtLatestSales:
                fragmentUtilsHome.replaceFragment(new LatestSalesFragment(), Constant.LatestSalesFragment, R.id.home_frame);
                break;
            case R.id.txtLatestExpense:
                fragmentUtilsHome.replaceFragment(new LatestExpensesFragment(), Constant.LatestExpensesFragment, R.id.home_frame);
                break;
            case R.id.txtLatestMedicine:
                fragmentUtilsHome.replaceFragment(new LatestMedicineFragment(), Constant.LatestMedicineFragment, R.id.home_frame);
                break;
            case R.id.txtSalesGraph:
                break;
        }
    }
}
