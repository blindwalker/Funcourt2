package at.kropf.funcourt.db.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

import at.kropf.funcourt.db.DbConfig;

@Entity(tableName = DbConfig.EVENT_TABLE_NAME)
public class League {

    @PrimaryKey
    private int uid;

    @ColumnInfo(name="league_name")
    private String name;

    @ColumnInfo(name="league_creator")
    private int creator;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }
}
