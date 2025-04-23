package treemachine;

import treemachine.env.*;
import treemachine.exp.*;

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
