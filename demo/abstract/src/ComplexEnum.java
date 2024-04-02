public class ComplexEnum {
    public static void main(String[] args) {
        Book[] bookShelf = new Book[]{Book.SICP, Book.OGL, Book.SICP};
        for (Book b : bookShelf) {
            System.out.println(b);
        }
    }
}

enum Book {
    SICP("Sicp"),
    OGL("OpenGL");

    private String name;

    private Book(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}