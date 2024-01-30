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