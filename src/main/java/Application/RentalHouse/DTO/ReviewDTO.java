package Application.RentalHouse.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class ReviewDTO {
    private long id;
    private long houseId;
    private long userId;
    @NotNull                                    //@NotNull: Ensures the field is not null.
    @DecimalMin(value = "1.0",inclusive = true, message = "Rating must be at least 1")
    @DecimalMax(value = "5.0",inclusive = true, message = "Rating must be at most 5")  //inclusive = true:
    // This means the boundary values 1.0 and 5.0 are allowed.
    // If you want to exclude them, set inclusive = false.
    private  double rating;
    @NotBlank
    private String comment;
    private String url;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Dhaka")
    private Date created_at;




    public ReviewDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getHouseId() {
        return houseId;
    }

    public void setHouseId(long houseId) {
        this.houseId = houseId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
