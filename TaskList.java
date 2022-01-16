package toDoList;
/* This class file describes the way Task objects will be stored in a PriorityQueue
 * There is a method to add a Task with its attributes, as well as methods to peek  
 * the top of the queue, mark a task as completed, and print the contents of the queue
 */

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Date;	
public class TaskList {
		//Create PriorityQueue for tasks
		private PriorityQueue<Task> list;
		//constructor
		public TaskList() {
			list = new PriorityQueue<>();
		}
		//Adds task to the PriorityQueue
		public void addTask(Task T) {
			list.add(T);
		}
		//Creates a task object with the passed in parameters
		public void addTask(String taskDesc, String taskName, Date dueDate) {
			Task newTask = new Task(taskDesc, taskName, dueDate);
			addTask(newTask);
		}
		//Peeks top of list to get 
		public Task getTask() {
			return list.peek();
		}
		//sets the completed value of the top task in the queue to true.
		public void markCompleted(boolean completed) {
			list.peek().setCompleted(true);
		}
		
	    //Creates a copy of the PriorityQueue, iterates through the queue and prints all of its contents
		public void printQueue() {      
	        PriorityQueue<Task> copy = new PriorityQueue<Task>();
	        copy.addAll(list) ;        
	        Iterator<Task> through = list.iterator() ;
	        while(through.hasNext() ) {
	                System.out.print(through.next() + " ") ;
	        }
	        System.out.println();      
	        list.addAll(copy) ;
	    }
}//end taskList