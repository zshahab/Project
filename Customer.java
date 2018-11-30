/*
*This class will contain a reference to the Customer within the Shopping Center it will have: String uniqueName, int timeEntered and int amountInCart
*Authors: Angela Gaudio
*Version: 11/30/2018
*/


public class Customer
{
    String uniqueName;
    int itemsInCart;
    int timeEntered;
  
    class Customer()
    {
        uniqueName = null;
        itemsInCart = 0;
    }
  
    class Customer(String name, int timeEntered)
    {
        uniqueName = name;
        itemsInCart = 0;
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
        return "Customer " + uniqueName + " with " + itemInCart + " items";
    }
}
