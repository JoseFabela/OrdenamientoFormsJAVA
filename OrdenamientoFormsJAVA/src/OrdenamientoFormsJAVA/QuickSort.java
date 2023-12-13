package OrdenamientoFormsJAVA;

import java.util.Comparator;
import java.util.List;

public class QuickSort<T extends Comparable<T>> implements ISortAlgorithm<T> {

    @Override
    public List<T> sort(List<T> input, Comparator<T> comparator) {
        quickSort(input, comparator, 0, input.size() - 1);
        return input;
    }

    private void quickSort(List<T> input, Comparator<T> comparator, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(input, comparator, low, high);

            quickSort(input, comparator, low, partitionIndex - 1);
            quickSort(input, comparator, partitionIndex + 1, high);
        }
    }

    private int partition(List<T> input, Comparator<T> comparator, int low, int high) {
        T pivot = input.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(input.get(j), pivot) <= 0) {
                i++;
                // Swap input[i] and input[j]
                T temp = input.get(i);
                input.set(i, input.get(j));
                input.set(j, temp);
            }
        }

        // Swap input[i+1] and input[high] (or pivot)
        T temp = input.get(i + 1);
        input.set(i + 1, input.get(high));
        input.set(high, temp);

        return i + 1;
    }
}
