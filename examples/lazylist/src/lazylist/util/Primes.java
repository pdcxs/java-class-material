package lazylist.util;

import lazylist.LazyList;

import static lazylist.util.ListTool.*;

public class Primes {
  static public LazyList<Integer> primes() {
    return filterPrimes(naturals(2));
  }

  private static LazyList<Integer> filterPrimes(LazyList<Integer> p) {
    return new LazyList<Integer>(p.head(),
        () -> filterPrimes(p.tail().filter(
            (Integer t) -> t % p.head() != 0)));
  }
}
