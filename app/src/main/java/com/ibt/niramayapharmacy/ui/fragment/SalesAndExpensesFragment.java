package com.ibt.niramayapharmacy.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ibt.niramayapharmacy.R;
import com.ibt.niramayapharmacy.adapter.InvoiceListAdapter;
import com.ibt.niramayapharmacy.utils.BaseFragment;
import com.ibt.niramayapharmacy.utils.ConnectionDetector;

import java.util.ArrayList;
import java.util.List;

import static com.ibt.niramayapharmacy.ui.activity.HomeActivity.imgSearch;
import static com.ibt.niramayapharmacy.ui.activity.HomeActivity.imgSort;

public class SalesAndExpensesFragment extends BaseFragment implements View.OnClickListener {

    private View rootView;
    private List<String> prescriptionList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_sales_and_exepenses, container, false);
        init();
        return rootView;
    }

    private void init() {
        imgSearch.setVisibility(View.VISIBLE);
        imgSort.setVisibility(View.GONE);

        activity = getActivity();
        mContext = getActivity();
        cd = new ConnectionDetector(mContext);

    }


    @Override
    public void onClick(View v) {

    }
}
