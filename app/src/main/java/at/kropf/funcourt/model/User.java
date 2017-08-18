package at.kropf.funcourt.model;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by martinkropf on 31.12.15.
 */
public class User {

    public enum StrongFoot {
        LEFT, RIGHT, BOTH
    };

    public enum Experience {
        AMATEUR, TEAM, FORMER_TEAM
    }

    private int id;
    private String email;
    private String username;
    private Map<Integer, Position> positions;
    private Experience experience;
    private StrongFoot strongFoot;
    private Bitmap profileImage;

    public User() {}

    public User(int id, String email, String username, Map<Integer, Position> positions, Experience experience, StrongFoot strongFoot, Bitmap profileImage) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.positions = positions;
        this.experience = experience;
        this.strongFoot = strongFoot;
        this.profileImage = profileImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Map<Integer, Position> getPositions() {
        return positions;
    }

    public void setPositions(Map<Integer, Position> positions) {
        this.positions = positions;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public StrongFoot getStrongFoot() {
        return strongFoot;
    }

    public void setStrongFoot(StrongFoot strongFoot) {
        this.strongFoot = strongFoot;
    }

    public Bitmap getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(Bitmap profileImage) {
        this.profileImage = profileImage;
    }

    public static List<User> createDummyUserList(int amount) {
        List<User> userList = new ArrayList<>();
        for(int i=0; i<amount; i++) {
            User tempUser = new User();
            tempUser.setId(i);
            tempUser.setEmail("a@b.cd"+i);
            tempUser.setExperience(Experience.AMATEUR);
            tempUser.setStrongFoot(StrongFoot.RIGHT);
            tempUser.setUsername("user"+i);
            tempUser.setPositions(Position.createDummyPositionList());
            userList.add(tempUser);
        }

        return userList;
    }
}
