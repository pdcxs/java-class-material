import tree_machine.Machine;
import static tree_machine.exp.Primitives.*;
import static tree_machine.utils.List.*;
import static tree_machine.exp.Leaf.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("========== Program 1 ===========");
        var program = BEGIN(
            DEF("fib", FUN(LST(VAR("n")),
                IF(LST(VAR("<"), VAR("n"), NUM(2)),
                   VAR("n"),
                   LST(VAR("+"),
                       LST(VAR("fib"), LST(VAR("-"), VAR("n"), NUM(1))),
                       LST(VAR("fib"), LST(VAR("-"), VAR("n"), NUM(2))))))),
            PRINT(LST(VAR("fib"), NUM(20)))
        );
        

        System.out.println(program);

        Machine machine = new Machine(program);
        machine.run();

        System.out.println("========== Program 2 ===========");
        program = BEGIN(
            DEF("x", NUM(1)),
            DEF("f", FUN(LST(VAR("x")),
                PRINT(VAR("x")))),
            LST(VAR("f"), NUM(2)),
            PRINT(VAR("x"))
        );
        System.out.println(program);
        machine = new Machine(program);
        machine.run();
    }
}
