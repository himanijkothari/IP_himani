/** This class represents ToDoList which contains the ArrayList of Task objects
 * @author : Himani Paronigar
 * @version : 1.0
 *@since : 2021-03-19
 **/

package ip.todolist;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import  java.util.ArrayList;

public class Task_List {
    
    // An array list of task objects
    private ArrayList<Task> taskList;

    //Creating todolist object
    public Task_List()
    {
        taskList = new ArrayList<Task>();
    }

    /**
     * Adding a Task object in ArrayList
     * @param task that is already created
     */
    public void addTaskList(Task task)
    {
        taskList.add(task);
    }


    /**+
     * Check whether TaskList is empty
     * @return true if tasklist is empty , false otherwise
     */
    public boolean isTaskListEmpty()
    {
      if(taskList.size() == 0)
          return true;
      else
          return false;
    }


    /**
     * A method to read the value from user (standard input, i.e., terminal)
     * to create a Task object and to add in the ArrayList of Tasks
     */
    public void readTaskFromUser()
    {
        try
        {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the title of task:");
            String title = Main.getStrInputFromUser();  //Calling this method for restricting user to enter string only
            System.out.print("Enter the project associated with task:");
            String projectName = Main.getStrInputFromUser();  //Calling this method for restricting user to enter string only
            System.out.print("Enter the due date of task(for example:2019-12-02):");
            String date = sc.next();
            LocalDate dueDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
            Task new_task = new Task(title, dueDate, projectName);
            addTaskList(new_task);           //adding newly created task to tasklist object
            System.out.println("Task added Successfully");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * A method to display the contents of ArrayList with first column as task ID
     */
    public void displayAllTask()
    {
        String displayFormat = "%-4s%-35s%-20s%-20s%-10s";
        System.out.println(String.format(displayFormat, "ID", "TITLE", "PROJECT-NAME", "DUEDATE", "STATUS"));
        System.out.println(String.format(displayFormat, "==", "=====", "============", "========", "======"));
        for (Task task : taskList) {

            System.out.println(String.format(displayFormat, taskList.indexOf(task) + 1, task.getTitle(), task.getProjectName(), task.getDueDate(), (task.getStatus() ? "COMPLETED" : "NOT COMPLETED")));
        }
    }

     /**
     * A method to display the contents of ArrayList
     * @param sortBy a string holding a number, 1 for sorting by date and 2 for sorting by date
     */
    public void listAllTaskFromList(int sortBy)
    {
        if(sortBy == 1)
        {
            taskList.sort(new SortbyDate());            //Sorting tasks by Date
            displayAllTask();
        }
        else if(sortBy == 2)
        {
            taskList.sort(new SortbyProjectName());      //Sorting tasks by ProjectName
            displayAllTask();
        }
    }

     /**
     * A method to display the task details by particular task ID
     * @param ID is the ID entered by the user for updating the task
     */
    public void displayTaskFromList(int ID)
    {
        System.out.println("Task to be updated:");
        System.out.println("===================");
        Task task=taskList.get(ID-1);
        System.out.println("Task title:  "+task.getTitle());
        System.out.println("Task dueDate:"+task.getDueDate());
        System.out.println("Task project:"+task.getProjectName());
        System.out.println("Task status: "+(task.getStatus()?"COMPLETED":"NOT COMPLETED"));
        System.out.println("=========================");
    }

    /**
     * A method to count the number of tasks with completed status
     * @return number of tasks with completed status
     */
    public int completedTaskCount()
    {
        return (int) taskList.stream()
                .filter(task -> task.getStatus() == true)
                .count();
    }


    /**
     * A method to count the number of tasks with incomplete status
     * @return number of tasks with not complete status
     */
    public int incompleteTaskCount()
    {
        return (int) taskList.stream()
                .filter(task -> task.getStatus() == false)
                .count();
    }


      /**
      * A method to update the task details by particular task ID
      * @param ID is the ID entered by the user for updating the task
      */
    public void updateTaskFromList(int ID)
    {
        Scanner sc=new Scanner(System.in);

        Task task= taskList.get(ID-1);
        System.out.println("Press enter the following details to update the task:");
        System.out.println("=====================================================");
        System.out.print("Task Title:");
        String title=Main.getStrInputFromUser();
        if(!(title.trim().equals("")||title==null))
            task.setTitle(title);

        System.out.print("Project name:");
        String projectName=Main.getStrInputFromUser();
        if(!(projectName.trim().equals("")||projectName==null))
            task.setProjectName(projectName);

        System.out.print("DueDate:");
        String date=sc.next();
        LocalDate  dueDate=LocalDate.parse(date,DateTimeFormatter.ISO_LOCAL_DATE);
        if(!(dueDate.equals("")||dueDate==null))
            task.setDueDate(dueDate);

        System.out.println("Task updated successfully.");
        System.out.println("=========================");
    }

      /**
      * A method to delete task by particular task ID
      * @param ID is the ID entered by the user for deleting the task
      */
    public void deleteTaskFromList(int ID){

        Task task=taskList.get(ID-1);
        taskList.remove(task);
        System.out.println("Task successfully deleted.");
        System.out.println("=========================");
    }


      /**
      * A method to mark task as complete by particular task ID
      * @param ID is the ID entered by the user for updating the task
      */
    public void markTaskAsDone(int ID)
    {
        Task task=taskList.get(ID-1);
        task.markAsDone();
        System.out.println("Task mark as done.");
        System.out.println("==================");
    }

    /**
     * This method will write the data of Tasks from ArrayList to data file on disk, i.e., tasks.obj
     * @param fileName a string specifying the full path and extension of data file, for example,  "resources/tasks.obj"
     * @return true if the reading operation was successful, otherwise false
     */
    public boolean saveToFile(String fileName){
        try{
            FileOutputStream fileOutputStream=new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(taskList);

            objectOutputStream.close();
            fileOutputStream.close();
            return true;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return  false;
        }
    }

     /**
     * This method will read the data file from disk which will contain the data of previously saved tasks
     * @param fileName a string specifying the full path and extension of data file, for example,  "resources/tasks.obj"
     * @return true if the reading operation was successful, otherwise false
     */    
    public boolean readFromFile(String fileName){
        boolean status=false;

        try{
            if(!Files.isReadable(Paths.get(fileName))){
                System.out.println("The data file,i.e.,"+fileName+"does not exists");
                return false;
            }

            FileInputStream fileInputStream=new FileInputStream(fileName);
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);

            taskList=(ArrayList<Task>)objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();
            return true;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

}

