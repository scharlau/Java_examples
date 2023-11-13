import java.util.*;

public class MyCustom {

    static class MyObject {
        String name;
        String value;
        String secret;

        public MyObject (String name, String value, String secret){
            this.name = name;
            this.value = value;
            this.secret = secret;
        }

        String getSecret(){
            return this.secret;

        }
    }

    public static void main(String[] args){

        ArrayList <MyObject> mc = new ArrayList <MyObject> ();
        MyObject mo1 = new MyObject("one","thisthing","true");
        MyObject mo2 = new MyObject("two","thatthing","false");
        mc.add(mo1);
        mc.add(mo2);

        Iterator <MyObject> iter = mc.iterator();
            while (iter.hasNext()){
            MyObject my = iter.next();
            if (my.getSecret()=="true") {
                System.out.println(my.getSecret());
            }
        }
    }
}