package test;

import lombok.RequiredArgsConstructor;
import model.Room;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.BookingService;
import service.PaymentService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BookingTest {
    private final BookingService bookingService = new BookingService();
    private static Room room;
    private static final double BILL_WITH_TAX = 110.25;
    private static final double BILL_WITH_DISCOUNT = 414.54;
    private static final double DISCOUNT = 6;
    private static final LocalDate CHECK_IN = LocalDate.of(2025,4,19);
    private static final LocalDate CHECK_OUT = LocalDate.of(2025,4,20);
    private static final LocalDate CHECK_IN_2 = LocalDate.of(2025,4,21);
    private static final LocalDate CHECK_OUT_2 = LocalDate.of(2025,4,25);
    @BeforeAll
    static void initializeRoom() {
        room = new Room(3,"Elite", 105D, LocalDate.of(2025,4,18),LocalDate.of(2025,4,20), true);
    }
    @Test
    void isRoomAvailable(){
        boolean check = bookingService.isRoomAvailable(room, CHECK_IN, CHECK_OUT);
        boolean check2 = bookingService.isRoomAvailable(room, CHECK_IN_2, CHECK_OUT_2);
        assertFalse(check);
        assertTrue(check2);
    }

    @Test
    void calculatePrice() {
        double bill = bookingService.calculatePrice(room,CHECK_IN,CHECK_OUT);
        double bill2 = bookingService.calculatePrice(room,CHECK_IN_2,CHECK_OUT_2);
        assertEquals(BILL_WITH_TAX,bill);
        assertEquals(BILL_WITH_DISCOUNT,bill2);
    }

    @Test
    void applyTax(){
        double billWithTax = PaymentService.applyTax(room.getPricePerNight());
        assertEquals(billWithTax, BILL_WITH_TAX);
    }

    @Test
    void applyDiscount(){
        final double expected = 103.64;
        double billWithDiscount = PaymentService.applyDiscount(BILL_WITH_TAX,DISCOUNT);
        assertEquals(expected,billWithDiscount);
    }
}
