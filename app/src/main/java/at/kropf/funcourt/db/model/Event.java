package at.kropf.funcourt.db.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;

import java.util.Date;

import at.kropf.funcourt.db.DbConfig;

@Entity(tableName = DbConfig.EVENT_TABLE_NAME)
public class Event {

    @PrimaryKey
    private int uid;

    @ColumnInfo(name="event_name")
    private String name;

    @ColumnInfo(name="event_location")
    private int eventLocation;

    @ColumnInfo(name="event_date")
    private Date eventDate;

    @ColumnInfo(name="event_players_min")
    private int playersMin;

    @ColumnInfo(name="event_players_max")
    private int playersMax;

    @ColumnInfo(name="event_players_current")
    private int playersCurrent;

    @ColumnInfo(name="event_creator")
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

    public int getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(int eventLocation) {
        this.eventLocation = eventLocation;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public int getPlayersMin() {
        return playersMin;
    }

    public void setPlayersMin(int playersMin) {
        this.playersMin = playersMin;
    }

    public int getPlayersMax() {
        return playersMax;
    }

    public void setPlayersMax(int playersMax) {
        this.playersMax = playersMax;
    }

    public int getPlayersCurrent() {
        return playersCurrent;
    }

    public void setPlayersCurrent(int playersCurrent) {
        this.playersCurrent = playersCurrent;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }
}
