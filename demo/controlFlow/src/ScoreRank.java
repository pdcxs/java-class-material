import java.io.*;

public class ScoreRank {
    public static void main(String[] args) throws IOException {
        // int testScore=86;
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Please input a score: ");
        float testScore = Float.parseFloat(buf.readLine());

        char grade;
        if (testScore >= 90) {
            grade = 'A';
        } else if (testScore >= 80) {
            grade = 'B';
        } else if (testScore >= 70) {
            grade = 'C';
        } else if (testScore >= 60) {
            grade = 'D';
        } else {
            grade = 'E';
        }
        System.out.println("grade = " + grade);
    }
}
