package Application.RentalHouse.DTO;

import Application.RentalHouse.model.House;
import Application.RentalHouse.model.Status;
import Application.RentalHouse.model.User;

public class RentalRequestDTO {
    private long houseId;
    private long rentalId;
    private Status status;

    public RentalRequestDTO() {
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
}
