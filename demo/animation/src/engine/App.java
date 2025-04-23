package engine;

import javax.swing.JFrame;
import java.awt.*;
import java.util.Random;

public class App {
  public App(String title, int width, int height) {
    this.title = title;
    this.width = width;
    this.height = height;
    gamePanel = new GamePanel(this);
    gamePanel.setPreferredSize(new Dimension(width, height));
    rand = new Random();
  }

  public void draw() {
  }

  public void update(double delta) {
  }

  public int getRandomInt(int left, int right) {
    return rand.nextInt(left, right + 1);
  }

  public double getRandom() {
    return rand.nextDouble();
  }

  public void run() {
    window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setTitle(title);

    window.add(gamePanel);
    window.pack();

    window.setLocationRelativeTo(null);
    window.setVisible(true);

    gamePanel.startGameThread();
  }

  public Dimension getSize() {
    return window.getSize();
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public void setColor(Color c) {
    if (g == null)
      return;
    g.setColor(c);
  }

  public void setStrokeColor(Color c) {
    if (g == null)
      return;
    strokeColor = c;
  }

  public void setStrokeWidth(int w) {
    strokeWidth = w;
  }

  public void rect(int x, int y, int width, int height) {
    if (g == null)
      return;
    g.fillRect(x, y, width, height);
    Color c = g.getColor();
    g.setColor(strokeColor);
    g.setStroke(new BasicStroke(strokeWidth));
    g.drawRect(x, y, width, height);
    g.setColor(c);
  }

  public void ellipse(int x, int y, int width, int height) {
    if (g == null)
      return;
    g.fillOval(x, y, width, height);
    Color c = g.getColor();
    g.setColor(strokeColor);
    g.setStroke(new BasicStroke(strokeWidth));
    g.drawOval(x, y, width, height);
    g.setColor(c);
  }

  public void circle(int x, int y, int radius) {
    ellipse(x - radius, y - radius, radius * 2, radius * 2);
  }

  public void background(Color c) {
    if (g == null)
      return;
    g.clearRect(0, 0, width, height);
    g.setColor(c);
    g.fillRect(0, 0, width, height);
  }

  public void setFPS(int fps) {
    this.fps = fps;
  }

  public boolean isKeyDown() {
    return gamePanel.keyHandler.isKeyDown();
  }

  public boolean isKeyPressed(int keycode) {
    return gamePanel.keyHandler.isKeyPressed(keycode);
  }

  public void mouseClicked() {
  }

  public void mousePressed() {
  }

  public void mouseReleased() {
  }

  public double mouseX() {
    return gamePanel.mouseX;
  }

  public double mouseY() {
    return gamePanel.mouseY;
  }

  public double prevMouseX() {
    return gamePanel.prevMouseX;
  }

  public double prevMouseY() {
    return gamePanel.prevMouseY;
  }

  private final String title;
  private final int width;
  private final int height;
  private JFrame window;
  GamePanel gamePanel;
  Graphics2D g;
  private int strokeWidth = 0;
  private Color strokeColor = Color.BLACK;
  int fps = 60;
  private final Random rand;
}
