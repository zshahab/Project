

// ********************************************************
// Interface ListInterface for the ADT list.
// *********************************************************
public interface ListInterface<T> 
{
  boolean isEmpty();
  int size();
  void add(int index, Object item) 
                  throws ListIndexOutOfBoundsException;
  Object get(int index) 
                    throws ListIndexOutOfBoundsException;
  void remove(int index) 
                     throws ListIndexOutOfBoundsException;
  void removeAll();
}  // end ListInterface