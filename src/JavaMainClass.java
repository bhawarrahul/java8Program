public class JavaMainClass {
    public  static  void  main(String args[]) {
        Student s = ()->System.out.println("Display");
        s.display();
        Student s2 = ()->System.out.println("Display2");
        s2.display();
    }
}


interface Student {
    void display();

}
//abstract class Student {
//    public abstract   void display();
//}
