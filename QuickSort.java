public class QuickSort {
    
    public static void analyzePerformance(int[] sizes) {
        System.out.println("Algorithm: Quick Sort");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");
        
        for (int size : sizes) {
            // Generate test data
            int[] array = AlgorithmAnalyzer.generateRandomArray(size);
            int[] arrayCopy = array.clone(); // Keep original for multiple runs
            
            // Measure execution time
            long startTime = System.nanoTime();
            quickSort(arrayCopy, 0, arrayCopy.length - 1);
            long endTime = System.nanoTime();
            
            // Convert to milliseconds
            double duration = (endTime - startTime) / 1_000_000.0;
            
            System.out.printf("%-10d | %.4f%n", size, duration);
        }
    }
    
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(array, low, high);
            
            // Recursively sort elements before and after partition
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }
    
    private static int partition(int[] array, int low, int high) {
        // Choose the rightmost element as pivot
        int pivot = array[high];
        
        // Index of smaller element
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (array[j] <= pivot) {
                i++;
                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        
        // Swap array[i+1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        
        return i + 1;
    }
    
    public static void demonstrate() {
        int[] demoArray = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("Quick Sort Demonstration:");
        System.out.println("Original array: " + java.util.Arrays.toString(demoArray));
        
        quickSort(demoArray, 0, demoArray.length - 1);
        System.out.println("Sorted array: " + java.util.Arrays.toString(demoArray));
    }
}