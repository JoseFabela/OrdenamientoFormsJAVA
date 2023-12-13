package OrdenamientoFormsJAVA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RadixSort<T extends Comparable<T>> implements ISortAlgorithm<T> {

    @Override
    public List<T> sort(List<T> input, Comparator<T> comparator) {
        // Find the maximum number to know the number of digits
        int max = getMax(input);

        // Do counting sort for every digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(input, exp, comparator);
        }

        return input;
    }

    private int getMax(List<T> input) {
        int max = Integer.MIN_VALUE;
        for (T element : input) {
            int value = element.hashCode();
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    private void countingSort(List<T> input, int exp, Comparator<T> comparator) {
        int n = input.size();
        List<T> output = new ArrayList<>(n);
        int[] count = new int[10];

        // Initialize count array
        for (int i = 0; i < 10; i++) {
            count[i] = 0;
        }

        // Store count of occurrences in count[]
        for (T element : input) {
            count[(element.hashCode() / exp) % 10]++;
        }

        // Change count[i] so that count[i] contains the actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output.add(null);
        }
        for (int i = n - 1; i >= 0; i--) {
            output.set(count[(input.get(i).hashCode() / exp) % 10] - 1, input.get(i));
            count[(input.get(i).hashCode() / exp) % 10]--;
        }

        // Copy the output array to input[], so that input[] now contains sorted numbers according to current digit
        for (int i = 0; i < n; i++) {
            input.set(i, output.get(i));
        }
    }
}
