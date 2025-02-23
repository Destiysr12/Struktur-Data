package Trees;
import java.util.Scanner;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}
class BinarySearchTree {
    Node root;
    BinarySearchTree(){
        root = null;
    }
    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

    boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(Node root, int key) {
        if (root == null) return false;
        if (root.key == key) return  true;
        return key< root.key ? searchRec(root.left, key) :searchRec(root.right, key);
    }

    void inorder() {
        inorderRec(root);
        System.out.println();
    }
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);

        }
    }
    void preorder() {
        preorderRec(root);
        System.out.println();
    }
    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }
    void postorder() {
        postorderRec(root);
        System.out.println();
    }
    void postorderRec(Node root) {
        if (root != null) {
            preorderRec(root.left);
            preorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }
    void delete(int key) {
        root = deleteRec(root, key);
    }
    Node deleteRec(Node root, int key) {
        if (root == null) return  root;
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key < root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }
    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
    public static void main(String[] args) {
        BinarySearchTree bts = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);

        int[] keys = {50, 30, 70, 20, 40, 60, 80};
        for (int key : keys) {
            bts.insert(key);
        }
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Search");
            System.out.println("2. Delete");
            System.out.println("3. Inorder Traversal");
            System.out.println("4. Preorder Traversal");
            System.out.println("5. Postorder Traversal");
            System.out.println("6. Exit");
            System.out.println("Pilih operasi");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Masukan nilai yang ingin di cari: ");
                    int searchKey = scanner.nextInt();
                    System.out.println("Hasil pencarian:" + (bts.search(searchKey) ? "Ditemukan" : "Tidak ditemukan"));
                    break;

                case 2:
                    System.out.print("Masukan nilai yang ingin dihapus: ");
                    int deleteKey = scanner.nextInt();
                    bts.delete(deleteKey);
                    break;

                case 3:
                    System.out.println("Inorder traversal: ");
                    bts.inorder();
                    break;

                case 4:
                    System.out.println("Preorder traversal: ");
                    bts.preorder();
                    break;

                case 5:
                    System.out.println("Postorder traversal: ");
                    bts.postorder();
                    break;

                case 6:
                    System.out.println("Keluar dari program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid, silahkan coba lagi.");
            }

        }
    }

}