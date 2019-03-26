package com.ibt.niramayapharmacy.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ibt.niramayapharmacy.R;
import com.ibt.niramayapharmacy.constant.Constant;
import com.ibt.niramayapharmacy.ui.fragment.DashboardFragment;
import com.ibt.niramayapharmacy.ui.fragment.PrescriptionsFragment;
import com.ibt.niramayapharmacy.utils.BaseActivity;
import com.ibt.niramayapharmacy.utils.FragmentUtils;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

public class HomeActivity extends BaseActivity  implements View.OnClickListener {

    public static TextView txtTitle;
    public static ImageView imgSearch, imgSort;
    private SlidingRootNav slidingRootNav;
    private FragmentUtils fragmentUtils;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init(savedInstanceState);
    }

    private void init(Bundle savedInstanceState) {
        imgSearch = findViewById(R.id.imgSearch);
        imgSort = findViewById(R.id.imgSort);
        txtTitle = findViewById(R.id.txtTitle);

        fragmentManager = getSupportFragmentManager();
        fragmentUtils = new FragmentUtils(fragmentManager);
        fragmentUtils.replaceFragment(new DashboardFragment(), Constant.HomeFragment, R.id.home_frame);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        slidingRootNav = new SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(true)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.menu_left_drawer)
                .inject();

        clickListener();
    }

    private void clickListener() {
        findViewById(R.id.txtDashboard).setOnClickListener(this);
        findViewById(R.id.txtPrescription).setOnClickListener(this);
        findViewById(R.id.txtMedicine).setOnClickListener(this);
        findViewById(R.id.txtAddMedicine).setOnClickListener(this);
        findViewById(R.id.txtSales).setOnClickListener(this);
        findViewById(R.id.txtExpenses).setOnClickListener(this);
        findViewById(R.id.txtProfile).setOnClickListener(this);
        findViewById(R.id.txtNotification).setOnClickListener(this);
        findViewById(R.id.txtSettings).setOnClickListener(this);
    }

   @Override
    public void onClick(View v) {
       Fragment HomeFragment = fragmentManager.findFragmentByTag(Constant.HomeFragment);
       Fragment PrescriptionFragment = fragmentManager.findFragmentByTag(Constant.PrescriptionFragment);
     /*   Fragment AddUserFragment = fragmentManager.findFragmentByTag(Constant.AddUserFragment);
        Fragment BloodDonationFragment = fragmentManager.findFragmentByTag(Constant.BloodDonationFragment);
        Fragment BedFragment = fragmentManager.findFragmentByTag(Constant.BedFragment);

        Fragment InvoiceFragment = fragmentManager.findFragmentByTag(Constant.InvoiceFragment);*/
        //Fragment ReportFragment = fragmentManager.findFragmentByTag(Constant.ReportsFragment);
        switch (v.getId()) {

            case R.id.txtDashboard:
                txtTitle.setText("Dashboard");
                if (HomeFragment == null) {
                    fragmentUtils.replaceFragment(new DashboardFragment(), Constant.HomeFragment, R.id.home_frame);
                }
                break;
            case R.id.txtPrescription:
                txtTitle.setText("Prescription");
                if (PrescriptionFragment == null) {
                    fragmentUtils.replaceFragment(new PrescriptionsFragment(), Constant.PrescriptionFragment, R.id.home_frame);
                }
                break;
            /*case R.id.txtMedicine:
                txtTitle.setText("Medicine");
                if (ReportFragment == null) {
                    fragmentUtils.replaceFragment(new ReportFragment(), Constant.ReportsFragment, R.id.home_frame);
                }
                break;
            case R.id.txtAddMedicine:
                txtTitle.setText("Invoice");
                if (InvoiceFragment == null) {
                    fragmentUtils.replaceFragment(new InvoiceFragment(), Constant.InvoiceFragment, R.id.home_frame);
                }
                break;
            case R.id.Sales:
                txtTitle.setText("Bed History");
                if (BedFragment == null) {
                    fragmentUtils.replaceFragment(new BedFragment(), Constant.BedFragment, R.id.home_frame);
                }
                break;
            case R.id.txtExpenses:
                break;
            case R.id.txtBloodDonation:
                txtTitle.setText("Expenses");
                if (BloodDonationFragment == null) {
                    fragmentUtils.replaceFragment(new BloodDonationFragment(), Constant.BloodDonationFragment, R.id.home_frame);
                }
                break;
            case R.id.txtDocuments:
                break;
            case R.id.txtSettings:
                break;
            case R.id.txtAddUser:
                txtTitle.setText("Add User");
                if (AddUserFragment == null) {
                    fragmentUtils.replaceFragment(new AddUserFragment(), Constant.AddUserFragment, R.id.home_frame);
                }
                break;*/
        }
        slidingRootNav.closeMenu();
    }

    @Override
    public void onBackPressed() {
        Fragment HomeFragment = fragmentManager.findFragmentByTag(Constant.HomeFragment);
        Fragment PrescriptionFragment = fragmentManager.findFragmentByTag(Constant.PrescriptionFragment);
       /* Fragment AddUserFragment = fragmentManager.findFragmentByTag(Constant.AddUserFragment);
        Fragment BedFragment = fragmentManager.findFragmentByTag(Constant.BedFragment);
        Fragment InvoiceFragment = fragmentManager.findFragmentByTag(Constant.InvoiceFragment);
        Fragment ReportFragment = fragmentManager.findFragmentByTag(Constant.ReportsFragment);
*/
        if (HomeFragment != null) {
            finish();
        } else if (PrescriptionFragment != null) {
            fragmentUtils.replaceFragment(new DashboardFragment(), Constant.HomeFragment, R.id.home_frame);
        } /*else if (ReportFragment != null) {
            fragmentUtils.replaceFragment(new DashboardFragment(), Constant.DashboardFragment, R.id.home_frame);
        } else if (InvoiceFragment != null) {
            fragmentUtils.replaceFragment(new DashboardFragment(), Constant.DashboardFragment, R.id.home_frame);
        } else if (BedFragment != null) {
            fragmentUtils.replaceFragment(new DashboardFragment(), Constant.DashboardFragment, R.id.home_frame);
        }*/ else {
            finish();
        }
    }
}
