package at.kropf.funcourt.ui.registration;

import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import at.kropf.funcourt.repository.UserRepository;

public class RegistrationViewModel extends ViewModel {


    @Inject
    public RegistrationViewModel(UserRepository userRepository) {

    }
}
