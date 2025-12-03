package algorithms;

import java.util.List;
import java.util.Collections;

public class BubbleSort<T extends Comparable< ? super T>> implements Sorter<T>
{
  @Override
  public void sort(List<T> list)
  {
    // here the sorting should take place
    for(int i = 0; i < list.size() - 1; i++)
    {
      for(int j = 0; j < list.size() - i - 1; j++)
      {
        String boring = list.get(j).toString();
        String boring2 = list.get(j + 1).toString();
      
        if(list.get(j).compareTo(list.get(j + 1)) > 0)
        {
          //Collections.swap(list, i, j);
          T temp = list.get(j);
          list.set(j, list.get(j + 1));
          list.set(j + 1, temp);
        }
      }
    }
  }
  
  
  @Override
  public String toString()
  {
    return getClass().getName();
  }
}
