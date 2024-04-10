public class MethodCall {
    public static void main(String[] args) {
        String inStr = "Hello, Java";
        String outStr;
        MyStrOps sOps = new MyStrOps();
        outStr = strOp(sOps::strReverse, inStr);
        System.out.println(outStr);
    }

    static String strOp(StrFunc f, String s) {
        return f.apply(s);
    }
}

@FunctionalInterface
interface StrFunc {
    String apply(String s);
}

class MyStrOps {
    String strReverse(String str) {
        StringBuffer sb = new StringBuffer(str);
        return sb.reverse().toString();
    }
}