import java.util.Scanner;

public class Quastion1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User enters the number of elements
        System.out.print("Enter the number of integers: ");
        int n = scanner.nextInt();

        // Create an array of the required size
        int[] arr = new int[n];

        // User inputs the integers
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Start merge sort on the entire array
        mergeSort(arr, 0, arr.length - 1);

        // Print the sorted array
        System.out.println("Sorted list:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    // Merge Sort function (recursive)
    public static void mergeSort(int[] arr, int left, int right) {

        // Condition: if left index is less than right — continue splitting
        if (left < right) {

            // Find the middle of the array
            int mid = (left + right) / 2;

            // Recursively sort the left half
            mergeSort(arr, left, mid);

            // Recursively sort the right half
            mergeSort(arr, mid + 1, right);

            // Merge the two sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Function that merges two sorted parts of the array
    public static void merge(int[] arr, int left, int mid, int right) {

        // Calculate sizes of two subarrays
        int n1 = mid - left + 1;   // size of the left part
        int n2 = right - mid;      // size of the right part

        // Create temporary arrays to store these parts
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data into the left temporary array
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }

        // Copy data into the right temporary array
        for (int i = 0; i < n2; i++) {
            R[i] = arr[mid + 1 + i];
        }

        // Indexes for iterating through temporary arrays L and R
        int i = 0, j = 0;

        // Index for the original array arr
        int k = left;

        // Merge arrays L and R back into arr
        while (i < n1 && j < n2) {
            // Take the smaller element from the two arrays and put it into arr
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // If there are remaining elements in the left array — add them
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // If there are remaining elements in the right array — add them
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
