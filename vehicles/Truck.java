package vehicles;

public class Truck extends Vehicle {

    private static final double AIR_CONDITION_CONSUMPTION = 1.6;
    private static final boolean AIR_CONDITION_DEFAULT_STATUS = true;
    private static final double TANK_REFUEL_FACTOR = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        super.setAirConditionConsumption(AIR_CONDITION_CONSUMPTION);
        super.setAirConditionStatus(AIR_CONDITION_DEFAULT_STATUS);
        super.setTankRefuelFactor(TANK_REFUEL_FACTOR);
    }
}
