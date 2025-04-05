package Application.RentalHouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class rentalRequest {
    @Id
    private long id;
    private House house_id;
    private users rental_id;
    private status Status;
    private Date requested_date;

}
