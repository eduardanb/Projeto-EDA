package ordenacao;

import models.Estudante;
import java.util.Arrays;

public class CountingSort {

    public static void countingSort(int[] A, int k) {
        int n = A.length;
        int[] B = new int[n];
        int[] C = new int[k + 1];

        for (int i = 0; i <= k; i++) {
            C[i] = 0;
        }

        for (int j = 0; j < n; j++) {
            C[A[j]] = C[A[j]] + 1;
        }

        for (int i = 1; i <= k; i++) {
            C[i] = C[i] + C[i - 1];
        }

        for (int j = n - 1; j >= 0; j--) {
            B[C[A[j]] - 1] = A[j];
            C[A[j]] = C[A[j]] - 1;
        }

        System.arraycopy(B, 0, A, 0, n);
    }

    public static Estudante[] countingSortEstudantes(Estudante[] estudantes) {
        if (estudantes.length == 0) return new Estudante[0];

        int[] notas = new int[estudantes.length];
        for (int i = 0; i < estudantes.length; i++) {
            notas[i] = (int)(estudantes[i].getNota() * 100);
        }

        int k = 0;
        for (int nota : notas) {
            if (nota > k) k = nota;
        }

        int[] C = new int[k + 1];
        for (int nota : notas) C[nota]++;
        for (int i = 1; i <= k; i++) C[i] += C[i - 1];

        Estudante[] B = new Estudante[estudantes.length];
        for (int i = estudantes.length - 1; i >= 0; i--) {
            int nota = notas[i];
            B[C[nota] - 1] = estudantes[i];
            C[nota]--;
        }

        return B;
    }

    public static void ordenar(int[] array) {
        if (array.length == 0) return;


        int k = 0;
        for (int num : array) {
            if (num > k) k = num;
        }

        countingSort(array, k);
    }
}