package OrdenamientoFormsJAVA;

import java.util.Comparator;
import java.util.List;

public class ShellSort<T extends Comparable<T>> implements ISortAlgorithm<T> {

    @Override
    public List<T> sort(List<T> input, Comparator<T> comparator) {
        int n = input.size();
        
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                T temp = input.get(i);
                int j;
                for (j = i; j >= gap && comparator.compare(input.get(j - gap), temp) > 0; j -= gap) {
                    input.set(j, input.get(j - gap));
                }
                input.set(j, temp);
            }
        }
        return input;
    }
}
