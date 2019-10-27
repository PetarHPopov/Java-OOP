package HotelReservation;

public enum  Season {
    Autumn(1),
    Spring(2),
    Winter(3),
    Summer(4);

    private int values;

    Season(int values) {
        this.values = values;
    }

    public int getValues() {
        return values;
    }
}
