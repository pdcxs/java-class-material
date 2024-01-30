package digit_circuit.compound;

import digit_circuit.Simulator;
import digit_circuit.Wire;
import digit_circuit.gates.*;

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
