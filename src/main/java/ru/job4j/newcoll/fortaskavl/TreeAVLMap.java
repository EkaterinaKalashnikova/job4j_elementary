package ru.job4j.newcoll.fortaskavl;

import java.util.*;

public class TreeAVLMap<T extends Comparable<T>, V> {

    private Node root;

    public boolean insert(T key, V value) {
        if (key == null || value == null) {
            return false;
        }
        root = insert(root, key, value);
        return true;
    }

    private Node insert(Node node, T key, V value) {
        if (node == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = insert(node.left, key, value);
        } else if (cmp > 0) {
            node.right = insert(node.right, key, value);
        } else {
            node.value = value;
        }
        updateHeight(node);
        return balance(node);
    }

    public boolean remove(T key) {
        if (key == null || !contains(key)) {
            return false;
        }
        root = remove(root, key);
        return true;
    }

    private Node remove(Node node, T key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = remove(node.left, key);
        } else if (cmp > 0) {
            node.right = remove(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node successor = getMin(node.right);
                node.key = successor.key;
                node.value = successor.value;
                node.right = remove(node.right, successor.key);
            }
        }
        updateHeight(node);
        return balance(node);
    }

    private Node getMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public V get(T key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    private Node getNode(Node node, T key) {
        if (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                return getNode(node.left, key);
            } else if (cmp > 0) {
                return getNode(node.right, key);
            } else {
                return node;
            }
        } else {
            return null;
        }
    }

    public Set<T> keySet() {
        Set<T> keys = new HashSet<>();
        inOrder(root, keys);
        return keys;
    }

    private void inOrder(Node node, Set<T> keys) {
        if (node != null) {
            inOrder(node.left, keys);
            keys.add(node.key);
            inOrder(node.right, keys);
        }
    }

    public Collection<V> values() {
        List<V> values = new ArrayList<>();
        inOrderValues(root, values);
        return values;
    }

    private void inOrderValues(Node node, List<V> values) {
        if (node != null) {
            inOrderValues(node.left, values);
            values.add(node.value);
            inOrderValues(node.right, values);
        }
    }

    private class Node {
        private int balanceFactor;
        private T key;
        private V value;
        private int height;
        private Node left;
        private Node right;

        Node(T key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public boolean contains(T key) {
        return getNode(root, key) != null;
    }

    private void updateHeight(Node node) {
        int leftHeight = (node.left == null) ? -1 : node.left.height;
        int rightHeight = (node.right == null) ? -1 : node.right.height;
        node.height = 1 + Math.max(leftHeight, rightHeight);
        node.balanceFactor = rightHeight - leftHeight;
    }

    private Node balance(Node node) {
        if (node.balanceFactor > 1) {
            if (node.right.balanceFactor < 0) {
                node.right = rightRotation(node.right);
            }
            return leftRotation(node);
        } else if (node.balanceFactor < -1) {
            if (node.left.balanceFactor > 0) {
                node.left = leftRotation(node.left);
            }
            return rightRotation(node);
        }
        return node;
    }

    private Node leftRotation(Node node) {
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }

    private Node rightRotation(Node node) {
        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }
}