package ordenacao;

public class BubbleSort {

    public static void bubbleSortSlide(int[] A) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    swap(A, j, j + 1);
                }
            }
        }
    }

    public static void bubbleSortOtimizado(int[] A) {
        int n = A.length;
        boolean trocou;
        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    swap(A, j, j + 1);
                    trocou = true;
                }
            }
            if (!trocou) break;
        }
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}