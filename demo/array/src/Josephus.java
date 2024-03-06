// Josephus Problem
public class Josephus {
    /**
     * Josephus Problem
     * There are {@code totalNumber} people sitting in a circle.
     * Labeled from 1 to {@code totalNumber}.
     * Count from people labeled with number {@code currentLocation}.
     * When count to {@code interval}, kill that people, re-count from one.
     * What's the label of the people who last be killed?
     */
    public static void main(String[] args) {
        // total number of people
        int totalNumber = 13;
        // start location
        int currentLocation = 2;
        // killing interval
        int interval = 5;

        // people's state (true means alive)
        boolean[] people = new boolean[totalNumber];
        for (int i = 0; i < totalNumber; i++) {
            people[i] = true;
        }

        System.out.println("Killed order:");

        int currentCount = 1;
        while (true) {
            // should current person be killed?
            if (currentCount == interval) {
                people[currentLocation] = false; // kill him
                System.out.print((currentLocation + 1) + "\t");

                totalNumber -= 1;
                if (totalNumber == 0) {
                    break;
                }
                currentCount = 0;
            }

            // next alive person
            do {
                currentLocation = (currentLocation + 1) % people.length;
            } while (!people[currentLocation]);
            currentCount += 1;
        }
        System.out.println();
    }
}
