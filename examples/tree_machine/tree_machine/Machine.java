package tree_machine;

import tree_machine.env.*;
import tree_machine.exp.*;

public class Machine {
    TreeNode program;
    Environment env;
    public Machine(TreeNode program) {
        env = new Environment();
        this.program = program;
    }

    public void run() {
        program.eval(env);
    }
}
