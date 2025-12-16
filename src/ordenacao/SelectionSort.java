package ordenacao;

public class SelectionSort {

    public static void selectionSortS(int[] A) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (A[j] < A[min]) {
                    min = j;
                }
            }
            swap(A, i, min);
        }
    }

    public static void selectionSortEstavel(int[] A) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (A[j] < A[min]) {
                    min = j;
                }
            }

            int minValue = A[min];
            while (min > i) {
                A[min] = A[min - 1];
                min--;
            }
            A[i] = minValue;
        }
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}