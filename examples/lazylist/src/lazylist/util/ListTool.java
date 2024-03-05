package lazylist.util;

import lazylist.LazyList;

public class ListTool {
    @SuppressWarnings("unchecked")
    public static <T> LazyList<T> List(T... args) {
        return arrayToList(args, 0);
    }

    private static <T> LazyList<T> arrayToList(T[] args, int n) {
        if (n == args.length) {
            return new LazyList<T>();
        }
        return new LazyList<T>(args[n], () -> arrayToList(args, n + 1));
    }

    static public <T> LazyList<T> repeat(T elem) {
        return new LazyList<>(elem, () -> repeat(elem));
    };

    static public LazyList<Integer> naturals(int start) {
        return new LazyList<>(start, () -> naturals(start + 1));
    }

    static public LazyList<Integer> naturals() {
        return naturals(0);
    }

    static public int sum(LazyList<Integer> lst) {
        if (lst.isEmpty()) {
            return 0;
        }
        return lst.head() + sum(lst.tail());
    }
}
