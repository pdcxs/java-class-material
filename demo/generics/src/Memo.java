import java.math.BigInteger;
import java.util.*;

public class Memo {
  static HashMap<Integer, BigInteger> results = new HashMap<>();

  public static void main(String[] args) {
    System.out.println("Start");
    long time = System.nanoTime();
    System.out.println(fib(40));
    System.out.println("Run time: " + (System.nanoTime() - time));

    time = System.nanoTime();
    System.out.println(slowFib(40));
    System.out.println("Run time: " + (System.nanoTime() - time));
  }

  static BigInteger fib(int n) {
    if (n < 2) {
      return BigInteger.valueOf(n);
    }
    if (results.containsKey(n)) {
      return results.get(n);
    }
    BigInteger r = fib(n - 1).add(fib(n - 2));
    results.put(n, r);
    return r;
  }

  static BigInteger slowFib(int n) {
    if (n < 2) {
      return BigInteger.valueOf(n);
    }
    return slowFib(n - 1).add(slowFib(n - 2));
  }
}
