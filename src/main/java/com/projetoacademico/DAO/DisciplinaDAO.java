
package com.projetoacademico.DAO;

import com.projetoacademico.model.Disciplina;
import java.io.*;
import java.util.ArrayList;

public class DisciplinaDAO {


private final String ARQUIVO = "disciplinas.txt";

public DisciplinaDAO(){
   if (BaseDeDados.getDisciplinas().isEmpty()){
       
   
    carregarDados();
   }
}
public void incluir(Disciplina disciplina) throws Exception {
    if (consultar(disciplina.getCodigo()) != null) {
        throw new Exception("Código de disciplina já existe!");
    }
    BaseDeDados.getDisciplinas().add(disciplina);
    salvarDados();
}

public void alterar(Disciplina novaDisc) throws Exception {
    Disciplina d = consultar(novaDisc.getCodigo());
    if (d == null) throw new Exception("Disciplina não encontrada.");
    
    d.setNome(novaDisc.getNome());
    d.setCargaHoraria(novaDisc.getCargaHoraria());
    salvarDados();
}
public Disciplina consultar(String codigo) {
    for (Disciplina d : BaseDeDados.getDisciplinas()) {
        if (d.getCodigo().equalsIgnoreCase(codigo)) return d;
    }
    return null;
}
public void excluir(String codigo) throws Exception {
    Disciplina d = consultar(codigo);
    if (d == null) throw new Exception("Disciplina não encontrada. ");
    
    BaseDeDados.getDisciplinas().remove(d);
    salvarDados();
}
public ArrayList<Disciplina> listarTodos(){
    return BaseDeDados.getDisciplinas();
}

private void salvarDados(){
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {
        for (Disciplina d : BaseDeDados.getDisciplinas()) {
            writer.write(d.getCodigo() + ";" + d.getNome() + ";" + d.getCargaHoraria());
            writer.newLine();
        }
    } catch (IOException e) {
        System.err.println("Erro ao salvar disciplinas: " + e.getMessage());
    }
}
private void carregarDados() {
    File arquivo = new File(ARQUIVO);
    if (!arquivo.exists()) return;
    
    try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
        String linha;
        while ((linha = reader.readLine()) != null){
            String [] partes = linha.split(";");
            if (partes.length >= 3){
                int ch = Integer.parseInt(partes[2]);
                Disciplina d = new Disciplina(partes[0], partes [1], ch);
                BaseDeDados.getDisciplinas().add(d);
            }
        }
    } catch (IOException | NumberFormatException e) {
        System.err.println("Erro ao ler disciplinas: " + e.getMessage());
    }
}
}
