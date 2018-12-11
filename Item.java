/*
*This class will hold references to items that are in the store and will contain two parameters: int stock and String name
*Authors: Angela Gaudio
*Version: 11/30/2018
*/

public class Item
{
      private String itemName;
      private int stock;
      public Item()
      {
          itemName = null;
          stock = 0;
      }
      
      public Item(String name, int num)
      {
          itemName = name;
          stock = num;
      }
      
      
      public String getName()
      {
          return itemName;
      }
      
      public int getStock()
      {
          return stock;
      }
      
      public int setStock(int newAmount)
      {
          stock = stock + newAmount;
          return stock;
      }
      
      public String toString()
      {
          return itemName + " with " + stock + " items.";
      }
}