package Application.RentalHouse.DTO;

import Application.RentalHouse.model.User;

import java.util.Date;

//  Create a custom DTO (Data Transfer Object)
//// that only includes the fields you need.
//// This gives you full control over your API response format.

//To avoid exposing your entity structure directly and add flexibility.
public class HouseDTO {
    private long house_id;
    private String title;
    private String description;
    private String address;
    private String city;
    private double rent_price;
    private int size;
    private int bedrooms;
    private int bathrooms;
    private boolean available;
    private Date created_at;
    private User owner;

    //constructor


    public HouseDTO() {
        this.house_id = house_id;
        this.title = title;
        this.description = description;
        this.address = address;
        this.city = city;
        this.rent_price = rent_price;
        this.size = size;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.available = available;
        this.created_at = created_at;
        this.owner=owner;

    }

    public HouseDTO(long house_id, String title, String description, String address, String city,
                    double rent_price, int size, int bedrooms,
                    int bathrooms, boolean available, Date created_at, User owner) {
        this.house_id = house_id;
        this.title = title;
        this.description = description;
        this.address = address;
        this.city = city;
        this.rent_price = rent_price;
        this.size = size;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.available = available;
        this.created_at = created_at;
        this.owner = owner;
    }

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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
