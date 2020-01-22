import java.io.*;
import java.util.Objects;

class SingleTone implements Serializable {
    private static SingleTone singleTone = null;

    private SingleTone() {}

    public static SingleTone getInstance() {
        if (singleTone == null) {
            singleTone = new SingleTone();
        }
        return singleTone;
    }
//    @Override
//    public boolean equals(Object o ) {
//        if (o instanceof  SingleTone) {
//            return  singleTone.equals(o);
//        } else {
//            return  false;
//        }
//
//    }
//    @Override
//    public int hashCode() {
//        if (singleTone!=null) {
//            return  Objects.hash(singleTone);
//        }
//        return 1;
//    }

    public Object readResolve() {
        return singleTone;
    }
}

public class SingletoneDemo {

    public static void main(String args[]) {
        SingleTone singleTone = SingleTone.getInstance();
        SingleTone singleTone1 = null;
        try {
            // Serilize
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("singletone.txt"));
            objectOutputStream.writeObject(singleTone);
            objectOutputStream.close();

            // Deserilize
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("singletone.txt"));
            singleTone1 = (SingleTone) objectInputStream.readObject();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("OBJ1 :=" + singleTone.hashCode());
        System.out.println("OBJ2 :=" + singleTone1.hashCode());
    }
}
