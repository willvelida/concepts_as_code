package com.willvelida.conceptsascode.bubblesort;

import java.util.Arrays;

public class BubbleSort {

    // Bubble Sort v1
    public void sortV1(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    // Bubble Sort improvement
    public void sortV2(int[] numbers) {
        int i = 0;
        boolean hasSwappedOccured = true;
        while (hasSwappedOccured) {
            hasSwappedOccured = false;
            i++;
            for (int j = 0; j < numbers.length - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    swap(numbers, j, j + 1);
                    hasSwappedOccured = true;
                }
            }
        }
    }

    // swap helper method
    private void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }

    // Program entry
    public static void main(String[] args) {
        // Instantiate a new instance of our BubbleSort class
        BubbleSort sort = new BubbleSort();

        // Define the input array that we wish to sort
        int[] inputArray = new int[]{6,4,3,6,4,7,9,2,4,3,1};

        // Call our sortV1 method and pass in our inputArray
        // sort.sortV1(inputArray);

        // Call our sortV2 method and pass in our inputArray
        sort.sortV2(inputArray);

        // Print out the results to the console
        System.out.println(Arrays.toString(inputArray));
    }
}
