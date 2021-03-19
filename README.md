## Todo-list: A command line application in JAVA

A simple command line JAVA program to create and manage a personal Todo List.

#### A brief overview:


This program is menu-driven. User will be presented with available options corresponding to selected menu. User will select an option from given choices and press ENTER key to move to next step. This program will save all tasks in the data file, therefore, next time when you open the program, it will resume its state.

#### Basic features:

* Models a task with:
    * Task title
    * Due date
    * Completion status
    * Project (if any)
    
* Display a collection of tasks that can be sorted
    * By Date
    * By Project
   
* Support the ability to
   * Add task
   * Edit task
   * Mark a task as done
   * Remove (delete) tasks
   
* Support a text-based user interface

* Load and save task list to data file


## Class Diagram










## User Manual

#### Starting the application

When user will run the program, main menu of the program (as shown below) will be shown to the user :

#### Display list of tasks

* If User types 1, the application will display the options for user to get list of all previously added tasks sorted by date or by project.

 ![Main menu](/Users/himaniparonigar/Desktop/github/IP_himani/UserManual/1.png)
 

* If User press 1, the list of all tasks will be sorted by date and displayed on the interface.

* If User press 2, the list of all tasks will be sorted by project name and displaye on the interface.


#### Add new task

* If user types 2, the application will prompt the User to enter the required fields of a task to add in the task list.



#### Edit an existing task (Update, Mark as Done, Remove)

* If user types 3, the application will display the list of all previously saved tasks with ID and user has to select a task to perform any update, to mark as done or to remove.

* After User enter ID and select 1, the application will prompt the User to enter the required fields of a task to update it.

* After User enter ID and select 2, the selected task will be marked as complete.

* After User enter ID and select 3, the selected task will be deleted from list.


#### Closing the application

* If User types 4, the application will save data of all tasks from memory,write to the data file on disk (defaut filename is tasks.obj) and quits the application.



