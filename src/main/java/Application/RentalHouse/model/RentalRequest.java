package Application.RentalHouse.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "rentals")
public class RentalRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private User rental;

    @Enumerated(EnumType.STRING) //Without @Enumerated, Hibernate doesn’t know how to store your custom Java enum in the database. You can choose:
    private Status status;
    private LocalDate started;
    private LocalDate endDate;

}
