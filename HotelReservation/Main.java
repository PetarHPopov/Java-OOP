package HotelReservation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split(" ");

        double pricePerDay = Double.parseDouble(tokens[0]);
        int numberOfDays = Integer.parseInt(tokens[1]);
        Season season = Season.valueOf(tokens[2]);
        Discount discountType = Discount.valueOf(tokens[3]);

       ReservationDatails reservationDatails = new ReservationDatails(pricePerDay,numberOfDays,season,discountType);

        System.out.println(String.format("%.2f",Calculator.calculatePrice(reservationDatails)));
    }
}
