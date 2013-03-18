
package br.inf.unisep.jeferson.Escola;

public class Aluno {
    
    private String nome;
    private int ra;
    private float notaG1, notaG2;
    private static int contador = 0;
    //private Turma turma;

    public Aluno(String nome) {
        contador++;
        ra = contador;
        this.nome = nome;
    }
    
    public void setG1(float g1){
        notaG1 = g1;
    }
    
    public void setG2(float g2){
        notaG2 = g2;
    }

    public float getG1(){
        return notaG1;
    }

    public float getG2(){
        return notaG2;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }
    
    /**
     * Retorna a <p> media </p> do aluno
     * @return double
     */
    public double getMedia(){
        return ((notaG1 + (notaG2 * 2)) / 3);
    }
    
    public int getCodigo(){
        return ra;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.ra;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        if (this.ra != other.ra) {
            return false;
        }
        return true;
    }
}
