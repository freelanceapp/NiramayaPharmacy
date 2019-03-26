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
import com.ibt.niramayapharmacy.ui.fragment.AddMedicineFragment;
import com.ibt.niramayapharmacy.ui.fragment.DashboardFragment;
import com.ibt.niramayapharmacy.ui.fragment.InvoiceFragment;
import com.ibt.niramayapharmacy.ui.fragment.PrescriptionsFragment;
import com.ibt.niramayapharmacy.utils.BaseActivity;
import com.ibt.niramayapharmacy.utils.FragmentUtils;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    public static TextView txtTitle;
    public static ImageView imgSearch, imgSort;
    private SlidingRootNav slidingRootNav;
    public static FragmentUtils fragmentUtilsHome;
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
        fragmentUtilsHome = new FragmentUtils(fragmentManager);
        txtTitle.setText("Dashboard");
        fragmentUtilsHome.replaceFragment(new DashboardFragment(), Constant.HomeFragment, R.id.home_frame);

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
        findViewById(R.id.txtSetting).setOnClickListener(this);
        findViewById(R.id.txtInvoice).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Fragment HomeFragmentTag = fragmentManager.findFragmentByTag(Constant.HomeFragment);
        Fragment PrescriptionFragmentTag = fragmentManager.findFragmentByTag(Constant.PrescriptionFragment);
        Fragment LatestSalesFragmentTag = fragmentManager.findFragmentByTag(Constant.LatestSalesFragment);
        Fragment ProfileFragmentTag = fragmentManager.findFragmentByTag(Constant.ProfileFragment);
        Fragment AddMedicineFragmentTag = fragmentManager.findFragmentByTag(Constant.AddMedicineFragment);
        Fragment InvoiceFragmentTag = fragmentManager.findFragmentByTag(Constant.InvoiceFragment);

        switch (v.getId()) {
            case R.id.txtDashboard:
                txtTitle.setText("Dashboard");
                if (HomeFragmentTag == null) {
                    fragmentUtilsHome.replaceFragment(new DashboardFragment(), Constant.HomeFragment, R.id.home_frame);
                }
                break;
            case R.id.txtPrescription:
                txtTitle.setText("Prescription");
                if (PrescriptionFragmentTag == null) {
                    fragmentUtilsHome.replaceFragment(new PrescriptionsFragment(), Constant.PrescriptionFragment, R.id.home_frame);
                }
                break;
            case R.id.txtInvoice:
                txtTitle.setText("Invoice");
                if (InvoiceFragmentTag == null) {
                    fragmentUtilsHome.replaceFragment(new InvoiceFragment(), Constant.InvoiceFragment, R.id.home_frame);
                }
                break;
            case R.id.txtAddMedicine:
                txtTitle.setText("Add Medicine");
                if (AddMedicineFragmentTag == null) {
                    fragmentUtilsHome.replaceFragment(new AddMedicineFragment(), Constant.AddMedicineFragment, R.id.home_frame);
                }
                break;
        }
        slidingRootNav.closeMenu();
    }

    @Override
    public void onBackPressed() {
        Fragment HomeFragmentTag = fragmentManager.findFragmentByTag(Constant.HomeFragment);
        Fragment PrescriptionFragmentTag = fragmentManager.findFragmentByTag(Constant.PrescriptionFragment);
        Fragment ProfileFragmentTag = fragmentManager.findFragmentByTag(Constant.ProfileFragment);
        Fragment AddMedicineFragmentTag = fragmentManager.findFragmentByTag(Constant.AddMedicineFragment);
        Fragment InvoiceFragmentTag = fragmentManager.findFragmentByTag(Constant.InvoiceFragment);

        Fragment LatestExpensesFragmentTag = fragmentManager.findFragmentByTag(Constant.LatestExpensesFragment);
        Fragment LatestSalesFragmentTag = fragmentManager.findFragmentByTag(Constant.LatestSalesFragment);
        Fragment LatestMedicineFragmentTag = fragmentManager.findFragmentByTag(Constant.LatestMedicineFragment);

        if (LatestExpensesFragmentTag != null) {
            txtTitle.setText("Dashboard");
            fragmentUtilsHome.replaceBackFragment(new DashboardFragment(), Constant.DashboardFragment, R.id.home_frame);
        } else if (LatestSalesFragmentTag != null) {
            txtTitle.setText("Dashboard");
            fragmentUtilsHome.replaceBackFragment(new DashboardFragment(), Constant.DashboardFragment, R.id.home_frame);
        } else if (LatestMedicineFragmentTag != null) {
            txtTitle.setText("Dashboard");
            fragmentUtilsHome.replaceBackFragment(new DashboardFragment(), Constant.DashboardFragment, R.id.home_frame);
        } else if (InvoiceFragmentTag != null) {
            txtTitle.setText("Dashboard");
            fragmentUtilsHome.replaceBackFragment(new DashboardFragment(), Constant.DashboardFragment, R.id.home_frame);
        } else if (PrescriptionFragmentTag != null) {
            txtTitle.setText("Dashboard");
            fragmentUtilsHome.replaceBackFragment(new DashboardFragment(), Constant.DashboardFragment, R.id.home_frame);
        }
    }
}
