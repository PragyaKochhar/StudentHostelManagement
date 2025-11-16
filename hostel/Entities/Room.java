package hostel.Entities;

public class Room{
    	private int roomNumber;
    	private boolean isOccupied;

    	public Room(int roomNumber, boolean isOccupied){
        	this.roomNumber = roomNumber;
        	this.isOccupied = isOccupied;
    	}

    	public int getRoomNumber(){
        	return roomNumber;
    	}

    	public boolean isOccupied(){
        	return isOccupied;
    	}

    	public void setOccupied(boolean occupied){
        	this.isOccupied = occupied;
    	}

    	public void displayRoom(){
        	System.out.println("Room Number: " + roomNumber);
        	System.out.println("Status: " + (isOccupied ? "Occupied" : "Available"));
        	System.out.println("------------------");
    	}
}
