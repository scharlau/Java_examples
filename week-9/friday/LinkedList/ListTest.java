import java.util.NoSuchElementException;


public class ListTest {
    public static void main (String[] args) {
        List<Integer> list = new List<> (); 
        
        list.insertAtFront(-1);
        list.print();
        list.insertAtFront(0);
        list.print();
        list.insertAtFront(1);
        list.print();
        list.insertAtFront(5);
        list.print();


        try {
            int removedItem = list.removeFromFront(); 
            System.out.printf ("%n%d removed%n", removedItem);
            list.print(); 

            removedItem = list.removeFromFront(); 
            System.out.printf ("%n%d removed%n", removedItem);
            list.print(); 

            removedItem = list.removeFromBack(); 
            System.out.printf ("%n%d removed%n", removedItem);
            list.print(); 

            removedItem = list.removeFromBack(); 
            System.out.printf ("%n%d removed%n", removedItem);
            list.print();
        }
        catch (NoSuchElementException noSuchElementException) {
            noSuchElementException.printStackTrace();
        }



        //sorted

        list = new List<> (); 
        
        list.insertSorted(-2);
        list.print();
        list.insertSorted(-2);
        list.print();
        list.insertSorted(1);
        list.print();
        list.insertSorted(0);
        list.print();
        list.insertSorted(-1);
        list.print();
        list.insertSorted(3);
        list.print();
        list.insertSorted(5);
        list.print();
        list.insertSorted(6);
        list.print();
        list.insertSorted(4);
        list.print();

    }


}