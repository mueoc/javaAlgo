package algorithms;

import java.util.Collection;
import java.util.List;

public class MergeSorter<T extends Comparable< ? super T>> implements Sorter<T>
{
  @Override
  public void sort(List<T> list)
  {
    MergeSort(list, 0, list.size() - 1);     
  }

  private void MergeSort(List<T> list, int left, int right)
  {
    if(left < right)
    {    
      int mid = (left + right) / 2;
      MergeSort(list, left, mid);
      MergeSort(list, mid + 1,  right);
      merge(list, left, mid, mid + 1, right);
    }
    // here the sorting should take place
  }
  
  private void merge(List<T> list, int left, int leftMid, int rightMid, int right)
  {
    int i = left;
    int j = rightMid;
    int k = left;
    int sameSize = list.size();
    List<T> temp = new java.util.ArrayList<>(java.util.Collections.nCopies(sameSize, null));

    while(i <= leftMid && j <= right)
    {
      if(list.get(i).compareTo(list.get(j)) <= 0)
      {
        temp.set(k, list.get(i));
        i++;
        k++;
      }
      else
      {
        temp.set(k, list.get(j));
        j++;
        k++;
      }
    }

    while(i <= leftMid)
    {
      temp.set(k, list.get(i));
      i++;
      k++;
    }

    while(j <= right)
    {
      temp.set(k, list.get(j));
      j++;
      k++;
    }

    for(i = left; i <= right; i++)
    {
      String bo = list.get(i).toString();
      String b1 = temp.get(i).toString();
      list.set(i, temp.get(i));
    }
  }

  @Override
  public String toString()
  {
    return getClass().getName();
  }
}
