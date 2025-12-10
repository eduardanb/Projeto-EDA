package analise;

import models.Estudante;
import java.util.Arrays;
import java.util.function.BiFunction;

import busca.BuscaBinaria;
import busca.BuscaLinear;

public class AnalisadorPerformance {

    private static final int REPETICOES = 25; // 5 warm-up + 20 medições
    private static final int WARM_UP_COUNT = 5;

    // =====================================================================
    // --- MÉTODOS DE BUSCA ---
    // =====================================================================

    public long medirTempoBusca(Estudante[] array, Estudante chave,
            BiFunction<Estudante[], Estudante, Integer> algoritmo) {

        long tempoTotal = 0;

        for (int i = 0; i < REPETICOES; i++) {
            long tempoInicio = System.nanoTime();
            // Executa o algoritmo de busca
            algoritmo.apply(array, chave);
            long tempoFim = System.nanoTime();
            long duracao = tempoFim - tempoInicio;

            if (i >= WARM_UP_COUNT) {
                tempoTotal += duracao;
            }
        }
        return tempoTotal / (REPETICOES - WARM_UP_COUNT);
    }

    public void rodarAnaliseBusca(int tamanhoArray, String cenario) {
        // Gera um array ordenado (obrigatório para a Busca Binária)
        Estudante[] array = GeradorDados.gerarArrayOrdenado(tamanhoArray);
        Estudante chave = GeradorDados.getChaveBusca(array, cenario);

        System.out.println("==========================================================================");
        System.out.printf("| ANÁLISE DE BUSCA | N=%-15s | CENÁRIO: %-10s |\n", tamanhoArray, cenario.toUpperCase());
        System.out.println("==========================================================================");
        System.out.printf("| %-25s | %18s |\n", "ALGORITMO                         ", "TEMPO MÉDIO (ns)");

        // 1. Busca Linear Iterativa
        long tempoLinearIterativa = medirTempoBusca(array, chave, BuscaLinear::buscarIterativa);
        System.out.printf("| %-25s | %18d |\n", "Busca Linear Iterativa (O(N))     ", tempoLinearIterativa);

        // 2. Busca Binária Iterativa
        long tempoBinariaIterativa = medirTempoBusca(array, chave, BuscaBinaria::buscarIterativa);
        System.out.printf("| %-25s | %18d |\n", "Busca Binária Iterativa (O(log N))", tempoBinariaIterativa);

        // 3. Busca Linear Recursiva com Divide and Conquer (O(log N) profundidade)
        long tempoLinearRecursiva = medirTempoBusca(array, chave, BuscaLinear::buscarRecursiva);
        System.out.printf("| %-25s | %18d |\n", "Busca Linear Recursiva (O(N))     ", tempoLinearRecursiva);

        long tempoBinariaRecursiva = medirTempoBusca(array, chave, BuscaBinaria::buscarRecursiva);
        System.out.printf("| %-25s | %18d |\n", "Busca Binária Recursiva (O(log N))", tempoBinariaRecursiva);

        System.out.println(" ");
    }
}