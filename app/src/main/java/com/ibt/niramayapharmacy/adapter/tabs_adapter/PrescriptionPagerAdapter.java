package com.ibt.niramayapharmacy.adapter.tabs_adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ibt.niramayapharmacy.ui.fragment.prescription_tabs.CreateInvoiceTabFragment;
import com.ibt.niramayapharmacy.ui.fragment.prescription_tabs.DoseChartTabFragment;
import com.ibt.niramayapharmacy.ui.fragment.prescription_tabs.PreviewInvoiceTabFragment;

public class PrescriptionPagerAdapter extends FragmentPagerAdapter {

    private int COUNT = 3;

    public PrescriptionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        switch (i) {
            case 0:
                fragment = new CreateInvoiceTabFragment();
                break;
            case 1:
                fragment = new PreviewInvoiceTabFragment();
                break;
            case 2:
                fragment = new DoseChartTabFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "Create Invoice";
                break;
            case 1:
                title = "Preview Invoice";
                break;
            case 2:
                title = "Dose Chart";
                break;
        }
        return title;
    }

}
