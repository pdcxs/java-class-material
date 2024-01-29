package digit_circuit.gates;

import digit_circuit.Gate;
import digit_circuit.Wire;

public class Probe extends Gate {
    public String name;
    public Wire wire;

    public Probe(String name, Wire wire) {
        this.name = name;
        this.wire = wire;
        wire.addGate(this);
    }

    @Override
    public void run() {
        System.out.println(
                String.format("At time %d, %s is %d",
                        simulator.getTime(),
                        name,
                        wire.getSignal()));
    }

    @Override
    public String toString() {
        return "Probe";
    }
}
