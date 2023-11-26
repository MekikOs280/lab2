import java.util.ArrayList;

public class Bubble implements Sorter{
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> input){
        ArrayList<Integer> copy = new ArrayList<>(input);
        int n = copy.size();
        boolean swap;
        do{
            swap = false;
            for(int i = 1; i < n; i++){
                if(copy.get(i-1) > copy.get(i)){
                    int temp = copy.get(i - 1);
                    copy.set(i - 1, copy.get(i));
                    copy.set(i, temp);
                    swap = true;
                }
            }
        }while(swap);
        return copy;
    }
}
