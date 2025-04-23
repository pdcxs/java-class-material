import static lazylist.util.ListTool.*;
import static lazylist.util.Primes.*;
import lazylist.util.Fibonacci;

import lazylist.*;

public class App {
  public static void main(String[] args) {
    LazyList<Integer> list = List(1, 2, 3, 4, 5);
    System.out.println(list);
    System.out.println(list.tail());
    System.out.println(list.length());

    LazyList<String> infiniteList = repeat("Hello");
    System.out.println(infiniteList.take(10));

    var somePrimes = primes().takeWhile(n -> n < 100);

    System.out.println(somePrimes);
    System.out.println(sum(somePrimes));

    var fibs = new Fibonacci();
    System.out.println(fibs.first(30));
  }
}
