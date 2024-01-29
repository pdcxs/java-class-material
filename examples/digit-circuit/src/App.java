import digit_circuit.*;
import digit_circuit.compound.HalfAdder;
import digit_circuit.gates.*;

public class App {
    public static void main(String[] args) {
        Simulator sim = new Simulator();
        Wire input1 = new Wire();
        Wire input2 = new Wire();
        Wire sum = new Wire();
        Wire carry = new Wire();

        sim.add(new Probe("sum", sum));
        sim.add(new Probe("carry", carry));
        sim.add(new Probe("input1", input1));
        sim.add(new Probe("input2", input2));
        sim.add(new HalfAdder(input1, input2, sum, carry));

        sim.run();

        input1.setSignal(1);
        sim.run();

        input1.setSignal(0);
        input2.setSignal(1);
        sim.run();

        input1.setSignal(1);
        sim.run();
    }
}
