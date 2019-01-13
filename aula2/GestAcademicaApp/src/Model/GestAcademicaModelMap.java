package Model;

import java.util.Map;
import java.util.TreeMap;
import static java.util.stream.Collectors.toMap;

import Model.Aluno;

public class GestAcademicaModelMap implements InterfaceGestAcademicaModel {
	
	private Map<String, Aluno> fichas = new TreeMap<>();
	
    public GestAcademicaModelMap() {}
    public GestAcademicaModelMap(Map<String, Aluno> alunos) { 
          fichas = alunos; 
    }
    public Map<String,Aluno> getFichas(){
		return fichas.entrySet()
                .stream()
                .collect(toMap(e->e.getKey(), e->e.getValue().clone()));
    }
    public void insereAluno(String codigo, String nome, int idade, String curso, double media){
    	fichas.put(codigo,new Aluno(codigo,nome,idade,curso,media));
    }
    public boolean existeAluno(String codAluno){
    	return fichas.containsKey(codAluno);
    }
    public Aluno getAluno(String codAluno){
    	return fichas.get(codAluno);
    }
    public void removeAluno(String codAluno){
    	fichas.remove(codAluno);
    }
    public int numDeAlunos(){
    	return fichas.size();
    }
}