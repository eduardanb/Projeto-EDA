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

    // Busca Linear Recursiva (Wrapper)
    public static int buscarRecursiva(Estudante[] array, Estudante chave) {
        return buscarRecursiva(array, chave, 0);
    }

    // Busca Linear Recursiva (Core)
    private static int buscarRecursiva(Estudante[] array, Estudante chave, int indice) {
        if (indice >= array.length) {
            return -1;
        }
        if (array[indice].compareTo(chave) == 0) {
            return indice;
        }
        return buscarRecursiva(array, chave, indice + 1);
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