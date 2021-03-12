/** Represents List of available task.
 * @author : Himani Paronigar
 */

package ip.todolist;
import  java.util.*;
public class Task_List {

    private ArrayList<Task> taskList;

    public Task_List(){

        taskList = new ArrayList<Task>();

    }

    public void addTaskList(Task task)
    {
        taskList.add(task);
    }





}
