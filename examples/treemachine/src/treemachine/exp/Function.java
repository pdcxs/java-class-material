package treemachine.exp;

import treemachine.env.Environment;

public interface Function extends TreeNode {
    public void apply(TreeNode args);
    public TreeNode compute(Environment env);
}
