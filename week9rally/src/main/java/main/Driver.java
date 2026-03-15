package main;

public class Driver {
    private String name;
    private String country;
    private int points = 0;
    private RallyCar car;

    public Driver (String name, String country, RallyCar car) {
        this.name = name;
        this.country = country;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getPoints() {
        return points;
    }

    public RallyCar getCar() {
        return car;
    }

    //Change car for different races
    public void setCar(RallyCar car) {
        this.car = car;
    }

    public void addPoints(int points) {
        this.points += points;
    }
    
}
