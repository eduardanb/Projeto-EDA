package analise;

import models.Estudante;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class GeradorDados {

    private static final Random RAND = new Random();

    private static Estudante gerarEstudanteAleatorio(int i) {
        String nome = "Aluno " + i;
        double nota = RAND.nextDouble() * 10; // Nota entre 0.0 e 10.0
        int matricula = 1000000 + i;
        return new Estudante(matricula, nome, nota);
    }

    // MÉTODOS DE GERAÇÃO PARA TESTES DE ORDENAÇÃO

    // Gera um array de Estudantes com campos aleatórios NÃO ORDENADOS
    public static Estudante[] gerarArrayBase(int tamanho) {
        Estudante[] array = new Estudante[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = gerarEstudanteAleatorio(i);
        }
        return array;
    }

    public static Estudante[] gerarArrayAleatorio(int tamanho) {
        return gerarArrayBase(tamanho);
    }

    public static Estudante[] gerarArrayOrdenado(int tamanho) {
        Estudante[] array = gerarArrayBase(tamanho);
        Arrays.sort(array);
        return array;
    }

    public static Estudante[] gerarArrayInverso(int tamanho) {
        Estudante[] array = gerarArrayBase(tamanho);
        Arrays.sort(array, Collections.reverseOrder());
        return array;
    }

    // MÉTODOS PARA TESTES DE BUSCA

    public static Estudante getChaveBusca(Estudante[] array, String cenario) {
        int tamanho = array.length;
        if (tamanho == 0) return null;

        switch (cenario.toLowerCase()) {
            case "melhor":
                return array[tamanho / 2];
            case "pior":
                return array[tamanho - 1];
            case "inexistente":
                return new Estudante(9999999, "Chave Inexistente", 100.0);
            default:
                return array[tamanho / 2];
        }
    }
}