public class SimpleEnum {
    public static void main(String[] args) {
        Direction dir = Direction.EAST;
        Direction dir2 = Direction.valueOf("NORTH");
        System.out.println(dir);
        System.out.println(dir2);

        for (Direction d : Direction.values()) {
            System.out.println(d.ordinal() + ": " + d.name());
        }
    }
}

enum Direction {
    EAST, SOUTH, WEST, NORTH
}
