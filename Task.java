package toDoList;
/* This class outlines the an individual Task object 
*/

import java.text.DateFormat;
import java.text.SimpleDateFormat;  
import java.util.Date;

public class Task implements Comparable<Task> {
	 //Declare Vars
	 private String taskName, taskDesc;		//vars for the name and description of a task object 
     private Date dueDate = new Date();
	 SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); //to format date  
	 private boolean completed;
	 //Var for tracking current date
	 java.util.Date date = new java.util.Date();  //needs a get and set as well?

	 //constructor
	public Task(String taskName, String taskDesc, Date dueDate) {
		this.taskName = taskName;
		this.taskDesc = taskDesc;
		this.dueDate = dueDate;

		completed = false; 
		
	}
	
	//Getters and Setters for the various fields:
	
	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	public String getTaskDesc() {
		return taskDesc;
	}
	
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	
	
	//@Override
    public Date getDueDate() {
    	return dueDate;
    }
    
    public void setDueDate(Date dueDate) {
    	this.dueDate = dueDate;
    }
    
    public boolean getCompleted() {
    	return completed;
    }
    
    public void setCompleted(boolean completed) {
    	this.completed = completed;
    }
    


    //toString method
	@Override
	public String toString() {
		return "\nTask Name: " + taskName +
				"\nDescription: " + taskDesc +
				"\nDue Date: " + dueDate +
				"\nCompleted?: " + completed + "\n";
	}
	
	//This method compares dates, but will be implemented in the client at a later date. 
	@Override
	public int compareTo(Task T) {
		return dueDate.compareTo(date);
	}

	
}
