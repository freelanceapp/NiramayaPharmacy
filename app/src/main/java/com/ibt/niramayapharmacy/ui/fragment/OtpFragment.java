package com.ibt.niramayapharmacy.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.ibt.niramayapharmacy.R;
import com.ibt.niramayapharmacy.ui.activity.HomeActivity;
import com.ibt.niramayapharmacy.utils.BaseFragment;


public class OtpFragment extends BaseFragment implements OnClickListener {
    private static View view;

    private static EditText emailId;
    private static TextView submit, back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.otp_layout, container, false);
        mContext = getActivity();
        initViews();
        setListeners();
        return view;
    }

    // Initialize the views
    private void initViews() {
        //emailId = (EditText) view.findViewById(R.id.registered_emailid);
        submit = (TextView) view.findViewById(R.id.btnSubmit);
        //back = (TextView) view.findViewById(R.id.backToLoginBtn);

        // Setting text selector over textviews
        @SuppressLint("ResourceType") XmlResourceParser xrp = getResources().getXml(R.drawable.text_selector);
        try {
            ColorStateList csl = ColorStateList.createFromXml(getResources(),
                    xrp);

            back.setTextColor(csl);
            submit.setTextColor(csl);

        } catch (Exception e) {
        }

    }

    // Set Listeners over buttons
    private void setListeners() {
        //back.setOnClickListener(this);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
		/*case R.id.backToLoginBtn:
			// Replace Login Fragment on Back Presses
			new LoginActivity().replaceLoginFragment();
			break;*/
            case R.id.btnSubmit:
                startActivity(new Intent(mContext, HomeActivity.class));
                break;

        }

    }

	/*private void submitButtonTask() {
		String getEmailId = emailId.getText().toString();

		// Pattern for email id validation
		Pattern p = Pattern.compile(ConstantData.regEx);

		// Match the pattern
		Matcher m = p.matcher(getEmailId);

		// First check if email id is not null else show error toast
		if (getEmailId.equals("") || getEmailId.length() == 0)

			new CustomToast().Show_Toast(getActivity(), view,
					"Please enter your Email Id.");

		// Check if email id is valid or not
		else if (!m.find())
			new CustomToast().Show_Toast(getActivity(), view,
					"Your Email Id is Invalid.");

		// Else submit email id and fetch passwod or do your stuff
		else
			Toast.makeText(getActivity(), "Get Forgot Password.",
					Toast.LENGTH_SHORT).show();
	}*/
}