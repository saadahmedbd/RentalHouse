package Application.RentalHouse.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;

    @ManyToOne
    @JoinColumn(name = "user_id") //review
    private User user;
    private double rating;
    @Lob //large object if you want to a large text you need lob annotation
    private String comment;
    private String url;
    private Date created_at;
}
