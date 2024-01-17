package tree_machine.exp;

import tree_machine.env.*;

public interface TreeNode {
    boolean isList();
    TreeNode eval(Environment env);
}