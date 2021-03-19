package ip.todolist;

import java.util.Scanner;

/**
 *This is main class of the project
 * Responsible for taking input from user and call methods accordingly
 * @author : Himani Paronigar
 * @version : 1.0
 * @since : 2021-03-19
 *
 */

public class Main {

    // A string to hold the data file name which contains all tasks and their details
    public static String fileName = "TaskList.obj";

    //Main method to run the command line based "To Do List" application

    public static void main(String[] args) {

            //An object of Task_List to hold all tasks and their data
            Task_List todolist = new Task_List();

            //Reading the date from task data file
            todolist.readFromFile(fileName);

            System.out.println("Welcome to ToDoLy");

            //A string to hold the choice that will be entered by the user
            int choice = -1;
            while (choice != 4)
            {
                //Check if task list is empty,If empty call method that will ask user to enter new task
                if(todolist.isTaskListEmpty())
                {
                    System.out.println("You can only add task as TaskList is empty now.");
                    todolist.readTaskFromUser();
                }
                System.out.println("You have " + todolist.incompleteTaskCount() + " tasks todo and " + todolist.completedTaskCount() + " tasks are done");
                System.out.println("Pick an option:");
                System.out.println("(1)Show Task List(by Date or Project)");
                System.out.println("(2)Add New Task");
                System.out.println("(3)Edit Task(Update, Mark as Cone, Remove)");
                System.out.println("(4)Save and Quit");
                System.out.print("Enter your choice:");
                choice = getIntInputFromUser(); //Calling this method for restricting user to enter integer only
                switch (choice) {
                    case 1:
                        System.out.println("Display all tasks");
                        System.out.println("=================");
                        System.out.println("Pick an option:");
                        System.out.println("(1)Show Task List by Date");
                        System.out.println("(2)Show Task List by Project");
                        System.out.print("Please enter you choice:");
                        int choiceD = getIntInputFromUser(); //Calling this method for restricting user to enter integer only
                        switch (choiceD) {
                            case 1:
                                todolist.listAllTaskFromList(1);
                                break;
                            case 2:
                                todolist.listAllTaskFromList(2);
                                break;
                            default:
                                System.out.println("Returning to Main menu");
                        }
                        break;
                    case 2:
                        todolist.readTaskFromUser(); // method will read task from user
                        break;
                    case 3:
                        todolist.displayAllTask(); // method for displaying all tasks to make it easier for the user to choose a task
                        System.out.print("Enter the task ID which you want to edit:");
                        int ID = getIntInputFromUser(); //Calling this method for restricting user to enter integer only
                        todolist.displayTaskFromList(ID); // method to display task details selected by user
                        System.out.println("Task Edit options:");
                        System.out.println("=================");
                        System.out.println("Choose Options:");
                        System.out.println("==============");
                        System.out.println("(1)Update the selected task");
                        System.out.println("(2)Mark selected task as done");
                        System.out.println("(3)Delete selected task");
                        System.out.println();
                        System.out.print("Enter you choice:");
                        int choice1 = getIntInputFromUser(); //Calling this method for restricting user to enter integer only
                        switch (choice1) {
                            case 1:
                                todolist.updateTaskFromList(ID); //method to update the selected task
                                break;
                            case 2:
                                todolist.markTaskAsDone(ID); //method to mark selected task as done
                                break;
                            case 3:
                                todolist.deleteTaskFromList(ID); //method to delete selected task
                                break;
                            default:
                                System.out.println("Returning to Main menu");
                        }
                    case 4:
                        break;  // No code here because 4 is for quiting an app
                    default:
                        System.out.println("Please enter you choice between [1-4].");
                }
            }
        System.out.println("Thank you for using ToDoLy!");

        // saving the task details in data file
        // if this is the first time, a new task file will be created
        todolist.saveToFile(fileName);
    }

    /**
     * A method that restrict user to enter only integer value
     * @return int number entered by the user
     */
    public static int getIntInputFromUser()
    {
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            System.out.println("Nope, that's not an integer!");
            scan.nextLine();
        }
        int number = scan.nextInt();
        return number;
    }

    /**
     * A method that restrict user to enter only string value
     * @return string value entered by the use
     */
    public static String getStrInputFromUser()
    {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNext("[A-Za-z]+")) {
            System.out.println("Nope, that's not a string!");
            sc.next();
        }
        String str = sc.next();
        return str;
    }
}


