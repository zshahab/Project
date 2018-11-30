/*
*This class will contain a reference to the Customer within the Shopping Center it will have: String uniqueName and int amountInCart
*Authors: Angela Gaudio
*Version: 11/30/2018
*/


public class Customer
{
    String uniqueName;
    int itemsInCart;
  
    class Customer()
    {
        uniqueName = null;
        itemsInCart = 0;
    }
  
    class Customer(String name)
    {
        uniqueName = name;
        itemsInCart = 0;
    }
}
