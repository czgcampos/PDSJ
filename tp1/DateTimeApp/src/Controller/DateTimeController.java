package Controller;

import static java.lang.System.out;
import Model.*;
import View.*;

public class DateTimeController {

	private InterfaceDateTimeModel model;
	private InterfaceDateTimeView view;

	public void setModel(InterfaceDateTimeModel model) { 
		this.model=model;
	}

	public void setView(InterfaceDateTimeView view) { 
		this.view=view;
	}

	private void datesFlow() {
		Menu menu = this.view.getMenu(1);
		String opcao;
		do {
			menu.show();
			opcao = Input.readString(); 
			opcao = opcao.toUpperCase();
			switch(opcao) {
				case "1" : DateTimeFlowController.datesDif(); break;
				case "2" : DateTimeFlowController.datesAddOrSub(); break;
				case "3" : DateTimeFlowController.AgeCalc(); break;
				case "4" : DateTimeFlowController.timeDif(); break;
				case "5" : DateTimeFlowController.timeAddOrSub(); break;
				case "6" : DateTimeFlowController.lastBusinessDayInMonth(); break;
				case "7" : DateTimeFlowController.businessDaysBetween(); break;
				case "8" : DateTimeFlowController.addBusinessDays(); break;
				case "Q" : break;
				default: out.println("Opcão Inválida !"); break;
			}
		}
		while(!opcao.equals("Q"));
	}

	private void timezoneFlow() {
		Menu menu = this.view.getMenu(2);
		String opcao;
		do {
			menu.show();
			opcao = Input.readString(); 
			opcao = opcao.toUpperCase();
			switch(opcao) {
				case "1" : TimeZoneFlowController.changeZone();break;
				case "2" : TimeZoneFlowController.differenceBetweenZones();break;
				case "3" : TimeZoneFlowController.calculateArrivalTime(); break;
				case "4" : TimeZoneFlowController.tripTime(); break;
				case "5" : TimeZoneFlowController.listZoneIds();  break;
				case "Q" : break;
				default: out.println("Opcão Inválida !"); break;
			}
		}
		while(!opcao.equals("Q"));
	}

	private void scheduleFlow() {
		Menu menu = this.view.getMenu(3);
		String opcao;
		do {
			menu.show();
			opcao = Input.readString(); 
			opcao = opcao.toUpperCase();
			switch(opcao) {
				case "1" : ScheduleFlowController.consultShedule(this.model); break;
				case "2" : ScheduleFlowController.insertTask(this.model); break;
				case "3" : ScheduleFlowController.consultDay(this.model); break;
				case "4" : ScheduleFlowController.alterTask(this.model); break;
				case "5" : ScheduleFlowController.deleteTask(this.model); break;
				case "Q" : break;
				default: out.println("Opcão Inválida !"); break;
			}
		}
		while(!opcao.equals("Q"));
	}

	public void startFlow () {
		Menu menu = this.view.getMenu(0);
		String opcao;
		do {
			menu.show();
			opcao = Input.readString(); 
			opcao = opcao.toUpperCase();
			switch(opcao) {
				case "1" : datesFlow(); break;
				case "2" : timezoneFlow(); break;
				case "3" : scheduleFlow(); break;
				case "Q": break;
				default: out.println("Opcão Inválida !"); break;
			}
		}
		while(!opcao.equals("Q"));
	}
}