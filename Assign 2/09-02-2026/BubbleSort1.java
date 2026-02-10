package Capgg;

public class BubbleSort1 {
    public static void main(String[] args) {
        int[] a = {2, 8, 4, 14, 23, 5, 1};
        System.out.println("Before Sorting:");
        for (int num : a) {
            System.out.print(num + " ");
        }
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println("\nAfter Sorting:");
        for (int num : a) {
            System.out.print(num + " ");
        }
    }
}
