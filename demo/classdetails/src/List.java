class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class List {
    private Node head;

    public List() {
        // empty list
        head = null;
    }

    public List(int[] arr) {
        if (arr.length == 0) {
            head = null;
        } else {
            head = new Node(arr[0]);
            Node prev = head;
            Node next = null;
            for (int i = 1; i < arr.length; i++) {
                next = new Node(arr[i]);
                prev.next = next;
                prev = next;
            }
        }
    }

    public List(int data) {
        this(new int[]{data});
    }

    private List(int data, List another) {
        this(data);
        head.next = another.head;
    }

    public static List cons(int data, List another) {
        return new List(data, another);
    }

    public int length() {
        int len = 0;
        Node n = head;
        while (n != null) {
            n = n.next;
            len++;
        }
        return len;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        Node n = head;
        while (n != null) {
            sb.append(n.data);
            if (n.next != null) {
                sb.append(", ");
            }
            n = n.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public List prepend(int data) {
        Node n = new Node(data);
        n.next = head;
        head = n;
        return this;
    }

    public static void main(String[] args) {
        List lst = new List();
        System.out.println(lst);
        System.out.println(lst.length());

        lst = new List(new int[]{1, 2, 3, 4});
        System.out.println(lst);
        System.out.println(lst.length());

        List lst2 = List.cons(0, lst);
        System.out.println(lst2);
        System.out.println(lst2.length());
    }
}