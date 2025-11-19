package hostel.Entities;

public class Person {
  	private int id;
    	private String name;

    	public Person(int id, String name) {
        	this.id = id;
        	this.name = name;
    	}

    	public int getId() {
        	return id;
    	}

    	public String getName() {
        	return name;
    	}

     	public void setName(String name) {
    		this.name = name;
    	}

    	public void displayPerson() {
        	System.out.println("ID: " + id);
        	System.out.println("Name: " + name);
    	}
}
