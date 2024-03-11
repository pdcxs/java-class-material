public class VarArgs {
    public static int min(int firstNumber, int... otherNumbers) {
        int result = firstNumber;
        for (int n : otherNumbers) {
            if (result > n) {
                result = n;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(min(-10, 1, 2, 3));
        System.out.println(min(0));
    }
}
