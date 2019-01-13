package Model;

public interface InterfaceGestAcademicaModel {
	public void insereAluno(String codigo, String nome, int idade, String curso, double media);
	public boolean existeAluno(String codAluno);
	public Aluno getAluno(String codAluno);
	public void removeAluno(String codAluno);
	public int numDeAlunos();
}