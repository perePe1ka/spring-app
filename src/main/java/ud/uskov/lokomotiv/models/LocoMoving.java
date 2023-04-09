package ud.uskov.lokomotiv.models;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement
@Getter
@Setter
public class LocoMoving {
    private Long id;
    private Long mileage; // общий пробег
    private Integer tankVolume; //общий объём бака
    private String isMoving; //двигается?
}
