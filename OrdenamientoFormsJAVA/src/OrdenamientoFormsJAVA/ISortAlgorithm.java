package OrdenamientoFormsJAVA;

import java.util.Comparator;
import java.util.List;

public interface ISortAlgorithm<T extends Comparable<T>> {
    List<T> sort(List<T> input, Comparator<T> comparator);
}