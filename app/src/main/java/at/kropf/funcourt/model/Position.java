package at.kropf.funcourt.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by martinkropf on 30.12.15.
 */
public class Position {

    private int id;
    private String shortName;
    private String name;

    public Position(int id, String shortName, String name) {
        this.id = id;
        this.shortName = shortName;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Map<Integer, Position> createDummyPositionList() {
        Map<Integer, Position> positionMap = new HashMap<>();
        positionMap.put(0, new Position(0, "T", "Tor"));
        positionMap.put(0, new Position(1, "V", "Verteidigung"));
        positionMap.put(0, new Position(2, "M", "Mittelfeld"));
        positionMap.put(0, new Position(3, "S", "Sturm"));

        return positionMap;
    }

}
