package analise;

import models.Estudante;
import busca.BuscaBinaria;
import busca.BuscaLinear;

import java.util.Arrays; // Necessário para ordenar

public class Main {

    public static void main(String[] args) {
        System.out.println("--- Testes de Busca em Estudantes ---");

        Estudante[] alunos = criarEstudantes();

        Arrays.sort(alunos);

        System.out.println("\nArray de Estudantes (Ordenado):");
        imprimirArray(alunos);

        // Definição das Chaves de Busca (Binária)
        Estudante chaveExistente = alunos[alunos.length / 2];
        Estudante chaveInexistente = new Estudante(999, "Inexistente", 9.9);

        System.out.println("\n========================================");
        System.out.println("CHAVE EXISTENTE (Buscar: " + chaveExistente + ")");
        executarTestesBusca(alunos, chaveExistente);

        System.out.println("\n========================================");
        System.out.println("CHAVE INEXISTENTE (Buscar: " + chaveInexistente + ")");
        executarTestesBusca(alunos, chaveInexistente);
    }

    private static void executarTestesBusca(Estudante[] array, Estudante chave) {
        int indice;

        // Busca Linear Iterativa
        indice = BuscaLinear.buscarIterativa(array, chave);
        exibirResultado("Linear Iterativa", indice, array, chave);

        // Busca Linear Recursiva
        indice = BuscaLinear.buscarRecursiva(array, chave);
        exibirResultado("Linear Recursiva", indice, array, chave);

        // Busca Linear Duas Pontas
        indice = BuscaLinear.buscarDuasPontas(array, chave);
        exibirResultado("Linear Duas Pontas", indice, array, chave);

        // Busca Binária Iterativa
        indice = BuscaBinaria.buscarIterativa(array, chave);
        exibirResultado("Binária Iterativa", indice, array, chave);

        // Busca Binária Recursiva
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