package tree_machine.exp;

import tree_machine.env.*;

public class Leaf<T> implements TreeNode {
    public boolean isList() {
        return false;
    }

    public boolean selfEvaluating = true;
    public T value;

    Leaf(T v) {
        value = v;
    }

    public TreeNode eval(Environment env) {
        if (isSymbol()) {
            return env.lookup((String)value);
        }
        return this;
    }

    public static Leaf<String> STR(String s) {
        return new Leaf<String>(s);
    }

    public static Leaf<Boolean> BOOL(boolean b) {
        return new Leaf<Boolean>(b);
    }

    public static Leaf<Double> NUM(double v) {
        return new Leaf<Double>(v);
    }

    public static Leaf<String> VAR(String id) {
        Leaf<String> variable = new Leaf<>(id);
        variable.selfEvaluating = false;
        return variable;
    }

    public boolean isSymbol() {
        return value instanceof String && !selfEvaluating;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
