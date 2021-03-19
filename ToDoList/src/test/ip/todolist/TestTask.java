/**
 * This class is created for unit testing for model class, i.e., Task (Task.java)
 *
 * @author  Himani Paronigar
 * @version 1.0
 * @since   2019-03-19
 **/
package ip.todolist;

import org.junit.jupiter.api.Test;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static org.junit.jupiter.api.Assertions.*;


public class TestTask {

    /**
     * This method will validate the task.setProjectName() method for trimming an empty string " " as invalid parameter
     * which should result as NullPointerException
     */
    public final
    @Test
    void AddEmptyProjectName()
    {
        String project = " ";
        String title = "cook";
        LocalDate date = LocalDate.now();
        NullPointerException exception = assertThrows(NullPointerException.class,
                ()->{
                Task task = new Task(title,date,project);
                });
        assertEquals("Project can not be empty", exception.getMessage());
    }

    /**
     * This method will validate the task.setTitle() method for trimming an empty string " " as invalid parameter
     * which should result as NullPointerException
     */
    public final
    @Test
    void AddEmptyTitle()
    {
        String project = "home";
        String title = " ";
        LocalDate date = LocalDate.now();
        NullPointerException exception = assertThrows(NullPointerException.class,
                ()->{
                    Task task = new Task(title,date,project);
                });
        assertEquals("Title can not be empty", exception.getMessage());
    }

    /**
     * This method will validate the task.setDueDate() method for not accepting date which are earlier then today
     * which should result as DateTimeException
     */
    public final
    @Test
    void invalidDueDateInTask()
    {
        String project = "home";
        String title = "cook";
        LocalDate date = LocalDate.parse("2021-01-01", DateTimeFormatter.ISO_LOCAL_DATE);
        DateTimeException exception = assertThrows(DateTimeException.class,
                ()->{
                      Task task = new Task(title,date,project);
                })  ;
        assertEquals("Enter date after today", exception.getMessage());
    }

    /**
     * This method will check if task.markAsDone() method mark status of task as done successfully
     * which return true as true indicated task is completed
     */
    public final
    @Test
    void successfulMarkAsDoneToTask()
    {
        String project = "home";
        String title = "cook";
        LocalDate date = LocalDate.parse("2021-12-30", DateTimeFormatter.ISO_LOCAL_DATE);
        Task task = new Task(title,date,project);
        task.markAsDone();
        assertTrue(task.getStatus());
    }
}
