package at.kropf.funcourt.application;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import at.kropf.funcourt.db.model.User;
import at.kropf.funcourt.di.AppInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class FuncourtApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    private static Preferences preferences;

    @Override
    public void onCreate() {
        super.onCreate();

        AppInjector.init(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    public static User getCurrentUser() {
        return null;
    }
}
