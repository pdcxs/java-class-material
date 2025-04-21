import java.awt.Color;
// import java.awt.event.KeyEvent;

import engine.App;

public class Sketch extends App {
    public Sketch() {
        super("My Sketch", 500, 500);
        ball = new Ball(this, 100, 100, 50, Color.RED);
    }

    @Override
    public void draw() {
        background(Color.WHITE);
        ball.draw();
    }

    @Override
    public void update(double delta) {
        ball.update(delta);
    }

    @Override
    public void mousePressed() {
        double dx = mouseX() - ball.x;
        double dy = mouseY() - ball.y;
        if (dx * dx + dy * dy < ball.radius * ball.radius)
            ball.isActive = false;
    }

    @Override
    public void mouseReleased() {
        if (ball.isActive) return;
        ball.isActive = true;
        ball.velx = 10 * (mouseX() - prevMouseX());
        ball.vely = 10 * (mouseY() - prevMouseY());
    }

    Ball ball;
}
