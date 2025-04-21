package engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class KeyHandler implements KeyListener {
    private final Set<Integer> pressedKeys = new HashSet<>();

    public boolean isKeyDown() {
        return !pressedKeys.isEmpty();
    }

    public boolean isKeyPressed(int keycode) {
        return pressedKeys.contains(keycode);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressedKeys.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
    }
}
