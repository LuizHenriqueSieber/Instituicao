
package br.inf.unisep.jeferson.Escola;

import java.util.ArrayList;
import java.util.List;

public class Instituicao {

   protected List<Turma> turmas;

    public Instituicao(){
        turmas = new ArrayList();
    }
    
    public void abrirTurma(Turma turma){
        turmas.add(turma);
    }
    
    public void fechaTurma(String descricao){
        for (Turma tur : turmas){
            if (tur.getDescricao().equals(descricao)){
                turmas.remove(tur);
            }
        }
    }
}
