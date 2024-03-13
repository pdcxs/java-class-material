class Ball {
    static final int radius = 20;
    color c = color(random(255), random(255), random(255));
    PVector loc;
    PVector vel;
    PVector acc;

    Ball() {
      init();
    }
    
    void applyForce(PVector f) {
      acc.add(f);
    }
    
    void update() {
      vel.add(acc);
      loc.add(vel);
      acc.mult(0);
    }
    
    void draw() {
      fill(c);
      ellipse(loc.x, loc.y, radius, radius);
    }
    
    boolean isOut() {
      return loc.x < -100 || loc.x > width + 100 || loc.y < -100 || loc.y > height + 100;
    }
    
    void init() {
      loc = new PVector(random(10, 30), height);
      vel = new PVector(random(-0.5, 0.5), random(-10, -5));
      acc = new PVector();
    }
}
