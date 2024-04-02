import cn.edu.pdcxs.list.*;
import static cn.edu.pdcxs.list.util.Tools.*;

public class App {
    public static void main(String[] args) {
        List lst = new List(new int[]{1, 2, 3});
        System.out.println(lst);

        double[] arr = new double[]{3.3, 4.4};
        List lst2 = toList(arr);
        System.out.println(lst2);
    }
}
