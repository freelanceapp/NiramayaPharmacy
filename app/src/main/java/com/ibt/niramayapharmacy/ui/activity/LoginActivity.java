package com.ibt.niramayapharmacy.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.ibt.niramayapharmacy.R;
import com.ibt.niramayapharmacy.constant.Constant;
import com.ibt.niramayapharmacy.ui.fragment.LoginFragment;
import com.ibt.niramayapharmacy.utils.BaseActivity;
import com.ibt.niramayapharmacy.utils.FragmentUtils;

public class LoginActivity extends BaseActivity {

    public static FragmentManager fragmentManager;
    public static FragmentUtils fragmentUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        fragmentManager = getSupportFragmentManager();
        fragmentUtils = new FragmentUtils(fragmentManager);

        if (savedInstanceState == null) {
            fragmentUtils.replaceFragment(new LoginFragment(), Constant.LoginFragment, R.id.login_frame);
        }
    }

    @Override
    public void onBackPressed() {
        // Find the tag of signup and forgot password fragment
        Fragment SignUp_Fragment = fragmentManager
                .findFragmentByTag(Constant.SignUpFragment);
        Fragment ForgotPassword_Fragment = fragmentManager
                .findFragmentByTag(Constant.Otp_Fragment);

        if (SignUp_Fragment != null)
            fragmentUtils.replaceFragment(new LoginFragment(), Constant.LoginFragment, R.id.login_frame);
        else if (ForgotPassword_Fragment != null)
            fragmentUtils.replaceFragment(new LoginFragment(), Constant.LoginFragment, R.id.login_frame);
        else
            super.onBackPressed();
    }
}


