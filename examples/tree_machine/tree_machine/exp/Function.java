package tree_machine.exp;

import tree_machine.env.Environment;

public interface Function extends TreeNode {
    public void apply(TreeNode args);
    public TreeNode compute(Environment env);
}
