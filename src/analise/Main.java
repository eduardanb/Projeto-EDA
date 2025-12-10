package analise;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnalisadorPerformance analisador = new AnalisadorPerformance();

        int opcao = -1;

        while (opcao != 0) {
            exibirMenu();

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        rodarTestesOrdenacao(analisador);
                        break;
                    case 2:
                        rodarTestesBusca(analisador);
                        break;
                    case 0:
                        System.out.println("\nSaindo do programa. Até mais!");
                        break;
                    default:
                        System.out.println("\nOpção inválida. Digite 1, 2 ou 0 para sair.");
                }
            } else {
                System.out.println("\nEntrada inválida. Digite um número.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n========================================");
        System.out.println("  MENU DE ANÁLISE DE ALGORITMOS (EDA)  ");
        System.out.println("========================================");
        System.out.println("1 - Rodar Testes de ORDENAÇÃO (Pendente)");
        System.out.println("2 - Rodar Testes de BUSCA (Performance)");
        System.out.println("0 - Sair");
        System.out.print("Escolha a opção: ");
    }

    private static void rodarTestesOrdenacao(AnalisadorPerformance analisador) {
        System.out.println("\n[AGUARDANDO IMPLEMENTAÇÃO] A lógica de teste de Ordenação será ativada quando os algoritmos de Sort estiverem prontos no pacote 'ordenacao'.");
    }

    private static void rodarTestesBusca(AnalisadorPerformance analisador) {
        // Tamanhos de vetor para testar a diferença de complexidade O(N) vs O(log N)
        int[] tamanhos = { 5000, 100000, 1000000 };
        String[] cenarios = { "melhor", "pior", "inexistente" };

        System.out.println("\n*** ANÁLISE DE BUSCA (Performance) ***");

        for (int tamanho : tamanhos) {
            for (String cenario : cenarios) {
                analisador.rodarAnaliseBusca(tamanho, cenario);
            }
        }
    }
}