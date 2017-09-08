/*
package at.kropf.funcourt.ui.registration;

import android.arch.lifecycle.LifecycleActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import javax.inject.Inject;

import at.kropf.funcourt.R;
import at.kropf.funcourt.application.FuncourtApplication;
import at.kropf.funcourt.ui.activities.ProfileActivity;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class RegistrationActivity extends LifecycleActivity implements HasSupportFragmentInjector,
        TextWatcher,
        View.OnClickListener {

    private static final String TAG = "RegistrationActivity";
    private EditText txtEmail;
    private EditText txtPassword;
    private EditText txtUsername;
    private Button btnConfirm;

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        btnConfirm = (Button) findViewById(R.id.btnConfirm);
        LinearLayout btnFacebookLogin = (LinearLayout) findViewById(R.id.llFacebookLogin);

        btnFacebookLogin.setOnClickListener(this);
        btnConfirm.setOnClickListener(this);

        txtEmail.addTextChangedListener(this);
        txtPassword.addTextChangedListener(this);
        txtUsername.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (validateInput()) {
            btnConfirm.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            btnConfirm.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        } else {
            btnConfirm.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            btnConfirm.setTextColor(getResources().getColor(R.color.colorPrimaryDark20));

        }
    }

    private boolean validateInput() {
        boolean isValid = true;

        if (TextUtils.isEmpty(txtEmail.getText()) || !android.util.Patterns.EMAIL_ADDRESS.matcher(txtEmail.getText()).matches()) {
            isValid = false;
        }

        if (TextUtils.isEmpty(txtPassword.getText())) {
            isValid = false;
        }

        if (TextUtils.isEmpty(txtUsername.getText())) {
            isValid = false;
        }

        return isValid;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnConfirm:
                if (validateInput()) {
                    FuncourtApplication.getCurrentUser().setUsername(txtUsername.getText().toString());
                    FuncourtApplication.getCurrentUser().setEmail(txtEmail.getText().toString());
                    startActivity(new Intent(RegistrationActivity.this, ProfileActivity.class));
                }
                break;
        }
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
*/
