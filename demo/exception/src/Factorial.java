public class Factorial {
    public static void main(String[] args) {
        try {
            int m = Integer.parseInt(args[0]);
            System.out.println(m + "! = " + fractorial(m));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Usage: java Factorial [num].");
        } catch (NumberFormatException e) {
            System.out.println("Should provide an integer.");
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Program finished.");
        }
    }

    public static long fractorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Facotorial of negative number");
        }
        long s = 1;
        for (int i = 1; i <= n; i++) {
            s *= i;
        }

        return s;
    }
}
