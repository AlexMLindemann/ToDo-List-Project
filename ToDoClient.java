package toDoList;
/* This is the client class for a ToDo list. It prints a menu that lets users perform various functions related to the ToDo list. 
 * @author Alex Lindemann
 * @Date 12/13/2021
 */

//Imports for packages
import java.util.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ToDoClient {
    public static void main(String[] args) throws ParseException {			//Exception signals that an error was reached while parsing a string
    	//Creates a task list object to hold the tasks and data
        TaskList list = new TaskList();				
    	//Declare scanner var, declare input variables
    	Scanner kb = new Scanner(System.in);
        String name, description, dueDate;
        boolean condition = true;	//for running while loop
        //Print statements for console menu
        System.out.println("=========================");
    	System.out.println("This is a simple to-do list app");
    	System.out.println("What's on the agenda?");
    	while (condition == true) {		
        	Scanner menuInput = new Scanner(System.in);		//for getting menu input during the loop
    		System.out.println("\n1. Add a task \n2. View Highest Priority Task \n3. View All Tasks \n4. Mark As Completed \n5. Exit");
        	int userPrint = menuInput.nextInt();	//saves user input
    		Date newDate = new Date();	//create Date Object
        	if (userPrint == 1) {		//lets user wants to add a task
	    		    //ask and get user input for task name
        			System.out.println("Enter the name of a task you want to add: ");
	    		    name = kb.nextLine(); 
	    		    
	    		    //Ask and get userinput for task description
	    		    System.out.println("Enter a description of the task: ");
	    		    description = kb.nextLine();
	    		   
	    		    ///Gets due date from user input and saves in var
	    		    System.out.println("Enter the task's due date in yyyy-MM-dd:  ");
	    		    dueDate = kb.nextLine();		
	    		    
	    		    //call parseDate method to parse the entered string to Date object
	    		    newDate = parseDate(dueDate);
	    		    list.addTask(name, description, newDate);		//add task name, description and duedate to PQueue
	    		    System.out.println("Task Added Succesfully");
	    		    System.out.println("\n\nMore on the agenda?");
	    	} else if (userPrint == 2) {
	    		System.out.println("\nHighest Priority Task: ");
	    		System.out.println(list.getTask());		//gets task at the front of the queue	    	
	   		} else if(userPrint == 3) {
	   			list.printQueue();			//Prints all tasks in the queue
	   		} else if (userPrint == 4) {
	   			list.markCompleted(true);   //Marks task at the front of the queue as completed
	   		} else if (userPrint == 5) {
	   			condition = false;
	   			pressEnterToContinue(); 	//Calls method to double check that the user wants to exit
	   			kb.close();
	   	        menuInput.close();
	   		} //end if else 
    	}//end while loop     
    }//end main

    //Makes sure user wants to quit program by making them hit enter key
    private static void pressEnterToContinue()
    { 
           System.out.println("Are you sure you want to quit? Hit the Enter key to confirm...");
           try
           {
               System.in.read();
               //System.exit(0);
           }  
           catch(Exception e)
           {
        	   
           }  
    }//end pressEnterToContinue
    
    //parses the user entered string for the dueDate, returns a SimpleDateFormat date, and throws an exception if entered incorrectly.
	public static Date parseDate(String dueDate) throws ParseException {
		Date date = new Date();
		try {
	    	date = new SimpleDateFormat("yyyy-MM-dd").parse(dueDate);
	    	return date;
	    } catch (ParseException e) {
	    	System.out.println("ParseException occured: " + e.getMessage());
	    }
	return date; 
	}//end parseDate method   
}//end ToDoClient

/*	OUTPUT:
	=========================
	This is a simple to-do list app
	What's on the agenda?
	
	1. Add a task 
	2. View Highest Priority Task 
	3. View All Tasks 
	4. Mark As Completed 
	5. Exit
	1
	Enter the name of a task you want to add: 
	Math Homework
	Enter a description of the task: 
	Page 22 Problems 6-12
	Enter the task's due date in yyyy-MM-dd:  
	2021-12-21
	Task Added Succesfully
	
	
	More on the agenda?
	
	1. Add a task 
	2. View Highest Priority Task 
	3. View All Tasks 
	4. Mark As Completed 
	5. Exit
	2
	
	Highest Priority Task: 
	
	Task Name: Math Homework
	Description: Page 22 Problems 6-12
	Due Date: Tue Dec 21 00:00:00 EST 2021
	Completed?: false
	
	
	1. Add a task 
	2. View Highest Priority Task 
	3. View All Tasks 
	4. Mark As Completed 
	5. Exit
	4
	
	1. Add a task 
	2. View Highest Priority Task 
	3. View All Tasks 
	4. Mark As Completed 
	5. Exit
	3
	
	Task Name: Math Homework
	Description: Page 22 Problems 6-12
	Due Date: Tue Dec 21 00:00:00 EST 2021
	Completed?: true
	 
	
	1. Add a task 
	2. View Highest Priority Task 
	3. View All Tasks 
	4. Mark As Completed 
	5. Exit
	5
	Are you sure you want to quit? Hit the Enter key to confirm...
*/