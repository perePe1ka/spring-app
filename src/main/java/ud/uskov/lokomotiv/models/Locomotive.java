package ud.uskov.lokomotiv.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Locomotives")
@Getter
@Setter

public class Locomotive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private Long id; // айди
    @Column
    private Long serialNumber; // серийный номер
    @Column
    private String model; // модель
    @Column
    private String axFormule; // осевая формула
    @Column
    private Integer powerOnDiesel; // мощность по дизелю
    @Column
    private Double structuralSpeed; // конструкционная скорость
    @Column
    private Integer fuelReserve; // запасы топлива
    @Column
    private Double minRadius; // минимальный радиус прохождения кривых
    @Column
    private String dimensions; // габаритные размеры

    @Column
    private Long mileage; // общий пробег
    @Column
    private Integer tankVolume; //общий объём бака
    @Column
    private String isMoving; //двигается?

    public Locomotive() {

    }

    public Locomotive(Long id, Long serialNumber, String model, String axFormule, Integer powerOnDiesel, Double structuralSpeed, Integer fuelReserve, Double minRadius, String dimensions, Long mileage, Integer tankVolume, String isMoving) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.model = model;
        this.axFormule = axFormule;
        this.powerOnDiesel = powerOnDiesel;
        this.structuralSpeed = structuralSpeed;
        this.fuelReserve = fuelReserve;
        this.minRadius = minRadius;
        this.dimensions = dimensions;
        this.mileage = mileage;
        this.tankVolume = tankVolume;
        this.isMoving = isMoving;
    }

    public Locomotive(Long serialNumber, String model, String axFormule, Integer powerOnDiesel, Double structuralSpeed, Integer fuelReserve, Double minRadius, String dimensions, Long mileage, Integer tankVolume, String isMoving) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.axFormule = axFormule;
        this.powerOnDiesel = powerOnDiesel;
        this.structuralSpeed = structuralSpeed;
        this.fuelReserve = fuelReserve;
        this.minRadius = minRadius;
        this.dimensions = dimensions;
        this.mileage = mileage;
        this.tankVolume = tankVolume;
        this.isMoving = isMoving;
    }
}
