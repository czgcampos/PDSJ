/**
 *
 * @author LEI 2018
 */

package gestAcademia;

import java.util.*;
import static java.util.stream.Collectors.toList;

public class GestAcademicaModel {
    
    private Map<String, Aluno> fichas = new TreeMap<>();
    
    public GestAcademicaModel() {}
    public GestAcademicaModel(Map<String, Aluno> alunos) { fichas = alunos; }
    
    public boolean existeCod(String cod) { return fichas.containsKey(cod); }
    public void add(Aluno al) { fichas.put(al.getCodigo(), al); }
    public void removeAluno(String cod) { fichas.remove(cod); }
    public Aluno get(String cod) { return fichas.get(cod); }
    public int size() { return fichas.size(); }
    
    public Aluno[] toArray() { 
        Aluno[] als = new Aluno[fichas.size()];
        fichas.values().toArray(als);
        return als;
    } 
    
    public List<Aluno> toListAlunos() { return new ArrayList<Aluno>(fichas.values()); }
    
    public Aluno[] toArrayCurso(String c) {
        List<Aluno> alsCurso = fichas.values().stream().filter(a -> a.getCurso().equals(c)).collect(toList());
        Aluno[] als = new Aluno[alsCurso.size()];
        alsCurso.toArray(als);
        return als;     
    }
    
    public Set<String> cursos() {
        Set<String> crs = new TreeSet<>();
        for(String cod : fichas.keySet()) crs.add(fichas.get(cod).getCurso());
        return crs;
    }
        
}
    
  
    
