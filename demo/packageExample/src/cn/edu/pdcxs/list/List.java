package cn.edu.pdcxs.list;

public class List {
    private Node head;

    public List() {
        head = null;
    }

    public List(int d) {
        head = new Node(d);
    }

    public List(int[] arr) {
        if (arr.length == 0) {
            head = null;
            return;
        }
        head = new Node(arr[0]);
        Node cur = head;
        for (int i = 1; i < arr.length; i++) {
            Node nextNode = new Node(arr[i]);
            cur.next = nextNode;
            cur = nextNode;
        }
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }
        return "[" + head + "]";
    }
}
