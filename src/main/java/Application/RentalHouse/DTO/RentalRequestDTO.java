package Application.RentalHouse.DTO;

import Application.RentalHouse.model.House;
import Application.RentalHouse.model.Status;
import Application.RentalHouse.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class RentalRequestDTO {
   private long id;
   private long houseId;
   private long rentalId;
   private Status status;
    @JsonFormat(pattern = "yyyy-MM-dd")
   private LocalDate  started;
    @JsonFormat(pattern = "yyyy-MM-dd")
   private  LocalDate endDate;

    public RentalRequestDTO() {
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

    public long getRentalId() {
        return rentalId;
    }

    public void setRentalId(long rentalId) {
        this.rentalId = rentalId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getStarted() {
        return started;
    }

    public void setStarted(LocalDate started) {
        this.started = started;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
