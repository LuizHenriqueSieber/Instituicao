package bc.inf.unisep.jeferson.Escola;

import br.inf.unisep.jeferson.Escola.Aluno;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class AlunoTest {

    Aluno aluno;

    // Testes a serem implementados
    // - Para cada um das operações descritas.

    @Before
    public void init(){
        aluno = new Aluno("");
        aluno.setG1(1);
        aluno.setG2(10);
    }

    @Test
    public void getMedia(){
        assertEquals(7, aluno.getMedia(), 0);        
    }
}
