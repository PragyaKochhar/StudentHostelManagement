package hostel.Management;

import hostel.Entities.Student;
import hostel.Entities.Room;
import hostel.Exceptions.InvalidRoomException;
import hostel.Exceptions.RoomOccupiedException;

public class Hostel {
    private Student[] students;
    private Room[] rooms;
    private int studentCount;
    private int roomCount;

    public Hostel() {
	// Array of 50 students total
        students = new Student[50];

	// Hostel contains 20 rooms
        rooms = new Room[20];

        studentCount = 0;
        roomCount = 0;

	// Initialize all rooms 1-20
        for (int i = 0; i < 20; i++) {
            rooms[i] = new Room(i + 1, false);
            roomCount++;
        }
    }
   

    private boolean isValidRoom(int roomNumber) {
    	return roomNumber >= 1 && roomNumber <= roomCount;
    }


    public void addStudent(Student s) {

    	int room = s.getRoomNumber();

    	// 1. Validate room
    	if (!isValidRoom(room)) {
       	 	System.out.println("Invalid room number!");
        	return;
    	}

    	// 2. Check if room is already occupied
    	if (rooms[room - 1].isOccupied()) {
        	System.out.println("Room " + room + " is already occupied!");
        	return;
    	}

    	// 3. Add student
    	if (studentCount < students.length) {
        	students[studentCount] = s;
        	studentCount++;

        	// 4. Mark room as occupied
        	rooms[room - 1].setOccupied(true);

        	System.out.println("Student added successfully!");
    	} 
	else {
        	System.out.println("Hostel is full!");
    	}
}


    public void displayAllStudents() {
        if (studentCount == 0) {
            System.out.println("No students to display.");
            return;
        }
        for (int i = 0; i < studentCount; i++) {
            students[i].displayStudent();
            System.out.println("------------------");
        }
    }


    public Student searchStudent(int id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId() == id) {
                return students[i];
            }
        }
        return null;
    }

    // feature to delete student
    public boolean deleteStudent(int id) {
    	for (int i = 0; i < studentCount; i++) {

        	if (students[i].getId() == id) {

            	// 1. Free the room the student was occupying
            	int roomToFree = students[i].getRoomNumber();
            	if (roomToFree >= 1 && roomToFree <= roomCount) {
                	rooms[roomToFree - 1].setOccupied(false);
            	}

            	// 2. Shift array left to fill the gap
            	for (int j = i; j < studentCount - 1; j++) {
                	students[j] = students[j + 1];
            	}

            	// 3. Remove last duplicate reference
            	students[studentCount - 1] = null;
            	studentCount--;

            	System.out.println("Student deleted successfully!");
            	return true;
        	}
    	}

    	return false; // if student not found
    }


    // feature to update student details
    public boolean updateStudent(int id, String newName, int newRoom, int newStay) {

    	Student s = searchStudent(id);
    	if (s == null) return false;

    	// 1. Validate room number
    	if (!isValidRoom(newRoom)) {
        	System.out.println("Invalid room number!");
        	return false;
    	}

    	// 2. If new room is already occupied (and not the current student's room)
    	if (rooms[newRoom - 1].isOccupied() && s.getRoomNumber() != newRoom) {
        	System.out.println("Room " + newRoom + " is already occupied!");
        	return false;
    	}

    	// 3. Free old room
    	int oldRoom = s.getRoomNumber();
    	if (oldRoom >= 1 && oldRoom <= roomCount) {
        	rooms[oldRoom - 1].setOccupied(false);
    	}

    	// 4. Assign new room
    	rooms[newRoom - 1].setOccupied(true);
    	s.setRoomNumber(newRoom);

    	// 5. Update other details
    		s.setName(newName);
   		s.setStayDuration(newStay);

    	System.out.println("Student updated successfully!");
    	return true;
    }



    public void showAvailableRooms() {
        System.out.println("\n--- Available Rooms ---");
        boolean found = false;
        for (int i = 0; i < roomCount; i++) {
            if (!rooms[i].isOccupied()) {
                rooms[i].displayRoom();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No rooms available.");
        }
    }

    public void assignRoom(int studentId, int roomNumber) {

    // 1. Check room number validity
    if (!isValidRoom(roomNumber)) {
        System.out.println("Invalid room number!");
        return;
    }

    // 2. Check if room is already occupied
    if (rooms[roomNumber - 1].isOccupied()) {
        System.out.println("Room " + roomNumber + " is already occupied!");
        return;
    }

    // 3. Find student
    Student s = searchStudent(studentId);
    if (s == null) {
        System.out.println("Student not found!");
        return;
    }

    // 4. If student already has a room, free the old room
    int oldRoom = s.getRoomNumber();
    if (oldRoom >= 1 && oldRoom <= roomCount) {
        rooms[oldRoom - 1].setOccupied(false);
    }

    // 5. Assign new room
    s.setRoomNumber(roomNumber);
    rooms[roomNumber - 1].setOccupied(true);

    System.out.println("Room " + roomNumber + " assigned to student ID " + studentId);
}


    public void generateMessBill(int studentId, double ratePerDay) {
        Student s = searchStudent(studentId);
	if (s!=null){
		double total = s.calculateMessBill(ratePerDay);
		System.out.println("Mess Bill: ");
        	System.out.println("Student ID: " + studentId);
        	System.out.println("Days Stayed: " + s.getStayDuration());
        	System.out.println("Total Bill: Rs. " + total);
	}
	else{
		System.out.println("Student not found!");
	}
    }

    


}
