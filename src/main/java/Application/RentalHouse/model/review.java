package Application.RentalHouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.w3c.dom.Text;

import java.util.Date;

@Entity
public class review {
    @Id
    private long id;
    private House house_id;
    private users users_id;
    private double rating;
    private Text comment;
    private String url;
    private Date created_at;
}
