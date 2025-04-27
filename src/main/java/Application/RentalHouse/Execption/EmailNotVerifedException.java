package Application.RentalHouse.Execption;

public class EmailNotVerifedException extends RuntimeException {
    public EmailNotVerifedException (String message) {
        super(message);
    }
}
