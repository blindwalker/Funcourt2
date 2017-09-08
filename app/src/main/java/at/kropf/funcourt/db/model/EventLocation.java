package at.kropf.funcourt.db.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;

import at.kropf.funcourt.db.DbConfig;

@Entity(tableName = DbConfig.EVENT_LOCATION_TABLE_NAME)
public class EventLocation {

    @PrimaryKey
    private int uid;

    private String name;

    @Ignore
    private Bitmap image;

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

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
