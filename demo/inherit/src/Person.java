class Person {
    private String name;
    private int age;

    public Person() {
        System.out.println("Called Constructor of Person.");
    }

    public Person(String name, int age) {
        System.out.println("Called Constructor with parameters of Person.");
        this.name = name;
        this.age = age;
    }

    public void setNameAge(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.println("Name: " + name + " , Age: " + age);
    }
}