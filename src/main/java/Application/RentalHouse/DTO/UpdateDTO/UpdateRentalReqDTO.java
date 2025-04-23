package Application.RentalHouse.DTO.UpdateDTO;

import Application.RentalHouse.model.Status;

import java.time.LocalDate;

public class UpdateRentalReqDTO {
    private long houseId;
    private long rentalId;
    private Status status;
    private LocalDate started;
    private LocalDate endDate;

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
