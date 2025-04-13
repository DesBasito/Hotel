package service;

import lombok.RequiredArgsConstructor;
import model.Guest;
import model.Hotel;
import model.Room;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@RequiredArgsConstructor
public class BookingService {
    public static final int DIS_DAYS = 3;
    public static final int DISCOUNT = 6;
    public boolean isRoomAvailable(Room room, LocalDate checkIn, LocalDate checkOut) {
        // TODO: Реализовать проверку доступности номера
        return false;
    }

    public boolean bookRoom(Hotel hotel, Room room, Guest guest, LocalDate checkIn, LocalDate checkOut) {
        // TODO: Реализовать логику бронирования номера
        return false;
    }

    public double calculatePrice(Room room, LocalDate checkIn, LocalDate checkOut) {
        long days = ChronoUnit.DAYS.between(checkIn,checkOut);

        double billPrice = BigDecimal.valueOf(room.getPricePerNight() * days)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();

        double amountWithTax = PaymentService.applyTax(billPrice);

        return days >= DIS_DAYS ? amountWithTax : PaymentService.applyDiscount(amountWithTax, DISCOUNT);
    }
}
