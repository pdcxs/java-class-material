import java.util.*;

public class TreeSetDemo {
    public static void main(String[] args) {
        Set<String> hs = new HashSet<>();
        hs.add("唐僧");
        hs.add("孙悟空");
        hs.add("猪八戒");
        hs.add("沙和尚");
        hs.add("白龙马");
        TreeSet<String> ts = new TreeSet<>(hs);
        System.out.println("树集合：" + ts);
        System.out.println("第一个元素：" + ts.first());
        System.out.println("最后一个元素：" + ts.last());
        System.out.println("孙悟空前的元素集合" + ts.headSet("孙悟空"));
        System.out.println("孙悟空后的元素集合" + ts.tailSet("孙悟空"));
        System.out.println("大于等于“沙”的元素" + ts.ceiling("沙"));
    }
}
