package toDoList;
/*
 * An interface for the ADT PriprotyQueue
 * 
 */
public interface PriorityQueueInterface<T extends Comparable<? super T>> {
	// Adds a new entry to this priority queue.
	// 4 @param newEntry An object to be added. 
	public void enqueue(T newEntry);
	
	//Removes & @return entry with highest priority. Returns null if empty
	public T remove();
	
	//Fetches element with highest priority
	//@return element with highest priority or null if empty
	public T peek();
	
	//Checks if the queue is empty. 
	//@return True if empty, false if not
	public boolean isEmpty(); 
	
	//@return num of entries in this PriortyQueue	
	public int getSize();
	
	//removes all entries from this PriortyQueue
	public void clear();
}//end PriorityQueueInterface
