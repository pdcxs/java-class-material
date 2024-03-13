public class Node {
    int data = 0;
    Node next = null;

    int length() {
        if (next == null) {
            return 1;
        }
        return 1 + next.length();
    }

    static Node createNode(int data, Node next) {
        Node node = new Node();
        node.data = data;
        node.next = next;
        return node;
    }

    public static void main(String[] args) {
        Node a = Node.createNode(1, null);
        System.out.println(a.length());
    }
}
