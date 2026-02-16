package Capgg;
class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;
    MinHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }
    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }
        heap[size] = value;
        size++;
        heapifyUp(size - 1);
    }
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap[index] < heap[parent]) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }
    public int extractMin() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return min;
    }
    private void heapifyDown(int index) {
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;
            if (left < size && heap[left] < heap[smallest])
                smallest = left;
            if (right < size && heap[right] < heap[smallest])
                smallest = right;
            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }
    public boolean contains(int value) {
        for (int i = 0; i < size; i++) {
            if (heap[i] == value)
                return true;
        }
        return false;
    }
    public int parentIndex(int index) {
        if (index <= 0 || index >= size)
            return -1;
        return (index - 1) / 2;
    }
    public int leftChildIndex(int index) {
        int left = 2 * index + 1;
        if (left >= size)
            return -1;
        return left;
    }
    public int rightChildIndex(int index) {
        int right = 2 * index + 2;
        if (right >= size)
            return -1;
        return right;
    }
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
public class Heap1 {
    public static void main(String[] args) {
        MinHeap heap = new MinHeap(10);
        heap.insert(50);
        heap.insert(30);
        heap.insert(20);
        heap.insert(10);
        heap.insert(40);
        System.out.println("Heap Elements:");
        heap.printHeap();
        System.out.println("Contains 20? " + heap.contains(20));
        System.out.println("Contains 99? " + heap.contains(99));
        System.out.println("Parent index of 3: " + heap.parentIndex(3));
        System.out.println("Left child index of 1: " + heap.leftChildIndex(1));
        System.out.println("Right child index of 1: " + heap.rightChildIndex(1));
        System.out.println("Extract Min: " + heap.extractMin());
        System.out.println("After Extraction:");
        heap.printHeap();
    }
}
