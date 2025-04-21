package engine;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener{
    App app;

    public MouseHandler(App app) {
        this.app = app;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        app.mouseClicked();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        app.mousePressed();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        app.mouseReleased();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        updateMousePosition(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        updateMousePosition(e);
    }
    
    private void updateMousePosition(MouseEvent e) {
        app.gamePanel.setMousePosition(e.getX(), e.getY());
    }
}
