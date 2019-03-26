package com.ibt.niramayapharmacy.ui.fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ibt.niramayapharmacy.R;
import com.ibt.niramayapharmacy.adapter.AddMedicineAdapter;
import com.ibt.niramayapharmacy.utils.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class AddMedicineFragment extends BaseFragment implements View.OnClickListener {
    private View rootview;
    private AddMedicineAdapter addMedicineAdapter;
    private List<String> addMedicineList = new ArrayList<>();
    private  int position = 0;
    private Button buttonClose,buttonAdd;
    private FloatingActionButton fbAddMedicine;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_add_medicine, container, false);
        init();
        return rootview;
    }

    private void init() {
        mContext = getActivity();
        RecyclerView rvAddMedicine = rootview.findViewById(R.id.rvAddMedicine);
         fbAddMedicine = rootview.findViewById(R.id.fbAddMedicine);
         fbAddMedicine.setOnClickListener(this);

        for (int i = 0; i <= 6; i++) {
            addMedicineList.add("Paracetamol");
            addMedicineList.add("Pain Killer");
            addMedicineList.add("100 pcs");
            addMedicineList.add("100 pcs");
        }

        rvAddMedicine.setHasFixedSize(true);
        rvAddMedicine.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        addMedicineAdapter = new AddMedicineAdapter(addMedicineList, mContext,this);
        rvAddMedicine.setAdapter(addMedicineAdapter);
        addMedicineAdapter.notifyDataSetChanged();
    }

    private void viewMedicineDialog() {
        AlertDialog.Builder dialogBox = new AlertDialog.Builder(mContext);
        dialogBox.setCancelable(false);

        LayoutInflater li = LayoutInflater.from(mContext);
        final View dialogBoxView = li.inflate(R.layout.view_medicine_dialogbox, null);
        dialogBox.setView(dialogBoxView);

        final AlertDialog alertDialog = dialogBox.create();
        alertDialog.show();
        buttonClose = dialogBoxView.findViewById(R.id.btnClose);
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.cancel();
            }
        });
    }
    private void addMedicineDialog() {
        AlertDialog.Builder dialogBox = new AlertDialog.Builder(mContext);
        dialogBox.setCancelable(false);

        LayoutInflater li = LayoutInflater.from(mContext);
        final View dialogBoxView = li.inflate(R.layout.add_medicine_dialog, null);
        dialogBox.setView(dialogBoxView);

        final AlertDialog alertDialog = dialogBox.create();
        alertDialog.show();
        buttonAdd = dialogBoxView.findViewById(R.id.btnAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.cancel();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ivViewMedicine:
            position = Integer.parseInt(v.getTag().toString());
            viewMedicineDialog();
            break;
            case R.id.fbAddMedicine:
                addMedicineDialog();
                break;
        }
    }
}
