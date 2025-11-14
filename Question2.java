import java.util.Scanner;

public class Question2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the size of the array
        System.out.print("Enter the number of integers: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        // User inputs the array (must be sorted)
        System.out.println("Enter " + n + " sorted integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Ask the user for the target number to search for
        System.out.print("Enter the number to search: ");
        int target = scanner.nextInt();

        // Call binary search function
        int index = binarySearch(arr, target);

        // Print result
        if (index == -1) {
            System.out.println("Number not found.");
        } else {
            System.out.println("Number found at index: " + index);
        }
    }

    // Binary Search algorithm
    // Returns the index of the target if found, otherwise returns -1
    public static int binarySearch(int[] arr, int target) {

        int left = 0;                // start of the search range
        int right = arr.length - 1;  // end of the search range

        while (left <= right) {

            // Find the middle index
            int mid = (left + right) / 2;

            // Check if the middle element is equal to the target
            if (arr[mid] == target) {
                return mid; // number found
            }

            // If target is larger — ignore the left half
            if (target > arr[mid]) {
                left = mid + 1;
            }
            // If target is smaller — ignore the right half
            else {
                right = mid - 1;
            }
        }

        // If we finish the loop, the number is not in the array
        return -1;
    }
}
