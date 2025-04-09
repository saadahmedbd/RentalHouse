package Application.RentalHouse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
 //  @Lob // large object if you want to a large text you need lob annotation
 //  @Column(columnDefinition = "TEXT")
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

    //getter setter


    public long getHouse_id() {
        return house_id;
    }

    public void setHouse_id(long house_id) {
        this.house_id = house_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getRent_price() {
        return rent_price;
    }

    public void setRent_price(double rent_price) {
        this.rent_price = rent_price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<RentalRequest> getRentalRequests() {
        return rentalRequests;
    }

    public void setRentalRequests(List<RentalRequest> rentalRequests) {
        this.rentalRequests = rentalRequests;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
