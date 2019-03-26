package com.ibt.niramayapharmacy.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ibt.niramayapharmacy.R;
import com.ibt.niramayapharmacy.constant.Constant;
import com.ibt.niramayapharmacy.ui.fragment.AddMedicineFragment;
import com.ibt.niramayapharmacy.ui.fragment.FragmentTabDoseChart;
import com.ibt.niramayapharmacy.ui.fragment.HomeFragment;
import com.ibt.niramayapharmacy.ui.fragment.LatestSalesFragment;
import com.ibt.niramayapharmacy.ui.fragment.PrescriptionsFragment;
import com.ibt.niramayapharmacy.ui.fragment.ProfileFragment;
import com.ibt.niramayapharmacy.utils.BaseActivity;
import com.ibt.niramayapharmacy.utils.FragmentUtils;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

public class HomeActivity extends BaseActivity implements View.OnClickListener {

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
        fragmentUtils.replaceFragment(new HomeFragment(), Constant.HomeFragment, R.id.home_frame);

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
        findViewById(R.id.txtHome).setOnClickListener(this);
        findViewById(R.id.txtPrescription).setOnClickListener(this);
        findViewById(R.id.txtReports).setOnClickListener(this);
        findViewById(R.id.txtInvoice).setOnClickListener(this);
        findViewById(R.id.txtBed).setOnClickListener(this);
        findViewById(R.id.txtHistory).setOnClickListener(this);
        findViewById(R.id.txtBloodDonation).setOnClickListener(this);
        findViewById(R.id.txtAddMedicine).setOnClickListener(this);
        findViewById(R.id.txtProfile).setOnClickListener(this);
        findViewById(R.id.txtLatestSales).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Fragment HomeFragment = fragmentManager.findFragmentByTag(Constant.HomeFragment);
        Fragment PrescriptionFragment = fragmentManager.findFragmentByTag(Constant.PrescriptionFragment);
        Fragment ProfileFragment = fragmentManager.findFragmentByTag(Constant.ProfileFragment);
        Fragment AddMedicineFragment = fragmentManager.findFragmentByTag(Constant.AddMedicineFragment);
        switch (v.getId()) {

            case R.id.txtHome:
                txtTitle.setText("Home");
                if (HomeFragment == null) {
                    fragmentUtils.replaceFragment(new HomeFragment(), Constant.HomeFragment, R.id.home_frame);
                }
                break;
            case R.id.txtPrescription:
                txtTitle.setText("Prescription");
                if (PrescriptionFragment == null) {
                    fragmentUtils.replaceFragment(new PrescriptionsFragment(), Constant.PrescriptionFragment, R.id.home_frame);
                }
                break;
            case R.id.txtProfile:
                txtTitle.setText("Profile");
                if (ProfileFragment == null) {
                    fragmentUtils.replaceFragment(new ProfileFragment(), Constant.ProfileFragment, R.id.home_frame);
                }
                break;
            case R.id.txtAddMedicine:
                txtTitle.setText("Add Medicine");
                if (AddMedicineFragment == null) {
                    fragmentUtils.replaceFragment(new AddMedicineFragment(), Constant.AddMedicineFragment, R.id.home_frame);
                }
                break;
        }
        slidingRootNav.closeMenu();
    }

    @Override
    public void onBackPressed() {
        Fragment HomeFragment = fragmentManager.findFragmentByTag(Constant.HomeFragment);
        Fragment PrescriptionFragment = fragmentManager.findFragmentByTag(Constant.PrescriptionFragment);
        Fragment ProfileFragment = fragmentManager.findFragmentByTag(Constant.ProfileFragment);
        Fragment AddMedicineFragment = fragmentManager.findFragmentByTag(Constant.AddMedicineFragment);

        if (HomeFragment != null) {
            finish();
        } else if (PrescriptionFragment != null) {
            fragmentUtils.replaceFragment(new HomeFragment(), Constant.HomeFragment, R.id.home_frame);
        } else if (ProfileFragment != null) {
            fragmentUtils.replaceFragment(new ProfileFragment(), Constant.ProfileFragment, R.id.home_frame);
        } else if (AddMedicineFragment != null) {
            fragmentUtils.replaceFragment(new AddMedicineFragment(), Constant.AddMedicineFragment, R.id.home_frame);
        } else {
            finish();
        }
    }
}
