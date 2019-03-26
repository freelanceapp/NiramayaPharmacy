package com.ibt.niramayapharmacy.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
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

public class InvoiceFragment extends BaseFragment implements View.OnClickListener {

    private View rootView;
    private List<String> prescriptionList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_invoice, container, false);
        init();
        return rootView;
    }

    private void init() {
        imgSearch.setVisibility(View.VISIBLE);
        imgSort.setVisibility(View.GONE);

        activity = getActivity();
        mContext = getActivity();
        cd = new ConnectionDetector(mContext);

        invoiceListApi();
    }

    private void invoiceListApi() {
        for (int i = 0; i < 10; i++) {
            prescriptionList.add("Name");
        }
        RecyclerView recyclerViewInvoice = rootView.findViewById(R.id.recyclerViewInvoice);
        recyclerViewInvoice.setHasFixedSize(true);
        recyclerViewInvoice.setLayoutManager(new LinearLayoutManager(mContext));
        InvoiceListAdapter invoiceListAdapter = new InvoiceListAdapter(prescriptionList, mContext, this);
        recyclerViewInvoice.setAdapter(invoiceListAdapter);
        invoiceListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {

    }
}
