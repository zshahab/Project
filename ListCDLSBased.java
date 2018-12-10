/*
 * Purpose: Data Structure and Algorithms Lab 4 Problem 1
 * Status: All methods were tested
 * Last update: 09/26/18
 * Submitted:  10/02/18
 * Comment: test suite
 * @author: Angela Gaudio
 * @version: 2018.09.26
 */

public class ListCDLSBased implements ListInterface
{
    // reference to linked list of items
    protected DNode tail;
    int numItems;

    public ListCDLSBased()
    {
        tail = null;
	numItems = 0;
    }  // end default constructor

    public boolean isEmpty()
    {
        boolean empty = false;
        if(tail.getNext() == null)
            empty = true;

        return empty;
    }  // end isEmpty

    public int size()
    {
        return numItems;
    }

    protected DNode find(int index)
    {
        // --------------------------------------------------
        // Locates a specified node in a linked list.
        // Precondition: index is the number of the desired
        // node. Assumes that 0 <= index <= numItems
        // Postcondition: Returns a reference to the desired
        // node.
        // --------------------------------------------------
        DNode curr = tail.getNext();
	/*
	for (int skip = 0; skip < index; skip++)
        {
            curr = curr.getNext();
        } // end for
        return curr;
	*/
	int size = size();
	if(index <= size/2)
	{
        	for (int skip = 0; skip < index; skip++)
        	{
            		curr = curr.getNext();
        	}// end for
	}
	else
	{
		for(int skip = size; skip > index; skip--)
		{
			curr = curr.getPrev();
		}//end for
	}
        return curr;
    } // end find

    public Object get(int index)
    throws ListIndexOutOfBoundsException
    {
	int size = size();
        if (index >= 0 && index < size)
        {
            // get reference to node, then data in node
            DNode curr = find(index);
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
	int size = size();
        if (index >= 0 && index < size + 1)
        {
           if(index == 0)
            {
                // insert the new node containing item at
                // beginning of the list
		if(size == 0)
		{
                	DNode newNode = new DNode(item);
			tail = newNode;
		}
		else
		{
		    DNode newNode = new DNode(item, tail.getNext(), tail);
                    tail.setNext(newNode);
		    newNode.getNext().setPrev(newNode);
		}
            }
            else
	    {
		    DNode prev = find(index-1);
		    DNode curr = prev.getNext();
                    // insert the newMyListReferenceBased( node containing item after
                    // the node that prev reference
                    DNode newNode = new DNode(item, curr, prev);
                    prev.setNext(newNode);
		    curr.setPrev(newNode);
		    if(index == size)
		    	tail = newNode;
            } // end if
	    numItems++;
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
	int size = size();
        if (index >= 0 && index < size)
        {
            if (index == 0 && size == 1)
            {
                // delete the first node from the list
                tail = null;
            }
            else
            {
		if(index == 0)
		{
			DNode curr = tail.getNext();
			DNode next = curr.getNext();
			tail.setNext(next);
			next.setPrev(tail);
		}
		else
		{
			DNode prev = find(index-1);
                	// delete the node after the node that prev
                	// references, save reference to node
                	DNode curr = prev.getNext();
			DNode next = curr.getNext();
                	prev.setNext(next);
			next.setPrev(prev);
			if(index == size-1)
				tail = prev;
		}
            } // end if
	    numItems--;
        } // end if
        else
        {
            throw new ListIndexOutOfBoundsException(
                "List index out of bounds exception on remove");
        } // end if
    }   // end remove

    public void removeAll()
    {
        // setting head to null causes list to be
        // unreachable and thus marked for garbage
        // collection
        tail = null;
	numItems = 0;
	System.out.println("Your list has been cleared");
    } // end removeAll

    public String toString()
    {
	String arr = "";
        for(int i = 0; i < size(); i++)
        {
            arr += (String)get(i);
        }
        return arr;
    }

} // end ListReferenceBased

