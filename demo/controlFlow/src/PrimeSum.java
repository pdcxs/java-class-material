public class PrimeSum {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 2; i < 100; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                sum += i;
            }
        }
        System.out.println("Total of primes less than 100 is: " + sum);
    }
}
