# 数字电路仿真程序

本例是一个数字电路仿真程序。原例参见[SICP 电路仿真案例](https://sarabander.github.io/sicp/html/3_002e3.xhtml#g_t3_002e3_002e4)。

## 程序基本单元

程序基本单元有以下几种：

- `Wire`：电线，可以设置信号，并与其他门（`Gate`）进行连接。当设置的信号与原来的信号不同时，会触发其连接着的门运行。
- `Gate`：门电路，用于保存和执行各种电路逻辑。基础门电路包括与、非和或，可以用基础门电路组合成其他复合门，如`Half-Adder`。
- `Simulator`：仿真器，用于对全局事件和时间进行存储和计算。

## 程序主体

**Main Class** 是 `App.java`，其中实现了一个半加器的仿真。半加器的电路如下图所示：

![Half-Adder](https://raw.githubusercontent.com/pdcxs/java-class-material/main/examples/digit-circuit/imgs/half-adder.png)

其中，A和B对应于程序中的 `input1` 和 `input2`。S和C分别对应于程序中的 `sum` 和 `carry`。 D和E分别对应于程序中的 `orResult` 和 `notResult` 。原程序构造如下：

```java
public class HalfAdder extends CompoundGate {
    public Wire input1, input2;
    public Wire sum, carry;

    public Wire orResult, notResult;

    public HalfAdder(Wire input1, Wire input2, Wire sum, Wire carry) {
        orResult = new Wire();
        notResult = new Wire();
        this.input1 = input1;
        this.input2 = input2;
        this.sum = sum;
        this.carry = carry;
    }

    @Override
    public void setSimulator(Simulator simulator) {
        super.setSimulator(simulator);
        simulator.add(new Or(input1, input2, orResult));
        simulator.add(new And(input1, input2, carry));
        simulator.add(new Not(carry, notResult));
        simulator.add(new And(orResult, notResult, sum));
    }
}
```

## 问题

> 根据全加器的构造，实现对全加器的仿真（需要在 `compound` 中加入自己定义的 `FullAdder.java`，并更改 `App.java` 中的内容）。全加器构造如下：

![Full-Adder](https://raw.githubusercontent.com/pdcxs/java-class-material/main/examples/digit-circuit/imgs/full-adder.png)

> 根据以下构造，实现 $n$ 比特无符号整数的加法：

![Ripple-Carry Adder](https://raw.githubusercontent.com/pdcxs/java-class-material/main/examples/digit-circuit/imgs/ripple-carry-adder.png)
