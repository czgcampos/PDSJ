package View;
import java.util.Arrays;
import java.util.List;

public class GestAcademicaView {
	public GestAcademicaView() {
        menusGestAcademica = initView();
    }

    private Menus menusGestAcademica = new Menus();

    public static Menus initView() {
    	Menus menusSIGCA = new Menus();
        Opcao p1,p2,p3;
        p1= new Opcao("Gestao de Alunos ....... ", "A");
        p2= new Opcao("Gestao de Cursos ....... ", "C");
        p3= new Opcao("Sair da Aplicacao ...... ","S");
        List<Opcao> linhasPrinc=Arrays.asList(p1,p2,p3);
        Menu menuPrinc=new Menu(linhasPrinc,"   Menu Principal");
        menusSIGCA.addMenu(0,menuPrinc);
        Opcao op1, op2, op3, op4;
        op1 = new Opcao("Inserir Aluno ....... ", "I");
        op2 = new Opcao("Remover Aluno ....... ", "R");
        op3 = new Opcao("Consultar Aluno ..... ", "C");
        op4 = new Opcao("Menu Principal >>>>>> ", "S");
        List<Opcao> linhas = Arrays.asList(op1, op2, op3, op4);
        Menu menuAlunos = new Menu(linhas, "   Gestão Alunos");
        menusSIGCA.addMenu(1, menuAlunos);
	    Opcao opC1,opC2,opC3,opC4;
	    opC1 = new Opcao("Lista de Cursos ............ ","L");
	    opC2 = new Opcao("Total de Inscritos ......... ", "I");
	    opC3 = new Opcao("Tabela No Alunos por Curso . ", "T");
	    opC4 = new Opcao("Voltar ao menu principal >>> ","S");
	    List<Opcao> linhasCurso=Arrays.asList(opC1,opC2,opC3,opC4);
	    Menu menuCursos=new Menu(linhasCurso,"   Gestao Cursos");
	    menusSIGCA.addMenu(2,menuCursos);
        return menusSIGCA;
    }

	public Menu getMenu(int i) {
		return menusGestAcademica.getMenu(i);
	}
}