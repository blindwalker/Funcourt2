package at.kropf.funcourt.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import at.kropf.funcourt.db.model.User;
import io.reactivex.Single;

@Dao
public interface UserDao {

    @Query("SELECT * FROM " + DbConfig.USER_TABLE_NAME)
    List<User> getAll();

    @Query("SELECT * FROM " + DbConfig.USER_TABLE_NAME + " WHERE logged_in == 1")
    Single<User> getLoggedInUser();

    @Query("SELECT * FROM " + DbConfig.USER_TABLE_NAME + " WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}