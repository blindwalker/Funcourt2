package at.kropf.funcourt.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import at.kropf.funcourt.R;

public class RegisterActivity extends AppCompatActivity implements TextWatcher{

    private EditText txtEmail;
    private EditText txtPassword;
    private EditText txtUsername;
    private Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        btnConfirm = (Button) findViewById(R.id.btnConfirm);

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
        if(validateInput()) {
            btnConfirm.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            btnConfirm.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            btnConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(RegisterActivity.this, ProfileActivity.class));
                }
            });
        } else {
            btnConfirm.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            btnConfirm.setTextColor(getResources().getColor(R.color.colorPrimaryDark20));
            btnConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }
    }

    private boolean validateInput() {
        boolean isValid = true;

        if(TextUtils.isEmpty(txtEmail.getText()) || !android.util.Patterns.EMAIL_ADDRESS.matcher(txtEmail.getText()).matches()) {
            isValid = false;
        }

        if(TextUtils.isEmpty(txtPassword.getText())) {
            isValid = false;
        }

        if(TextUtils.isEmpty(txtUsername.getText())) {
            isValid = false;
        }

        return isValid;
    }
}
