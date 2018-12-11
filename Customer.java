
public class Customer
{
    String uniqueName;
    int itemsInCart;
    int timeEntered;
  
    public Customer()
    {
        uniqueName = null;
        itemsInCart = 0;
    }
  
    public Customer(String name, int timeEntered)
    {
        uniqueName = name;
        itemsInCart = 0;
        this.timeEntered = timeEntered;
    }
    
    public void resetTime(int timeEntered)
    {
    	this.timeEntered = timeEntered;
    }
    public String getName()
    {
        return uniqueName;
    }
    
    public int getAmountInCart()
    {
        return itemsInCart;
    }
    
    public void addItemToCart()
    {
        itemsInCart++;
    }
    
    public void removeItemFromCart()
    {
        itemsInCart--;
    }
    
    public int getTimeInStore()
    {
        return timeEntered;
    }
    
    public String toString()
    {
        return "Customer " + uniqueName + " with " + itemsInCart + " items";
    }
}