package digit_circuit;

import java.util.ArrayList;
import java.util.List;

public class Simulator {
    int time;
    List<Event> events;
    List<Gate> gates;

    public Simulator() {
        time = 0;
        events = new ArrayList<>();
        gates = new ArrayList<>();
    }

    public int getTime() {
        return time;
    }

    public void addEvent(int delay, Gate gate) {
        events.add(new Event(delay + time, gate));
    }

    public void add(Gate gate) {
        gates.add(gate);
        gate.setSimulator(this);
        gate.invoke();
    }

    public void step() {
        List<Event> curEvents = new ArrayList<>();
        for (Event e : events) {
            if (e.time == time) {
                curEvents.add(e);
            }
        }
        if (curEvents.isEmpty()) {
            time++;
        } else {
            for (Event e : curEvents) {
                e.gate.run();
            }
            events.removeAll(curEvents);
        }
    }

    public void run() {
        while (!events.isEmpty()) {
            step();
        }
    }
}

class Event {
    int time;
    Gate gate;

    Event(int time, Gate gate) {
        this.time = time;
        this.gate = gate;
    }
}