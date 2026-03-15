package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChampionshipStatistics {

    //Calculate average point per drive
    static double calculateAveragePointsPerDriver(List<Driver> drivers) {
        ChampionshipManager cm = ChampionshipManager.getInstance();
        int totalChampionshipPoints = ChampionshipManager.getTotalChampionshipPoints();

        if (drivers.isEmpty()) {
            return 0.0;
        }

        return totalChampionshipPoints/cm.getTotalDrive();
    }

    //Find most successful country by total points of drivers with that nationality
    static String findMostSuccessfulCountry(List<Driver> drivers) {
        ChampionshipManager cm = ChampionshipManager.getInstance();
        Map<String, Integer> countriesPoints = new HashMap<>();

        for (Driver driver : drivers) {
            int point = 0;

            for (RallyRaceResult race : cm.getRaces()) {
                point += race.getDriverPoints(driver);
            }

            countriesPoints.put(driver.getCountry(), countriesPoints.getOrDefault(driver, 0) + point);
        }

        String bestCountry = null;
        int maxCountryPoint = -1;

        for(Map.Entry<String, Integer> entry : countriesPoints.entrySet()) {
            if (entry.getValue() > maxCountryPoint) {
                maxCountryPoint = entry.getValue();
                bestCountry = entry.getKey();
            }
        }

        return bestCountry;
    }

    //Get total number of races held
    static int getTotalRacesHeld() {
        ChampionshipManager cm = ChampionshipManager.getInstance();
        return cm.getTotalRace();
    }

}
