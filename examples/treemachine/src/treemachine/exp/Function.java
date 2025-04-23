package treemachine.exp;

import treemachine.env.Environment;

public interface Function extends TreeNode {
  void apply(TreeNode args);

  TreeNode compute(Environment env);
}
