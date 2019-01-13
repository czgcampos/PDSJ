package Main;
import java.util.*;

import Controller.GestAcademicaController;
import Model.Aluno;
//import Model.GestAcademicaModel;
import Model.GestAcademicaModelMap;
import Model.InterfaceGestAcademicaModel;
import View.GestAcademicaView;

import static java.lang.System.out;

public class GestAcademicaMVCApp {
	private static GestAcademicaModelMap createData() {
        Map<String, Aluno> fichas = new TreeMap<>();
        fichas.put("212", new Aluno("212", "Rui Mota", 21, "LEI", 13.7));
        fichas.put("120", new Aluno("120", "Paulo Rio", 22, "LEM", 12.7));
        fichas.put("192", new Aluno("192", "Rui Silva", 20, "LEI", 13.4));
        fichas.put("310", new Aluno("310", "Marta Couto", 24, "LCC", 13.9));
        fichas.put("912", new Aluno("912", "Rita Moura", 23, "LEI", 14.7));
        fichas.put("232", new Aluno("232", "Joao Silva", 21, "LCC", 15.1));
        fichas.put("311", new Aluno("311", "Jose Faria", 22, "LEM", 13.1));
        fichas.put("415", new Aluno("415", "Paula Ruiz", 20, "LEI", 10.7));
        fichas.put("711", new Aluno("711", "Mario Silva", 25, "LEI", 13.8));
        fichas.put("712", new Aluno("712", "Luis Carlos", 24, "LEM", 12.7));
        fichas.put("200", new Aluno("200", "Maria Joao", 22, "LCC", 12.5));
        return new GestAcademicaModelMap(fichas);  
    }
           
    public static void main(String[] args) {    
    	InterfaceGestAcademicaModel model = createData();
        GestAcademicaView view = new GestAcademicaView();
        GestAcademicaController control = new GestAcademicaController();
        control.setModel(model);  
        control.setView(view);
        control.startFlow();
        out.println("Fim da Aplicação >> " + java.time.LocalDateTime.now());
        System.exit(0);
    }
}