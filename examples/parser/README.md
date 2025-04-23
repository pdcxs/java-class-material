# Lisp 语言解析器

基于 `tree_machine` 项目，创建一个前端的文本解析器。

可以解析code.txt中的scheme语言代码：

```scheme
(define fib (lambda (n)
  (if (< n 2) n
      (+ (fib (- n 1))
         (fib (- n 2))))))
(displayln (fib 20))

(define fib2 (lambda (n a b)
  (if (< n 1) a
      (fib2 (- n 1) b (+ a b)))))

(displayln (fib2 20 0 1))
```

## 运行方法

### 方法一

如果电脑安装有 `make`，则可以运行 `make` 进行编译，并运行 `make run` 运行。

### 方法二

用 VS Code 打开本项目，如 treemachine 项目中描述的类似，运行 `Java: Export Jar` 命令，选择 `Parser` 作为主类，包含所有jar文件，可在本项目目录下生成 `parser.jar` 文件。运行：

```shell
java -jar parser.jar code.txt
```

即可。可以尝试更改code.txt中的程序来查看效果。

### 方法三

用 `IntelliJ IDEA` 打开本项目(`parser.iml`)，打开`Parser.java`，运行选项为当前文件，点击运行即可。