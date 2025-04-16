package model;

import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Room {
    private Integer number;
    private String type;
    private Double pricePerNight;
    private LocalDate lastCheckIn;
    private LocalDate lastCheckOut;
    @Setter @Accessors(fluent = true)
    private Boolean isAvailable;
}
