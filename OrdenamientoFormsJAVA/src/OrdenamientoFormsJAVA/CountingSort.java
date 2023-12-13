package OrdenamientoFormsJAVA;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountingSort<T extends Comparable<T>> implements ISortAlgorithm<T> {

    @Override
    public List<T> sort(List<T> input, Comparator<T> comparator) {
        Map<T, Integer> countMap = new HashMap<>();

        for (T element : input) {
            countMap.put(element, countMap.getOrDefault(element, 0) + 1);
        }

        int index = 0;
        for (T key : countMap.keySet()) {
            int count = countMap.get(key);
            for (int i = 0; i < count; i++) {
                input.set(index++, key);
            }
        }

        return input;
    }
}
