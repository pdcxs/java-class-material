package tree_machine.utils;

import static tree_machine.exp.Primitives.*;
import tree_machine.exp.Node;
import tree_machine.exp.TreeNode;

public class List {
    public static TreeNode LST(TreeNode... nodes) {
        return createList(nodes, 0);
    }

    private static TreeNode createList(TreeNode[] nodes, int index) {
        if (index == nodes.length) {
            return NIL;
        }
        return Node.CONS(nodes[index],
                createList(nodes, index + 1));
    }

    public static boolean isConsList(TreeNode node) {
        if (node == NIL) {
            return true;
        }
        if (node instanceof Node) {
            return ((Node) node).isList();
        }
        return false;
    }

    public static TreeNode BEGIN(TreeNode... nodes) {
        return SEQ(LST(nodes));
    }
}
