package main;

public class App 
{
    public static void main( String[] args )
    {
        ChampionshipManager cm = ChampionshipManager.getInstance();

        //Create cars and drivers
        GravelCar gravel1 = new GravelCar("Volkswagen", "Beetle RX", 600, 2);
        GravelCar gravel2 = new GravelCar("Hyundai", "Veloster SR Turbo", 200, 3);
        AsphaltCar asphalt1 = new AsphaltCar("Mazda", "RX-8", 250, 2500);
        AsphaltCar asphalt2 = new AsphaltCar("Subaru", "Impreza", 300, 4000);

        Driver driver1 = new Driver("Linh", "Vietnam", gravel1);
        Driver driver2 = new Driver("Benzamin", "Finland", asphalt2);
        Driver driver3 = new Driver("Mane", "Senegal", gravel2);
        Driver driver4 = new Driver("Marvin", "Brazil", asphalt1);

        //Register drivers to the championship manager
        cm.registerDriver(driver1);
        cm.registerDriver(driver2);
        cm.registerDriver(driver3);
        cm.registerDriver(driver4);

        //Create first race and record result
        RallyRaceResult race1 = new RallyRaceResult("Vietnam GP", "Ha Noi");
        race1.recordResult(driver1, 1, 25);
        race1.recordResult(driver2, 2, 18);
        race1.recordResult(driver3, 3, 15);
        race1.recordResult(driver4, 4, 12);

        cm.addRaceResult(race1);

        // Change car
        driver1.setCar(asphalt2);
        driver2.setCar(gravel1);
        driver3.setCar(asphalt1);
        driver4.setCar(gravel2);

        // Create second race and record result
        RallyRaceResult race2 = new RallyRaceResult("Monza Rally", "Monza");
        race2.recordResult(driver3, 1, 25);
        race2.recordResult(driver4, 2, 18);
        race2.recordResult(driver2, 3, 15);
        race2.recordResult(driver1, 4, 12);

        cm.addRaceResult(race2);

        //Display Standing
        System.out.println("Championship standing:");
        int i = 1;
        for (Driver driver : cm.getDriverStandings()) {
            System.out.println(i + ". " + driver.getName() + " (" + driver.getCountry() + "): " + driver.getPoints() + " points");
        }
        System.out.println("\nCHAMPIONSHIP LEADER");
        System.out.println(ChampionshipManager.getLeadingDriver().getName() + " with " + cm.getLeadingDriver().getPoints() + " points");

        //Display Statistic
        System.out.println("\nChampionship Statistic");
        System.out.println("Total Drivers: " + cm.getTotalDrive());
        System.out.println("Total Races: " + cm.getTotalRace());
        System.out.println("Average Points Per Driver: " + ChampionshipStatistics.calculateAveragePointsPerDriver(cm.getDriverStandings()));
        System.out.println("Most Successful Country: " + ChampionshipStatistics.findMostSuccessfulCountry(cm.getDriverStandings()));
        System.out.println("Total Championship Points: " + cm.getTotalChampionshipPoints());

        //Display Races Result
        System.out.println("\nRACE RESULTS");
        for (RallyRaceResult race : cm.getRaces()) {
            System.out.println("Race: " + race.getRaceName() + " (" + race.getLocation() + ")");
            int j =1;
            for (Driver driver : race.getResults()) {
                System.out.println("Position " + j + ": " + driver.getName() + " - " + race.getDriverPoints(driver) + " points");
                j++;
            }
            System.out.println();
        }

        //Display Car Performance Rating
        System.out.println("CAR PERFORMANCE RATING");
        System.out.println(gravel1.getMake() + " " + gravel1.getModel() + " Performance: " + Math.round(gravel1.calculatePerformance()*100.0)/100.0);
        System.out.println(gravel2.getMake() + " " + gravel2.getModel() + " Performance: " + Math.round(gravel2.calculatePerformance()*100.0)/100.0);
        System.out.println(asphalt1.getMake() + " " + asphalt1.getModel() + " Performance: " + Math.round(asphalt1.calculatePerformance()*100.0)/100.0);
        System.out.println(asphalt2.getMake() + " " + asphalt2.getModel() + " Performance: " + Math.round(asphalt2.calculatePerformance()*100.0)/100.0);
    }
}
