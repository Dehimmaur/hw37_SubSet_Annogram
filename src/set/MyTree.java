package set;

import java.util.ArrayList;
import java.util.List;

public class MyTree {

    private static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node root, int value) {
        if (root == null)
            return new Node(value);
        if (value < root.value)
            root.left = addRecursive(root.left, value);
        else if (value > root.value)
            root.right = addRecursive(root.right, value);
        return root;
    }

    public void traverse() {
        traverseRecursive(root);
    }

    private void traverseRecursive(Node root) {
        if (root != null) {
            traverseRecursive(root.left);
            System.out.print(root.value + " ");
            traverseRecursive(root.right);
        }
    }

    public boolean contains(int value) {
        return searchRecursive(root, value) != null;
    }

    private Node searchRecursive(Node root, int value) {
        if (root == null || root.value == value)
            return root;
        if (value < root.value)
            return searchRecursive(root.left, value);
        return searchRecursive(root.right, value);
    }

    private int findSmall(Node node) {
        return node.left == null ? node.value : findSmall(node.left);
    }

    public void remove(int value) {
        root = removeRecursive(root, value);
    }

    private Node removeRecursive(Node root, int value) {
        if (root == null)
            return null;
        if (root.value == value) {
            if (root.left == null && root.right == null) return null;   // no children
            // one child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            // two children
            int small = findSmall(root.right);
            root.value = small;
            root.right = removeRecursive(root.right, small);
        } else if (value < root.value) {
            root.left = removeRecursive(root.left, value);
        } else {
            root.right = removeRecursive(root.right, value);
        }
        return root;
    }

    // ============= SubSet =========================
    public List<Integer> subSet(int from, int to) {
        List<Integer> result = new ArrayList<>();
        subSetRecursive(root, from, to, result);
        return result;
    }

    private void subSetRecursive(Node node, int from, int to, List<Integer> result) {
        if (node == null) return;
        if (node.value > from) {
            subSetRecursive(node.left, from, to, result);
        }
        if (node.value >= from && node.value < to) {
            result.add(node.value);
        }
        if (node.value < to) {
            subSetRecursive(node.right, from, to, result);
        }
    }
}
