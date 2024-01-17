import tree_machine.exp.*;
import static tree_machine.exp.Leaf.*;
import static tree_machine.exp.Primitives.*;
import static tree_machine.utils.List.*;

import tree_machine.env.Environment;

import static tree_machine.exp.Node.CONS;

public class Test {
    static public void main(String[] args) {
        Environment env = new Environment();
        TreeNode list = LST(
            NUM(1.),
            STR("Hello"),
                LST(
                    BOOL(false),
                    NUM(2.)));
        TreeNode cons = CONS(NUM(3), BOOL(true));
        System.out.println(list);
        System.out.println(cons);

        list = CONS(NUM(1), CONS(NUM(2), CONS(VAR("pi"), NIL)));
        Plus plus = PLUS(list);
        System.out.println(plus);
        System.out.println(plus.eval(env));

        TreeNode apply = CONS(VAR("+"), list);
        System.out.println(apply.eval(env));

        // should be zero.
        System.out.println(CONS(VAR("+"), NIL).eval(env));

        System.out.println(IF((LST(VAR("<"), NUM(1), NUM(2))),
            NUM(1.), NUM(2.)).eval(env));

        // Sequence and Define
        TreeNode seq = BEGIN(DEF("x", NUM(1)), VAR("x"));
        System.out.println(seq.eval(env));

        // Function Test
        TreeNode defFunc = BEGIN(
            DEF("add",
                FUN(LST(VAR("x"), VAR("y")), 
                    LST(VAR("+"), VAR("x"), VAR("y")))),
            LST(VAR("add"), NUM(3), NUM(4)));

        System.out.println(defFunc);
        System.out.println(defFunc.eval(env));

        // Fibonacci
        DEF("fib",
            FUN(LST(VAR("n")),
                IF(LST(VAR("<"), VAR("n"), NUM(2)),
                   VAR("n"),
                   LST(VAR("+"),
                       LST(VAR("fib"), LST(VAR("-"), VAR("n"), NUM(1))),
                       LST(VAR("fib"), LST(VAR("-"), VAR("n"), NUM(2))))))).eval(env);
        System.out.println(env);
        System.out.println(LST(VAR("fib"), NUM(10)).eval(env));
    }
}
