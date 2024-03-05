package lazylist.util;

import lazylist.LazyList;

public class Fibonacci {
    private LazyList<Integer> fibs;

    public Fibonacci() {
        fibs = new LazyList<Integer>(0,
                () -> new LazyList<Integer>(1,
                        () -> fibs.zipWith((Integer t, Integer u) -> t + u, fibs.tail())));
    }

    public LazyList<Integer> first(int n) {
        return fibs.take(n);
    }
}
