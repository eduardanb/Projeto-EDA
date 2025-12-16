package ordenacao;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] A, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(A, left, mid);
            mergeSort(A, mid + 1, right);
            merge(A, left, mid, right);
        }
    }

    private static void merge(int[] A, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = A[left + i];
        for (int j = 0; j < n2; j++) R[j] = A[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            A[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            A[k] = R[j];
            j++;
            k++;
        }
    }


    public static void timSort(int[] array) {
        Arrays.sort(array);
    }

    public static void ordenar(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }
}