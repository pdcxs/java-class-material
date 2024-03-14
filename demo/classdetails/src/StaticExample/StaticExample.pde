Ball[] balls;
int ballsNum = 0;

void setup() {
  size(1000, 500);
  balls = new Ball[300];
}

void draw() {
  background(255);
  
  if (ballsNum < balls.length) {
    balls[ballsNum] = new Ball();
    ballsNum++;
  }
  
  for (Ball b : balls) {
    if (b == null) {
      break;
    }
    b.applyForce(new PVector(0.05, 0.1));
    b.update();
    if (b.isOut()) {
      b.init();
    }
    b.draw();
  }
}
