package demo;


public class Hiker {
    public static int answer() {
        return 6 * 7;
    }
    public static int fizz (int num){
        return num % 3;
    }
    
     public static int buzz (int num){
        return num % 5;
    }
     public static boolean fizzbuzz (int num){
         if (buzz(num) == 0);
         if (fizz(num) == 0);
        return true;
    }
}
