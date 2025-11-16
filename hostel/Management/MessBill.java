package hostel.Management;

public class MessBill{
    	private int studentId;
    	private int days;
    	private double ratePerDay;

    	public MessBill(int studentId, int days, double ratePerDay){
        	this.studentId = studentId;
        	this.days = days;
        	this.ratePerDay = ratePerDay;
    	}

	public int getDays() {
        	return days;
    	}

	public void setDays(int days) {
        	if (days > 0){
            		this.days = days;
		}
        	else{
            		System.out.println("Days must be positive.");
		}
    	}


	public void setRatePerDay(double ratePerDay) {
        	if (ratePerDay > 0)
            		this.ratePerDay = ratePerDay;
        	else
            		System.out.println("Invalid: Rate must be positive.");
    	}

    	public double calculateTotal(){
        	return days * ratePerDay;
    	}

    	public void displayBill(){
        	System.out.println("\n--- Mess Bill ---");
        	System.out.println("Student ID: " + studentId);
        	System.out.println("Days Stayed: " + days);
        	System.out.println("Total Bill: Rs. " + calculateTotal());
        	System.out.println("------------------");
    	}
}
