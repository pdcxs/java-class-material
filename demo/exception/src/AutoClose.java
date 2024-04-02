import java.util.Scanner;

public class AutoClose {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try (in) {
            while (in.hasNextLine()) {
                System.out.println(in.nextLine());
            }
        }
    }
}
