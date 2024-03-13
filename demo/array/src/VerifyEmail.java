import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class VerifyEmail {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("ab\\.*c");
        Matcher matcher = pattern.matcher("ab..cxyzab...cxxx");

        while (matcher.find()) {
            System.out.println(matcher.group() + ": " + matcher.start() + ", " + matcher.end());
        }

        String regex = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        String email;
        Scanner sc = new Scanner(System.in);
        boolean getEmail = false;
        while (true) {
            System.out.print("Please input your email address: ");
            email = sc.nextLine();
            Pattern emailPattern = Pattern.compile(regex);
            Matcher emailMatcher = emailPattern.matcher(email);
            
            if (emailMatcher.matches()) {
                getEmail = true;
                break;
            }
            else {
                System.out.print("Wrong email! Would you like to re-input? ");
                String ans = sc.nextLine();
                if (ans.equals("y") || ans.equals("Y")) {
                    continue;
                }
                break;
            }
        }
        if (getEmail) {
            System.out.println("You have entered an email: " + email);
        } else {
            System.out.println("Input email failed.");
        }
        sc.close();
    }
}
