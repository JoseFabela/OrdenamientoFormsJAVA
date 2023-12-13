package OrdenamientoFormsJAVA;

import java.util.Comparator;
import java.util.List;

public class BubbleSort<T extends Comparable<T>> implements ISortAlgorithm<T> {

    @Override
    public List<T> sort(List<T> input, Comparator<T> comparator) {
        int n = input.size();
        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (comparator.compare(input.get(i - 1), input.get(i)) > 0) {
                    // Swap elements if they are in the wrong order
                    T temp = input.get(i - 1);
                    input.set(i - 1, input.get(i));
                    input.set(i, temp);
                    swapped = true;
                }
            }
            n--;
        } while (swapped);

        return input;
    }
}

