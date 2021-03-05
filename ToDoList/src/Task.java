/**
 * The Task class is used to create an individual task
 * @author: Himani Paronigar
 */

import  java.util.*;
public class Task {

        // Making all fields public temporary.I will change it according to demand of implementation.
        public String title;    // Represents task title.
        public boolean status;  // Represents task status.
        public String projectName;  // Represents project name associate with task.
        public Date dueDate;    // Represents task due date.

        public Task(String title,Date dueDate,String projectName)
        {
            this.title = title;
            this.dueDate = dueDate;
            this.projectName = projectName;
            this.status = false;    // Setting by default status of task as false. False indicates pending task.
        }


}
