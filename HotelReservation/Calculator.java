package HotelReservation;

public class Calculator {
    public static double calculatePrice (ReservationDatails details){
        double price = details.getNumberOfDays() * details.getPricePerDay();
        price = price * details.getSeason().getValues();

        price = price * (1 - details.getDiscount().getValue());

        return price;
    }
}
