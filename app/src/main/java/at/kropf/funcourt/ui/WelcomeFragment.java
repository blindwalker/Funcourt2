package at.kropf.funcourt.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import at.kropf.funcourt.R;
import at.kropf.funcourt.di.Injectable;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeFragment extends android.support.v4.app.Fragment implements Injectable{

    @Inject
    NavigationController navigationController;

    public static WelcomeFragment newInstance() {
        return new WelcomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        ButterKnife.bind(this, view);

        return view;
    }


    @OnClick(R.id.btnLogin)
    public void goToLogin() {
        navigationController.navigateToLogin(false);
    }

    @OnClick(R.id.btnRegister)
    public void goToRegistration() {
        //startActivity(new Intent(WelcomeActivity.this, RegistrationActivity.class));
    }

}
