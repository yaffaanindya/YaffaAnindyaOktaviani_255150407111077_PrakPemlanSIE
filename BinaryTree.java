import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    public void add(String data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        root.add(data);
    }

    // --- Kumpulan Method Traversal (Soal 4 & 9) ---

    public void preTraverse(Node node) {
        if (node == null) return;
        System.out.printf("[%s]", node.data);
        preTraverse(node.left);
        preTraverse(node.right);
    }

    public void inTraverse(Node node) {
        if (node == null) return;
        inTraverse(node.left);
        System.out.printf("[%s]", node.data);
        inTraverse(node.right);
    }

    public void postTraverse(Node node) {
        if (node == null) return;
        postTraverse(node.left);
        postTraverse(node.right);
        System.out.printf("[%s]", node.data);
    }

    // Algoritma Level-Order menggunakan Queue
    public void levelTraverse(Node node) {
        if (node == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.printf("[%s]", current.data);

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    public int countNodes(Node node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public int countLeaves(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }

    public int getHeight(Node node) {
        if (node == null) return -1;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        String[] dataset = {"Mangga", "Apel", "Zebra", "Durian", "Sirsak", "Jambu", "Melon"};
        
        System.out.println("Proses Input Data:");
        for (String s : dataset) {
            System.out.println("Input: " + s);
            tree.add(s);
        }

        System.out.println("\n--- Perbandingan Traversal ---");
        System.out.print("Pre-Order   : "); tree.preTraverse(tree.root);
        System.out.print("\nIn-Order    : "); tree.inTraverse(tree.root);
        System.out.print("\nPost-Order  : "); tree.postTraverse(tree.root);
        System.out.print("\nLevel-Order : "); tree.levelTraverse(tree.root);
        
        System.out.println("\n\n--- Statistik Tree ---");
        System.out.println("Total Node   : " + tree.countNodes(tree.root));
        System.out.println("Total Daun   : " + tree.countLeaves(tree.root));
        System.out.println("Tinggi Pohon : " + tree.getHeight(tree.root));
    }
}