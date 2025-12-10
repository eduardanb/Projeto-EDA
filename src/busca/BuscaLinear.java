package busca;

import models.Estudante;

public class BuscaLinear {

    // Busca Linear Iterativa
    public static int buscarIterativa(Estudante[] array, Estudante chave) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(chave) == 0) {
                return i;
            }
        }
        return -1;
    }

    // Busca Linear Recursiva com Divide and Conquer (O(log N) profundidade)
    public static int buscarRecursiva(Estudante[] array, Estudante chave) {
        return buscarRecursivaDivideConquer(array, chave, 0, array.length - 1);
    }

    // Busca Linear Recursiva - Divide and Conquer
    // Reduz profundidade de O(N) para O(log N), evitando Stack Overflow
    private static int buscarRecursivaDivideConquer(Estudante[] array, Estudante chave,
            int esquerda, int direita) {
        if (esquerda > direita) {
            return -1;
        }

        int meio = (esquerda + direita) / 2;

        // Verifica o elemento do meio
        if (array[meio].compareTo(chave) == 0) {
            return meio;
        }

        // Busca na metade esquerda
        int resultadoEsquerda = buscarRecursivaDivideConquer(array, chave, esquerda, meio - 1);
        if (resultadoEsquerda != -1) {
            return resultadoEsquerda;
        }

        // Busca na metade direita
        return buscarRecursivaDivideConquer(array, chave, meio + 1, direita);
    }

    // Busca Linear Iterativa Duas Pontas
    public static int buscarDuasPontas(Estudante[] array, Estudante chave) {
        int esquerda = 0;
        int direita = array.length - 1;

        while (esquerda <= direita) {
            if (array[esquerda].compareTo(chave) == 0) {
                return esquerda;
            }
            if (esquerda != direita && array[direita].compareTo(chave) == 0) {
                return direita;
            }
            esquerda++;
            direita--;
        }
        return -1;
    }
}