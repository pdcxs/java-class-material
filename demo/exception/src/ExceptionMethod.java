public class ExceptionMethod {
    public static void main(String[] args) {
        int num;
        try {
            check(args[0]);
            num = Integer.parseInt(args[0]);
            if (num > 60) {
                System.out.println("Good");
            } else {
                System.out.println("Bad");
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        } catch (NumberFormatException e) {
            System.out.println("Not provide a number.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please provide a score.");
        }
    }
    
    @SuppressWarnings("null")
    static void check(String str) throws NullPointerException {
        if (str.length() > 2) {
            str = null;
            System.out.println(str.length());
        }
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (!Character.isDigit(ch)) {
                throw new NumberFormatException();
            }
        }
    }
}
