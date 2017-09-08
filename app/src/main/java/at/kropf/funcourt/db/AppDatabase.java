package at.kropf.funcourt.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import at.kropf.funcourt.db.model.PlayerExperience;
import at.kropf.funcourt.db.model.PlayerPosition;
import at.kropf.funcourt.db.model.User;

@Database(entities = {User.class, PlayerPosition.class, PlayerExperience.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();

}
