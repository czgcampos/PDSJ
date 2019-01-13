package View;

import java.util.Arrays;
import java.util.List;

public class DateTimeViewTxt implements InterfaceDateTimeView{
	
	private Menus menus = new Menus();
	
	public DateTimeViewTxt() {
		this.menus = initMenus();
	}

	public static Menus initMenus() {
		Menus menusDateTime = new Menus();
		Option op1,op2,op3,op4;
		op1 = new Option("Calculadora de datas ............... ","1");
		op2 = new Option("Calculadora de fusos ............... ","2");
		op3 = new Option("Agenda ............................. ","3");
		op4 = new Option("Sair da Aplicacao >>>>>>>>>>>>>>>>>> ","Q");
		List<Option> linhasPrinc=Arrays.asList(op1,op2,op3,op4);
		Menu menuPrinc=new Menu(linhasPrinc,"   Menu Principal");
		menusDateTime.addMenu(0,menuPrinc);
		Option od1, od2, od3, od4, od5, od6, od7, od8, od9;
		od1 = new Option("Diferença entre datas .............. ","1");
		od2 = new Option("Somar/subtrair tempo a uma data .... ","2");
		od3 = new Option("Calcular idade ..................... ","3");
		od4 = new Option("Diferenaça entre tempos ............ ","4");
		od5 = new Option("Somar/subtrair tempo a outro tempo . ","5");
		od6 = new Option("Último dia útil do mês ............. ","6");
		od7 = new Option("Dias úteis entre datas ............. ","7");
		od8 = new Option("Somar dias utéis a uma data ........ ","8");
		od9 = new Option("Menu Principal >>>>>>>>>>>>>>>>>>>>> ","Q");
		List<Option> linhasDatas = Arrays.asList(od1, od2, od3, od4, od5, od6, od7, od8, od9);
		Menu menuDatas = new Menu(linhasDatas, "   Calculadora de Datas");
		menusDateTime.addMenu(1, menuDatas);
		Option of1,of2,of3,of4,of5,of6;
		of1 = new Option("Ver hora atual por fuso horário .... ","1");
		of2 = new Option("Diferença de tempo entre fusos ..... ","2");
		of3 = new Option("Simular chegada de viagem .......... ","3");
		of4 = new Option("Número de horas de viagem .......... ","4");
		of5 = new Option("Listas de Zone IDS ................. ","5");
		of6 = new Option("Voltar ao menu principal >>>>>>>>>>> ","Q");
		List<Option> linhasFuso=Arrays.asList(of1,of2,of3,of4,of5,of6);
		Menu menuFuso=new Menu(linhasFuso,"   Calculadora de Fusos Horários");
		menusDateTime.addMenu(2,menuFuso);
		Option oa1,oa2,oa3,oa4,oa5,oa6;
		oa1 = new Option("Consultar agenda ................... ","1");
		oa2 = new Option("Inserir tarefa ..................... ","2");
		oa3 = new Option("Consultar dia ...................... ","3");
		oa4 = new Option("Alterar tarefa ..................... ","4");
		oa5 = new Option("Remover tarefa ..................... ","5");
		oa6 = new Option("Voltar ao menu principal >>>>>>>>>>> ","Q");
		List<Option> linhasAgenda=Arrays.asList(oa1,oa2,oa3,oa4,oa5,oa6);
		Menu menuAgenda=new Menu(linhasAgenda,"   Gestão de Agenda");
		menusDateTime.addMenu(3,menuAgenda);
		return menusDateTime;
	}

	public Menu getMenu(int index) {
		return this.menus.getMenu(index);
	}	
}