


/*
 * Purpose: Data Structure and Algorithms Lab Exam
 * Status: Complete and thoroughly tested 
 * Last update: 10/17/18
 * Submitted:  10/17/18
 * Comment: test suite and sample run attached
 * @author: Zain Shahabuddin
 * @version: 2018.10.17
 */

public class Queue<T> implements QueueInterface<T> {

	 protected T []items;
	 protected int front;
	 protected int rear;
	 private static final int MAX_LIST = 3;
	 protected int numItems;
	 
	 public Queue()
	 {
		 front = 0;
		 rear = 0;
		 numItems = 0;
		 items = (T[]) new Object[MAX_LIST];
	 }
	 
	 public T peek()
	 {
		 if(!isEmpty())
		 {
		 return items[front];
		 }
		 else
		 {
			 throw new QueueException("Exception on peak") ;
		 }
	 }
	 public void enqueue(T item)
	 {
		 if(numItems == items.length)
		 {
			 resize();
		 }
		 items[rear] = item;
		 rear = (rear + 1) % items.length;
		 numItems++;
	 }
	 
	 public T dequeue()
	 {
		 if(!isEmpty())
		 {
		 T temp = items[front];
		 items[front] = null;
		 front = (front + 1) % items.length;
		 numItems--;
		 return temp;
		 }
		 else
		 {
			 throw new QueueException("Exception on dequeue") ; 
		 }
	 }
	 
	 public void dequeueAll()
	 {
		 items = (T[]) new Object[MAX_LIST];//create new list
		 numItems = 0; //list is empty
		 front = 0;
		 rear = 0;
	 }
	 
	 
	 public boolean isEmpty()
	 {
		 if(numItems == 0)
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	 }
	 
	 public int getSize()
	 {
		 return numItems;
	 }
	 
	 public String toString()
	 {
		 String toString = "";
		 for(int x = 0; x < numItems; x++)
		 {
			 toString += items[(front + x) % items.length].toString() + "\n";
		 }
		 return toString;
	 }
	 protected void resize()
	 {
	 	
		T []temp = (T[])new Object[items.length*2];
	 	for(int x = 0; x < numItems; x++)
	 	{
	 		temp [x] = items[(front + x) % items.length];
	 	}
	 	front = 0;
	 	rear = numItems;
	 	items = temp;
	 }


}
