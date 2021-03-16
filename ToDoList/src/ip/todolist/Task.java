/**
 * The Task class is used to create an individual task
 * @author: Himani Paronigar
 */
package  ip.todolist;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;
import java.io.Serializable;
public class Task implements Serializable{


        public static int count = 0;
        private int taskID;
        private String title;    // Represents task title.
        private boolean status;  // Represents task status.
        private String projectName;  // Represents project name associate with task.
        private LocalDate dueDate;    // Represents task due date.

        public Task(String title, LocalDate dueDate, String projectName) {
            setTaskID();
            setTitle(title);
            setProjectName(projectName);
            setDueDate(dueDate);
            this.status = false;    // Setting by default status of task as false. False indicates pending task.

        }
        public void setTaskID()
        {
            this.taskID = ++count;
        }

        public int getTaskID()
        {
            return taskID;
        }

        public void setTitle(String title)
        {
            if(title == null)
                throw new NullPointerException("Title can not be empty");
            this.title = title.trim();
        }

        public String getTitle()
        {
            return title;
        }

        public void setProjectName(String projectName)
        {
            if(projectName == null)
                throw new NullPointerException("Project can not be empty");
            this.projectName = projectName;
        }


        public String getProjectName()
        {
            return projectName;
        }

        public void setStatus(boolean status)
        {
            this.status = status;
        }

        public boolean getStatus()
        {
            return status;
        }

        public boolean markComplete()
        {
            this.status = true;
            return this.status;
        }

        public void setDueDate(LocalDate dueDate)
        {
            if(dueDate.compareTo(LocalDate.now()) < 0)
            {
               throw new DateTimeException("Enter date after today");
            }
            this.dueDate = dueDate;
        }

        public LocalDate getDueDate()
        {
            return dueDate;
        }

        public void markAsDone()
        {
            this.status = true;
        }

}


class SortbyDate implements Comparator<Task>
{
    @Override
    public int compare(Task t1,Task t2)
    {
        return t1.getDueDate().compareTo(t2.getDueDate());
    }
}

class SortbyProjectName implements Comparator<Task>
{
    @Override
    public int compare(Task t1,Task t2)
    {
        return t1.getProjectName().compareToIgnoreCase(t2.getProjectName());
    }

}


