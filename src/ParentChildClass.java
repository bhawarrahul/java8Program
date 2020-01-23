class Parent {
    int val = 10;
    public void get(){
        System.out.println("Parent get method");
    }
}
class Child extends Parent {
    int val = 11;
    public void get(){
        System.out.println("Child get method");
    }
}

public class ParentChildClass {
    public static void main(String[] args) {
        Parent p = new Child();
        p.get();
        System.out.println(p.val);

        Parent p2 = new Parent();
        p2.get();
        System.out.println(p2.val);
    }
}
