package at.kropf.funcourt.application;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.facebook.AccessToken;

import java.util.UUID;

public class Preferences {

    private static final String PREFERENCE_IS_LOGGED_IN = "isLoggedIn";

    private SharedPreferences preferences;

    public Preferences(Context context) {
        this.preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public boolean isLoggedIn() {
        if(!preferences.getBoolean(PREFERENCE_IS_LOGGED_IN, false) && AccessToken.getCurrentAccessToken() == null) {
            return false;
        }
        return true;
    }

    public void setLoggedIn(boolean enabled) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(PREFERENCE_IS_LOGGED_IN, enabled);
        editor.commit();
    }
}
