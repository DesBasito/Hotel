package model;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Room {
    Integer number;
    String type;
    Double pricePerNight;
    LocalDate lastCheckIn;
    LocalDate lastCheckOut;
    @Setter
    @Accessors(fluent = true)
    Boolean isAvailable;
}
