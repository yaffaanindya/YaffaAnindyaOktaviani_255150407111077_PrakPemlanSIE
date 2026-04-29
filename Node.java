class Node {
    String data; // Perubahan: int ke String
    Node left, right;

    Node(String data) {
        this.data = data;
    }

    // Method add menggunakan compareTo untuk perbandingan alfabetis
    public void add(String data) {
        if (data.compareTo(this.data) > 0) { 
            if (this.right == null) this.right = new Node(data);
            else this.right.add(data);
        } else if (data.compareTo(this.data) < 0) {
            if (this.left == null) this.left = new Node(data);
            else this.left.add(data);
        }
    }
}