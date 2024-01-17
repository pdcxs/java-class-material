package tree_machine.env;

import tree_machine.exp.*;
import java.util.Stack;
import static tree_machine.exp.Primitives.*;
import static tree_machine.exp.Leaf.*;

public class Environment {
    private Stack<Frame> env;
    private Frame global;

    public Environment() {
        // global frame
        global = new Frame();
        global.insert("+", PLUS(NIL));
        global.insert("-", MINUS(NIL));
        global.insert("<", LESS(NIL));
        global.insert("pi", NUM(Math.PI));

        env = new Stack<>();
        env.push(global);
    }

    public TreeNode lookup(String id) {
        for (int i = env.size() - 1; i >= 0; i--) {
            Frame frame = env.get(i);
            if (frame.has(id)) {
                return frame.get(id);
            }
        }
        System.err.println("Variable " + id + " is not binded!");
        return null;
    }

    public Frame currentFrame() {
        return env.peek();
    }

    public Frame extend(Frame f) {
        env.push(f);
        return f;
    }

    public Frame pop() {
        return env.pop();
    }

    @Override
    public String toString() {
        return env.toString();
    }
}
