import java.util.ArrayList;
import java.util.Random;

public class Bubblesort {
    /**
     * best case: O(n)
     * average case: O(n^2)
     * worst case: O(n^2)
     * @param list to be sorted using a bubblesort algorithm
     * @return number of shifts needed to sort
     */
    private static long sort(ArrayList<Integer> list) {
        long counter = 0;

        for (int i = list.size(); i > 1; i--) {
            boolean isTrue = false;

            for (int j = 0; j < i-1; j++) {
                if (list.get(j) > list.get(j+1)) {
                    int tmpVal = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, tmpVal);

                    counter++;
                    isTrue = true;
                }
            }

            if (!isTrue) break; // Optimization -> break if no more shifts happened
        }

        return counter;
    }

    private static void fill(ArrayList<Integer> list, int length) {
        if (length <= 0) {
            System.out.println("length must be at least 1");
            return;
        }

        if (!list.isEmpty()) {
            list.clear();
        }

        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            list.add(rand.nextInt(1000000));   // numbers between 0 and 1 million
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        fill(list, 10); /* new comment! this here adds 10 elements to list */

        System.out.println("Before sorting: " + list);
        sort(list);
        System.out.println("After sorting: " + list);
    }
}
