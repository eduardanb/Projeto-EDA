package busca;

import models.Estudante;

public class BuscaBinaria {

    // Busca Binária Iterativa
    public static int buscarIterativa(Estudante[] array, Estudante chave) {
        int esquerda = 0;
        int direita = array.length - 1;

        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;
            int resultado = array[meio].compareTo(chave);

            if (resultado == 0) {
                return meio;
            } else if (resultado < 0) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }
        return -1;
    }

    // Busca Binária Recursiva (Método Wrapper)
    public static int buscarRecursiva(Estudante[] array, Estudante chave) {
        return buscarRecursiva(array, chave, 0, array.length - 1);
    }

    // Busca Binária Recursiva (Método Core)
    private static int buscarRecursiva(Estudante[] array, Estudante chave, int esquerda, int direita) {
        if (esquerda > direita) {
            return -1;
        }

        int meio = esquerda + (direita - esquerda) / 2;
        int resultado = array[meio].compareTo(chave);

        if (resultado == 0) {
            return meio;
        }

        if (resultado < 0) {
            return buscarRecursiva(array, chave, meio + 1, direita);
        } else {
            return buscarRecursiva(array, chave, esquerda, meio - 1);
        }
    }
}