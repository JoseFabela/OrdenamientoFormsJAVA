package OrdenamientoFormsJAVA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BucketSort<T extends Comparable<T>> implements ISortAlgorithm<T> {

    @Override
    public List<T> sort(List<T> input, Comparator<T> comparator) {
        int n = input.size();

        // Find the maximum and minimum values
        T maxVal = Collections.max(input, comparator);
        T minVal = Collections.min(input, comparator);

        // Calculate the range and number of buckets
        int range = n * 10;
        int numBuckets = n / 2;

        // Create buckets
        List<List<T>> buckets = new ArrayList<>(numBuckets);
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        // Assign elements to buckets
        for (T element : input) {
            int bucketIndex = (int) (((float) (element.hashCode() - minVal.hashCode()) / (maxVal.hashCode() - minVal.hashCode())) * (numBuckets - 1));
            buckets.get(bucketIndex).add(element);
        }

        // Sort each bucket
        for (List<T> bucket : buckets) {
            Collections.sort(bucket, comparator);
        }

        // Concatenate buckets
        List<T> result = new ArrayList<>();
        for (List<T> bucket : buckets) {
            result.addAll(bucket);
        }

        return result;
    }
}
