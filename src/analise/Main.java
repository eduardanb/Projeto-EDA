package analise;

import models.Estudante;
import busca.BuscaBinaria;
import busca.BuscaLinear;
import ordenacao.*;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== ANÁLISE DE ALGORITMOS DE BUSCA E ORDENAÇÃO ===\n");

        testeDemonstracao();
        testePerformance();
        testesEspecificosProjeto();
    }

    private static void testeDemonstracao() {
        System.out.println("--- TESTE DE DEMONSTRAÇÃO (Arrays pequenos) ---\n");
        System.out.println("1. TESTANDO ALGORITMOS DE ORDENAÇÃO:");
        testarOrdenacaoInteiros();
        System.out.println("\n2. TESTANDO ALGORITMOS DE BUSCA:");
        testarBuscaEstudantes();
    }

    private static void testarOrdenacaoInteiros() {
        int[] arrayOriginal = {64, 34, 25, 12, 22, 11, 90, 88, 45, 33};
        System.out.println("Array original: " + Arrays.toString(arrayOriginal));

        System.out.println("\n--- BubbleSort (Slide) ---");
        int[] array1 = arrayOriginal.clone();
        BubbleSort.bubbleSortSlide(array1);
        System.out.println("Resultado: " + Arrays.toString(array1));

        System.out.println("\n--- BubbleSort (Otimizado) ---");
        int[] array2 = arrayOriginal.clone();
        BubbleSort.bubbleSortOtimizado(array2);
        System.out.println("Resultado: " + Arrays.toString(array2));

        System.out.println("\n--- SelectionSort (Slide) ---");
        int[] array3 = arrayOriginal.clone();
        SelectionSort.selectionSortS(array3);
        System.out.println("Resultado: " + Arrays.toString(array3));

        System.out.println("\n--- SelectionSort (Estável) ---");
        int[] array3b = arrayOriginal.clone();
        SelectionSort.selectionSortEstavel(array3b);
        System.out.println("Resultado: " + Arrays.toString(array3b));

        System.out.println("\n--- InsertionSort ---");
        int[] array4 = arrayOriginal.clone();
        InsertionSort.insertionSort(array4);
        System.out.println("Resultado: " + Arrays.toString(array4));

        System.out.println("\n--- MergeSort (Clássico) ---");
        int[] array5 = arrayOriginal.clone();
        MergeSort.mergeSort(array5, 0, array5.length - 1);
        System.out.println("Resultado: " + Arrays.toString(array5));

        System.out.println("\n--- MergeSort (TimSort - Java) ---");
        int[] array5b = arrayOriginal.clone();
        MergeSort.timSort(array5b);
        System.out.println("Resultado: " + Arrays.toString(array5b));

        System.out.println("\n--- QuickSort (Slide) ---");
        int[] array6 = arrayOriginal.clone();
        QuickSort.quickSortSlide(array6, 0, array6.length - 1);
        System.out.println("Resultado: " + Arrays.toString(array6));

        System.out.println("\n--- QuickSort (Slide+Shuffle) ---");
        int[] array6b = arrayOriginal.clone();
        QuickSort.quickSortShuffle(array6b, 0, array6b.length - 1);
        System.out.println("Resultado: " + Arrays.toString(array6b));

        System.out.println("\n--- QuickSort (Java Arrays.sort) ---");
        int[] array6c = arrayOriginal.clone();
        QuickSort.quickSortJava(array6c);
        System.out.println("Resultado: " + Arrays.toString(array6c));

        System.out.println("\n--- CountingSort ---");
        int[] array7 = arrayOriginal.clone();
        CountingSort.ordenar(array7);
        System.out.println("Resultado: " + Arrays.toString(array7));

        System.out.println("\n--- Java Arrays.sort (Dual-Pivot) ---");
        int[] array8 = arrayOriginal.clone();
        Arrays.sort(array8);
        System.out.println("Resultado: " + Arrays.toString(array8));
    }

    private static void testarBuscaEstudantes() {
        Estudante[] alunos = criarEstudantes();

        Arrays.sort(alunos);

        System.out.println("\nArray de Estudantes (Ordenado por nota decrescente):");
        imprimirArray(alunos);

        Estudante chaveExistente = alunos[alunos.length / 2];
        Estudante chaveInexistente = new Estudante(999, "Inexistente", 9.9);

        System.out.println("\n========================================");
        System.out.println("CHAVE EXISTENTE (Buscar: " + chaveExistente + ")");
        executarTestesBusca(alunos, chaveExistente);

        System.out.println("\n========================================");
        System.out.println("CHAVE INEXISTENTE (Buscar: " + chaveInexistente + ")");
        executarTestesBusca(alunos, chaveInexistente);
    }

    private static void testePerformance() {
        System.out.println("\n\n--- TESTES DE PERFORMANCE (Arrays grandes) ---");

        System.out.println("\n1. PERFORMANCE DOS ALGORITMOS DE ORDENAÇÃO:");
        testarPerformanceOrdenacao();

        System.out.println("\n2. PERFORMANCE DOS ALGORITMOS DE BUSCA:");
        testarPerformanceBusca();
    }

    private static void testarPerformanceOrdenacao() {
        int[] tamanhos = {20000, 100000};
        Random random = new Random();

        for (int tamanho : tamanhos) {
            System.out.println("\n--- Tamanho do array: " + tamanho + " ---");

            int[] array = new int[tamanho];
            for (int i = 0; i < tamanho; i++) {
                array[i] = random.nextInt(10000);
            }

            testarAlgoritmoOrdenacao("BubbleSort (Slide)", array, () -> {
                int[] copia = array.clone();
                BubbleSort.bubbleSortSlide(copia);
            });

            testarAlgoritmoOrdenacao("BubbleSort (Otimizado)", array, () -> {
                int[] copia = array.clone();
                BubbleSort.bubbleSortOtimizado(copia);
            });

            testarAlgoritmoOrdenacao("SelectionSort (Slide)", array, () -> {
                int[] copia = array.clone();
                SelectionSort.selectionSortS(copia);
            });

            testarAlgoritmoOrdenacao("SelectionSort (Estável)", array, () -> {
                int[] copia = array.clone();
                SelectionSort.selectionSortEstavel(copia);
            });

            testarAlgoritmoOrdenacao("InsertionSort", array, () -> {
                int[] copia = array.clone();
                InsertionSort.insertionSort(copia);
            });

            testarAlgoritmoOrdenacao("MergeSort (Clássico)", array, () -> {
                int[] copia = array.clone();
                MergeSort.mergeSort(copia, 0, copia.length - 1);
            });

            testarAlgoritmoOrdenacao("MergeSort (TimSort)", array, () -> {
                int[] copia = array.clone();
                MergeSort.timSort(copia);
            });

            testarAlgoritmoOrdenacao("QuickSort (Slide)", array, () -> {
                int[] copia = array.clone();
                QuickSort.quickSortSlide(copia, 0, copia.length - 1);
            });

            testarAlgoritmoOrdenacao("QuickSort (Slide+Shuffle)", array, () -> {
                int[] copia = array.clone();
                QuickSort.quickSortShuffle(copia, 0, copia.length - 1);
            });

            testarAlgoritmoOrdenacao("QuickSort (Java)", array, () -> {
                int[] copia = array.clone();
                QuickSort.quickSortJava(copia);
            });

            testarAlgoritmoOrdenacao("CountingSort", array, () -> {
                int[] copia = array.clone();
                CountingSort.ordenar(copia);
            });

            testarAlgoritmoOrdenacao("Java Arrays.sort", array, () -> {
                int[] copia = array.clone();
                Arrays.sort(copia);
            });
        }
    }

    private static void testarAlgoritmoOrdenacao(String nome, int[] arrayOriginal, Runnable algoritmo) {
        // Warm-up (5 execuções)
        for (int i = 0; i < 5; i++) {
            int[] copiaWarmup = arrayOriginal.clone();
            algoritmo.run();
        }

        long[] tempos = new long[20];

        for (int i = 0; i < 20; i++) {
            int[] dadosTeste = arrayOriginal.clone();

            long inicio = System.nanoTime();
            algoritmo.run();
            long fim = System.nanoTime();

            tempos[i] = fim - inicio;
        }

        Arrays.sort(tempos);
        long soma = 0;
        for (int i = 5; i < 15; i++) {
            soma += tempos[i];
        }
        double mediaNs = soma / 10.0;
        double mediaMs = mediaNs / 1_000_000.0;

        System.out.printf("  %-25s: %.2f ms%n", nome, mediaMs);
    }

    private static void testarPerformanceBusca() {
        int tamanho = 100000;
        Estudante[] estudantes = gerarEstudantesAleatorios(tamanho);
        Arrays.sort(estudantes);

        Estudante chaveExistente = estudantes[tamanho / 2];
        Estudante chaveInexistente = new Estudante(99999, "Inexistente", 11.0);

        System.out.println("\n--- Busca com " + tamanho + " estudantes ---");
        System.out.println("Chave existente no índice " + (tamanho / 2));

        System.out.println("\nCHAVE EXISTENTE:");
        testarAlgoritmoBusca("Busca Linear Iterativa", estudantes, chaveExistente);
        testarAlgoritmoBusca("Busca Linear Recursiva", estudantes, chaveExistente);
        testarAlgoritmoBusca("Busca Linear Duas Pontas", estudantes, chaveExistente);
        testarAlgoritmoBusca("Busca Binária Iterativa", estudantes, chaveExistente);
        testarAlgoritmoBusca("Busca Binária Recursiva", estudantes, chaveExistente);

        System.out.println("\nCHAVE INEXISTENTE:");
        testarAlgoritmoBusca("Busca Linear Iterativa", estudantes, chaveInexistente);
        testarAlgoritmoBusca("Busca Linear Recursiva", estudantes, chaveInexistente);
        testarAlgoritmoBusca("Busca Linear Duas Pontas", estudantes, chaveInexistente);
        testarAlgoritmoBusca("Busca Binária Iterativa", estudantes, chaveInexistente);
        testarAlgoritmoBusca("Busca Binária Recursiva", estudantes, chaveInexistente);
    }

    private static void testarAlgoritmoBusca(String nomeAlgoritmo, Estudante[] array, Estudante chave) {
        for (int i = 0; i < 5; i++) {
            switch (nomeAlgoritmo) {
                case "Busca Linear Iterativa": BuscaLinear.buscarIterativa(array, chave); break;
                case "Busca Linear Recursiva": BuscaLinear.buscarRecursiva(array, chave); break;
                case "Busca Linear Duas Pontas": BuscaLinear.buscarDuasPontas(array, chave); break;
                case "Busca Binária Iterativa": BuscaBinaria.buscarIterativa(array, chave); break;
                case "Busca Binária Recursiva": BuscaBinaria.buscarRecursiva(array, chave); break;
            }
        }

        long[] tempos = new long[20];

        for (int i = 0; i < 20; i++) {
            long inicio = System.nanoTime();

            switch (nomeAlgoritmo) {
                case "Busca Linear Iterativa": BuscaLinear.buscarIterativa(array, chave); break;
                case "Busca Linear Recursiva": BuscaLinear.buscarRecursiva(array, chave); break;
                case "Busca Linear Duas Pontas": BuscaLinear.buscarDuasPontas(array, chave); break;
                case "Busca Binária Iterativa": BuscaBinaria.buscarIterativa(array, chave); break;
                case "Busca Binária Recursiva": BuscaBinaria.buscarRecursiva(array, chave); break;
            }

            long fim = System.nanoTime();
            tempos[i] = fim - inicio;
        }

        Arrays.sort(tempos);
        long soma = 0;
        for (int i = 5; i < 15; i++) {
            soma += tempos[i];
        }
        double mediaNs = soma / 10.0;

        System.out.printf("  %-25s: %8.2f ns%n", nomeAlgoritmo, mediaNs);
    }

    private static void testesEspecificosProjeto() {
        System.out.println("\n\n--- TESTES ESPECÍFICOS DO PROJETO ---");

        System.out.println("\n1. CountingSort com Estudantes:");
        testarCountingSortEstudantes();

        System.out.println("\n2. Comparação das versões do QuickSort:");
        compararVersoesQuickSort();

        System.out.println("\n3. Teste com vetor ordenado vs. desordenado:");
        testarVetorOrdenadoVsDesordenado();
    }

    private static void testarCountingSortEstudantes() {
        Estudante[] estudantes = criarEstudantes();

        System.out.println("Array original:");
        for (Estudante e : estudantes) {
            System.out.println("  " + e);
        }

        Estudante[] ordenado = CountingSort.countingSortEstudantes(estudantes);

        System.out.println("\nArray ordenado por nota (CountingSort):");
        for (Estudante e : ordenado) {
            System.out.println("  " + e);
        }
    }

    private static void compararVersoesQuickSort() {
        int tamanho = 50000;
        Random random = new Random();
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = random.nextInt(10000);
        }

        System.out.println("Comparando com array de " + tamanho + " elementos:");

        testarUmaVersaoQuickSort("Slide", array, () -> {
            int[] copia = array.clone();
            QuickSort.quickSortSlide(copia, 0, copia.length - 1);
        });

        testarUmaVersaoQuickSort("Slide+Shuffle", array, () -> {
            int[] copia = array.clone();
            QuickSort.quickSortShuffle(copia, 0, copia.length - 1);
        });

        testarUmaVersaoQuickSort("Java Arrays.sort", array, () -> {
            int[] copia = array.clone();
            Arrays.sort(copia);
        });
    }

    private static void testarUmaVersaoQuickSort(String nome, int[] array, Runnable algoritmo) {
        for (int i = 0; i < 5; i++) {
            int[] copiaWarmup = array.clone();
            algoritmo.run();
        }


        int[] copiaTeste = array.clone();
        long inicio = System.nanoTime();
        algoritmo.run();
        long fim = System.nanoTime();

        double tempoMs = (fim - inicio) / 1_000_000.0;
        System.out.printf("  %-20s: %.2f ms%n", nome, tempoMs);
    }

    private static void testarVetorOrdenadoVsDesordenado() {
        int tamanho = 20000;

        int[] ordenado = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            ordenado[i] = i + 1;
        }

        int[] desordenado = new int[tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            desordenado[i] = random.nextInt(10000);
        }

        System.out.println("Testando InsertionSort (20k elementos):");


        int[] copiaOrdenada = ordenado.clone();
        long inicio1 = System.nanoTime();
        InsertionSort.insertionSort(copiaOrdenada);
        long fim1 = System.nanoTime();
        double tempoOrdenado = (fim1 - inicio1) / 1_000_000.0;


        int[] copiaDesordenada = desordenado.clone();
        long inicio2 = System.nanoTime();
        InsertionSort.insertionSort(copiaDesordenada);
        long fim2 = System.nanoTime();
        double tempoDesordenado = (fim2 - inicio2) / 1_000_000.0;

        System.out.printf("  Vetor ordenado:     %.2f ms%n", tempoOrdenado);
        System.out.printf("  Vetor desordenado:  %.2f ms%n", tempoDesordenado);
        System.out.printf("  Diferença:          %.2f ms (%.1fx mais rápido no ordenado)%n",
                tempoDesordenado - tempoOrdenado, tempoDesordenado / tempoOrdenado);
    }

    private static void executarTestesBusca(Estudante[] array, Estudante chave) {
        int indice;

        indice = BuscaLinear.buscarIterativa(array, chave);
        exibirResultado("Linear Iterativa", indice, array, chave);

        indice = BuscaLinear.buscarRecursiva(array, chave);
        exibirResultado("Linear Recursiva", indice, array, chave);

        indice = BuscaLinear.buscarDuasPontas(array, chave);
        exibirResultado("Linear Duas Pontas", indice, array, chave);

        indice = BuscaBinaria.buscarIterativa(array, chave);
        exibirResultado("Binária Iterativa", indice, array, chave);

        indice = BuscaBinaria.buscarRecursiva(array, chave);
        exibirResultado("Binária Recursiva", indice, array, chave);
    }

    private static Estudante[] criarEstudantes() {
        return new Estudante[]{
                new Estudante(101, "Ana", 8.5),
                new Estudante(102, "Bruno", 7.0),
                new Estudante(103, "Carla", 9.0),
                new Estudante(104, "David", 7.0),
                new Estudante(105, "Erica", 8.5),
                new Estudante(106, "Felipe", 10.0),
                new Estudante(107, "Gabriela", 9.0),
                new Estudante(108, "Hugo", 5.5),
                new Estudante(109, "Igor", 7.0)
        };
    }

    private static Estudante[] gerarEstudantesAleatorios(int quantidade) {
        Random random = new Random();
        String[] nomes = {"Ana", "Bruno", "Carla", "David", "Erica", "Felipe", "Gabriela", "Hugo", "Igor", "Julia"};
        Estudante[] estudantes = new Estudante[quantidade];

        for (int i = 0; i < quantidade; i++) {
            int matricula = 1000 + i;
            String nome = nomes[random.nextInt(nomes.length)];
            double nota = Math.round(random.nextDouble() * 1000) / 100.0;
            estudantes[i] = new Estudante(matricula, nome, nota);
        }

        return estudantes;
    }

    private static void exibirResultado(String algoritmo, int indice, Estudante[] array, Estudante chave) {
        if (indice != -1) {
            System.out.println("-> " + algoritmo + ": Encontrado no índice [" + indice + "]. (Valor: " + array[indice].getNome() + ")");
        } else {
            System.out.println("-> " + algoritmo + ": NÃO encontrado. (Esperado para chave: " + chave.getNome() + ")");
        }
    }

    private static void imprimirArray(Estudante[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("[" + i + "] " + array[i].toString());
        }
    }
}