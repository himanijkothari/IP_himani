/**
 * The Task class is used to create an individual task
 * @author: Himani Paronigar
 */
package  ip.todolist;;
import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Date;
public class Task {


    public static int count = 0;
        private int taskID;
        private String title;    // Represents task title.
        private boolean status;  // Represents task status.
        private String projectName;  // Represents project name associate with task.
        private Date dueDate;    // Represents task due date.

        public Task(String title,Date dueDate,String projectName)
        {
            setTitle(title);
            setProjectName(projectName);
            setDueDate(dueDate);
            this.status = false;    // Setting by default status of task as false. False indicates pending task.
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

        public void setStatus(boolean status) {
            this.status = status;
        }

        public boolean getStatus() {
            return status;
        }

        public boolean markComplete(){
            this.status = true;
            return this.status;
        }

        public void setDueDate(Date dueDate)
        {
            Date currentDate = new Date();
            if(dueDate.compareTo(currentDate) < 0)
            {
               throw new DateTimeException("Enter date after today");
            }
            this.dueDate = dueDate;
        }

        public Date getDueDate() {
            return dueDate;
        }

}
