package br.inf.unisep.jeferson.Escola;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Turma {
    
    private static int contador = 0;
    private int codigo;
    private String descricao;
    private List<Aluno> alunos;
    
    public Turma(String descricao){
        contador++;
        codigo = contador;
        this.descricao = descricao.toUpperCase();
        alunos = new ArrayList();
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao.toUpperCase();
    }
    
    public String getDescricao(){
        return descricao;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public int quantidadeAlunos(){
        return alunos.size();
    }
    
    public int quantidadeAlunosAprovados(){
        int quantidadeAprovados = 0;
        for (Aluno alunoAtual : alunos) {
            if (alunoAtual.getMedia() >= 7.0){
                quantidadeAprovados++;
            }
        }
        return quantidadeAprovados;
    }
    
    public int quantidadeAlunosReprovados(){
        int quantidadeReprovados = 0;
        for (Aluno alunoAtual : alunos){
            if (alunoAtual.getMedia() < 7.0){
                quantidadeReprovados++;
            }
        }
        return quantidadeReprovados;
    }

    public double porcentagemAlunosAprovados(){
        return ((quantidadeAlunosAprovados() / alunos.size()) * 100);
    }
    
    public double porcentagemAlunosReprovados(){
        return ((quantidadeAlunosReprovados() / alunos.size()) * 100);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.codigo;
        hash = 37 * hash + Objects.hashCode(this.descricao);
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
        final Turma other = (Turma) obj;
        return true;
    }

    public double mediaGeral(){
        double somaMedia = 0;
        for (Aluno alunoAtual : alunos){
            somaMedia = somaMedia + alunoAtual.getMedia();
        }
        return (somaMedia / alunos.size());
    }

    public void matricula(Aluno aluno){
        alunos.add(aluno);
    }
    
    public void cancelarMatricula(int ra){
        for (Aluno al : alunos){
            if(al.getCodigo() == ra ){
                alunos.remove(al);
            }
        }
    }
    
    public int getAluno(String nome){
        for (Aluno al : alunos){
            if (al.getNome().equals(nome)){
                return al.getCodigo();
            }
        }
        return 0;
    }
}
