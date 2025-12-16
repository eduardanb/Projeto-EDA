package ordenacao;

public interface AlgoritmoOrdenacao {
    void ordenar(int[] array);
    String getNome();
    boolean isEstavel();
}