package hostel.Exceptions;

// Custom exception thrown when a room number does not exist (ex: 0 or above 100).
public class InvalidRoomException extends Exception {
    public InvalidRoomException(String message) {
        super(message);
    }
}
