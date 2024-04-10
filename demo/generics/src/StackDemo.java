import java.util.*;

public class StackDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringStack stack = new StringStack();
        System.out.println("Please input strings: (end with quit)");
        while (true) {
            String input = sc.next();
            if (input.equals("quit"))
                break;
            stack.push(input);
        }
        sc.close();
        System.out.print("LIFO Order: ");
        while (!stack.isEmpty())
            System.out.print(stack.pop() + "  ");
    }
}

class StringStack {
    private LinkedList<String> ld = new LinkedList<>();

    public void push(String name) {
        ld.addFirst(name);
    }

    public String pop() {
        return ld.removeFirst();
    }

    public boolean isEmpty() {
        return ld.isEmpty();
    }
}
