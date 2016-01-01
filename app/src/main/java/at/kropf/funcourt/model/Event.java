package at.kropf.funcourt.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import at.kropf.funcourt.R;

/**
 * Created by martinkropf on 31.12.15.
 */
public class Event {

    private int id;
    private String name;
    private EventLocation location;
    private Date date;
    private int playersMin;
    private int playersMax;
    private int playersCurrent;
    private User creator;

    public Event() {
    }

    public Event(int id, String name, EventLocation location, Date date, int playersMin, int playersMax, int playersCurrent, User creator) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.date = date;
        this.playersMin = playersMin;
        this.playersMax = playersMax;
        this.playersCurrent = playersCurrent;
        this.creator = creator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventLocation getLocation() {
        return location;
    }

    public void setLocation(EventLocation location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public static List<Event> dummyEvents(int count, Context context) {
        List<Event> eventList = new ArrayList<>();
        Bitmap bm = BitmapFactory.decodeResource(context.getResources(), R.drawable.event_placeholder);

        for(int i=0;i<count;i++) {
            Event tempEvent = new Event();
            tempEvent.setId(i);
            tempEvent.setDate(new Date());
            tempEvent.setName("Event nr "+new Random().nextInt());
            tempEvent.setPlayersCurrent(i);
            tempEvent.setPlayersMax(100);
            tempEvent.setLocation(new EventLocation(i, "Ort"+i, bm));
            eventList.add(tempEvent);
        }
        return eventList;
    }
}
