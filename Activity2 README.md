Part 1 – Scenario Based Analysis

Scenario	Choice	Complexity
Real-time chat message storage	LinkedList	Insertion: O(1)
Music playlist (frequently reordered)	LinkedList	Reordering: O(1)
Student database (search by index)	ArrayList	Access: O(1)
Browser back and forward navigation	LinkedList	Navigation: O(1)
Online exam (sequential answers)	ArrayList	Sequential access: O(1)

Part 2 – Coding Challenges

Task A – ArrayList Advanced

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTask {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        int[] input = {12, 45, 7, 22, 89, 2, 33, 60, 15, 10};
        for (int n : input) {
            numbers.add(n);
        }
        System.out.println("Original List: " + numbers);
        numbers.removeIf(n -> n % 2 == 0);
        System.out.println("After removing evens: " + numbers);
        if (!numbers.isEmpty()) {
            int max = Collections.max(numbers);
            int min = Collections.min(numbers);
            System.out.println("Max: " + max + " | Min: " + min);
            Collections.sort(numbers, Collections.reverseOrder());
            System.out.println("Sorted Descending: " + numbers);
        }
    }
}

Task B – LinkedList (Hospital Queue)

import java.util.LinkedList;

public class HospitalQueue {
    public static void main(String[] args) {
        LinkedList<String> patientQueue = new LinkedList<>();
        patientQueue.add("Patient A");
        patientQueue.add("Patient B");
        patientQueue.add("Patient C");
        patientQueue.add("Patient D");
        patientQueue.add("Patient E");
        System.out.println("Initial Queue: " + patientQueue);
        patientQueue.addFirst("EMERGENCY PATIENT");
        System.out.println("After Emergency: " + patientQueue);
        System.out.println("Treated: " + patientQueue.removeFirst());
        System.out.println("Treated: " + patientQueue.removeFirst());
        System.out.println("Remaining Queue: " + patientQueue);
    }
}

Part 3 – Singly Linked List 

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CustomLinkedList {
    Node head;
    public void insertAt(int data, int pos) {
        Node newNode = new Node(data);
        if (pos == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        for (int i = 0; i < pos - 1; i++) {
            if (temp == null) return;
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public void deleteByValue(int value) {
        if (head == null) return;
        if (head.data == value) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
    public int countNodes() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
    public int getMiddle() {
        if (head == null) return -1;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
    public void reverse() {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.insertAt(10, 0);
        list.insertAt(20, 1);
        list.insertAt(30, 2);
        list.insertAt(15, 1);
        list.display();
        System.out.println("Middle Element: " + list.getMiddle());
        System.out.println("Total Nodes: " + list.countNodes());
        list.reverse();
        list.display();
    }
}

Part 4-Viva Questions – Answers

1.What is amortized time complexity?
Average time per operation over a sequence of operations.

2.Why is ArrayList resizing expensive?
Requires allocating a new array and copying all elements.

3.How does LinkedList store elements?
Using nodes containing data and reference to the next node.

4.Difference between Singly and Doubly Linked List?
Singly has one pointer (next). Doubly has two (next, prev).

5.Space complexity of LinkedList?
O(n), with extra memory for pointers.
