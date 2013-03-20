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
                    Console.Escreverln("5 - Quantidade de Alunos aprovados");
                    Console.Escreverln("6 - Quantidade de Alunos reprovados");
                    Console.Escreverln("7 - Porcentagem de alunos aprovados");
                    Console.Escreverln("8 - Porcentagem de alunos reprovados");
                    Console.Escreverln("9 - Quantidade de turmas cadastradas");
                    
                    digitado = Console.Ler();
                    switch (digitado){
                        case "1" :
                            double media = 0;
                            for (Turma tm : inst.turmas) {
                                media = media + tm.mediaGeral();
                            }
                            Console.Escreverln("Média da escola: " + media / inst.turmas.size());

                        case "2" :
                            Console.Escreverln("Digite a turma: ");
                            digitado = Console.Ler();
                            for (Turma tm : inst.turmas) {
                                if (digitado.equalsIgnoreCase(tm.getDescricao())){
                                    Console.Escreverln("Media da turma: " + tm.mediaGeral());
                                    break;
                                }
                            }
                            
                        case "3" :
                            Console.Escreverln("Digite a turma: ");
                            digitado = Console.Ler();
                            for (Turma tm : inst.turmas) {
                                if (digitado.equalsIgnoreCase(tm.getDescricao())){
                                    Console.Escreverln("Digite o nome do aluno: ");
                                    int codigo = tm.getAluno(Console.Ler());
                                }
                            }
                            
                        case "4" :
                            double quantidade = 0;
                            for (Turma tm : inst.turmas) {
                                quantidade = quantidade + tm.quantidadeAlunos();
                            }
                            
                            Console.Escreverln("Quantidade de alunos: " + quantidade);
                            break;
                            
                        case "5" :
                            Console.Escreverln("Digite a turma: ");
                            digitado = Console.Ler();
                            for (Turma tm : inst.turmas) {
                                if (digitado.equalsIgnoreCase(tm.getDescricao())){
                                    Console.Escreverln("Quantidade de alunos aprovados: " + tm.quantidadeAlunosAprovados());
                                    break;
                                }
                            }
                            
                        case "6" :
                            Console.Escreverln("Digite a turma: ");
                            digitado = Console.Ler();
                            for (Turma tm : inst.turmas) {
                                if (digitado.equalsIgnoreCase(tm.getDescricao())){
                                Console.Escreverln("Quantidade de alunos reprovados: " + tm.quantidadeAlunosReprovados());
                                    break;
                                }
                            }

                        case "7" :
                            Console.Escreverln("Digite a turma: ");
                            digitado = Console.Ler();
                            for (Turma tm : inst.turmas) {
                                if (digitado.equalsIgnoreCase(tm.getDescricao())){
                                    Console.Escreverln("Porcentagem de alunos aprovados: " + tm.porcentagemAlunosAprovados());
                                    break;
                                }
                            }
                            
                        case "8" :
                            Console.Escreverln("Digite a turma: ");
                            digitado = Console.Ler();
                            for (Turma tm : inst.turmas) {
                                if (digitado.equalsIgnoreCase(tm.getDescricao())){
                                    Console.Escreverln("Porcentagem de alunos reprovados: " + tm.porcentagemAlunosReprovados());
                                    break;
                                }
                            }

                        case "9" :
                            Console.Escreverln("quantidade de turmas cadastradas: " + inst.turmas.size());
                            
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