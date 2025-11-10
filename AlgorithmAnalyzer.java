// AlgorithmAnalyzer.java
import java.util.*;

public class AlgorithmAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("CIT300 Algorithm Analyzer");
        System.out.println("=========================");
        System.out.println("1. Linear Search - 22UG3-0504");
        System.out.println("2. Binary Search - 22UG3-0504");
        System.out.println("3. Bubble Sort - 22UG3-0504");
        System.out.println("4. Quick Sort - 22UG3-0504");
        System.out.println("5. Run All Algorithms");
        System.out.println("6. Individual Demonstrations");
        System.out.print("Choose an option (1-6): ");
        
        int choice = scanner.nextInt();
        
        // Test sizes as per requirements
        int[] sizes = {100, 500, 1000};
        
        switch(choice) {
            case 1:
                LinearSearch.analyzePerformance(sizes);
                break;
            case 2:
                BinarySearch.analyzePerformance(sizes);
                break;
            case 3:
                BubbleSort.analyzePerformance(sizes);
                break;
            case 4:
                QuickSort.analyzePerformance(sizes);
                break;
            case 5:
                runAllAlgorithms(sizes);
                break;
            case 6:
                runAllDemonstrations();
                break;
            default:
                System.out.println("Invalid choice!");
        }
        
        scanner.close();
    }
    
    private static void runAllAlgorithms(int[] sizes) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("RUNNING ALL ALGORITHMS - PERFORMANCE ANALYSIS");
        System.out.println("=".repeat(50));
        
        LinearSearch.analyzePerformance(sizes);
        
        System.out.println("\n" + "=".repeat(50));
        BinarySearch.analyzePerformance(sizes);
        
        System.out.println("\n" + "=".repeat(50));
        BubbleSort.analyzePerformance(sizes);
        
        System.out.println("\n" + "=".repeat(50));
        QuickSort.analyzePerformance(sizes);
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("ALL ALGORITHMS COMPLETED");
        System.out.println("=".repeat(50));
    }
    
    private static void runAllDemonstrations() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("ALGORITHM DEMONSTRATIONS");
        System.out.println("=".repeat(50));
        
        LinearSearch.demonstrate();
        
        System.out.println("\n" + "=".repeat(50));
        BinarySearch.demonstrate();
        
        System.out.println("\n" + "=".repeat(50));
        BubbleSort.demonstrate();
        
        System.out.println("\n" + "=".repeat(50));
        QuickSort.demonstrate();
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("ALL DEMONSTRATIONS COMPLETED");
        System.out.println("=".repeat(50));
    }
    
    // Utility method to generate random arrays
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000); // Numbers between 0-9999
        }
        return array;
    }
    
    // Utility method to generate sorted array for binary search
    public static int[] generateSortedArray(int size) {
        int[] array = generateRandomArray(size);
        Arrays.sort(array);
        return array;
    }
    
    // Utility method to print array (for debugging)
    public static void printArray(int[] array) {
        if (array.length <= 20) {
            System.out.println(Arrays.toString(array));
        } else {
            System.out.println("Array too large to display (" + array.length + " elements)");
        }
    }
}