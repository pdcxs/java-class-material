class ClaA {
}

class ClaB extends ClaA {
    int x;
}

class ClaC extends ClaB {
    int y;
}

public class DynamicMakeObjects {
    static ClaA getObj(int n) { // 返回值类型为 ClasA
        switch (n) {
            case 0:
                return new ClaA();
            case 1:
                return new ClaB();
            default:
                return new ClaC();
        }
    }

    public static void main(String[] args) {
        var m1 = getObj(0);
        var m2 = getObj(1);
        var m3 = getObj(2);
        System.out.println("m1: " + m1.getClass());
        System.out.println("m2: " + m2.getClass());
        System.out.println("m3: " + m3.getClass());
        // m2.x=10;
        // m3.y=20;
    }
}
