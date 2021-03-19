package ip.todolist;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class TestTask_List {

    Task task1 = new Task("read", LocalDate.parse("2021-12-15"),"sda");
    Task task2 = new Task("code",LocalDate.parse("2021-05-15"),"practice");
    Task task3 = new Task("shop",LocalDate.parse("2021-10-30"),"fun");


    /**
     * This method will check if Task_List.isTaskListEmpty() method will return true
     * if there are no tasks in TaskList
     */
    public final
    @Test
    void testIfTaskListIsEmpty()
    {
         Task_List taskList = new Task_List();
         boolean result = taskList.isTaskListEmpty();
         assertTrue(result);
    }

    /**
     * This method will check if Task_List.isTaskListEmpty() method will return false
     * if there are tasks in TaskList
     */
    public final
    @Test
    void testIfTaskHasAddedInTaskList()
    {
        Task_List taskList = new Task_List();
        taskList.addTaskList(task1);
        boolean result = taskList.isTaskListEmpty();
        assertFalse(result);
    }

    /**
     * This method will check if Task_List.listAllTaskFromList() method will sort
     * tasks in TaskList by Date if called with argument : 1
     */
    public final
    @Test
    void successfulSortingByDate()
    {
        Task_List taskList1 = new Task_List();
        taskList1.addTaskList(task1);
        taskList1.addTaskList(task2);
        taskList1.addTaskList(task3);
        taskList1.listAllTaskFromList(1);
        assertEquals("code",taskList1.taskList.get(0).getTitle());
        assertEquals("shop",taskList1.taskList.get(1).getTitle());
        assertEquals("read",taskList1.taskList.get(2).getTitle());
    }


    /**
     * This method will check if Task_List.listAllTaskFromList() method will sort
     * tasks in TaskList by ProjectName if called with argument : 2
     */
    public final
    @Test
    void successfulSortingByProjectName()
    {
        Task_List taskList1 = new Task_List();
        taskList1.addTaskList(task1);
        taskList1.addTaskList(task2);
        taskList1.addTaskList(task3);
        taskList1.listAllTaskFromList(2);
        assertEquals("shop",taskList1.taskList.get(0).getTitle());
        assertEquals("code",taskList1.taskList.get(1).getTitle());
        assertEquals("read",taskList1.taskList.get(2).getTitle());
    }


    /**
     * This method will check if Task_List.completedTaskCount() returns the
     * number of tasks which are mark as completed
     */
    public final
    @Test
    void completedTaskCountTest()
    {
        Task_List taskList1 = new Task_List();
        taskList1.addTaskList(task1);
        taskList1.addTaskList(task2);
        taskList1.addTaskList(task3);
        task1.markAsDone();
        task2.markAsDone();
        int result = taskList1.completedTaskCount();
        assertEquals(2,result);
    }

    /**
     * This method will check if Task_List.inCompletedTaskCount() returns the
     * number of tasks which are mark as not completed
     */
    public final
    @Test
    void inCompletedTaskCountTest()
    {
        Task_List taskList1 = new Task_List();
        taskList1.addTaskList(task1);
        taskList1.addTaskList(task2);
        taskList1.addTaskList(task3);
        task1.markAsDone();
        task2.markAsDone();
        int result = taskList1.inCompleteTaskCount();
        assertEquals(1,result);
    }


    /**
     * This method will check if Task_List.deleteTaskFromList(ID) will delete the task
     * which is at number : ID
     */
    public final
    @Test
    void successfulDeletionOfTask()
    {
        Task_List taskList1 = new Task_List();
        taskList1.addTaskList(task1);
        taskList1.addTaskList(task2);
        taskList1.addTaskList(task3);
        taskList1.deleteTaskFromList(2);
        int result = taskList1.taskList.size();
        assertEquals(2,result);
        assertEquals("read",taskList1.taskList.get(0).getTitle());
        assertEquals("shop",taskList1.taskList.get(1).getTitle());
    }

}
