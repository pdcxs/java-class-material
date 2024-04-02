class A {
    int a = 1;

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == A.class) {
            A objA = (A)obj;
            return this.a == objA.a;
        }
        return false;
    }
}

public class Equals {
    public static void main(String[] args) {
        A obj1 = new A();
        A obj2 = new A();
        String s1, s2, s3 = "abc", s4 = "abc";
        s1 = new String("abc");
        s2 = new String("abc");
        System.out.println("s1.equals(s2): " + (s1.equals(s2)));
        System.out.println("s1==s3: " + (s1 == s3));
        System.out.println("s1.equals(s3): " + (s1.equals(s3)));
        System.out.println("s3==s4: " + (s3 == s4));
        System.out.println("s2.equals(s3): " + (s2.equals(s3)));
        System.out.println("s1==s2: " + (s1 == s2));
        System.out.println("obj1==obj2等于: " + (obj1 == obj2));
        System.out.println("obj1.equals(obj2): " + (obj1.equals(obj2)));
        obj1 = obj2;
        System.out.println("obj1=obj2后obj1==obj2: " + (obj1 == obj2));
        System.out.println("obj1=obj2后obj1.equals(obj2): " + (obj1.equals(obj2)));
    }
}
