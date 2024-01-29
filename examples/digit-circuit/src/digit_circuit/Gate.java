package digit_circuit;

abstract public class Gate {
    protected Simulator simulator;
    protected int delay = 0;

    abstract public void run();

    public void setSimulator(Simulator simulator) {
        this.simulator = simulator;
    }

    public void invoke() {
        simulator.addEvent(delay, this);
    }
}
