package Controller;
import static java.lang.System.out;

import Model.InterfaceGestAcademicaModel;
import View.GestAcademicaView;
import View.Menu;

public class GestAcademicaController {
	private InterfaceGestAcademicaModel model;
    private GestAcademicaView viewTxt;
    
    public void setModel(InterfaceGestAcademicaModel alunos) { 
		model = alunos; 
    }
    
    public void setView(GestAcademicaView txtMenus) { 
		viewTxt = txtMenus; 
    }
    
	private void flowInsereAluno() {
        String codigo;
        String nome;
        int idade;
        String curso;
        double media;
        System.out.print("Codigo: ");
        codigo = Input.lerString();
        System.out.print("Nome: ");
        nome = Input.lerString();
        System.out.print("Idade: ");
        idade = Input.lerInt();
        System.out.print("Curso: ");
        curso = Input.lerString();
        System.out.print("Media: ");
        media = Input.lerDouble();
        if(model.existeAluno(codigo))
        	System.out.println("Já existe "+codigo);
        else
        	model.insereAluno(codigo, nome, idade, curso, media);
	}
	
	private void flowRemoveAluno() {
		String codigo;
        System.out.print("Codigo: ");
        codigo = Input.lerString();
        model.removeAluno(codigo);
        if(model.existeAluno(codigo))
        	System.out.println("Removeu "+codigo);
        else
        	System.out.println("Não existe "+codigo);
	}

	private void flowConsultaAluno() {
		String codigo;
        System.out.print("Codigo: ");
        codigo = Input.lerString();
        if(model.existeAluno(codigo))
        	System.out.println(model.getAluno(codigo).getNome());
        else
        	System.out.println("Não existe "+codigo);
	}
	
    private void flowAlunos() {
		Menu menu = viewTxt.getMenu(1);
        String opcao;
        do {
            menu.show();
            opcao = Input.lerString(); 
            opcao = opcao.toUpperCase();
            switch(opcao) {
                case "I" : flowInsereAluno(); break;
                case "R" : flowRemoveAluno(); break;
                case "C" : flowConsultaAluno(); break;
                case "S": break;
                default: out.println("Opcão Inválida !"); break;
            }
        }
        while(!opcao.equals("S"));
	}

	private void flowCursos() {
		Menu menu = viewTxt.getMenu(2);
        String opcao;
        do {
            menu.show();
            opcao = Input.lerString(); 
            opcao = opcao.toUpperCase();
            switch(opcao) {
                case "L" : flowAlunos(); break;
                case "I" : flowCursos(); break;
                case "T" : flowAlunos(); break;
                case "S": break;
                default: out.println("Opcão Inválida !"); break;
            }
        }
        while(!opcao.equals("S"));  
	}
	
    public void startFlow () {
        Menu menu = viewTxt.getMenu(0);
        String opcao;
        do {
            menu.show();
            opcao = Input.lerString(); 
            opcao = opcao.toUpperCase();
            switch(opcao) {
                case "A" : flowAlunos(); break;
                case "C" : flowCursos(); break;
                case "S": break;
                default: out.println("Opcão Inválida !"); break;
            }
        }
        while(!opcao.equals("S"));
    }
}