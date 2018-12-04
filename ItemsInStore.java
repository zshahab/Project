/*
*
*This class will be using the ListArrayBased ADT to hold several items in the store of the type Item.
*Author: Angela Gaudio
*Version: 11/30/2018
*/

public class ItemsInStore
{
    ListArrayBased<Item> items;
    private int restockAmount;
    public ItemsInStore(int restock)
    {
        restockAmount = restock;
        items = new ListArrayBased<>();
    }
    
    public void addItem(String itemName, int amount)
    {
        items.add(items.size(), new Item(itemName, amount));
    }
    
    public void needsRestocking()
    {
        System.out.println("Items at restocking level: )
        int size = items.size();
        for(int i = 0; i < size; i++)
        {
          if(items.get(i).getAmount.getStock() <= restockAmount)
                System.ou.println(items);
        }   
    }
                           
    public void takeOneItem(String item)
    {
       int size = items.size();
       boolean contin = true;
       for(int i = 0; i < size && contin; i++)
       {
          if((items.get(i).getName()).equals(item))
          {
              contin = false;
              items.get(i).removeOneItem();
          }
         
       }
    }
     
    public void restockItem(String item, int newAmount)
    {
       int size = items.size();
       boolean contin = true;
      for(int i = 0; i < size && contin; i++)
      {
         if((items.get(i).getName()).equals(item))
         {
           contin = false;
           items.get(i).setStock(newAmount);
           System.out.println("Stock now has " + items.get(i).getStock() + item);
         }
      }
    }
}
