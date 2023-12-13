package OrdenamientoFormsJAVA;

import java.util.Comparator;
import java.util.List;

public class HeapSort<T extends Comparable<T>> implements ISortAlgorithm<T> {

    @Override
    public List<T> sort(List<T> input, Comparator<T> comparator) {
        int n = input.size();

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(input, n, i, comparator);
        }

        for (int i = n - 1; i > 0; i--) {
            T temp = input.get(0);
            input.set(0, input.get(i));
            input.set(i, temp);

            heapify(input, i, 0, comparator);
        }

        return input;
    }

    private void heapify(List<T> input, int n, int i, Comparator<T> comparator) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && comparator.compare(input.get(left), input.get(largest)) > 0) {
            largest = left;
        }

        if (right < n && comparator.compare(input.get(right), input.get(largest)) > 0) {
            largest = right;
        }

        if (largest != i) {
            T swap = input.get(i);
            input.set(i, input.get(largest));
            input.set(largest, swap);

            heapify(input, n, largest, comparator);
        }
    }
}
