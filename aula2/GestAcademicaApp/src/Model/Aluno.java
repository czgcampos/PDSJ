package Model;
public class Aluno {
	private String codigo;
	private String nome;
	private int idade;
	private String curso;
	private double media;
	
	public Aluno(String c, String n, int i, String cr, double m) {
		codigo=new String(c);
		nome=new String(n);
		idade=i;
		curso=new String(cr);
		media=m;
	}
	public Aluno(Aluno a2) {
		codigo=a2.getCodigo();
		nome=a2.getNome();
		idade=a2.getIdade();
		curso=a2.getCurso();
		media=a2.getMedia();
	}
	public String getCodigo() {
		return codigo;
	}
	public String getNome() {
		return nome;
	}
	public int getIdade() {
		return idade;
	}
	public String getCurso() {
		return curso;
	}
	public double getMedia() {
		return media;
	}
	public void setCodigo(String c) {
		codigo=c;
	}
	public void setNome(String n) {
		nome=n;
	}
	public void setIdade(int i) {
		idade=i;
	}
	public void setCurso(String cr) {
		curso=cr;
	}
	public void setMedia(double m) {
		media=m;
	}
	public Aluno clone() {
		return new Aluno(this);
	}
	public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("\nAluno\n");
        s.append("Codigo: ");
        s.append(codigo+"\n");
        s.append("Nome: ")    ;
        s.append(nome+"\n");
        s.append("Idade: ");
        s.append(idade+"\n");
        s.append("Curso: ");
        s.append(curso+"\n");
        s.append("Média: ");
        s.append(media+"\n");
        return s.toString();
    }
}