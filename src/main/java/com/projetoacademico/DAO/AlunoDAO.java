package com.projetoacademico.DAO;
import com.projetoacademico.model.Aluno;
import java.io.*;
import java.util.ArrayList;
public class AlunoDAO {
    private final String ARQUIVO = "alunos.txt";
    
    public AlunoDAO(){
        if (BaseDeDados.getAlunos().isEmpty()) {
            
        
        carregarDados();
        }
    }
    
    public void incluir(Aluno aluno) throws Exception {
        if (consultar(aluno.getMatricula()) != null) {
            throw new Exception("Matricula já cadastrada!");
        }
        BaseDeDados.getAlunos().add(aluno);
        salvarDados();
    }
    
    public void alterar(Aluno alunoAtualizado) throws Exception {
        Aluno a = consultar(alunoAtualizado.getMatricula());
        if (a == null) {
            throw new Exception("Aluno não encontrado para alteração.");
        }
        a.setNome(alunoAtualizado.getNome());
        a.setCurso(alunoAtualizado.getCurso());
        salvarDados();
    }
public Aluno consultar (int matricula) {
    for (Aluno a : BaseDeDados.getAlunos()) {
        if (a.getMatricula() == matricula) {
            return a;
        }
    }
    return null;
}
public void excluir(int matricula) throws Exception{
    Aluno a = consultar(matricula);
    if (a == null) {
        throw new Exception("Aluno não encontrado para exclusão.");
    }
    BaseDeDados.getAlunos().remove(a);
    salvarDados();
}
public ArrayList<Aluno> listarTodos() {
    return BaseDeDados.getAlunos();
}

private void salvarDados(){
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))){
        for (Aluno a : BaseDeDados.getAlunos()){
            writer.write(a.getMatricula() + ";" + a.getNome() + ";" + a.getCurso());
            writer.newLine();
        }
    } catch (IOException e) {
        System.err.println("Erro ao salvar arquivo de alunos: " + e.getMessage());
    }
}
private void carregarDados(){
    File arquivo = new File(ARQUIVO);
    if (!arquivo.exists()) return;
    
    try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))){
        String linha;
        while ((linha = reader.readLine()) !=null) {
            String[] partes = linha.split(";");
            if (partes.length >=3) {
                try {
                    int mat = Integer.parseInt(partes[0]);
                    Aluno a = new Aluno(mat, partes[1], partes[2]);
                    BaseDeDados.getAlunos().add(a);
                } catch (NumberFormatException e){
                    System.err.println("Erro ao converter matrícula do arquivo (linha ignorada): " + linha);
                }
            }
        }
    } catch (IOException e){
        System.err.println("Erro ao ler arquivo de alunos: " + e.getMessage());
    }
}
}

