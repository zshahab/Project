/*
 * Purpose: Data Structure and Algorithms Lab 4 Pre-Lab
 * Status: All methods were tested
 * Last update: 09/25/18
 * Submitted:  09/26/18
 * Comment: Editted version of node from Lab 3
 * @author: Angela Gaudio
 * @version: 2018.09.25
 */

public class DNode
{
    private Object item;
    private DNode next;
    private DNode back;

    public DNode(Object newItem)
    {
        item = newItem;
        next = this;
	back = this;
    } // end constructor

    public DNode(Object newItem, DNode nextNode, DNode prevNode)
    {
        item = newItem;
        next = nextNode;
	back = prevNode;
    } // end constructor

    public void setItem(Object newItem)
    {
        item = newItem;
    } // end setItem

    public Object getItem()
    {
        return item;
    } // end getItem

    public void setNext(DNode nextNode)
    {
        next = nextNode;
    } // end setNext

    public DNode getNext()
    {
        return next;
    } // end getNext

    public void setPrev(DNode prevNode)
    {
	back = prevNode;
    }//end setPrev

    public DNode getPrev()
    {
	return back;
    }//end getPrev
} // end class Node

