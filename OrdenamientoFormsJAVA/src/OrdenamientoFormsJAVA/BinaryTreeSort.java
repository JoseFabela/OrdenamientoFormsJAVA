package OrdenamientoFormsJAVA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeSort<T extends Comparable<T>> implements ISortAlgorithm<T> {

    private static class Node<T> {
        T data;
        Node<T> left, right;

        public Node(T item) {
            data = item;
            left = right = null;
        }
    }

    @Override
    public List<T> sort(List<T> input, Comparator<T> comparator) {
        Node<T> root = null;

        for (T item : input) {
            root = insert(root, item, comparator);
        }

        List<T> result = new ArrayList<>();
        inOrderTraversal(root, result);

        return result;
    }

    private Node<T> insert(Node<T> root, T key, Comparator<T> comparator) {
        if (root == null) {
            root = new Node<>(key);
            return root;
        }

        if (comparator.compare(key, root.data) < 0) {
            root.left = insert(root.left, key, comparator);
        } else if (comparator.compare(key, root.data) > 0) {
            root.right = insert(root.right, key, comparator);
        }

        return root;
    }

    private void inOrderTraversal(Node<T> root, List<T> result) {
        if (root != null) {
            inOrderTraversal(root.left, result);
            result.add(root.data);
            inOrderTraversal(root.right, result);
        }
    }
}
