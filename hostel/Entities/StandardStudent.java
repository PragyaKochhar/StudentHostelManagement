package hostel.Entities;

public class StandardStudent extends Student{
    	public StandardStudent(int id, String name, int roomNumber, int stayDuration, String contact) {
        	super(id, name, roomNumber, stayDuration, contact);
    	}

    	// StandardStudent uses normal calculation
    	public double calculateMessBill(double ratePerDay) {
        	return super.calculateMessBill(ratePerDay);
    	}
}
