package digit_circuit;

import java.util.ArrayList;
import java.util.List;

public class Wire {
    private byte signal;
    private List<Gate> gates;

    public Wire() {
        signal = 0;
        gates = new ArrayList<>();
    }

    public void setSignal(byte signal) {
        if (this.signal != signal) {
            this.signal = signal;
            for (Gate g : gates) {
                g.invoke();
            }
        }
    }
    
    public void setSignal(int signal) {
        setSignal((byte)signal);
    }

    public void addGate(Gate gate) {
        gates.add(gate);
    }

    public byte getSignal() {
        return signal;
    }
}
