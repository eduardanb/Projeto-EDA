package busca;

import models.Estudante;

/**
 * Interface para padronizar todos os algoritmos de busca.
 * Retorna o índice do Estudante no array, ou -1 se não encontrado.
 */
public interface AlgoritmoBusca {
    int buscar(Estudante[] array, Estudante chave);
}