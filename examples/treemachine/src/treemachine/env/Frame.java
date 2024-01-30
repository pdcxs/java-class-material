package treemachine.env;

import treemachine.exp.*;
import static treemachine.exp.Primitives.*;
import static treemachine.util.List.isConsList;

import java.util.Hashtable;

public class Frame {
    private Hashtable<String, TreeNode> hash;

    public Frame(String[] id, TreeNode[] value) {
        hash = new Hashtable<>();
        for (int i = 0; i < id.length; i++) {
            hash.put(id[i], value[i]);
        }
    }

    public Frame() {
        hash = new Hashtable<>();
    }

    public Frame(TreeNode id, TreeNode value) {
        hash = new Hashtable<>();
        addToFrame(id, value);
    }

    @SuppressWarnings("rawtypes")
    private void addToFrame(TreeNode id, TreeNode value) {
        assert isConsList(id);
        assert isConsList(value);

        if (id == NIL) {
            return;
        }

        assert value != NIL;

        Node n = (Node) id;
        Node v = (Node) value;

        assert n.left instanceof Leaf;
        assert ((Leaf)n.left).value instanceof String;
        hash.put((String)((Leaf)n.left).value, v.left);
        addToFrame(n.right, v.right);
    }

    public Frame insert(String id, TreeNode value) {
        hash.put(id, value);
        return this;
    }

    public boolean has(String id) {
        return hash.containsKey(id);
    }

    public TreeNode get(String id) {
        return hash.get(id);
    }

    @Override
    public String toString() {
        return hash.toString();
    }
}
