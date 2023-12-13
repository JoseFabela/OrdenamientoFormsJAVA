package OrdenamientoFormsJAVA;

import java.util.Comparator;
import java.util.List;

public class InsertionSort<T extends Comparable<T>> implements ISortAlgorithm<T> {

    @Override
    public List<T> sort(List<T> input, Comparator<T> comparator) {
        int n = input.size();

        for (int i = 1; i < n; ++i) {
            T key = input.get(i);
            int j = i - 1;

            while (j >= 0 && comparator.compare(input.get(j), key) > 0) {
                input.set(j + 1, input.get(j));
                j = j - 1;
            }

            input.set(j + 1, key);
        }

        return input;
    }
}
