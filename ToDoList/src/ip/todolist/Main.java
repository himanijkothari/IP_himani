
package ip.todolist;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Main {

    public static String fileName = "Tasklist.obj";

    public static void main(String[] args)  {

            System.out.println("Welcome to ToDoLy");
            System.out.println("You have X tasks todo and Y tasks are done");
            System.out.println("Pick an option:");
            System.out.println("(1)Show Task List(by date or project");
            System.out.println("(2)Add New Task");
            System.out.println("(3)Edit Task(update, mark as done, remove)");
            System.out.println("(4)Save and quit");
            Task_List todolist = new Task_List();

            int choice = -1;
            while (choice != 4)
            {
                System.out.println("Enter your choice:");
                Scanner sc = new Scanner(System.in); // Taking input from user
                choice = sc.nextInt();
                switch (choice) {
                    case 1:

                        break;
                    case 2:
                        try {
                            System.out.println("Enter the title of task:");
                            String title = sc.next();
                            System.out.println("Enter the project associated with task:");
                            String projectName = sc.next();
                            System.out.println("Enter the due date of task(for example:2019-12-02):");
                            String date = sc.next();
                            LocalDate dueDate = LocalDate.parse(date,DateTimeFormatter.ISO_LOCAL_DATE);
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
                        todolist.displayAllTask();
                        System.out.println("Enter the task ID which you want to edit:");
                        int ID = sc.nextInt();
                        todolist.displayTaskFromList(ID);
                        System.out.println("Task Edit options:");
                        System.out.println("=================");
                        System.out.println();
                        System.out.println("Choose Options:");
                        System.out.println("==============");
                        System.out.println("(1)Update the selected task:");
                        System.out.println("(2)Mark selected task as done:");
                        System.out.println("(3)Delete selected task:");
                        System.out.println();
                        System.out.println("Enter you choice:");
                        int choice1 = sc.nextInt();
                        switch (choice1){
                            case 1:
                                todolist.updateTaskFromList(ID);
                                break;
                            case 2:
                                todolist.markTaskAsDone(ID);
                                break;
                            case 3:
                                todolist.deleteTaskFromList(ID);
                                break;
                            default:
                                System.out.println("Returning to Main menu");
                        }
                    case 4:
                        break;
                }
            }

        }
    }

