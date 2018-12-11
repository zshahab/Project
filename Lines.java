
public class Lines {
    private Queue<Customer> express;
    private Queue<Customer> regular1;
    private Queue<Customer> regular2;
    private int currLine;
    
    public Lines()
    {
        express = new Queue<Customer>();
        regular1 = new Queue<Customer>();
        regular2 = new Queue<Customer>();
        currLine = 0; 
    }
	
    public String addCustomer(Customer addition)
	{
    	String x  = " After " + addition.getTimeInStore() + " minutes in the Shopping Center " + addition.getName() + " is now in ";
		if(addition.getAmountInCart() <= 4)
		{
			if((express.getSize() >= (regular1.getSize() *2)) || ((express.getSize() >= (regular2.getSize() *2))))
			{
			    if(regular1.getSize() > regular2.getSize()) {
			        regular2.enqueue(addition);
			        x += " second checkout lane";
			    } else {
				    regular1.enqueue(addition);
				    x += " first checkout lane";
			    }
			}

			else
			{
				express.enqueue(addition);
				x += " express checkout lane";
			}
		}
		else
		{
			if(regular1.getSize() > regular2.getSize()) {
			       regular2.enqueue(addition);
			       x += " second checkout lane";
			}
			else 
			{
				regular1.enqueue(addition);
				x += " first checkout lane";
			}
		}
		return x;
	}

	
public void setLine(String x)
{
	switch(x)
	{
		case "express":
			currLine = 0;
			break;
		case "regular1":
			currLine = 1;
			break;
		case "regular2":
			currLine = 2;
			break;
		
	}
	
}

public Customer deleteCustomer() {
    //Need to go through all of our lines and check out if anyone is there
	Customer done = null;
	int temp = currLine++;
	
	for(int i = 0; i < 3; i++)
	{
		switch(temp)
		{
			case 0:
			if(!(express.isEmpty()))
			{
				temp++;
				 return express.dequeue();
			}
			break;
			case 1:
			if(!(regular1.isEmpty()))
			{
				temp++;
				return regular1.dequeue();
			}
			break;
			case 2:
			if(!(regular2.isEmpty()))
			{
				temp = 0;
				return regular2.dequeue();
			}
			break;			
		}
	}
		return done;
}


public void printCustomers()
{
	if(regular1.isEmpty())
	{
		System.out.println("No customers are in the first checkout line!");
	}
	else
	{
		if(regular1.getSize() >= 2)
		{
			System.out.println("The following customers are in the first regular line:");
		}
		else
		{
			System.out.println("The following customer is in the first regular line:");
		}
		System.out.println(regular1.toString());
	}
	if(regular2.isEmpty())
	{
		System.out.println("No customers are in the second checkout line!");
	}
	else
	{
		if(regular2.getSize() >= 2)
		{
			System.out.println("The following customers are in the second regular line:");
		}
		else
		{
			System.out.println("The following customer is in the second regular line:");
		}
		System.out.println(regular2.toString());
	}
	if(express.isEmpty())
	{
		System.out.println("No customers are in the express checkout line!");
	}
	else
	{
		if(express.getSize() >= 2)
		{
			System.out.println("The folloqing customers are in the express line:");
		}
		else
		{
			System.out.println("The folloqing customer is in the express line:");
		}
		System.out.println(express.toString());
	}
	
}
}
	
                    