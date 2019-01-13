package Model;
import java.util.*;
import java.util.stream.Collectors;

public class GestAcademicaModel implements InterfaceGestAcademicaModel {
	private Set<Aluno> fichas = new TreeSet<>();
    public GestAcademicaModel() {}
    public GestAcademicaModel(Set<Aluno> alunos) { 
          fichas = alunos; 
    }
    public Set<Aluno> getFichas(){
		return fichas.stream().collect(Collectors.toSet());
    }
    public void insereAluno(String codigo, String nome, int idade, String curso, double media){
    	fichas.add(new Aluno(codigo,nome,idade,curso,media));
    }
    public boolean existeAluno(String codAluno){
    	for(Aluno a : fichas) {
    		if(a.getCodigo().equals(codAluno))
    			return true;
		}
    	return false;
    }
    public Aluno getAluno(String codAluno){
    	for(Aluno a : fichas) {
    		if(a.getCodigo().equals(codAluno))
    			return a;
		}
    	return null;
    }
    public void removeAluno(String codAluno){
    	for(Aluno a : fichas) {
    		if(a.getCodigo().equals(codAluno))
    			fichas.remove(a);
		}
    }
    public int numDeAlunos(){
    	return fichas.size();
    }
}