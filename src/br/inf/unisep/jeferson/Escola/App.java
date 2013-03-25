package br.inf.unisep.jeferson.Escola;

import br.com.fadanelli.utilitarios.io.Console;

public class App {

    public static void main(String args[]) {
        String escolha, subEscolha;

        Instituicao inst = new Instituicao();

        do {
            Console.escreverln("1 - Gerênciar turmas");
            Console.escreverln("2 - Gerênciar alunos");
            Console.escreverln("3 - Relatórios");
            Console.escreverln("4 - Abandonar");
            escolha = Console.ler();

            switch (escolha) {
                case "1":
                    Console.escreverln("1 - Abrir turma");
                    Console.escreverln("2 - Fechar turma");
                    Console.escreverln("3 - Voltar");
                    subEscolha = Console.ler();
                    if (subEscolha.equals("3")){
                        break;
                    }
                    if (subEscolha.equals("1")) {
                        Console.escreverln("Digite a série da turma: ");
                        Turma tur = new Turma(Console.ler());
                        inst.abrirTurma(tur);
                    } else {
                        if (temTurmaCadastrada(inst)){
                            Console.escreverln("Digite a série da turma: ");
                            inst.fechaTurma(Console.ler());
                        } else {
                            Console.escreverln("É necessário cadastrar uma turma antes de fecha-la.");
                        }
                    }
                    break;

                case "2":
                    if (temTurmaCadastrada(inst)) {
                        Console.escreverln("1 - Matricular aluno");
                        Console.escreverln("2 - Cancelar matrícula");
                        Console.escreverln("3 - Lançar nota G1");
                        Console.escreverln("4 - Lançar nota G2");                        
                        Console.escreverln("5 - Voltar");
                        
                        String digitado = Console.ler();
                        switch (digitado) {
                            case "1":
                                Console.escreverln("Digite a turma do aluno: ");
                                for (Turma tm : inst.turmas) {
                                    if (tm.getDescricao().equalsIgnoreCase(Console.ler())) {
                                        Console.escreverln("Digite o nome do aluno: ");
                                        Aluno alunoNovo = new Aluno(Console.ler());
                                        tm.matricula(alunoNovo);
                                    }
                                }
                                break;

                            case "2":
                                Console.escreverln("Digite a turma do aluno: ");
                                for (Turma tm : inst.turmas) {
                                    if (tm.getDescricao().equalsIgnoreCase(Console.ler())) {
                                        Console.escreverln("Digite o nome do aluno: ");
                                        tm.cancelarMatricula(tm.getCodigoAluno(Console.ler()));
                                    }
                                }
                                break;

                            case "3" :
                                Console.escreverln("Digite a turma do aluno: ");
                                for (Turma tm : inst.turmas) {
                                    if (tm.getDescricao().equalsIgnoreCase(Console.ler())) {
                                        Console.escreverln("Digite o nome do aluno: ");
                                        Aluno aluno = tm.getAluno(Console.ler());
                                        Console.escreverln("Digite a nota: ");
                                        digitado = Console.ler();
                                        float nota = Float.parseFloat(digitado);
                                        if (nota > 0 && nota <= 10){
                                            aluno.setG1(nota);
                                        } else {
                                            Console.escreverln("Nota inválida");
                                        }
                                    }
                                }
                                break;
                                
                            case "4" :
                                Console.escreverln("Digite a turma do aluno: ");
                                for (Turma tm : inst.turmas) {
                                    if (tm.getDescricao().equalsIgnoreCase(Console.ler())) {
                                        Console.escreverln("Digite o nome do aluno: ");
                                        Aluno aluno = tm.getAluno(Console.ler());;
                                        Console.escreverln("Digite a nota: ");
                                        digitado = Console.ler();
                                        float nota = Float.parseFloat(digitado);
                                        if (nota > 0 && nota <= 10){
                                            aluno.setG2(nota);
                                        } else {
                                            Console.escreverln("Nota inválida");
                                        }
                                    }
                                }
                                break;

                            default:
                                break;
                        }
                    } else{
                        Console.escreverln("Cadastre a turma antes de inserir alunos!");
                    }
                    break;

                case "3":
                    Console.escreverln("1 - Média escola");
                    Console.escreverln("2 - Média turma");
                    Console.escreverln("3 - Média aluno");
                    Console.escreverln("4 - Quantidade de Alunos matriculados");
                    Console.escreverln("5 - Quantidade de Alunos aprovados");
                    Console.escreverln("6 - Quantidade de Alunos reprovados");
                    Console.escreverln("7 - Porcentagem de alunos aprovados");
                    Console.escreverln("8 - Porcentagem de alunos reprovados");
                    Console.escreverln("9 - Quantidade de turmas cadastradas");

                    String digitado = Console.ler();
                    switch (digitado) {
                        case "1":
                            double media = 0;
                            for (Turma tm : inst.turmas) {
                                media = media + tm.mediaGeral();
                            }
                            Console.escreverln("Média da escola: " + media / inst.turmas.size());

                        case "2":
                            Console.escreverln("Digite a turma: ");
                            digitado = Console.ler();
                            for (Turma tm : inst.turmas) {
                                if (digitado.equalsIgnoreCase(tm.getDescricao())) {
                                    Console.escreverln("Media da turma: " + tm.mediaGeral());
                                    break;
                                }
                            }

                        case "3":
                            Console.escreverln("Digite a turma: ");
                            digitado = Console.ler();
                            for (Turma tm : inst.turmas) {
                                if (digitado.equalsIgnoreCase(tm.getDescricao())) {
                                    Console.escreverln("Digite o nome do aluno: ");
                                    Aluno aluno = tm.getAluno(Console.ler());
                                    Console.escreverln("Média do aluno: " + aluno.getMedia());
                                }
                            }

                        case "4":
                            double quantidade = 0;
                            for (Turma tm : inst.turmas) {
                                quantidade = quantidade + tm.quantidadeAlunos();
                            }

                            Console.escreverln("Quantidade de alunos: " + quantidade);
                            break;

                        case "5":
                            Console.escreverln("Digite a turma: ");
                            digitado = Console.ler();
                            for (Turma tm : inst.turmas) {
                                if (digitado.equalsIgnoreCase(tm.getDescricao())) {
                                    Console.escreverln("Quantidade de alunos aprovados: " + tm.quantidadeAlunosAprovados());
                                    break;
                                }
                            }

                        case "6":
                            Console.escreverln("Digite a turma: ");
                            digitado = Console.ler();
                            for (Turma tm : inst.turmas) {
                                if (digitado.equalsIgnoreCase(tm.getDescricao())) {
                                    Console.escreverln("Quantidade de alunos reprovados: " + tm.quantidadeAlunosReprovados());
                                    break;
                                }
                            }

                        case "7":
                            Console.escreverln("Digite a turma: ");
                            digitado = Console.ler();
                            for (Turma tm : inst.turmas) {
                                if (digitado.equalsIgnoreCase(tm.getDescricao())) {
                                    Console.escreverln("Porcentagem de alunos aprovados: " + tm.porcentagemAlunosAprovados());
                                    break;
                                }
                            }

                        case "8":
                            Console.escreverln("Digite a turma: ");
                            digitado = Console.ler();
                            for (Turma tm : inst.turmas) {
                                if (digitado.equalsIgnoreCase(tm.getDescricao())) {
                                    Console.escreverln("Porcentagem de alunos reprovados: " + tm.porcentagemAlunosReprovados());
                                    break;
                                }
                            }

                        case "9":
                            Console.escreverln("quantidade de turmas cadastradas: " + inst.turmas.size());

                    }

                    break;

                case "4":
                    Console.escreverln("App Finalizado.");
                    break;

                default:
                    Console.escreverln("Digite somente os números disponíveis");
            }
            Console.escreverln(" ");
            Console.escreverln(" ");
        } while (!escolha.equals("4"));
    }
   
    public static boolean temTurmaCadastrada(Instituicao inst){   
        return inst.turmas.size() > 0;
    }
    
}