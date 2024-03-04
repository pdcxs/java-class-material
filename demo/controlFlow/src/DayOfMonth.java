import java.util.Scanner;

public class DayOfMonth {
    public static void main(String[] args) {
        int month, days;
        Scanner sc = new Scanner(System.in);
        System.out.print("Month Number (1-12): ");
        month = sc.nextInt();
        switch (month) {
            case 2:
                days = 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            default:
                days = 31;
        }
        sc.close();
        System.out.println(month + " month has " + days + " days.");
    }
}
