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

    /**
     * mease speed of bubblesort algorithm
     * @param list
     * @param length
     */
    private static void measure(ArrayList<Integer> list, int length) {
        double startTime = 0, stopTime = 0, avgTime = 0, avgSteps = 0;

        for (int i = 0; i < 1000; i++) {
            fill(list, length);

            startTime += System.nanoTime();
            avgSteps += sort(list);
            stopTime += System.nanoTime();
        }

        avgTime = ((stopTime - startTime) / 10) / 1000000000;
        avgSteps /= 10;

        System.out.println("Average steps: " + avgSteps);
        System.out.println("Average runtime: " + avgTime + " seconds");
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        fill(list, 10);

        System.out.println("Before sorting: " + list);
        sort(list);
        System.out.println("After sorting: " + list);
    }
}
