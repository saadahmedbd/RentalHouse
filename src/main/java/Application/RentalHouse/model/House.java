package Application.RentalHouse.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.w3c.dom.Text;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "houses")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long house_id;
    private String title;
    @Lob // large object if you want to a large text you need lob annotation
    private String description;
    private String address;
    private String city;
    private double rent_price;
    private int size;
    private int bedrooms;
    private int bathrooms;
    private boolean available;
    @ManyToOne //  opposite of one to many "one owner can post multiple houses for rent post"
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany(mappedBy = "house") // one house can rent many rentals
    private List<RentalRequest> rentalRequests;

    @OneToMany (mappedBy = "house") // one house can have a lot of review
    private List<Review> reviews;
    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL)
    private List<Image> images;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date created_at; //automatic set current timezone
}
