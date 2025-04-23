package digitcircuit.gates;

import digitcircuit.Gate;
import digitcircuit.Wire;

public class Or extends Gate {
  public Wire input1, input2;
  public Wire output;

  public Or(Wire input1, Wire input2, Wire output) {
    delay = 5;
    this.input1 = input1;
    this.input2 = input2;
    this.output = output;
    input1.addGate(this);
    input2.addGate(this);
  }

  @Override
  public void run() {
    byte a1 = input1.getSignal();
    byte a2 = input2.getSignal();
    byte result = (byte) (a1 | a2);
    output.setSignal(result);
  }
}
