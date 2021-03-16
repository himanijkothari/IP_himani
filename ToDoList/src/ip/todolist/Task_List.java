/** Represents List of available task.
 * @author : Himani Paronigar
 */

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

    private ArrayList<Task> taskList;

    public Task_List()
    {
        taskList = new ArrayList<Task>();
    }

    public void addTaskList(Task task)
    {
        taskList.add(task);
    }

    public void displayAllTask()
    {
        String displayFormat="%-4s%-35s%-20s%-20s%-10s";
        System.out.println(String.format(displayFormat,"ID","TITLE","PROJECT-NAME","DUEDATE","STATUS"));
        System.out.println(String.format(displayFormat,"==","=====","============","========","======"));
        for(Task task:taskList){

            System.out.println(String.format(displayFormat,task.getTaskID(),task.getTitle(),task.getProjectName(),task.getDueDate(),(task.getStatus()?"COMPLETED":"NOT COMPLETED")));
        }

    }

    public void listAllTaskFromList(int sortBy)
    {
        if(taskList.size()==0)
            System.out.println("No task in list");
        else
        if(sortBy==1)//by date
        {
            taskList.sort(new SortbyDate());
            displayAllTask();
        }
        else
        {
            taskList.sort(new SortbyProjectName());
            displayAllTask();
        }
    }


    public void displayTaskFromList(int ID)
    {
        System.out.println("Task to be updated:");
        System.out.println("===================");
        Task task=getTaskByID(ID);
        System.out.println("Task title:  "+task.getTitle());
        System.out.println("Task dueDate:"+task.getDueDate());
        System.out.println("Task project:"+task.getProjectName());
        System.out.println("Task status: "+(task.getStatus()?"COMPLETED":"NOT COMPLETED"));
        System.out.println("=========================");
    }

    public Task getTaskByID(int ID)
    {
        for(Task task:taskList){
            int task_id=task.getTaskID();
            if(task_id== ID)
                return task;
        }
        return null;
    }

    public void updateTaskFromList(int ID)
    {
        Scanner sc=new Scanner(System.in);

        Task task=getTaskByID(ID);
        System.out.println("Press enter the following details to update thetask:");
        System.out.println("=====================================================");
        System.out.print("Task Title:");
        String title=sc.next();
        if(!(title.trim().equals("")||title==null))
            task.setTitle(title);

        System.out.print("Project name:");
        String projectName=sc.next();
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

    public void deleteTaskFromList(int ID){

        Task task=getTaskByID(ID);
        taskList.remove(task);
        System.out.println("Tasksuccessfullydeleted.");
        System.out.println("=========================");
    }


    public void markTaskAsDone(int ID)
    {
        Task task=getTaskByID(ID);
        task.markAsDone();
        System.out.println("Task mark as done.");
        System.out.println("==================");
    }

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

