public class SimpleCalculator {
    public static void main(String[] args) throws Exception {
        int a = 100, b = 6;
        char operator;
        System.out.print("Please input operator: ");
        operator = (char) System.in.read();
        switch (operator) {
            case '+':
                System.out.println(a + " + " + b + " = " + (a + b));
                break;
            case '-':
                System.out.println(a + " - " + b + " = " + (a - b));
                break;
            case '*':
                System.out.println(a + " * " + b + " = " + (a * b));
                break;
            case '/':
                System.out.println(a + " / " + b + " = " + ((float) a / b));
                break;
            default:
                System.out.println("Unknown operator: " + operator);
        }
    }
}
