import java.util.Scanner;

public class HanoiTower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input a number: ");

        int n = sc.nextInt();
        hanoi(n, 'a', 'b', 'c');

        sc.close();
    }

    public static void hanoi(int n, char a, char b, char c) {
        if (n == 1) {
            System.out.println("Move disk from " + a + " to " + c  + ".");
            return;
        }
        hanoi(n - 1, a, c, b);
        hanoi(1, a, b, c);
        hanoi(n - 1, b, a, c);
    }
}
