package hostel.Entities;

public class ScholarshipStudent extends Student{
    	public ScholarshipStudent(int id, String name, int roomNumber, int stayDuration, String contact){
        	super(id, name, roomNumber, stayDuration, contact);
    	}

    	// Override mess bill calculation (e.g., 50% discount)
    	public double calculateMessBill(double ratePerDay) {
        	return super.calculateMessBill(ratePerDay) * 0.5;
    	}
}
