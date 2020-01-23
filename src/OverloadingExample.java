class Overloading {
    public void m1(String str) {
        System.out.println("String");
    }
    public void m1(Object str) {
        System.out.println("String");
    }
    public void m1(Integer str) {
        System.out.println("String");
    }
}

public class OverloadingExample {
    public static void main(String[] args) {
    Overloading overloading = new Overloading();
    //overloading.m1(null);

    }
}
