package engine;

import java.awt.*;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    private Thread gameThread;
    private App app;
    KeyHandler keyHandler;
    MouseHandler mouseHandler;
    double mouseX, mouseY, prevMouseX, prevMouseY;

    public GamePanel(App app) {
        this.app = app;
        keyHandler = new KeyHandler();
        mouseHandler = new MouseHandler(app);
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);
        setDoubleBuffered(true);
        addKeyListener(keyHandler);
        setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        app.g = (Graphics2D)g;
        app.draw();
    }

    @Override
    public void run() {
        setPreferredSize(app.getSize());

        double drawInterval;
        double nextDrawTime;
        while (gameThread != null) {
            drawInterval = 1e9 / app.fps;
            nextDrawTime = System.nanoTime() + drawInterval;

            prevMouseX = mouseX;
            prevMouseY = mouseY;

            app.update(drawInterval / 1e9);
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                if (remainingTime < 0) {
                    remainingTime = 0;
                } else {
                    remainingTime /= 1e6;
                }
                Thread.sleep((long) remainingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void setMousePosition(double x, double y) {
        mouseX = x;
        mouseY = y;
    }
}
