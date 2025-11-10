public class LinearSearch {
    
    public static void analyzePerformance(int[] sizes) {
        System.out.println("Algorithm: Linear Search");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");
        
        for (int size : sizes) {
            // Generate test data
            int[] array = AlgorithmAnalyzer.generateRandomArray(size);
            int target = array[array.length / 2]; // Search for middle element
            
            // Measure execution time
            long startTime = System.nanoTime();
            linearSearch(array, target);
            long endTime = System.nanoTime();
            
            // Convert to milliseconds
            double duration = (endTime - startTime) / 1_000_000.0;
            
            System.out.printf("%-10d | %.4f%n", size, duration);
        }
    }
    
    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // Return index if found
            }
        }
        return -1; // Return -1 if not found
    }
    
    // Additional method for demonstration
    public static void demonstrate() {
        int[] demoArray = {5, 2, 8, 1, 9, 3};
        int target = 8;
        
        System.out.println("Linear Search Demonstration:");
        System.out.println("Array: " + java.util.Arrays.toString(demoArray));
        System.out.println("Searching for: " + target);
        
        int result = linearSearch(demoArray, target);
        if (result != -1) {
            System.out.println("Found at index: " + result);
        } else {
            System.out.println("Not found in array");
        }
    }
}