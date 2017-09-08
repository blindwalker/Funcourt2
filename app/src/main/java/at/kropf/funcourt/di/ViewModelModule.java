package at.kropf.funcourt.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import at.kropf.funcourt.ui.registration.RegistrationViewModel;
import at.kropf.funcourt.viewmodel.FuncourtViewModelFactory;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(RegistrationViewModel.class)
    abstract ViewModel bindRegistrationViewModel(RegistrationViewModel userViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(FuncourtViewModelFactory factory);
}
