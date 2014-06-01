/**
 * Created by Johannes on 11.01.14.
 */


class A {
}

class B extends A {
}

public class C {
    public void method(A a) {
        System.out.println("methode(A a) aufgerufen");
    }

    public void method(B b) {
        System.out.println("methode(B b) aufgerufen");
    }

    public static <T> void main(String[] args) {

        C c = new C();

        A a1 = new A();
        A a2 = new B();

        c.method(a1);
        c.method(a2);


    }
}
