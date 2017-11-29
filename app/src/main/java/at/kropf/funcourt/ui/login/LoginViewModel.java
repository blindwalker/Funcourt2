package at.kropf.funcourt.ui.login;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import at.kropf.funcourt.repository.UserRepository;
import at.kropf.funcourt.rx.SchedulersFacade;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {

    private final CompositeDisposable disposables = new CompositeDisposable();

    private final SchedulersFacade schedulersFacade;

    private UserRepository userRepository;

    private final MutableLiveData<Response<String>> loginStatus = new MutableLiveData<>();

    @Inject
    public LoginViewModel(UserRepository userRepository, SchedulersFacade schedulersFacade) {
        this.userRepository = userRepository;
        this.schedulersFacade = schedulersFacade;
    }

    public void doLogin() {

    }

    MutableLiveData<Response<String>> getLoginStatus() {
        return loginStatus;
    }

    //TODO: add Schedulers Facade via DI
    private void loadGreeting(Single<String> single) {
        disposables.add(single
                .subscribeOn(schedulersFacade.io())
                .observeOn(schedulersFacade.ui())
                .doOnSubscribe(s -> loginStatus.setValue(true))
                .doAfterTerminate(() -> loginStatus.setValue(false))
                .subscribe(
                        greeting -> response.setValue(Response.success(greeting)),
                        throwable -> response.setValue(Response.error(throwable))
                )
        );
    }
}
