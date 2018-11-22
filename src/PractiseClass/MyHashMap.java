
package PractiseClass;
// use linkedlist to solve the collision
public class MyHashMap<K, V> {
    private static class Node<K, V> { // Node rely on the HashMap class not the instance
        private final K key;
        private V value;
        Node<K, V> next;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private int hash(K key) {
        if (key == null) {
            return 0;
        }
        int hashNumber = key.hashCode();
        return hashNumber & 0x7fffffff;

    }
    private int getIndex(K key) {
        return hash(key) % array.length;
    }

    private boolean match(K key1, K key2) {
        if (key1 == null && key2 == null) {
            return true;
        } else if (key1 == null || key2 == null) {
            return false;
        } else {
            return key1.equals(key2);
        }
    }

    private void expand() {
        Node<K, V>[] tempArray = array;
        array = (Node<K, V>[]) new Node[SCALE_FACTOR * array.length]; // if not assign, the length still is the old one
        for (Node<K, V> node : tempArray) {
            while (node != null) {
                Node<K, V> next = node.next; // put the node into the head
                int index = getIndex(node.getKey());
                node.next = array[index];
                array[index] = node;
                node = next;
            }
        }
    }

    private Node<K, V>[] array;
    private int size; // amount of the element in the map
    private static final int INITIAL_CAP = 10;
    private static final int SCALE_FACTOR = 2;
    private static final double LOAD_FACTOE = 0.75;

    public MyHashMap() {
        array = (Node<K, V>[]) new Node[INITIAL_CAP];
    }

    public MyHashMap(int cap) {
        array = (Node<K, V>[]) new Node[cap];
    }

    public V put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> head = array[index];
        while (head != null) {
            if (match(head.getKey(), key)) {
                V prevValue = head.getValue();
                head.setValue(value);
                return prevValue;
            }
            head = head.next;
        }
        Node<K, V> newEntry = new Node<>(key, value);
        newEntry.next = array[index];
        array[index] = newEntry;
        size++;
        if (size >= LOAD_FACTOE * array.length) {
            expand();
        }
        return null;
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> head = array[index];
        while (head != null) {
            head = head.next;
            if (match(head.key, key)) {
                return head.getValue();
            }
        }
        return null;
    }
 // if input key is null ??????
    public boolean containsKey(K key) {
        int index = getIndex(key);
        Node<K, V> head = array[index];
        while (head != null) { // even the key of the node is null, the node itself is not null
            head = head.next;
            if (match(head.key, key)) {
                return true;
            }
        }
        return false;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;

    }

    public V remove(K key) {
        int index = getIndex(key);
        Node<K, V> head = array[index];
        Node<K, V> prev = head;
        // when we try to remove :
        // there is two case:
        // 1. if the head match, delete the head
        // 2. if the middle match, delete the middle node
        while (head != null) {
            if (match(head.getKey(), key)) {
                V value = head.getValue();
                if (prev == null) {
                    array[index] = head.next;
                } else {
                    prev.next = head.next;
                }
                size--;
                return value;

            }
            prev = head;
            head = head.next;
        }
        return null;
    }

}
