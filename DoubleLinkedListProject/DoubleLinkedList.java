package DoubleLinkedListProject;

public class DoubleLinkedList {
    Node head, tail;
    int size = 0;

    void init() {
        head = null;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    void addFirst(Node data) {
        if (isEmpty()) {
            head = data;
            tail = data;
        } else {
            data.next = head;
            head.prev = data;
            head = data;
        }
        size++;
    }

    void addLast(Node data) {
        if (isEmpty()) {
            head = data;
            tail = data;
        } else {
            tail.next = data;
            data.prev = tail;
            tail = data;
        }
        size++;
    }

    void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    void printReverse() {
        Node current = tail;
        while (current != null) {
            System.out.println(current.data);
            current = current.prev;
        }
    }

    // A
    Node find(Object data) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // B
    Node get(int index) {
        if (index < 0 || index >= size)
            return null;

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    // C
    void removeAt(int index) {
        if (index < 0 || index >= size)
            return;

        if (index == 0) {
            head = head.next;
            if (head == null)
                tail = null;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            if (current.next == null)
                tail = current;
        }
        size--;
    }

    // D
    void remove(Object data) {
        if (head == null)
            return;

        if (head.data.equals(data)) {
            head = head.next;
            if (head == null)
                tail = null;
            size--;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                if (current.next == null)
                    tail = current;
                size--;
                return;
            }
            current = current.next;
        }
    }

    // E
    void addAt(int index, Node data) {
        if (index < 0 || index > size)
            return;

        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            data.next = current.next;
            current.next = data;
            size++;
        }
    }

    // F
    void addAfter(Object key, Node data) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(key)) {
                data.next = current.next;
                current.next = data;
                if (current == tail)
                    tail = data;
                size++;
                return;
            }
            current = current.next;
        }
    }

    // G
    void addBefore(Object key, Node data) {
        if (head == null)
            return;

        if (head.data.equals(key)) {
            addFirst(data);
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(key)) {
                data.next = current.next;
                current.next = data;
                size++;
                return;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");

        list.addLast(nodeA);
        System.out.println("head: " + list.head.data);
        System.out.println("tail: " + list.tail.data);

        list.addFirst(nodeB);
        System.out.println("head: " + list.head.data);
        System.out.println("tail: " + list.tail.data);

        list.addFirst(nodeC);
        System.out.println("head: " + list.head.data);
        System.out.println("tail: " + list.tail.data);

        list.print();

        System.out.println("Next of B: " + nodeB.next.data);
        System.out.println("Prev of B: " + nodeB.prev.data);

        System.out.println("Reverse:");
        list.printReverse();

        System.out.println("\n=== TEST METHOD ===");

        // a. find
        System.out.println("Find B: " + (list.find("B") != null ? list.find("B").data : null));

        // b. get index
        System.out.println("Get index 1: " + (list.get(1) != null ? list.get(1).data : null));

        // e. addAt
        list.addAt(1, new Node("X"));
        System.out.println("After addAt(1, X): " + list.get(1).data);

        // f. addAfter
        list.addAfter("B", new Node("Y"));
        System.out.println("After addAfter B (Y): " + list.find("Y").data);

        // g. addBefore
        list.addBefore("A", new Node("Z"));
        System.out.println("After addBefore A (Z): " + list.find("Z").data);

        // c. removeAt
        list.removeAt(2);
        System.out.println("After removeAt(2): " + (list.get(2) != null ? list.get(2).data : null));

        // d. remove by value
        list.remove("B");
        System.out.println("After remove B: " + (list.find("B") != null ? list.find("B").data : null));
    }
}