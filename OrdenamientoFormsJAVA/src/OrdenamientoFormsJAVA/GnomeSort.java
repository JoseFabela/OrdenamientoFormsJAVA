package OrdenamientoFormsJAVA;

import java.util.Comparator;
import java.util.List;

public class GnomeSort<T extends Comparable<T>> implements ISortAlgorithm<T> {

    @Override
    public List<T> sort(List<T> input, Comparator<T> comparator) {
        int n = input.size();
        int index = 0;

        while (index < n) {
            if (index == 0) {
                index++;
            }
            if (comparator.compare(input.get(index), input.get(index - 1)) >= 0) {
                index++;
            } else {
                // Swap the elements if they are in the wrong order
                T temp = input.get(index);
                input.set(index, input.get(index - 1));
                input.set(index - 1, temp);
                index--;
            }
        }

        return input;
    }
}
