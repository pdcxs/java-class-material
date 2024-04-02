public class InterfaceInherit {
    public static void main(String[] args) {
        Player player = new DotaPlayer("Eric", 30);
        System.out.println(player.getName() + " plays " + player.getGameName());
    }
}

interface Player extends Person {
    String getGameName();
}

class DotaPlayer implements Player {
    private String name;
    private int age;

    public DotaPlayer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGameName() {
        return "dota";
    }
}
