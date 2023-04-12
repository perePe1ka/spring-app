package ud.uskov.lokomotiv.models;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class LocoMoving {
    private int id;
    private int serialNumber;
    private int mileage; // общий пробег
    private int tankVolume; //общий объём бака
    private boolean isMoving; //двигается?
}
