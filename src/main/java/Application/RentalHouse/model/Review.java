package Application.RentalHouse.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

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
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date created_at; //automatic hibernate set current timezone
}
