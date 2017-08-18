package at.kropf.funcourt.application;

import android.app.Application;

import at.kropf.funcourt.model.User;

/**
 * Created by martinkropf on 02.01.16.
 */
public class App extends Application {

    private static Preferences preferences;
    private static User currentUser;

    public static Preferences getPreferences() {
        return preferences;
    }

    public static User getCurrentUser() {
        return currentUser;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        preferences = new Preferences(this);
        currentUser = new User();
    }
}
