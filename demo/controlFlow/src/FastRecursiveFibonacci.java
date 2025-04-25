import java.util.HashMap;

public class FastRecursiveFibonacci {
  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    System.out.println(fib(40));
    long endTime = System.currentTimeMillis();
    System.out.println("Run time: " + (endTime - startTime) + "ms.");
  }

  public static long fib(long n) {
    if (n < 2)
      return n;
    if (results.containsKey(n))
      return results.get(n);
    long r = fib(n - 1) + fib(n - 2);
    results.put(n, r);
    return r;
  }

  static HashMap<Long, Long> results = new HashMap<>();
}
