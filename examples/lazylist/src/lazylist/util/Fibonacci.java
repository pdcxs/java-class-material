package lazylist.util;

import lazylist.LazyList;

public class Fibonacci {
  private LazyList<Integer> fibs;

  public Fibonacci() {
    fibs = new LazyList<>(0,
        () -> new LazyList<>(1,
            () -> fibs.zipWith(Integer::sum, fibs.tail())));
  }

  public LazyList<Integer> first(int n) {
    return fibs.take(n);
  }
}
