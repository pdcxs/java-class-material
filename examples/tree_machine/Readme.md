# 语法树解释器

本项目展示了如何创建一个通用计算机 `Machine` ，该计算机支持用户创建自己的命令，并在机器上运行。

## 支持的命令

用户可以使用以下命令：

- `NUM`: `NUM(1)` 将会创建一个数字字面常量： `1`。
- `STR`: `STR("hello")` 将会创建一个字符串字面常量： `"hello"`。
- `BOOL`： `BOOL(true)` 将会创建一个字符串字面常量： `true`。
- `VAR`： `VAR("id")` 将会创建一个名为 `id` 的变量（或者可以称为符号）。
- `CONS`： `CONS(x, y)` 将会创建一个二元 tuple ： `(x . y)`。
- `IF`： `IF(cond, left, right)` 是一个三元运算符，如果 `cond` 为真，则返回 `left`，否则返回 `right`。
- `NIL`： 代表空值或者链表的结尾。
- `LST`： `LST(a1, a2, a3)` 将会创建一个值为 `[a1, a2, a3]` 的链表，实际上是一个语法糖，本质上等于：`CONS(a1, CONS(a2, CONS(a3, NIL)))` 。
- `DEF`： 用于定义一个变量，例如：`DEF("x", NUM(1))` 将定义一个变量，其名字为 `x` ，值为 `1` 。
- `FUN`： 定义一个匿名函数，例如： `FUN(LST(VAR("x"), VAR("y")), Var("x"))` 相当于定义了一个接收两个参数，返回第一个参数的值的匿名函数。
- `BEGIN`： `BEGIN(a1, a2, ..., an)` 将逐个执行 `a1`, `a2` ... `an`，并返回 `an` 的值。
- `PRINT`： `PRINT(x)` 会打印 `x` 的值。
  
## 语法规则

1. 语言支持：数字(Java 中的Double)，字符串、布尔、NIL 等基本数据类型。
2. 一个表达式可以是基本数据类型，也可以是复合数据类型。
3. 除了一些特殊情况（IF、FUN）等，复合数据类型均通过 `CONS` 构造。
4. 执行 `VAR(id)` 会在当前环境中查找名为 `id` 的变量的值。
5. 对于链表 `LST(a1, a2, ..., an)`，相当于将 `a2, ..., an` 作为参数传递给 `a1` （此时 `a1` 需要是一个 `FUN`），并返回执行的结果。

## 默认函数

`Machine` 提供了以下函数：

- `+`： `LST(VAR("+"), NUM(1), NUM(2), NUM(3))` 将会得到 `1+2+3` 的结果，即为 `NUM(6)`。
- `-`： 与 `+` 类似，只不过是减法。
- `<`： `LST(VAR("<"), NUM(1), NUM(2))` 将会得到 `1 < 2` 的结果，即为 `BOOL(true)`。

## 示例程序

以及程序用于计算斐波那契数列的第20项：

```
BEGIN(
    DEF("fib", FUN(LST(VAR("n")),
        IF(LST(VAR("<"), VAR("n"), NUM(2)),
           VAR("n"),
           LST(VAR("+"),
               LST(VAR("fib"), LST(VAR("-"), VAR("n"), NUM(1))),
               LST(VAR("fib"), LST(VAR("-"), VAR("n"), NUM(2))))))),
    PRINT(LST(VAR("fib"), NUM(20)))
);
```

## 语言特性

本语言支持变量覆盖，例如

```
BEGIN(
    DEF("x", NUM(1)),
    DEF("f", FUN(LST(VAR("x")),
        PRINT(VAR("x")))),
    LST(VAR("f"), NUM(2)),
    PRINT(VAR("x"))
);
```

将得到结果：

```
2.0
1.0
```

本语言不支持闭包。

## 运行方法

如果安装有 `make` 程序，则可以运行：

```
make
```

进行编译，运行

```
make run
```

运行编译好的程序，

运行

```
make test
```

运行测试程序。

如果没有安装 `make` 程序，运行：

```
javac -d ./build Main.java
```

编译 `Main.java` 文件，运行：

```
javac -d ./build Test.java
```

编译测试文件。运行：

```
java -cp ./build Main
java -cp ./build Test
```

将分别执行主程序和测试程序。

## 总结

本项目相当于是一个非常简陋的 `Lisp` 语言解释器，且没有提供语法解析的问题，直接从语法树开始写。仅仅用于语言学习。如果有兴趣可以尝试完成以下几个挑战（编号越大越困难）：

1. 利用现有程序，写一个程序，计算 `100` 以内正整数的和。
2. 添加乘法（`*`）和除法（`/`）运算，添加相等判断（`=`）、大于判断（`>`），使得以及阶乘程序可以运行：
   ```
   BEGIN(
    DEF("fac", FUN(LST(VAR("n")),
        IF(LST(VAR("=") VAR("n") NUM(0)),
           NUM(1),
           LST(VAR("*"), VAR("n"),
               LST(VAR("fac"), LST(VAR("-"), VAR("n"), NUM(1))))))),
    LST(VAR("fac"), 10)
   );
   ```
3. 实现更多的函数，例如三角函数、平方根函数等等，利用现有编程语言，使用牛顿迭代法求 $\sqrt{2}$ 的近似值，与直接套用系统函数求得的值运行比较，输出其误差。
4. 实现 `QUOTE` 语句，`QUOTE(x)` 后边的 `x` 将不会被执行，例如，`LST(1, 2, 3)` 将会报错，因为 `1` 不是一个函数，但是 `QUOTE(LST(1, 2, 3))` 将会单纯返回 `LST(1, 2, 3)`。再例如，`VAR("x")` 将会在当前环境中查找变量 `x` 的值并返回，但是 `QUOTE(VAR("x"))` 仅仅会得到 `VAR("x")`，而不会进行查找操作。
5. 实现闭包特性。
6. 实现一个解析器，使得程序可以读入一段[`scheme`语言](https://www.scheme.com/tspl4/)的代码，并执行。（如果觉得这个问题过于困难，可以参考[`parser`示例](https://github.com/pdcxs/java-class-material/tree/main/examples/parser)。