
package com.projetoacademico.DAO;

import com.projetoacademico.model.Aluno;
import com.projetoacademico.model.Disciplina;
import java.util.ArrayList;
public class BaseDeDados {
    private static ArrayList<Aluno> tabelaAlunos;
    private static ArrayList<Disciplina> tabelaDisciplinas;
    
    static {
        tabelaAlunos = new ArrayList<>();
        tabelaDisciplinas = new ArrayList<>();
    }
    public static ArrayList<Aluno> getAlunos() {
        return tabelaAlunos;
    }
    public static ArrayList<Disciplina> getDisciplinas() {
        return tabelaDisciplinas;
    }
    
}
