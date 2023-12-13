package OrdenamientoFormsJAVA;

import java.util.Comparator;
import java.util.List;

public class CocktailSort<T extends Comparable<T>> implements ISortAlgorithm<T> {

    @Override
    public List<T> sort(List<T> input, Comparator<T> comparator) {
        boolean swapped;
        int start = 0;
        int end = input.size();

        do {
            swapped = false;

            // Forward pass
            for (int i = start; i < end - 1; ++i) {
                if (comparator.compare(input.get(i), input.get(i + 1)) > 0) {
                    T temp = input.get(i);
                    input.set(i, input.get(i + 1));
                    input.set(i + 1, temp);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;  // If no swap occurs, the array is already sorted
            }

            swapped = false;

            // Backward pass
            end--;

            for (int i = end - 1; i >= start; --i) {
                if (comparator.compare(input.get(i), input.get(i + 1)) > 0) {
                    T temp = input.get(i);
                    input.set(i, input.get(i + 1));
                    input.set(i + 1, temp);
                    swapped = true;
                }
            }

            start++;

        } while (swapped);

        return input;
    }
}
