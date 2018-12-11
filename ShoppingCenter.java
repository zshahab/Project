
public class ShoppingCenter {

private ListArrayBasedPlus<Customer> customers;
private ListArrayBasedPlus<Item> Items;
private int restocking;
private int elapsedTime = 0;


public ShoppingCenter(int restocking)
{
	Items = new ListArrayBasedPlus<Item>();
	this.restocking = restocking;
	customers = new ListArrayBasedPlus<Customer>();
}

public void addCustomer(String addition)
{
	customers.add(customers.size(), new Customer(addition, elapsedTime));;
}
public void addCustomer(Customer customer)
{
	customer.resetTime(elapsedTime);
	customers.add(customers.size(), customer);
}

public int getCustomersSize()
{
	return customers.size();
}
public Customer findCustomer(String name)
{
	boolean found = false;
	Customer thing = null;
	int index = 0;
	while((!found) && index < customers.size())
	{
		Customer temp = (Customer) customers.get(index);
		if(temp.getName().equalsIgnoreCase(name))
		{
			thing = temp;
			found = true;
		}
		else {
		index++;
		}
	}
	return thing;
	
}

public Customer dequeue()
{
	Customer temp = (Customer) customers.get(0);
	customers.remove(0);
	temp.resetTime(elapsedTime - temp.getTimeInStore());
	return temp;
}
public void printBelowRestock()
{
	System.out.println("Items at re-stocking level:");
	for(int i = 0; i < Items.size(); i++)
	{
		Item temp = (Item) Items.get(i);
		if(temp.getStock() <= restocking)
		{
			System.out.println(temp.toString());
		}
	}
}

public void printCustomers()
{
	if(customers.size() != 0)
	{
	int max = customers.size();
	System.out.println("The following " + max + " customers are in the shopping center:");
	for(int i = 0; i < max; i++)
	{
		Customer temp =(Customer) customers.get(i);
		System.out.println("Customer " + temp.getName() + " with " + temp.getAmountInCart() + " present for " + (elapsedTime - temp.getTimeInStore()) + " minutes");
	}
	}
	else
	{
		System.out.println("No customers are in the Shopping Center!");
	}
}
public Item findItem(String name)
{
	boolean found = false;
	Item thing = null;
	int index = 0;
	while((!found) && index < Items.size())
	{
		Item temp = (Item) Items.get(index);
		if(temp.getName().equalsIgnoreCase(name))
		{
			thing = temp;
			found = true;
		}
		index++;
	}
	return thing;
}

public void addItem(int index, String name, int amount)
{
	Item temp = new Item(name, amount);
	Items.add(index, temp);
}

public void RestockItem(int index, int amount)
{
		Item temp = (Item) Items.get(index);
		System.out.println("Stock has now " + temp.setStock(amount) + " " + temp.getName() + "s.");
}

public void incrementTime()
{
	elapsedTime++;
}


	


}
