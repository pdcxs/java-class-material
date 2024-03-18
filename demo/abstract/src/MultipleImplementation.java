public class MultipleImplementation {
    public static void main(String[] args) {
        MarriedPlayer eric = new MarriedPlayer(
                "Eric", 31, "Elden Ring",
                new DotaPlayer("Alice", 30));
        System.out.println(eric.getCouple().getName());
    }
}

interface Married {
    Person getCouple();
}

class MarriedPlayer implements Married, Player {
    String name;
    int age;
    Person couple;
    String gameName;

    public MarriedPlayer(String name, int age, String gameName, Person couple) {
        this.name = name;
        this.age = age;
        this.couple = couple;
        this.gameName = gameName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public Person getCouple() {
        return couple;
    }

    @Override
    public String getGameName() {
        return gameName;
    }
}