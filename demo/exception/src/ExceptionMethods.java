public class ExceptionMethods {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        try {
            System.out.println("Total number is: " + sum(arr));
        } catch (Exception e) {
            System.out.println("Exception name: " + e);
            e.printStackTrace();
            System.out.println("Message: " + e.getMessage());
            System.out.println(e.toString());
            StackTraceElement[] ste = e.getStackTrace();
            for (int i = 0; i < ste.length; i++) {
                System.out.println("Method: " + ste[i].getMethodName());
                System.out.println("Class: " + ste[i].getClassName());
                System.out.println("File: " + ste[i].getFileName());
                System.out.println("Line: " + ste[i].getLineNumber());
            }
        }
    }

    private static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i <= arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
