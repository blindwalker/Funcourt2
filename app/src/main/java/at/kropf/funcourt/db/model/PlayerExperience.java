package at.kropf.funcourt.db.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import at.kropf.funcourt.db.DbConfig;

@Entity(tableName = DbConfig.PLAYER_EXPERIENCE_TABLE_NAME)
public class PlayerExperience {

    @PrimaryKey
    private int uid;

    private String experience;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
