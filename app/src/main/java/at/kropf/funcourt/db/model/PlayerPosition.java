package at.kropf.funcourt.db.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import at.kropf.funcourt.db.DbConfig;

@Entity(tableName = DbConfig.PLAYER_POSITION_TABLE_NAME)
public class PlayerPosition {

    @PrimaryKey
    private int uid;

    @ColumnInfo(name="position_name")
    private String positionName;

    @ColumnInfo(name="position_name_short")
    private String positionShortName;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionShortName() {
        return positionShortName;
    }

    public void setPositionShortName(String positionShortName) {
        this.positionShortName = positionShortName;
    }
}
