package OrdenamientoFormsJAVA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StraightMergeSort<T extends Comparable<T>> implements ISortAlgorithm<T> {

    @Override
    public List<T> sort(List<T> input, Comparator<T> comparator) {
        int n = input.size();
        List<T> result = new ArrayList<>(input);

        int blockSize = 1;

        while (blockSize < n) {
            for (int leftStart = 0; leftStart < n - 1; leftStart += 2 * blockSize) {
                int leftEnd = Math.min(leftStart + blockSize - 1, n - 1);
                int rightStart = leftStart + blockSize;
                int rightEnd = Math.min(rightStart + blockSize - 1, n - 1);

                merge(result, leftStart, leftEnd, rightStart, rightEnd, comparator);
            }
            blockSize *= 2;
        }

        return result;
    }

    private void merge(List<T> input, int leftStart, int leftEnd, int rightStart, int rightEnd, Comparator<T> comparator) {
        int totalSize = rightEnd - leftStart + 1;
        List<T> mergedBlock = new ArrayList<>(totalSize);

        int leftIndex = leftStart;
        int rightIndex = rightStart;

        while (leftIndex <= leftEnd && rightIndex <= rightEnd) {
            if (comparator.compare(input.get(leftIndex), input.get(rightIndex)) <= 0) {
                mergedBlock.add(input.get(leftIndex));
                leftIndex++;
            } else {
                mergedBlock.add(input.get(rightIndex));
                rightIndex++;
            }
        }

        while (leftIndex <= leftEnd) {
            mergedBlock.add(input.get(leftIndex));
            leftIndex++;
        }

        while (rightIndex <= rightEnd) {
            mergedBlock.add(input.get(rightIndex));
            rightIndex++;
        }

        for (int i = 0; i < totalSize; i++) {
            input.set(leftStart + i, mergedBlock.get(i));
        }
    }
}
