package com.ibt.niramayapharmacy.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ibt.niramayapharmacy.R;

import java.util.List;

public class AddMedicineAdapter extends RecyclerView.Adapter<AddMedicineAdapter.MyViewHolder> {

    private List<String> vendorLists;
    private Context mContext;

    public AddMedicineAdapter(List<String> vendorLists, Context mContext) {
        this.vendorLists = vendorLists;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_add_medicine, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return vendorLists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView  txtOpen;
        public ImageView rc_img;
        private CardView cardViewItem;

        public MyViewHolder(View view) {
            super(view);
            cardViewItem = view.findViewById(R.id.cardViewItem);
            txtOpen = view.findViewById(R.id.txtOpen);
        }
    }

}
