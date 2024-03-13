public class Person {
    private String firstName, lastName;

    public void setName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Overload the function.
    public void setName(String fullName) {
        String[] words = fullName.split("\\s+");
        if (words.length == 1) {
            firstName = words[0];
            lastName = "";
        } else if (words.length > 1) {
            firstName = words[0];
            lastName = words[1];
        } else {
            firstName = lastName = "";
        }
    }

    public static void main(String[] args) {
        Person p = new Person();
        p.setName("Eric", "Brown");
        System.out.println("The name is: " + p);

        p.setName("Michael   Jackson");
        System.out.println("The name is: " + p);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Person) {
            Person p = (Person)obj;
            return p.firstName.equals(firstName) && p.lastName.equals(lastName);
        }
        return false;
    }
}
