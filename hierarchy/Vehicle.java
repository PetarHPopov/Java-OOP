package hierarchy;

public class Vehicle {

    private final static double DEFAULT_FUEL_CONSUMPTION = 1.25;

    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    Vehicle( double fuel, int horsePower) {
        this.fuel = fuel;
        this.horsePower = horsePower;
        this.fuelConsumption = DEFAULT_FUEL_CONSUMPTION;
    }

    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuel() {
        return this.fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void drive(double kilometers) {
      if (this.fuel > 0){
          this.fuel -= this.fuelConsumption * kilometers;
      }
    }
}
