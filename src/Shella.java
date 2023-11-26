import java.util.ArrayList;

public class Shella implements Sorter {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        ArrayList<Integer> copy = new ArrayList<>(input);
        int n = copy.size();
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = copy.get(i);
                int j;
                for (j = i; j >= gap && copy.get(j - gap) > temp; j -= gap) {
                    copy.set(j, copy.get(j - gap));
                }
                copy.set(j, temp);
            }
        }
        return copy;
    }
}