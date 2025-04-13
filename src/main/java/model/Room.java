package model;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Room {
    private Integer number;
    private String type;
    private Double pricePerNight;
    @Setter @Accessors(fluent = true)
    private Boolean isAvailable;
}
