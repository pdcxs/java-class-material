package lazylist;

import java.util.function.*;

public class LazyList<T> {
    private T elem;
    private Supplier<LazyList<T>> next;
    private boolean isEmpty;
    private LazyList<T> evaluatedNext = null;

    public LazyList(T elem, Supplier<LazyList<T>> next) {
        // normal list
        this.elem = elem;
        this.next = next;
        this.isEmpty = false;
    }

    public LazyList() {
        // empty list
        this.isEmpty = true;
    }

    public LazyList(T elem) {
        // single element
        this.elem = elem;
        this.next = new Supplier<LazyList<T>>() {
            public lazylist.LazyList<T> get() {
                return new LazyList<T>();
            };
        };
        this.isEmpty = false;
    }

    @Override
    public String toString() {
        return "[" + contents() + "]";
    }

    public LazyList<T> tail() {
        if (evaluatedNext == null) {
            evaluatedNext = next.get();
        }
        return evaluatedNext;
    }

    public T head() {
        return elem;
    }

    private String contents() {
        if (isEmpty)
            return "";
        if (tail().isEmpty) {
            return elem.toString();
        }
        return elem + ", " + next.get().contents();
    }

    public LazyList<T> takeWhile(Predicate<T> pred) {
        if (isEmpty || !pred.test(elem)) {
            return new LazyList<T>();
        }
        return new LazyList<T>(elem, new Supplier<LazyList<T>>() {
            @Override
            public LazyList<T> get() {
                return tail().takeWhile(pred);
            }
        });
    }

    public T get(int n) {
        if (isEmpty) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (n == 0) {
            return elem;
        }
        return tail().get(n - 1);
    }

    public LazyList<T> take(int n) {
        if (n == 0) {
            return new LazyList<T>();
        }
        if (isEmpty) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return new LazyList<T>(elem, new Supplier<LazyList<T>>() {
            @Override
            public LazyList<T> get() {
                return tail().take(n - 1);
            }
        });
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public LazyList<T> zipWith(BinaryOperator<T> op, LazyList<T> lst) {
        if (isEmpty || lst.isEmpty) {
            return new LazyList<T>();
        }
        return new LazyList<T>(op.apply(elem, lst.elem),
                new Supplier<LazyList<T>>() {
                    @Override
                    public LazyList<T> get() {
                        return tail().zipWith(op, lst.tail());
                    }
                });
    }

    public int length() {
        if (isEmpty) {
            return 0;
        }
        return 1 + tail().length();
    }

    public LazyList<T> filter(Predicate<T> pred) {
        if (isEmpty) {
            return new LazyList<>();
        }
        if (pred.test(elem)) {
            return new LazyList<T>(elem, new Supplier<LazyList<T>>() {
                @Override
                public LazyList<T> get() {
                    return tail().filter(pred);
                }
            });
        }
        return tail().filter(pred);
    }
}