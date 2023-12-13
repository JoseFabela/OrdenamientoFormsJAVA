package OrdenamientoFormsJAVA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort<T extends Comparable<T>> implements ISortAlgorithm<T> {

    @Override
    public List<T> sort(List<T> input, Comparator<T> comparator) {
        if (input.size() <= 1) {
            return input;
        }

        int middle = input.size() / 2;
        List<T> left = new ArrayList<>(input.subList(0, middle));
        List<T> right = new ArrayList<>(input.subList(middle, input.size()));

        left = sort(left, comparator);
        right = sort(right, comparator);

        return merge(left, right, comparator);
    }

    private List<T> merge(List<T> left, List<T> right, Comparator<T> comparator) {
        List<T> result = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (comparator.compare(left.get(leftIndex), right.get(rightIndex)) <= 0) {
                result.add(left.get(leftIndex));
                leftIndex++;
            } else {
                result.add(right.get(rightIndex));
                rightIndex++;
            }
        }

        result.addAll(left.subList(leftIndex, left.size()));
        result.addAll(right.subList(rightIndex, right.size()));

        return result;
    }
}
