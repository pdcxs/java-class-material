public class Swap {
   static void swap(Data a, Data b) {
        int tmp = a.data;
        a.data = b.data;
        b.data = tmp;
   }

   public static void main(String[] args) {
        Data a = new Data();
        Data b = new Data();
        a.data = 1;
        b.data = 2;
        swap(a, b);
        System.out.println(a.data);
        System.out.println(b.data);
   }
}

class Data {
    int data;
}