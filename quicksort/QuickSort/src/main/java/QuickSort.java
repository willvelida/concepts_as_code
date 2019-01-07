import java.util.Arrays;

public class QuickSort {

    public void sort(int[] inputNumbersArray) {
        sort(inputNumbersArray, 0, inputNumbersArray.length - 1);
    }

    private void sort(int[] numbers, int start, int end) {
        if (start < end) {
            int p = partition(numbers, start, end);
            sort(numbers, start, p - 1);
            sort(numbers, p + 1, end);
        }
    }

    private int partition(int[] numbers, int start, int end) {
        int pivot = numbers[end];
        int x = start - 1;
        for (int i = start; i < end; i++) {
            if (numbers[i] < pivot) {
                x++;
                swap(numbers, x, i);
            }
        }
        swap(numbers, x + 1, end);
        return x + 1;
    }

    private void swap(int[] numbers, int i,int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {

        int[] numbersList = new int[]{6,5,3,4,2,7,8,9,1,2};
        QuickSort quickSort = new QuickSort();

        quickSort.sort(numbersList);

        System.out.println(Arrays.toString(numbersList));

    }

}
