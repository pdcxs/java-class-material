import java.util.*;
import java.util.stream.*;

public class Primes {
    public static void main(String[] args) {
        ArrayList<Integer> records = new ArrayList<>();
        records.add(2);

        IntStream primes = IntStream.iterate(2, i -> {
            i += 1;
            while (true) {
                boolean isPrime = true;
                for (int p : records) {
                    if (i != p && i % p == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    records.add(i);
                    return i;
                }
                i += 1;
        }});

        // System.out.println(primes.takeWhile(i -> i < 100).sum());
        System.out.println(Arrays.toString(primes.limit(20).map(i -> i * i).toArray()));
    }
}
