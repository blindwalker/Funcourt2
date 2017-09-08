package at.kropf.funcourt.db.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;

import at.kropf.funcourt.db.DbConfig;

@Entity(tableName = DbConfig.USER_TABLE_NAME)
public class User {


    @PrimaryKey
    private int uid;

    private String email;

    private String username;

    @ColumnInfo(name = "player_position")
    private int playerPosition;

    @ColumnInfo(name = "player_experience")
    private int playerExperience;

    @ColumnInfo(name = "strong_foot")
    private int strongFoot;

    @ColumnInfo(name = "logged_in")
    private Boolean loggedIn;

    @Ignore
    private Bitmap profileImage;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }

    public int getPlayerExperience() {
        return playerExperience;
    }

    public void setPlayerExperience(int playerExperience) {
        this.playerExperience = playerExperience;
    }

    public int getStrongFoot() {
        return strongFoot;
    }

    public void setStrongFoot(int strongFoot) {
        this.strongFoot = strongFoot;
    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public Bitmap getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(Bitmap profileImage) {
        this.profileImage = profileImage;
    }
}
