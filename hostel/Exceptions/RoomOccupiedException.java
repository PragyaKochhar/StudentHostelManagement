package hostel.Exceptions;

// Custom exception thrown when someone tries to use a room that is already occupied.
public class RoomOccupiedException extends Exception {
    public RoomOccupiedException(String message) {
        super(message);
    }
}
