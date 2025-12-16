package ordenacao;

import java.util.Arrays;
import models.Estudante;

public class UtilJavaSort implements AlgoritmoOrdenacao {

    @Override
    public String getNome() {
        return "Java Arrays.sort (int[])";
    }

    @Override
    public boolean isEstavel() {
        return false;
    }

    @Override
    public void ordenar(int[] array) {
        Arrays.sort(array);
    }

    public static void ordenarEstudantes(Estudante[] array) {
        Arrays.sort(array);
    }


    public static boolean isEstavelParaObjetos() {
        return true;
    }

    public static void ordenarInteiros(int[] array) {
        Arrays.sort(array);
    }
}