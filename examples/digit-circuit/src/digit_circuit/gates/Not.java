package digit_circuit.gates;

import digit_circuit.Gate;
import digit_circuit.Wire;

public class Not extends Gate {
    public Wire input;
    public Wire output;

    public Not(Wire input, Wire output) {
        this.input = input;
        this.output = output;
        delay = 2;
        input.addGate(this);
    }

    @Override
    public void run() {
        output.setSignal(~input.getSignal());
    }
}
