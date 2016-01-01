package at.kropf.funcourt.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by martinkropf on 01.01.16.
 */
public class League {

    private int id;
    private String name;
    private List<Event> events;
    private List<User> players;
    private User creator;

    public League() {
    }

    public League(int id, String name, List<Event> events, List<User> players, User creator) {
        this.id = id;
        this.name = name;
        this.events = events;
        this.players = players;
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

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<User> getPlayers() {
        return players;
    }

    public void setPlayers(List<User> players) {
        this.players = players;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public static List<League> createDummyLeagueList(int amount, Context context) {
        List<League> leagues  = new ArrayList<>();

        for(int i=0;i<amount;i++) {
            League tempLeague = new League();
            tempLeague.setId(i);
            tempLeague.setName("Liga "+i);
            tempLeague.setCreator(User.createDummyUserList(1).get(0));
            tempLeague.setEvents(Event.dummyEvents(5, context));
            tempLeague.setPlayers(User.createDummyUserList(10));
            leagues.add(tempLeague);
        }

        return leagues;
    }
}
