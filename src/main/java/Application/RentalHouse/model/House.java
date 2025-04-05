package Application.RentalHouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.w3c.dom.Text;

import java.util.Date;

@Entity
public class House {
    @Id
    private long house_id;
    private String title;
    private Text description;
    private String address;
    private String city;
    private double rent_price;
    private int size;
    private int bedrooms;
    private int bathrooms;
    private boolean available;
    private users owner_id;
    private Date created_at;
}
