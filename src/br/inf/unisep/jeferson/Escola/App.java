package br.inf.unisep.jeferson.Escola;

import br.com.fadanelli.utilitarios.io.Console;

public class App {
    public static void main(String args[]){
        String escolha, subEscolha;
        
        Instituicao inst = new Instituicao();
        
        do {
            Console.Escreverln("1 - Gerênciar turmas");
            Console.Escreverln("2 - Gerênciar alunos");
            Console.Escreverln("3 - Relatórios");
            Console.Escreverln("4 - Abandonar");
            escolha = Console.Ler();

            switch (escolha) {
                case "1":
                    Console.Escreverln("1 - Abrir turma");
                    Console.Escreverln("2 - Fechar turma");
                    subEscolha = Console.Ler();
                    Console.Escreverln("Digite a série da turma: ");
                    if (subEscolha.equals("1")){
                        Turma tur = new Turma(Console.Ler());
                        inst.abrirTurma(tur);
                    } else {
                        inst.fechaTurma(Console.Ler());
                    }
                    break;

                case "2":
                    Console.Escreverln("1 - Matricular aluno");
                    Console.Escreverln("2 - Cancelar matrícula");
                    Console.Escreverln("3 - Voltar");
                    String digitado = Console.Ler();
                    switch (digitado) {
                        case "1":
                            Console.Escreverln("Digite a turma do aluno: ");
                            for (Turma tm : inst.turmas){
                                if (tm.getDescricao().equals(Console.Ler())){
                                    Console.Escreverln("Digite o nome do aluno: ");
                                    Aluno alunoNovo = new Aluno(Console.Ler());
                                    tm.matricula(alunoNovo);
                                }
                            }

                        case "2" :
                            Console.Escreverln("Digite a turma do aluno: ");
                            for (Turma tm : inst.turmas){
                                if (tm.getDescricao().equals(Console.Ler())){
                                    Console.Escreverln("Digite o nome do aluno: ");
                                    tm.cancelarMatricula(tm.getAluno(Console.Ler()));
                                }
                            }
                        default :
                            break;
                    }
                case "3":
                    Console.Escreverln("1 - Média escola");
                    Console.Escreverln("2 - Média turma");
                    Console.Escreverln("3 - Média aluno");
                    Console.Escreverln("4 - Quantidade de Alunos matriculados");
                    Console.Escreverln("5 - Quantidade de Alunos reprovados");
                    Console.Escreverln("6 - Porcentagem de alunos aprovados");
                    Console.Escreverln("7 - Porcentagem de alunos reprovados");
                    Console.Escreverln("8 - Quantidade de turmas cadastradas");
                    
                    digitado = Console.Ler();
                    switch (digitado){
                        case "1" :

                        case "2" :
                            
                        case "8" :
                            Console.Escreverln("" + inst.turmas.size());
                            
                    }
                    
                    
                    break;
                
                case "4":
                    Console.Escreverln("App Finalizado.");
                    break;

                default:
                    Console.Escreverln("Digite somente os números disponíveis");  
            }
            Console.Escreverln(" ");
            Console.Escreverln(" ");
        } while(!escolha.equals("4"));
    }
}