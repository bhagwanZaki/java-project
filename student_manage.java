// Group 1 project
// import Scanner class
import java.util.Scanner;


// intiallizing the structure class which contain array of id,Student name,student marks,student department student year
class student_struct{
    static int id[] = new int[100];
    static String  name[] = new String[100]; 
    static int  marks[] = new int[100];
    static String dept[] = new String[100];
    static int year[] = new int[100]; 
}

//student manage class will inherit the structure class
public class student_manage extends student_struct{
    
    // declaring the static variable to add the new data after the data already inserted in array
    public static int r = 0;
    bo

    // add function will add the name, marks , department and year from user but the id will be auto generated
    public void add(int id[],String name[],int marks[],String dept[],int year[],int n)
    {
        int i ;
        Scanner sc = new Scanner(System.in); 
        student_manage m = new student_manage();
        for( i = 0 ; i < n ; i++ )
        {
            
            m.id[r+i] = i;
            System.out.println("Enter name of Student " + i);
            m.name[r+i] = sc.next();
            System.out.println("Enter marks of Student " + i);
            m.marks[r+i] = sc.nextInt();
            System.out.println("Enter dept of Student " + i);
            m.dept[r+i] = sc.next();
            System.out.println("Enter year of Student " + i);
            m.year[r+i] = sc.nextInt();
        }
        // incrementing the local reference variable
        r = r + n;
    }

    // Display function will display all the data in array
    public void display(){
        student_manage m = new student_manage();
        for (int i = 0; i <r;i++){
            System.out.println("Student name "+ m.name[i]);
            System.out.println("Student dept "+ m.dept[i]);
            System.out.println("Student year "+ m.year[i]);
            System.out.println("Student Pointer "+ m.marks[i] + "\n");
        }
    }
    // Search function will display the data of student whose name will be entered by the user
    public void search(String n){
        student_manage m = new student_manage();
        for (int i = 0 ; i<r;i++){
            if (m.name[i].equals(n)){
                System.out.println("Student name "+ m.name[i]);
                System.out.println("Student dept "+ m.dept[i]);
                System.out.println("Student year "+ m.year[i]);
                System.out.println("Student Pointer "+ m.marks[i] + "\n");

                break;
            }
            else{
                System.out.println("Name not found please Enter the valid name \n");
            }
        }
    }
    // Update function will update the student information whose name will be entered by the user
    public void update(String n){
        student_manage m = new student_manage();
        Scanner sc = new Scanner(System.in);
        for (int i = 0 ; i<r;i++){
            if (m.name[i].equals(n)){
                System.out.println("Current Student name "+ m.name[i]);
                System.out.println("Current Student dept "+ m.dept[i]);
                System.out.println("Current Student year "+ m.year[i]);
                System.out.println("Current Student Pointer "+ m.marks[i] + "\n");
                System.out.println(" ---------------------------------------------- ");
                m.id[i] = i;
                System.out.println("Enter New name of Student " + i);
                m.name[i] = sc.next();
                System.out.println("Enter New marks of Student " + i);
                m.marks[i] = sc.nextInt();
                System.out.println("Enter New dept of Student " + i);
                m.dept[i] = sc.next();
                System.out.println("Enter New year of Student " + i);
                m.year[i] = sc.nextInt();
                System.out.println(" ----------------------------------------------- \n");
                break;
            }
            else{
                System.out.println("Name not found please Enter the valid name \n");
            }
        }
    }

    // Delete function will delete the student data whose name will be entered by the user
    public void delete (String n){
        student_manage m = new student_manage();

        // delete is done by swaping the data to the last and decrementing the reference variable value by 1
        for (int i = 0; i < r ; i++){
            if (m.name[i].equals(n)){

                // swapping of data

                m.id[i] = m.id[i+1];
                m.name[i] = m.name[i+1];
                m.marks[i] = m.marks[i+1];
                m.dept[i] = m.dept[i+1];
                m.year[i] = m.year[i+1];

                System.out.println("Data of "+ n + " is deleted \n");

                // decrementing the reference variable

                r = r-1;
                break;
            }
            else{
                System.out.println("Name not found \n");
            }
        }
    }

    // this is a main function which will be called by the interpreter when code is executed
    public static void main(String[] args) {
        student_manage a = new student_manage();
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t\t Student Record Keeping system \n\n \t\t\t------------------------------");
        System.out.println("Select Choice\n1.Add Information\n2.Display Information\n3.Search Student\n4.Update Student Information");
        System.out.println("5.Delete Student Information\n6.Exit");
        int choice = sc.nextInt();
        int n = 2;
        
        // switch case is used for menu based program
        switch(choice)
        {
            // case 1 will be used for adding the data
            case 1 : System.out.println("How many Player Information you want to add");
                     n = sc.nextInt();
                     // passing all the array to add function as a parameter
                     a.add(a.id,a.name,a.marks,a.dept,a.year,n);
                     main(new String[] {});
            
            // case 2 is used to display the data of all array
            case 2 : a.display();
                     main(new String[] {});
            
            // case 3 is used to search the student name
            case 3 : System.out.println("Enter the student name to be searched");
                     String search_name = sc.next();
                     // passing name as parameter to search method
                     a.search(search_name);
                     main(new String[] {});

            // case 4 is used update the student info
            case 4 : System.out.println("Enter the name of student to be updated");
                     String update_name = sc.next();
                     // passing name as paremeter to update method
                     a.update(update_name);
                    main(new String[] {});

            // case 5 is used to delete the student info
            case 5 : System.out.println("Enter the name of student to be deleted");
                     String delete_name = sc.next();
                     // passing name as parameter to delete method
                     a.delete(delete_name);
                     main(new String[] {});

            // Exit case
            case 6 : System.exit(0);
             

        }        
    }
}