import java.awt.Color;

import engine.App;

public class Ball {
    Ball(App app, int x, int y, int radius, Color c) {
        this.app = app;
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.c = c;
        velx = app.getRandomInt(-200, 200);
        velx = app.getRandomInt(-200, 200);
        isActive = true;
    }

    public void draw() {
        app.setColor(c);
        app.setStrokeWidth(1);
        app.circle((int)x, (int)y, (int)radius);
    }

    public void update(double delta) {
        if (!isActive) {
            x = (float)app.mouseX();
            y = (float)app.mouseY();
            return;
        }

        if (x + radius > app.getWidth()) {
            x = app.getWidth() - radius;
            velx *= -0.9;
        } else if (x - radius < 0) {
            x = radius;
            velx *= -0.9;
        } else if (y + radius > app.getHeight()) {
            y = app.getHeight() - radius;
            vely *= -0.85;
        } else if (y - radius < 0) {
            y = radius;
            vely *= -1;
        }

        vely += 270 * delta;
        x += velx * delta;
        y += vely * delta;
    }

    double x, y;
    double radius;
    private Color c;
    private App app;
    double velx, vely;
    boolean isActive = true;
}
