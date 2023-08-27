
import java.util.Scanner;

import Interfaces.StudentDetailsInterface;
import Interfaces.StudentDetails;
import model.Student;

public class App {

    public static void menu(Scanner sc, StudentDetailsInterface sdi) {
        // for the view , update , delete the details
        int rollNo;
        boolean result;
        System.out.println("============Welcome to Student Management Application ============  ");
        do {

            System.out.println(
                    "\n1) Add Student Details \n2) View All Student Details \n3) Get Student Details Based on RollNo \n4) Delete Student record  \n5) Update Student Details  \n6) Exit ");
            System.out.println("Enter Your Choice :");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Add Student Details");
                    System.out.print("Enter Student Name :");
                    String name = sc.next();

                    System.out.print("Enter Student College Name :");
                    String clg = sc.next();

                    System.out.print("Enter Student City :");
                    String city = sc.next();

                    System.out.print("Enter Student Percentage :");
                    double percentage = sc.nextDouble();

                    Student s = new Student(name, clg, city, percentage);

                    boolean ans = sdi.insertStudent(s);
                    if (ans) {
                        System.out.println("Record Inserted SuccessFully");
                    } else {
                        System.out.println("Something went wrong");
                    }
                    break;
                case 2:
                    System.out.println("View All Student Details");
                    sdi.showAllStudent();
                    break;
                case 3:
                    System.out.println("Get Student Details Based on RollNo");
                    System.out.println("Enter Roll Number :");
                    rollNo = sc.nextInt();
                    result = sdi.showStudentById(rollNo);
                    if (!result) {
                        System.out.println("Id is not Exists");
                    }
                    break;
                case 4:
                    System.out.println("Delete Student record");
                    System.out.println("Enter Roll Number :");
                    rollNo = sc.nextInt();
                    result = sdi.delete(rollNo);
                    if (!result) {
                        System.out.println("Id is not Exists");
                    } else {
                        System.out.println("Successfully Deleted");
                    }
                    break;
                case 5:
                    System.out.println("Update Student Details ");
                    System.out.println("\n================== Update ================== ");
                    System.out.println("1) Update Name ");
                    System.out.println("2) Update clg Name ");
                    System.out.println("Enter your choice : ");
                    int choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("rollNo : ");
                            rollNo = sc.nextInt();
                            System.out.println("Enter New Name :");
                            name = sc.next();
                            Student std = new Student();
                            std.setName(name);
                            result = sdi.update(rollNo, name, choice, std);
                            if (result)
                                System.out.println("name updated Successfully");
                            else
                                System.out.println("Something went wrong");
                            break;
                        // case 2:
                        //     System.out.println("Enter City Name :");
                        //     city = sc.nextLine();
                        //     break;
                        default:
                            System.out.println("Enter Valid Choice");
                            break;
                    }
                case 6:
                    System.out.println("Exit");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter Valid Choice");
                    break;
            }

        } while (true);

    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StudentDetailsInterface sdi = new StudentDetails();

        menu(sc, sdi);

    }
}
