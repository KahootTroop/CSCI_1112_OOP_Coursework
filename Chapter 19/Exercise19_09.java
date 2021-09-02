import java.util.*;

public class Exercise19_09 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(14);
    list.add(24);
    list.add(4);
    list.add(42);
    list.add(5);
    Exercise19_09.<Integer>sort(list);
    
    System.out.print(list);
  }
  public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
    E holdings;
    for(int i = 0; i < list.size(); i++) {
      for(int j = i + 1; j < list.size(); j++) {
        if(list.get(i).compareTo(list.get(j)) > 0) {
          holdings = list.get(j);
          list.set(j, list.get(i));
          list.set(i, holdings);
        }
      }
    }
  }
}
