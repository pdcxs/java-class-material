import java.util.*;

public class HashSetDemo {
    public static void main(String[] args) {
        var hs = new HashSet<String>();
        for (String a : args)
            if (!hs.add(a))
                System.out.println(a + " replicated.");
        System.out.println("Set size: " + hs.size() + ", Elements: ");
        Iterator<String> it = hs.iterator();
        while (it.hasNext())
            System.out.print(it.next() + " ");
    }
}
