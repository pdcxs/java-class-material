public class InstanceOf {
    public static void main(String[] args) {
        Item sicp = new Book();
        sicp.print();
        System.out.println(sicp.getPrice());
        // sicp.getBook();
        if (sicp instanceof Book) {
            Book sicpBook = (Book)sicp;
            System.out.println(sicpBook.getBook());
        }
    }
}

class Item {
    String name;
    int price;

    void print() {
        System.out.println(name + "\t" + price);
    }

    int getPrice() {
        return price;
    }
}

class Book extends Item {
    Book() {
        this.name = "SICP";
        this.price = 30;
    }

    void print() {
        System.out.println("The price of book " + name + " is " + price + ".");
    }

    String getBook() {
        return name;
    }
}