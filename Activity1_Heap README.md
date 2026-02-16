2. Activity Tasks
• Task 1: Create a Binary Search Tree and insert the following elements: 50, 30, 70, 20, 40, 60,
80.
• Task 2: Perform Inorder, Preorder, and Postorder traversal.
• Task 3: Search for element 40 and 100 in the BST.
• Task 4: Implement a Min-Heap using Java PriorityQueue.
• Task 5: Insert 10 random numbers into Min-Heap and print them in sorted order.
CODE:
package practice;
import java.util.PriorityQueue;
import java.util.Random;
class BST {
    class Node {
        int data;
        Node left, right;
        Node(int value) {
            data = value;
            left = right = null;
        }
    }
    Node root;
    // Insert
    Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }
        return root;
    }
    // Search
    boolean search(Node root, int key) {
        if (root == null) return false;
        if (key == root.data) return true;
        if (key < root.data)
            return search(root.left, key);
        else
            return search(root.right, key);
    }
    // Inorder
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    // Preorder
    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    // Postorder
    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
}
public class Binaryst {
    public static void main(String[] args) {
        System.out.println("===== Binary Search Tree =====");
        BST tree = new BST();
        int[] elements = {50, 30, 70, 20, 40, 60, 80};
        for (int value : elements) {
            tree.root = tree.insert(tree.root, value);
        }
        System.out.print("Inorder Traversal: ");
        tree.inorder(tree.root);
        System.out.println();
        System.out.print("Preorder Traversal: ");
        tree.preorder(tree.root);
        System.out.println();
        System.out.print("Postorder Traversal: ");
        tree.postorder(tree.root);
        System.out.println();
        System.out.println("Search 40: " + (tree.search(tree.root, 40) ? "Found" : "Not Found"));
        System.out.println("Search 100: " + (tree.search(tree.root, 100) ? "Found" : "Not Found"));
        System.out.println("\n===== Min Heap (PriorityQueue) =====");
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Random rand = new Random();
        System.out.print("Inserted Numbers: ");
        for (int i = 0; i < 10; i++) {
            int num = rand.nextInt(100);
            minHeap.add(num);
            System.out.print(num + " ");
        }
        System.out.println("\nSorted Order (Min-Heap): ");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
    }
}
OUTPUT:
<img width="425" height="248" alt="heap1" src="https://github.com/user-attachments/assets/eb3dcaec-a720-49ae-ad0e-caaaca42799c" />

Binary Search Tree (BST)
Elements Inserted:

50, 30, 70, 20, 40, 60, 80

BST Structure:
        50
       /  \
     30    70
    /  \   /  \
  20   40 60   80

🔹 Operations Performed
1. Insert

Elements are inserted following BST property:

Left child < Root

Right child > Root

2. Traversals

Inorder (LNR):
20 30 40 50 60 70 80

Preorder (NLR):
50 30 20 40 70 60 80

Postorder (LRN):
20 40 30 60 80 70 50

3. Search

Search 40 → Found
Search 100 → Not Found

🧱 Min-Heap (PriorityQueue)

Implemented using Java PriorityQueue

Inserted 10 random numbers

Printed in sorted (ascending) order

Example Output:
1 3 10 12 25 34 45 56 78 89

⏱ Time Complexity Analysis
BST

Insert → O(log n) average, O(n) worst
Search → O(log n) average, O(n) worst
Traversal → O(n)

Worst case occurs when tree becomes skewed.

Min-Heap

Insert → O(log n)
Remove → O(log n)
Peek → O(1)

