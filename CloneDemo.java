import java.util.Arrays;

public class CloneDemo {
    public static void main(String[] args) {
        int[] array1 = { 1, 2, 3 };
        int[] array2 = array1;
        int[] array3 = array1.clone();

        array1[0] = 0;
        array1[1] = 0;
        array1[2] = 0;

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
        System.out.println("object" + array1.hashCode());
        System.out.println("object" + array2.hashCode());
        System.out.println("object" + array3.hashCode());
    }
}