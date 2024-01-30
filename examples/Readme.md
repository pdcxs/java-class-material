# 演示项目文件

这里是一些有一定难度的 Java 项目示例，一些项目的描述文件后面会有提出的问题，有兴趣的读者可以进行尝试。

项目内容如下（由易到难排序）

## brainfuck

`Brainfuck` 是一种极小化的计算机语言，它是由Urban Müller在1993年创建的。由于fuck在英语中是脏话，这种语言有时被称为brainf*ck或brainf**k，甚至被简称为BF。在brainfuck项目中，是一个 Java 版本的简易实现。并且有两段程序：`factorial` 和 `helloworld`。在运行Brainfuck.java后，程序会以REPL（Read-Eval-Print Loop）的方式等待用户录入程序（录入空行或者按 `Ctrl-C` 退出）。可以将两段程序粘贴进程序运行测试。

## digit-circuit

**Digital Circuit** 程序主要功能是利用 `Java` 进行数字电路仿真。灵感来源于 SICP（计算机程序的构造和解释），原版可以参看[教材](https://sarabander.github.io/sicp/html/3_002e3.xhtml#g_t3_002e3_002e4)或者[视频](https://www.bilibili.com/video/BV1Xx41117tr/?p=10)。

## treemachine

**TreeMachine** 是一种可以执行通用递归指令的计算机。实际上，这个计算机可以当作是 [`scheme` 语言](https://www.scheme.com/tspl4/) 的抽象语法树执行程序。

**TreeMachine** 项目只是一个非常简单的实现，很多语言特性不支持，没有任何优化。但是足够作为教学使用了。有余力的读者可以尝试练习该项目 Readme 中后边的问题。原版程序可参考 [SICP 第四章](https://sarabander.github.io/sicp/html/4_002e1.xhtml#g_t4_002e1)。

## parser

实际上是一个 `scheme` 语言的前端解析器，与 **TreeMachine** 项目共同构成一个完成的 scheme 语言解释器。当然了，只是一个 **toy interpreter**。
