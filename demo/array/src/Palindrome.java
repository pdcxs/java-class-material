public class Palindrome {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Palindrome [text]");
            System.exit(1);
        }
        String text = args[0];
        System.out.println("Text is: " + text);

        // method 1
        boolean isPalindrome = true;
        for (int i = 0; i < text.length() / 2; i++) {
            if (text.charAt(i) != text.charAt(text.length() - i - 1)) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println(isPalindrome);

        // method 2
        String reverse = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reverse += text.charAt(i);
        }
        System.out.println(reverse.equals(text));

        // method 3
        StringBuffer strBuf = new StringBuffer(text);
        System.out.println(strBuf.reverse().toString().equals(text));
    }
}
