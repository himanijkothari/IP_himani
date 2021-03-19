/**
 * This is a model class and it represents a Task object
 * and it contains necessary fields and methods to operate
 * on task object
 * @author: Himani Paronigar
 * @version : 1.0
 * @since : 2021-03-19
 */
package  ip.todolist;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.Serializable;
public class Task implements Serializable {

        private String title;    // Represents task title.
        private boolean status;  // Represents task status.
        private String projectName;  // Represents project name associate with task.
        private LocalDate dueDate;    // Represents task due date.


        /**
         * Creating an object of Task class
         * @param title A String that holds the title of a task
         * @param projectName A String that holds the name of project associated with task
         * @param dueDate The due date of the task
         */
        public Task(String title, LocalDate dueDate, String projectName) {

            setTitle(title);
            setProjectName(projectName);
            setDueDate(dueDate);
            this.status = false;    // Setting by default status of task as false. False indicates pending task.

        }


        /**
         * A method to set the title of a Task object
         * @param title A String that holds the title of a task and it cannot be empty or null.
         * @throws NullPointerException if title is null or empty string
         */
        public void setTitle(String title) throws NullPointerException {
            if(title == null)
                throw new NullPointerException("Title can not be empty");
            this.title = title.trim();
        }

        /**
         * A method to get the task title
         * @return a String containing the title of a task
         */
        public String getTitle()
        {
            return title;
        }

        /**
         * A method to set the project name
         * @param projectName A String that holds the name of project associated with task
         * @throws NullPointerException if title is null or empty string
         */
        public void setProjectName(String projectName) throws NullPointerException {
            if(projectName == null)
                throw new NullPointerException("Project can not be empty");
            this.projectName = projectName;
        }


        /**
         * A method to get the project name
         * @return a String containing the project name
         */
        public String getProjectName()
        {
            return projectName;
        }

        /**
         * A method to get the project name
         * @return a Boolean containing status of the task
         */
        public boolean getStatus()
        {
            return status;
        }


        /**
         * A method to set the due date of a task
         * @param dueDate The due date of the task
         * @throws DateTimeException if given date is a past date
         */
        public void setDueDate(LocalDate dueDate) throws DateTimeException
        {
            if(dueDate.compareTo(LocalDate.now()) < 0)
                throw new DateTimeException("Enter date after today");

            this.dueDate = LocalDate.parse(dueDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
        }


        /**
         * A method to get the due date of the task
         * @return the due date of task as LocalDate object
         */
        public LocalDate getDueDate()
        {
            return dueDate;
        }

        /**
         * A method to mark a task as completed
         */
        public void markAsDone()
        {
            this.status = true;
        }

}


/**
 * This class implements the comparator interface
 * that helps to sort the tasklist by date
 */
class SortbyDate implements Comparator<Task>
{
    @Override
    public int compare(Task t1,Task t2)
    {
        return t1.getDueDate().compareTo(t2.getDueDate());
    }
}

/**
 * This class implements the comparator interface
 * that helps to sort the tasklist by projectName
 */
class SortbyProjectName implements Comparator<Task>
{
    @Override
    public int compare(Task t1,Task t2)
    {
        return t1.getProjectName().compareToIgnoreCase(t2.getProjectName());
    }

}


