package models;

public class Estudante implements Comparable<Estudante> {
    private int matricula;
    private String nome;
    private double nota;

    // Construtor
    public Estudante(int matricula, String nome, double nota) {
        this.matricula = matricula;
        this.nome = nome;
        this.nota = nota;
    }

    // Getters
    public int getMatricula() {
        return matricula;
    }
    public String getNome() {
        return nome;
    }
    public double getNota() {
        return nota;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public int compareTo(Estudante outro) {
        if (this.nota != outro.nota) {
            return Double.compare(outro.nota, this.nota);
        }

        int comparacaoNome = this.nome.compareTo(outro.nome);
        if (comparacaoNome != 0) {
            return comparacaoNome;
        }

        return Integer.compare(this.matricula, outro.matricula);
    }

    // Método toString()
    @Override
    public String toString() {
        return "Estudante [Nota=" + String.format("%.1f", nota) + ", Nome=" + nome + ", Matrícula=" + matricula + "]";
    }
}