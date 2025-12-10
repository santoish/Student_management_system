import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.String;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        Scanner input = new Scanner(System.in);
        boolean flag = false;
        ArrayList <Student> students = new ArrayList<>();
        while(true){
            try{
                System.out.println("\n------ Student Management System ------");
                System.out.println("1. Add Student");
                System.out.println("2. View All Students");
                System.out.println("3. Search Student");
                System.out.println("4. Update Student");
                System.out.println("5. Delete Student");
                System.out.println("6. Exit");
                System.out.print("Enter Your Choice : ");
                int choice = input.nextInt();
                input.nextLine();
                if (choice == 6){
                    System.out.println("Thank you for using the Student Management System!\n");
                    break;
                }
                switch (choice){
                    case 1:
                        int t_rno;
                        String t_name;
                        int t_age;
                        char t_grade;

                        flag = false;
                        System.out.println("\nAdd Student");
                        while(true){
                            System.out.print("Enter Roll Number : ");
                            if(input.hasNextInt()){
                                t_rno = input.nextInt();
                                for(Student s:students){
                                    if(t_rno == s.getRollNo()){
                                        flag = true;
                                        break;
                                    }
                                }
                                break;
                            }
                            else{
                                System.out.println("Enter a Valid Number !");
                                input.nextLine();
                            }

                        }

                        if(flag) {
                            System.out.println("Student already exists in the list!");
                            break;
                        }

                        input.nextLine();

                        //NAME
                        while(true){
                            System.out.print("Enter Name : ");
                            t_name = input.nextLine();
                            if(t_name.matches("[a-zA-Z ]+")){
                                break;
                            }
                            else{
                                System.out.println("! Name must contain only letters and spaces.\n");
                            }
                        }

                        //AGE
                        while(true){
                            System.out.print("Enter Age : ");
                            if(input.hasNextInt()){
                                t_age = input.nextInt();
                                break;
                            }
                            else{
                                System.out.println("Age cannot be String");
                                input.nextLine();
                            }
                        }

                        //Grade
                        while(true){
                            System.out.print("Enter Grade : ");
                            t_grade = input.next().charAt(0);
                            if(t_grade == 'A' || t_grade == 'B' || t_grade == 'C'){
                                break;
                            }
                            else{
                                System.out.println("! Enter Valid Grade");
                            }
                        }

                        students.add(new Student(t_rno,t_name,t_age,t_grade));
                        System.out.println("Student added successfully!\n");
                        break;


                    case 2:
                        if(students.isEmpty()){
                            System.out.println("No Students in the List");
                        }
                        else{
                            System.out.println("\n--------------------------All Students--------------------------");
                            for(Student s : students){
                                System.out.println(s);
                            }
                            System.out.println("-----------------------------------------------------------------");
                        }
                        break;

                    case 3:
                        flag = false;
                        int getNo;
                        //Get Roll No
                        while(true){
                            System.out.print("Enter Roll No to Search: ");
                            if(input.hasNextInt()){
                                getNo = input.nextInt();
                                break;
                            }
                            else{
                                System.out.println("! Roll No must be a Number from the List");
                                input.nextLine();
                            }
                        }

                        for(Student s : students){
                            if(s.getRollNo() == getNo){
                                System.out.println("\n------------Student Found------------");
                                System.out.println(s);
                                flag = true;
                                break;
                            }
                        }
                        if(!flag){
                            System.out.println("Student Not Found");
                        }
                        break;

                    case 4:
                        flag = false;
                        int upNo;
                        while(true){
                            System.out.print("Enter Roll No to Update : ");
                            if(input.hasNextInt()){
                                upNo = input.nextInt();
                                break;
                            }
                            else{
                                System.out.println("! Roll No must be a Number from the List ");
                                input.nextLine();
                            }
                        }
                        for(Student s : students){
                            //System.out.println(s.getRollNo());
                            if(upNo == s.getRollNo()){
                                flag = true;
                                int option;

                                while(true){
                                    System.out.print("What do you want to Change ? ");
                                    System.out.println("\n------------Student Found------------");
                                    System.out.println("1.Name");
                                    System.out.println("2.Age");
                                    System.out.println("3.Grade");
                                    if(input.hasNextInt()){
                                        option  = input.nextInt();
                                        break;
                                    }
                                    else{
                                        System.out.println("Enter Valid Input");
                                        input.nextLine();
                                    }

                                }
                                input.nextLine();
                                switch (option){
                                    case 1:
                                        String temp_name;
                                        //Name
                                        while(true){
                                            System.out.print("Enter New Name : ");
                                            temp_name = input.nextLine();
                                            if(temp_name.matches("[a-zA-Z ]+")){
                                                break;
                                            }
                                            else{
                                                System.out.println("Name Must be Letters and Spaces");
                                            }
                                        }
                                        s.setName(temp_name);
                                        System.out.println("Updated Successfully");
                                        break;

                                    case 2:
                                        int temp_age;
                                        //AGE
                                        while(true){
                                            System.out.print("Enter New Age : ");
                                            if(input.hasNextInt()){
                                                temp_age = input.nextInt();
                                                break;
                                            }
                                            else{
                                                System.out.println("Age must be a Number");
                                                input.nextLine();
                                            }

                                        }

                                        s.setAge(temp_age);
                                        System.out.println("Updated Successfully");
                                        break;

                                    case 3:
                                        char temp_grade;
                                        while(true){
                                            System.out.print("Enter New Grade : ");
                                            temp_grade = input.next().charAt(0);
                                            if(temp_grade == 'A' || temp_grade == 'B' || temp_grade == 'C'){
                                                break;
                                            }
                                            else{
                                                System.out.println("Enter Valid Grades(A or B or C)");
                                            }
                                        }
                                        s.setGrade(temp_grade);
                                        System.out.println("Updated Successfully");
                                        break;

                                    default:
                                        System.out.println("Invalid Input");

                                }

                            }
                        }
                        if(!flag){
                            System.out.println("Student Not Found");
                        }
                        break;

                    case 5:
                        boolean deleted = false;
                        int delNo;
                        while(true){
                            System.out.print("\nEnter Roll No to Delete : ");
                            if(input.hasNextInt()){
                                delNo = input.nextInt();
                                break;
                            }
                            else{
                                System.out.println("Roll No must be a Number from the List");
                                input.nextLine();
                            }

                        }
                        for(Student s: students){
                            if(delNo == s.getRollNo()){
                                students.remove(s);
                                deleted = true;
                                break;
                            }
                        }
                        if(deleted){
                            System.out.println("Deleted Successfully");
                        }
                        else{
                            System.out.println("Student not Found");
                        }
                        break;

                    default:
                        System.out.println("Invalid Input");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Enter a Valid Input. Please Enter numbers only");
                input.nextLine();
            }
            catch (Exception e){
                System.out.println("Something went wrong : "+e.getMessage());
            }

        }

        input.close();

    }
}