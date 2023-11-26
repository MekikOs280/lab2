import java.util.ArrayList;
import java.util.Random;
public class Main {
    public static void main(String[] args){
        for (int count : new int[]{10, 1000, 10000, 1000000}) {
            System.out.println("Number of elements: " + count);
            ArrayList<Integer> input = generateRandomArray(count, count);

            for (SortingType.TypeEnum type : SortingType.TypeEnum.values()) {
                System.out.println("Sorting type: " + type);
                Sorter sorter = getSorter(type);
                long startTime = System.currentTimeMillis();
                ArrayList<Integer> sortedArray = sorter.sort(new ArrayList<>(input));
                long endTime = System.currentTimeMillis();

                System.out.println("Time taken: " + (endTime - startTime) + " ms");
                System.out.println("Sorted array: " + sortedArray);
            }
            System.out.println();
        }
    }

    public static ArrayList<Integer> generateRandomArray(int size, int max) {
        ArrayList<Integer> randomArray = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            randomArray.add(random.nextInt(max + 1));
        }
        return randomArray;
    }

    public static Sorter getSorter(SortingType.TypeEnum type) {
        return switch (type) {
            case BUBBLE -> new Bubble();
            case SHELL -> new Shella();
            case MERGE -> new merge();
            case QUICK -> new Quick();

        };
    }
}