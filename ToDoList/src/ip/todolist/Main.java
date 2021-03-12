
package ip.todolist;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

            System.out.println("Welcome to ToDoLy");
            System.out.println("You have X tasks todo and Y tasks are done");
            System.out.println("Pick an option:");
            System.out.println("(1)Show Task List(by date or project");
            System.out.println("(2)Add New Task");
            System.out.println("(3)Edit Task(update, mark as done, remove)");
            System.out.println("(4)Save and quit");
            Task_List todolist = new Task_List();
            System.out.println("Enter your choice:");
            Scanner sc = new Scanner(System.in); // Taking input from user
            int choice = sc.nextInt();
            do {

                switch (choice) {
                    case 1:

                        break;
                    case 2:
                        try {
                            System.out.println("Enter the title of task:");
                            String title = sc.next();
                            System.out.println("Enter the project associated with task:");
                            String projectName = sc.next();
                            System.out.println("Enter the due date of task(MM/DD/YYYY):");
                            SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                            String date = sc.next();
                            df.setLenient(false);
                            Date dueDate = df.parse(date);
                            Task new_task = new Task(title, dueDate, projectName);
                            todolist.addTaskList(new_task);
                            System.out.println("Task added Successfully");
                        }
                        catch (Exception e)
                        {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:





                        break;


                }
            }
            while (choice == 4);

        }
    }

