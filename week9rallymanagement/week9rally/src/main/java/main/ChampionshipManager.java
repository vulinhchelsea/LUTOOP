package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChampionshipManager {
    private static ChampionshipManager instance;
    private List<Driver> drivers;
    private List<RallyRaceResult> races;
    private static int totalDrivers = 0;
    private static int totalRace = 0;

    private ChampionshipManager() {
        drivers = new ArrayList<>();
        races = new ArrayList<>();
    }

    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    //Register drivers
    public void registerDriver(Driver driver) {
        drivers.add(driver);
        totalDrivers ++;
    }

    //Get total number of drivers
    public int getTotalDrive() {
        return totalDrivers;
    }

    //Add result to Championship Manager
    public void addRaceResult(RallyRaceResult result) {
        races.add(result);
        totalRace ++;
    }

    //Return races
    public List<RallyRaceResult> getRaces() {
        return races;
    }

    //Return total number of races
    public int getTotalRace() {
        return totalRace;
    }

    //Get driver standing sorted by total points
    public List<Driver> getDriverStandings() {
        Map<Driver, Integer> totalPoints = new HashMap<>();
        for (RallyRaceResult race : races) {
            for (Driver driver : race.getResults()) {
                int points = race.getDriverPoints(driver);
                totalPoints.put(driver, totalPoints.getOrDefault(driver, 0) + points);
            }
        }

        List<Driver> standings = new ArrayList<>(totalPoints.keySet());

        standings.sort((driver1,driver2) -> totalPoints.get(driver2) - totalPoints.get(driver1));

        return standings;
    }

    //Get top driver - index 0 of driver standing
    public static Driver getLeadingDriver() {
        ChampionshipManager cm = getInstance();
        List<Driver> standings = cm.getDriverStandings();
        
        if (standings.isEmpty()) {
            return null;
        }
        return standings.get(0);
    }

    //Calculate total Championship Points
    public static int getTotalChampionshipPoints() {
        ChampionshipManager cm = getInstance();
        int totalChampionshipPoints = 0;

        for (RallyRaceResult race : cm.races) {
            for (Driver driver : race.getResults()) {
                totalChampionshipPoints += race.getDriverPoints(driver);
            }
        }
        return totalChampionshipPoints;
    }
}
