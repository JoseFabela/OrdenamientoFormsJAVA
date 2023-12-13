package OrdenamientoFormsJAVA;

import java.util.Comparator;
import java.util.List;

public class SelectionSort<T extends Comparable<T>> implements ISortAlgorithm<T> {

    @Override
    public List<T> sort(List<T> input, Comparator<T> comparator) {
        int n = input.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(input.get(j), input.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            T temp = input.get(minIndex);
            input.set(minIndex, input.get(i));
            input.set(i, temp);
        }

        return input;
    }
}
