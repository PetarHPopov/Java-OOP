package vehicles;

public class Bus  extends Vehicle{

    private static final double AIR_CONDITION_CONSUMPTION = 1.4;
    private static final boolean AIR_CONDITION_DEFAULT_STATUS = true;

    protected Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption , tankCapacity);
        super.setAirConditionConsumption(AIR_CONDITION_CONSUMPTION);
        super.setAirConditionStatus(AIR_CONDITION_DEFAULT_STATUS);
    }
}
