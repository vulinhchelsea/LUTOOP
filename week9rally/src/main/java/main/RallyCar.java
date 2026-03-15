package main;

public abstract class RallyCar {
    private String make;
    private String model;
    private int horsePower;

    public RallyCar(String make, String model, int horsePower) {
        this.make = make;
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getHorsepower() {
        return horsePower;
    }

    public double calculatePerformance(){
        return 0.0;
    }
}

class GravelCar extends RallyCar{
    private double suspensionTravel;

    public GravelCar(String make, String model, int horsePower, double suspensionTravel) {
        super(make, model, horsePower);
        this.suspensionTravel = suspensionTravel;
    }

    @Override
    public double calculatePerformance() {
        return suspensionTravel *500/3;
    }
}

class AsphaltCar extends RallyCar{
    private double downforce;

    public AsphaltCar(String make, String model, int horsePower, double downforce) {
        super(make, model, horsePower);
        this.downforce = downforce;
    }

    @Override
    public double calculatePerformance() {
        return downforce / 10;
    }
}