package at.kropf.funcourt.ui.login;

import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import at.kropf.funcourt.repository.UserRepository;

public class LoginViewModel extends ViewModel {

    private UserRepository userRepository;

    @Inject
    public LoginViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
