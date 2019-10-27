package vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle implements Driving, Refueling {

    private double fuelConsumption;
    private double fuelQuantity;
    private double tankCapacity;
    private double tankRefuelFactor;
    private DecimalFormat decimalFormat = new DecimalFormat("#.##");
    private double airConditionConsumption;
    private boolean airConditionStatus;

    protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
        this.setAirConditionStatus(false);
        this.setAirConditionConsumption(0);
        this.setTankRefuelFactor(1.0);
    }

    protected void setTankRefuelFactor(double tankRefuelFactor) {
        this.tankRefuelFactor = tankRefuelFactor;
    }

    protected void setAirConditionConsumption(double airConditionConsumption) {
        this.airConditionConsumption = airConditionConsumption;
    }

    private boolean isAirConditionStatus() {
        return airConditionStatus;
    }

    public void setAirConditionStatus(boolean airConditionStatus) {
        this.airConditionStatus = airConditionStatus;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }


    public double getTankCapacity() {
        return tankCapacity;
    }

    private void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    @Override
    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    @Override
    public double getFuelConsumption() {
        return this.fuelConsumption + (this.isAirConditionStatus() ? this.airConditionConsumption : 0);
    }

    @Override
    public void refuel(double fuel) {
        if (fuel <= 0) {
            System.out.println("Fuel must be a positive number");
            return;
        }

        if ((fuel * this.tankRefuelFactor) + this.getFuelQuantity() > this.getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
            return;
        }
        this.fuelQuantity += fuel * this.tankRefuelFactor;
    }

    @Override
    public void drive(double distance) {

        double fuelNeeded = distance * this.getFuelConsumption();

        if (this.fuelQuantity >= fuelNeeded) {

            System.out.println(String.format("%s travelled %s km",
                    this.getClass().getSimpleName(),
                    decimalFormat.format(distance))
            );
            this.fuelQuantity -= fuelNeeded;
        } else {
            System.out.println(String.format("%s needs refueling",
                    this.getClass().getSimpleName())
            );
        }
    }

    @Override
    public String toString() {
        return
                String.format("%s: %.2f",
                        this.getClass().getSimpleName(),
                        this.fuelQuantity
                );
    }
}
