/** Main class which runs ToDoList app
 * @author : Himani Paronigar
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

            System.out.println("Welcome to ToDoLy");
            System.out.println("You have X tasks todo and Y tasks are done");
            System.out.println("Pick an option:");
            System.out.println("(1)Show Task List(by date or project");
            System.out.println("(2)Add New Task");
            System.out.println("(3)Edit Task(update, mark as done, remove)");
            System.out.println("(4)Save and quit");

            Scanner sc = new Scanner(System.in); // Taking input from user
            int choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                    break;
                case 2:
                    System.out.println("Enter the title of task:");
                    String title = sc.next();
                    System.out.println("Enter the project associated with task:");
                    String projectName = sc.next();
                    System.out.println("Enter the due date of task(MM-DD-YY):");
                    SimpleDateFormat df = new SimpleDateFormat("MM-DD-YY");
                    String date = sc.next();
                    Date dueDate;
                    try
                    {
                        dueDate = df.parse(date);
                    }
                    catch (ParseException e)
                    {
                        System.out.println("Invalid format. Please enter date in valid format");
                    }

                    Task new_task = new Task(title,dueDate,projectName);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:

            }
        }
    }

