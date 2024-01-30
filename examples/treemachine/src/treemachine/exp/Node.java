package treemachine.exp;

import treemachine.env.Environment;
import static treemachine.exp.Primitives.NIL;
import static treemachine.util.List.isConsList;

public class Node implements TreeNode {
    public TreeNode left;
    public TreeNode right;

    Node(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }

    public boolean isList() {
        return right == Primitives.NIL || right.isList();
    }

    public TreeNode eval(Environment env) {
        if (isConsList(this)) {
            Node evaluatedList = (Node)evalEach(env);

            assert evaluatedList.left instanceof Function;

            Function func = (Function)evaluatedList.left;
            TreeNode args = evaluatedList.right;

            func.apply(args);
            return func.compute(env);
        }
        return new Node(left.eval(env), right.eval(env));
    }

    public TreeNode evalEach(Environment env) {
        if (right == NIL) {
            return CONS(left.eval(env), NIL);
        }
        return CONS(left.eval(env),
                ((Node) right).evalEach(env));
    }

    @Override
    public String toString() {
        if (isList()) {
            return "(" + contents() + ")";
        }
        return "(" + left + " . " + right + ")";
    }

    String contents() {
        if (this == (TreeNode) Primitives.NIL) {
            return "";
        }
        String result = left.toString();
        if (right == Primitives.NIL) {
            return result;
        } else {
            result += " ";
            result += ((Node) right).contents();
        }
        return result;
    }

    public static Node CONS(TreeNode left, TreeNode right) {
        return new Node(left, right);
    }
}
