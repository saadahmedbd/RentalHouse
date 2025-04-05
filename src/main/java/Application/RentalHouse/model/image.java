package Application.RentalHouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class image {
    @Id
    private long id;
    private House house_id;
    private String url;
}
