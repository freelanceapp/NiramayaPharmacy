package com.ibt.niramayapharmacy.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.ibt.niramayapharmacy.R;

public class FragmentUtils {

    private FragmentManager fragmentManager;

    public FragmentUtils(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void replaceFragment(Fragment fragment, String tag, int frameId) {
        fragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.right_enter, R.anim.left_out)
                .replace(frameId, fragment,
                        tag).commit();
    }
}
