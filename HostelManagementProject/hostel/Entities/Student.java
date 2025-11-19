package hostel.Entities;

public class Student extends Person{
    	private int roomNumber;
    	private int stayDuration;
	private String contact;

    	public Student(int id, String name, int roomNumber, int stayDuration, String contact){
        	super(id, name); // call Person constructor
        	this.roomNumber = roomNumber;
        	this.stayDuration = stayDuration;
		this.contact = contact;
		
    	}

    	public void displayStudent(){
        	super.displayPerson(); // reuse Person method
		System.out.println("Contact: " + contact);
        	System.out.println("Room Number: " + roomNumber);
        	System.out.println("Stay Duration: " + stayDuration + " days");
    	}

    	public int getRoomNumber(){
        	return roomNumber;
    	}

    	public int getStayDuration(){
        	return stayDuration;
    	}
	
	public void setRoomNumber(int roomNumber){
        	this.roomNumber = roomNumber;
    	}

    	public void setStayDuration(int stayDuration){
        	this.stayDuration = stayDuration;
    	}

	public String getContact(){
        	return contact;
    	}

	public void setContact(String contact){
        	if (contact != null && !contact.trim().isEmpty())
            		this.contact = contact;
        	else
            	System.out.println("Invalid contact!");
    	}

	public double calculateMessBill(double ratePerDay) {
        	return stayDuration * ratePerDay;
    	}
}
