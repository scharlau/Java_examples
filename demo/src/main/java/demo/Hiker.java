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
         if ((buzz(num) == 0) && (fizz(num) == 0)){
             return true;
         } else {
            return false;
         }
    }

    public static void main(String[] args){
        System.out.println("Fizz Buzz");
        int i = 1;
        while (i < 101){
            if (Hiker.fizzbuzz(i)==true){
                System.out.println("fizzbuzz");
                i++;
            } else if (Hiker.buzz(i)==0){
                System.out.println("buzz");
                i++;
            }
            else if (Hiker.fizz(i)==0){
                System.out.println("fizz");
                i++;
            } else {
            System.out.println(i);
            i++;
            }
        }
    }

}
