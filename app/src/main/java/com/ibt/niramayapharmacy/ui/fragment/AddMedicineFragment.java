package com.ibt.niramayapharmacy.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ibt.niramayapharmacy.R;
import com.ibt.niramayapharmacy.adapter.AddMedicineAdapter;
import com.ibt.niramayapharmacy.utils.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class AddMedicineFragment extends BaseFragment {
    private View rootview;
    private AddMedicineAdapter addMedicineAdapter;
    private List<String> addMedicineList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_add_medicine,container,false);
        init();
        return rootview;
    }

    private void init() {
        RecyclerView rvAddMedicine = rootview.findViewById(R.id.rvAddMedicine);
        rvAddMedicine.setHasFixedSize(true);
        rvAddMedicine.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        addMedicineAdapter = new AddMedicineAdapter(addMedicineList, mContext);
        rvAddMedicine.setAdapter(addMedicineAdapter);
    }
}
