public class BubbleSort {
    
    public static void analyzePerformance(int[] sizes) {
        System.out.println("Algorithm: Bubble Sort");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");
        
        for (int size : sizes) {
            // Generate test data
            int[] array = AlgorithmAnalyzer.generateRandomArray(size);
            int[] arrayCopy = array.clone(); // Keep original for multiple runs
            
            // Measure execution time
            long startTime = System.nanoTime();
            bubbleSort(arrayCopy);
            long endTime = System.nanoTime();
            
            // Convert to milliseconds
            double duration = (endTime - startTime) / 1_000_000.0;
            
            System.out.printf("%-10d | %.4f%n", size, duration);
        }
    }
    
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no swapping occurred, array is sorted
            if (!swapped) break;
        }
    }
    
    public static void demonstrate() {
        int[] demoArray = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("Bubble Sort Demonstration:");
        System.out.println("Original array: " + java.util.Arrays.toString(demoArray));
        
        bubbleSort(demoArray);
        System.out.println("Sorted array: " + java.util.Arrays.toString(demoArray));
    }
}