package SingleLinkedListProject;

public class SingleLinkedList {

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
            tail = data;
        }
        size++;
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

    //B
    Node get(int index) {
        if (index < 0 || index >= size) return null;

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    //C
    void removeAt(int index) {
        if (index < 0 || index >= size) return;

        if (index == 0) {
            head = head.next;
            if (head == null) tail = null;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            if (current.next == null) tail = current;
        }
        size--;
    }

    //D
    void remove(Object data) {
        if (head == null) return;

        if (head.data.equals(data)) {
            head = head.next;
            if (head == null) tail = null;
            size--;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                if (current.next == null) tail = current;
                size--;
                return;
            }
            current = current.next;
        }
    }

    //E
    void addAt(int index, Node data) {
        if (index < 0 || index > size) return;

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

    //F
    void addAfter(Object key, Node data) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(key)) {
                data.next = current.next;
                current.next = data;
                if (current == tail) tail = data;
                size++;
                return;
            }
            current = current.next;
        }
    }

    //G
    void addBefore(Object key, Node data) {
        if (head == null) return;

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

        SingleLinkedList list = new SingleLinkedList();

        System.out.println("Head: " + list.head);
        System.out.println("Tail: " + list.tail);

        list.addFirst(new Node("A"));
        System.out.println("Head: " + list.head.data);
        System.out.println("Tail: " + list.tail.data);

        list.addFirst(new Node("B"));
        System.out.println("Head: " + list.head.data);
        System.out.println("Tail: " + list.tail.data);

        list.addLast(new Node("C"));
        System.out.println("Head: " + list.head.data);
        System.out.println("Tail: " + list.tail.data);

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