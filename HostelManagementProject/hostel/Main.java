package hostel;

import java.util.InputMismatchException;
import java.util.Scanner;
import hostel.Entities.Student;
import hostel.Entities.StandardStudent;
import hostel.Entities.ScholarshipStudent;
import hostel.Management.Hostel;

public class Main {
    public static int safeIntInput(Scanner sc, String message) {
        while (true) {
            try {
                System.out.print(message);
                int value = sc.nextInt();
                sc.nextLine(); // clear buffer
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine(); // clear invalid data
            }
        }
    }

    public static int safeRoomInput(Scanner sc) {
        while (true) {
            int room = safeIntInput(sc, "Enter Room Number (1 to 20): ");

            if (room >= 1 && room <= 20)
                return room;

            System.out.println("Room number must be between 1 and 20!");
        }
    }

    public static String safePhoneInput(Scanner sc) {
        while (true) {
            System.out.print("Enter Contact (10 digits): ");
            String contact = sc.nextLine();

            if (!contact.matches("\\d+")) {
                System.out.println(" Phone number must contain digits only!");
                continue;
            }

            if (contact.length() != 10) {
                System.out.println("Phone number must be exactly 10 digits!");
                continue;
            }

            return contact;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Hostel hostel = new Hostel();
        int choice;

        do {
            System.out.println("\n--- HOSTEL MANAGEMENT SYSTEM ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Show Available Rooms");
            System.out.println("4. Assign Room");
            System.out.println("5. Generate Mess Bill");
            System.out.println("6. Search Student");
            System.out.println("7. Delete Student");
            System.out.println("8. Update Student");
            System.out.println("9. Exit");

            choice = safeIntInput(sc, "Enter your choice: ");

            switch (choice) {
                case 1:
                    int id = safeIntInput(sc, "Enter Student's ID: ");

                    System.out.print("Enter Student's Name: ");
                    String name = sc.nextLine();

                    int room = safeRoomInput(sc);

                    int stay = safeIntInput(sc, "Enter Stay Duration (days): ");

                    String contact = safePhoneInput(sc);

                    System.out.println("\nChoose Student Type:");
                    System.out.println("1. Standard Student");
                    System.out.println("2. Scholarship Student");

                    int type = safeIntInput(sc, "Enter choice: ");

                    Student s;
                    if (type == 1) {
                        s = new StandardStudent(id, name, room, stay, contact);
                    } else if (type == 2) {
                        s = new ScholarshipStudent(id, name, room, stay, contact);
                    } else {
                        System.out.println("Invalid type! Defaulting to Standard.");
                        s = new StandardStudent(id, name, room, stay, contact);
                    }

                    hostel.addStudent(s);
                    break;

                case 2:
                    hostel.displayAllStudents();
                    break;

                case 3:
                    hostel.showAvailableRooms();
                    break;

                case 4:
                    int sid = safeIntInput(sc, "Enter Student ID: ");
		    if (hostel.searchStudent(sid) == null) {
        		System.out.println("Student not found! Please add the student first.");
        	    	break;
    		    }
                    int rno = safeRoomInput(sc);
                    hostel.assignRoom(sid, rno);
                    break;

                case 5:
                    int sid2 = safeIntInput(sc, "Enter Student ID: ");

                    double rate;
                    while (true) {
                        try {
                            System.out.print("Enter Rate per Day: ");
                            rate = sc.nextDouble();
                            sc.nextLine();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Enter a valid number!");
                            sc.nextLine();
                        }
                    }

                    hostel.generateMessBill(sid2, rate);
                    break;

                case 6:
                    int searchId = safeIntInput(sc, "Enter Student ID: ");
                    Student found = hostel.searchStudent(searchId);

                    if (found != null)
                        found.displayStudent();
                    else
                        System.out.println("Student not found!");
                    break;

                case 7:
                    int delId = safeIntInput(sc, "Enter Student ID to Delete: ");

                    if (!hostel.deleteStudent(delId))
                        System.out.println("Student not found!");
                    break;

                case 8:
                    int upId = safeIntInput(sc, "Enter Student ID to Update: ");
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    int newRoom = safeRoomInput(sc);

                    int newStay = safeIntInput(sc, "Enter New Stay Duration: ");

                    if (!hostel.updateStudent(upId, newName, newRoom, newStay))
                        System.out.println("Student not found!");
                    break;

                case 9:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 9);
    }
}
