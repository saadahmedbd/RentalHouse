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
 //  @Lob //large object if you want to a large text you need lob annotation
//   @Column(columnDefinition = "TEXT")
    private String comment;
    private String url;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date created_at; //automatic hibernate set current timezone

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
