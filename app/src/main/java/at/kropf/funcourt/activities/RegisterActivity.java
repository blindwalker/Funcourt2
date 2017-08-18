package at.kropf.funcourt.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import java.util.Arrays;

import at.kropf.funcourt.R;
import at.kropf.funcourt.application.App;

public class RegisterActivity extends AppCompatActivity implements
        TextWatcher,
        View.OnClickListener {

    private static final String TAG = "RegisterActivity";
    private EditText txtEmail;
    private EditText txtPassword;
    private EditText txtUsername;
    private Button btnConfirm;
    private CallbackManager callbackManager;
    private AccessToken accessToken;
    private AccessTokenTracker accessTokenTracker;

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

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Log.d("FB", "logged in");
                        App.getCurrentUser().setUsername(Profile.getCurrentProfile().getFirstName());

                        Picasso.with(RegisterActivity.this).load(Profile.getCurrentProfile().getProfilePictureUri(150, 150)).into(new Target() {
                            @Override
                            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                                Log.i(TAG, "The image was obtained correctly");
                                App.getCurrentUser().setProfileImage(bitmap);
                                startActivity(new Intent(RegisterActivity.this, ProfileActivity.class));
                                finish();
                            }

                            @Override
                            public void onBitmapFailed(Drawable errorDrawable) {
                                Log.e(TAG, "The image was not obtained");
                            }

                            @Override
                            public void onPrepareLoad(Drawable placeHolderDrawable) {

                            }
                        });

                    }

                    @Override
                    public void onCancel() {
                        Log.d("FB", "cancel login");
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Log.d("FB", "error logging in");
                    }
                });

        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(
                    AccessToken oldAccessToken,
                    AccessToken currentAccessToken) {
                accessToken = currentAccessToken;
            }
        };
        // If the access token is available already assign it.
        accessToken = AccessToken.getCurrentAccessToken();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
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
            case R.id.llFacebookLogin:
                LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile", "email"));
                break;
            case R.id.btnConfirm:
                if (validateInput()) {
                    App.getCurrentUser().setUsername(txtUsername.getText().toString());
                    App.getCurrentUser().setEmail(txtEmail.getText().toString());
                    startActivity(new Intent(RegisterActivity.this, ProfileActivity.class));
                }
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        accessTokenTracker.stopTracking();
    }
}
