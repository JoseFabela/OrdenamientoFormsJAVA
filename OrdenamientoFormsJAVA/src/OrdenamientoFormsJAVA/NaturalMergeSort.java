package OrdenamientoFormsJAVA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NaturalMergeSort<T extends Comparable<T>> implements ISortAlgorithm<T> {

    @Override
    public List<T> sort(List<T> input, Comparator<T> comparator) {
        int n = input.size();
        List<T> result = new ArrayList<>(input);

        List<Integer> runs = identifyRuns(result, comparator);

        while (runs.size() > 1) {
            List<Integer> newRuns = new ArrayList<>();
            for (int i = 0; i < runs.size(); i += 2) {
                int left = i;
                int right = i + 1;
                if (right < runs.size()) {
                    mergeRuns(result, left, runs.get(left), right, runs.get(right), comparator);
                    newRuns.add(runs.get(left) + runs.get(right));
                } else {
                    newRuns.add(runs.get(left));
                }
            }
            runs = newRuns;
        }

        return result;
    }

    private List<Integer> identifyRuns(List<T> input, Comparator<T> comparator) {
        List<Integer> runs = new ArrayList<>();
        int n = input.size();
        int runLength = 1;

        for (int i = 1; i < n; i++) {
            if (comparator.compare(input.get(i), input.get(i - 1)) < 0) {
                runs.add(runLength);
                runLength = 1;
            } else {
                runLength++;
            }
        }

        runs.add(runLength);
        return runs;
    }

    private void mergeRuns(List<T> input, int leftIndex, int leftRun, int rightIndex, int rightRun, Comparator<T> comparator) {
        int totalSize = leftRun + rightRun;
        List<T> mergedRun = new ArrayList<>(totalSize);

        int leftEnd = leftIndex + leftRun;
        int rightEnd = rightIndex + rightRun;

        while (leftIndex < leftEnd && rightIndex < rightEnd) {
            if (comparator.compare(input.get(leftIndex), input.get(rightIndex)) <= 0) {
                mergedRun.add(input.get(leftIndex));
                leftIndex++;
            } else {
                mergedRun.add(input.get(rightIndex));
                rightIndex++;
            }
        }

        while (leftIndex < leftEnd) {
            mergedRun.add(input.get(leftIndex));
            leftIndex++;
        }

        while (rightIndex < rightEnd) {
            mergedRun.add(input.get(rightIndex));
            rightIndex++;
        }

        for (int i = 0; i < totalSize; i++) {
            input.set(leftIndex - totalSize + i, mergedRun.get(i));
        }
    }
}
