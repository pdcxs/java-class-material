import java.util.*;

public class IteratorDemo {
    public static void main(String[] args) {
        List<Integer> al = new ArrayList<>();
        for (int i = 1; i < 5; i++)
            al.add(i);
        System.out.println("Elements: " + al);
        ListIterator<Integer> listIter = al.listIterator();
        listIter.add(0);
        System.out.println("List after adding element: " + al);
        if (listIter.hasNext()) {
            // int i = listIter.nextIndex();
            listIter.next();
            listIter.set(9);
            System.out.println("List after being modified: " + al);
        }
        listIter = al.listIterator(al.size());
        System.out.print("Reverse iterator: ");
        while (listIter.hasPrevious())
            System.out.print(listIter.previous() + "  ");
    }
}
