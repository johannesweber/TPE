/**
 * Created by Johannes on 15.01.14.
 */

class A {
     static int wert = 5;
}

class B extends A{
   static int wert = 6;

}
public class Astatic {
    void method(A a){
        System.out.println(a.wert);
    }

    public static void main(String[] args){

        Astatic astatic = new Astatic();
        A b = new B();

        astatic.method(b);

        System.out.println(B.wert);
    }
}
