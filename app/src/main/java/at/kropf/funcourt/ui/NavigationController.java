package at.kropf.funcourt.ui;

import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import javax.inject.Inject;

import at.kropf.funcourt.R;
import at.kropf.funcourt.ui.activities.MainActivity;
import at.kropf.funcourt.ui.login.LoginFragment;

/**
 * A utility class that handles navigation in {@link at.kropf.funcourt.ui.activities.MainActivity}.
 */
public class NavigationController {

    private final int containerId;
    private final android.support.v4.app.FragmentManager fragmentManager;
    private static final String BACK_STACK = "main";

    @Inject
    NavigationController(MainActivity mainActivity) {
        this.containerId = R.id.fragment_container;
        this.fragmentManager = mainActivity.getSupportFragmentManager();
    }

    public void navigateToWelcome(boolean directionBackwards) {
        if (fragmentManager.findFragmentById(containerId) instanceof WelcomeFragment) {
            return;
        }

        fragmentManager.popBackStack(BACK_STACK, android.app.FragmentManager.POP_BACK_STACK_INCLUSIVE);

        WelcomeFragment welcomeFragment = WelcomeFragment.newInstance();

        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        addAnimation(transaction, directionBackwards)
                .replace(containerId, welcomeFragment);

        doTransaction(transaction, 0);
    }

    public void navigateToLogin(boolean directionBackwards) {
        if (fragmentManager.findFragmentById(containerId) instanceof LoginFragment) {
            return;
        }

        fragmentManager.popBackStack(BACK_STACK, android.app.FragmentManager.POP_BACK_STACK_INCLUSIVE);

        LoginFragment loginFragment = LoginFragment.newInstance();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        addAnimation(transaction, directionBackwards)
                .replace(containerId, loginFragment);

        doTransaction(transaction, 0);
    }

    private FragmentTransaction addAnimation(FragmentTransaction transaction, boolean isBackwardsDirection) {
        Fragment currentFragment = fragmentManager.findFragmentById(containerId);
        if (currentFragment != null) {
            if (isBackwardsDirection) {
                transaction.setCustomAnimations(R.anim.slide_in_from_left, R.anim.slide_out_to_right, R.anim.slide_in_from_right, R.anim.slide_out_to_left);
            } else {
                transaction.setCustomAnimations(R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_left, R.anim.slide_out_to_right);
            }
        }
        return transaction;
    }

    private void doTransaction(FragmentTransaction transaction, int timeout) {
        HandlerThread thread = new HandlerThread("loginDelayHandler");
        thread.start();

        Runnable r = transaction::commit;

        Handler h = new Handler(thread.getLooper());
        h.postDelayed(r, timeout);
    }
}
