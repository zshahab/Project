


public class ListArrayBasedPlus<T> extends ListArrayBased {

public ListArrayBasedPlus()
{
	
}
public void add(int index, Object item)
{
	if(numItems == items.length)
	{
	resize();
	}
	super.add(index, item);
}

private void resize()
{
	
	Object [] temp = (T[]) new Object[items.length*2];
	for(int x = 0; x < super.numItems; x++)
	{
		temp [x] = super.items[x];
	}			
	items = temp;
}

public void reverse()
{
	if(numItems != 0)
	{
	Object [] temp = (T[]) new Object[numItems];
	int highestIndex = numItems - 1;
	for(int x = highestIndex; x >= 0; x--)
	{
		temp[highestIndex -x] = super.items[x];
	}
	items = temp;
	System.out.println("List reversed");
	}
	else
	{
		System.out.println("Nothing in list.");
	}
	
}
public String toString()
{
	String info = "";
	for(int x = 0; x < numItems; x++)
	{
		info += items [x] + " ";
	}
	return info; 
	
}

}
