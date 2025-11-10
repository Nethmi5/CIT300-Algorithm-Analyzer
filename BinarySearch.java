import java.util.Arrays;

public class BinarySearch {
    
    public static void analyzePerformance(int[] sizes) {
        System.out.println("Algorithm: Binary Search");
        System.out.println("Note: Array is sorted first, then search is performed");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");
        
        for (int size : sizes) {
            // Generate sorted test data
            int[] array = AlgorithmAnalyzer.generateSortedArray(size);
            int target = array[array.length / 2]; // Search for middle element
            
            // Measure execution time
            long startTime = System.nanoTime();
            binarySearch(array, target);
            long endTime = System.nanoTime();
            
            // Convert to milliseconds
            double duration = (endTime - startTime) / 1_000_000.0;
            
            System.out.printf("%-10d | %.4f%n", size, duration);
        }
    }
    
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Element not found
    }
    
    // Method to demonstrate sorting + binary search
    public static void demonstrate() {
        int[] demoArray = AlgorithmAnalyzer.generateRandomArray(10);
        int target = demoArray[5];
        
        System.out.println("Binary Search Demonstration:");
        System.out.println("Original array: " + Arrays.toString(demoArray));
        
        // Sort the array first
        Arrays.sort(demoArray);
        System.out.println("Sorted array: " + Arrays.toString(demoArray));
        System.out.println("Searching for: " + target);
        
        int result = binarySearch(demoArray, target);
        if (result != -1) {
            System.out.println("Found at index: " + result);
        } else {
            System.out.println("Not found in array");
        }
    }
}
