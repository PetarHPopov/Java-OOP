package vehicles;

public class Car extends Vehicle {

    private static final double AIR_CONDITION_CONSUMPTION = 0.9;
    private static final boolean AIR_CONDITION_DEFAULT_STATUS = true;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        super.setAirConditionConsumption(AIR_CONDITION_CONSUMPTION);
        super.setAirConditionStatus(AIR_CONDITION_DEFAULT_STATUS);
    }
}
