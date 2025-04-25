public class RecursiveFibonacci {
  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    System.out.println(fib(40));
    long endTime = System.currentTimeMillis();
    System.out.println("Run time: " + (endTime - startTime) + "ms.");
  }

  static public long fib(long n) {
    if (n < 2) {
      return n;
    }
    return fib(n - 1) + fib(n - 2);
  }
}
