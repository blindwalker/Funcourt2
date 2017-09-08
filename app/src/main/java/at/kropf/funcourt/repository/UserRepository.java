package at.kropf.funcourt.repository;

import at.kropf.funcourt.db.AppDatabase;
import at.kropf.funcourt.db.model.User;
import io.reactivex.Single;

public class UserRepository {

    private AppDatabase database;

    public UserRepository(AppDatabase database) {
        this.database = database;
    }

    public Single<User> getLoggedInUser() {
        return database.userDao().getLoggedInUser();
    }
}
