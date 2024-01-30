package treemachine.exp;

import treemachine.env.*;

public interface TreeNode {
    boolean isList();
    TreeNode eval(Environment env);
}