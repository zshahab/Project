

//Please note that this code is slightly different from the textbook code 
//to reflect the fact that the Node class is implemented using data encapsulation


//****************************************************
//Reference-based implementation of ADT list.
//****************************************************
public class ListReferenceBased implements ListInterface 
{
// reference to linked list of items9ht5
private Node head;  // number of items in list

public ListReferenceBased() 
{
 head = null;
}  // end default constructor

public boolean isEmpty() 
{
	return head == null;
}  // end isEmpty

public int size() 
{
	Node temp = head;
	int size = 0;
	while(temp != null)
	{
		temp = temp.getNext();
		size++;
	}
	return size;

}// end size

public void deleteLargest()
{
	if(isEmpty())
	{
		System.out.println("List is empty, nothing to delete!");
	}
	else
	{
	Node temp = head;
	String largestString = head.getItem().toString();
	int largest = 0;
	int pos = 0;
	while(temp != null)
	{
		if(largestString.compareTo(temp.getItem().toString())==-1)
		{
			largestString = temp.getItem().toString();
			largest = pos;
		}
		temp = temp.getNext();
		pos++;
	}
	remove(largest);
	System.out.println();
	}
}

private Node find(int index) 
{
// --------------------------------------------------
// Locates a specified node in a linked list.
// Precondition: index is the number of the desired
// node. Assumes that 0 <= index <= numItems 
// Postcondition: Returns a reference to the desired 
// node.
// --------------------------------------------------
 Node curr = head;
 for (int skip = 0; skip < index; skip++) 
 {
   curr = curr.getNext();
 } // end for
 return curr;
} // end find


public Object get(int index) 
             throws ListIndexOutOfBoundsException 
{
 if (index >= 0 && index < size()) 
 {
   // get reference to node, then data in node
   Node curr = find(index);
   Object dataItem = curr.getItem();
   return dataItem;
 } 
 else 
 {
   throw new ListIndexOutOfBoundsException(
                  "List index out of bounds exception on get");
 } // end if
} // end get

public void add(int index, Object item)
               throws ListIndexOutOfBoundsException 
{
 if (index >= 0 && index <= size()) 
 {
   if (index == 0) 
   {
     // insert the new node containing item at
     // beginning of list
     Node newNode = new Node(item, head);
     head = newNode;
   } 
   else  
   {
     Node prev = find(index-1);
     // insert the new node containing item after 
     // the node that prev references
     Node newNode = new Node(item, prev.getNext());
     prev.setNext(newNode);
   } // end if
 } 
 else 
 {
   throw new ListIndexOutOfBoundsException(
                 "List index out of bounds exception on add");
 } // end if
}  // end add

public void remove(int index) 
                throws ListIndexOutOfBoundsException 
{
 if (index >= 0 && index <= size()) 
 {
   if (index == 0) 
   {
     // delete the first node from the list
     head = head.getNext();
   } 
   else 
   {
     Node prev = find(index-1);
     // delete the node after the node that prev
     // references, save reference to node
     Node curr = prev.getNext(); 
     prev.setNext(curr.getNext());
   } // end if
 } // end if
 else 
 {
   throw new ListIndexOutOfBoundsException(
                "List index out of bounds exception on remove");
 } // end if
}  // end remove

public String toString()
{
	String toString = "";
	Node temp = head;
	while(temp != null)
	{
		toString += (String) temp.getItem() + " ";
		temp = temp.getNext();
		
	}
	return toString;
}

public void removeAll() 
{
 // setting head to null causes list to be
 // unreachable and thus marked for garbage 
 // collection
 head = null;
} // end removeAll

}// end ListReferenceBased

