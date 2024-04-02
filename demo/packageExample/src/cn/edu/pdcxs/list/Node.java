package cn.edu.pdcxs.list;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }

    @Override
    public String toString() {
        if (next == null) {
            return data + "";
        }
        return data + ", " + next.toString();
    }
}
