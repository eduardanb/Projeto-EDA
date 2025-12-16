package ordenacao;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    private static Random random = new Random();


    public static void quickSortSlide(int[] A, int left, int right) {
        if (left < right) {
            int pivot = partition(A, left, right);
            quickSortSlide(A, left, pivot - 1);
            quickSortSlide(A, pivot + 1, right);
        }
    }

    private static int partition(int[] A, int left, int right) {
        int p = A[left];
        int i = left + 1;
        int j = right;

        while (i <= j) {
            if (A[i] <= p) {
                i++;
            } else if (A[j] > p) {
                j--;
            } else {
                swap(A, i, j);
            }
        }
        swap(A, left, j);
        return j;
    }

    public static void quickSortShuffle(int[] A, int left, int right) {
        if (left < right) {
            shuffle(A, left, right);
            int pivot = partition(A, left, right);
            quickSortShuffle(A, left, pivot - 1);
            quickSortShuffle(A, pivot + 1, right);
        }
    }

    private static void shuffle(int[] A, int left, int right) {
        for (int i = right; i > left; i--) {
            int j = random.nextInt(i - left + 1) + left;
            swap(A, i, j);
        }
    }


    public static void quickSortJava(int[] array) {
        Arrays.sort(array);
    }


    public static void quickSortInt(int[] array, int low, int high) {
        quickSortSlide(array, low, high);
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}