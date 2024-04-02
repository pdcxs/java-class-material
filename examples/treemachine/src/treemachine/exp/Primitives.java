package treemachine.exp;

import treemachine.env.*;
import static treemachine.exp.Leaf.*;
import static treemachine.util.List.*;

public class Primitives {
    public static class NIL extends Leaf<Boolean> {
        NIL() {
            super(false);
        }

        @Override
        public boolean isList() {
            return true;
        }
    }

    public static NIL NIL = new NIL();

    public static class Plus implements Function {
        private TreeNode list;

        @Override
        public boolean isList() {
            return true;
        }

        Plus(TreeNode list) {
            assert isConsList(list);
            this.list = list;
        }

        Plus() {
            list = NIL;
        }

        @Override
        public void apply(TreeNode list) {
            assert isConsList(list);
            this.list = list;
        }

        @Override
        public TreeNode eval(Environment env) {
            return this;
        }

        @Override
        @SuppressWarnings("unchecked")
        public Leaf<Double> compute(Environment env) {
            if (list == NIL) {
                return new Leaf<Double>(0.0);
            }
            Leaf<Double> left = (Leaf<Double>) ((Node) list).left.eval(env);
            Leaf<Double> right = (new Plus(((Node) list).right)).compute(env);
            return NUM(left.value + right.value);
        }

        @Override
        public String toString() {
            return Node.CONS(STR("+"), list).toString();
        }
    }

    public static Plus PLUS(TreeNode args) {
        assert isConsList(args);
        return new Plus(args);
    }

    public static class Minus implements Function {
        private TreeNode list;

        @Override
        public boolean isList() {
            return true;
        }

        Minus(TreeNode list) {
            assert isConsList(list);
            this.list = list;
        }

        Minus() {
            list = NIL;
        }

        @Override
        public void apply(TreeNode list) {
            assert isConsList(list);
            this.list = list;
        }

        @Override
        public TreeNode eval(Environment env) {
            return this;
        }

        @Override
        @SuppressWarnings("unchecked")
        public Leaf<Double> compute(Environment env) {
            if (list == NIL) {
                return new Leaf<Double>(0.0);
            }
            Leaf<Double> left = (Leaf) ((Node) list).left.eval(env);
            Leaf<Double> right = (new Plus(((Node) list).right)).compute(env);
            return NUM(left.value - right.value);
        }

        @Override
        public String toString() {
            return Node.CONS(STR("-"), list).toString();
        }
    }

    public static Minus MINUS(TreeNode args) {
        assert isConsList(args);
        return new Minus(args);
    }

    public static class If implements TreeNode {
        private TreeNode condition;
        private TreeNode left;
        private TreeNode right;

        @Override
        public boolean isList() {
            return true; // compound statement
        }

        If(TreeNode condition, TreeNode left, TreeNode right) {
            this.condition = condition;
            this.left = left;
            this.right = right;
        }

        @Override
        @SuppressWarnings("unchecked")
        public TreeNode eval(Environment env) {
            boolean predict = ((Leaf<Boolean>) (condition.eval(env))).value;
            if (predict) {
                return left.eval(env);
            }
            return right.eval(env);
        }

        @Override
        public String toString() {
            return "(if " + condition + " " + left + " " + right + ")";
        }
    }

    public static If IF(TreeNode condition, TreeNode left, TreeNode right) {
        return new If(condition, left, right);
    }

    public static class Sequence implements TreeNode {
        private TreeNode list;

        @Override
        public boolean isList() {
            return true;
        }

        Sequence() {
            list = NIL;
        }

        Sequence(TreeNode cmds) {
            assert isConsList(cmds);
            list = cmds;
        }

        public TreeNode eval(Environment env) {
            if (list == NIL) {
                System.err.println("Body of sequence need at least one statement.");
                System.exit(1);
            }
            Node node = (Node) list;
            if (node.right == NIL) {
                return node.left.eval(env);
            }
            node.left.eval(env);
            return (new Sequence(node.right)).eval(env);
        }

        @Override
        public String toString() {
            assert list != NIL;
            assert list instanceof Node;
            return "(begin " + ((Node) list).contents() + ")";
        }
    }

    public static Sequence SEQ(TreeNode list) {
        return new Sequence(list);
    }

    public static class Define implements TreeNode {
        private String id;
        private TreeNode value;

        Define(String id, TreeNode value) {
            this.id = id;
            this.value = value;
        }

        @Override
        public boolean isList() {
            return true;
        }

        @Override
        public TreeNode eval(Environment env) {
            env.currentFrame().insert(id, value.eval(env));
            return new Leaf<Ret>(Ret.Ok);
        }

        @Override
        public String toString() {
            return "(define " + id + " " + value + ")";
        }
    }

    public static enum Ret {
        Ok, Err
    };

    public static Define DEF(String id, TreeNode value) {
        return new Define(id, value);
    }

    public static class Lambda implements Function {
        private TreeNode vars;
        private TreeNode body;
        private TreeNode args;

        public Lambda(TreeNode vars, TreeNode body) {
            assert isConsList(args);
            assert body != NIL;
            assert isConsList(body);

            this.vars = vars;
            this.body = body;
        }

        @Override
        public boolean isList() {
            return true;
        }

        @Override
        public void apply(TreeNode args) {
            this.args = args;
        }

        @Override
        public TreeNode eval(Environment env) {
            return this;
        }

        @Override
        public TreeNode compute(Environment env) {
            if (vars == NIL) {
                return body.eval(env);
            }
            env.extend(new Frame(vars, ((Node) args).evalEach(env)));
            TreeNode result = SEQ(body).eval(env);
            env.pop();
            return result;
        }

        @Override
        public String toString() {
            return "(lambda " + vars + " " + ((Node) body).contents() + ")";
        }
    }

    static public Lambda FUN(TreeNode vars, TreeNode... body) {
        return new Lambda(vars, LST(body));
    }

    static public class Less implements Function {
        private TreeNode vars;
        Less() {
            vars = NIL;
        }
        Less(TreeNode args) {
            vars = args;
        }
        @Override
        public boolean isList() {
            return true;
        }
        @Override
        public void apply(TreeNode args) {
            assert isConsList(args);
            vars = args;
        }
        @Override
        public TreeNode eval(Environment env) {
            return this;
        }
        @Override
        @SuppressWarnings("rawtypes")
        public TreeNode compute(Environment env) {
            Node args = (Node) vars;
            TreeNode left = args.left.eval(env);
            TreeNode right = ((Node) args.right).left.eval(env);
            assert left instanceof Leaf;
            assert right instanceof Leaf;

            return BOOL((Double)((Leaf)left).value < (Double)((Leaf)right).value);
        }

        @Override
        public String toString() {
            return "(<)";
        }
    }

    static public Less LESS(TreeNode args) {
        return new Less(args);
    }

    static public class Print implements TreeNode {
        private final TreeNode arg;
        @Override
        public boolean isList() {
            return true;
        }

        Print(TreeNode arg) {
            this.arg = arg;
        }

        @Override
        public TreeNode eval(Environment env) {
            System.out.println(arg.eval(env));
            return new Leaf<Ret>(Ret.Ok);
        }

        @Override
        public String toString() {
            return "(displayln " + arg + ")";
        }
    }

    public static Print PRINT(TreeNode arg) {
        return new Print(arg);
    }
}
