package Controller;

import static java.lang.System.out;
import java.time.LocalDate;
import java.time.LocalTime;
import Model.InterfaceDateTimeModel;

public class ScheduleFlowController {

	private static String getTask() {
		out.print("Qual é a tarefa? ");
		return Input.readString();
	}

	private static int getIndex() {
		int index=0;
		boolean ok = false; 
		while(!ok) {
			out.println("Qual é o indice? ");
			index=Input.readPositiveInt();
			ok=true;
		}
		return index;
	}

	private static void getDay(InterfaceDateTimeModel model, LocalDate day) {
		if(model.getSchedule().containsKey(day))
			out.println(model.consultDay(day));
		else
			out.println("Não tem nada marcado para esse dia");
	}

	public static void consultShedule(InterfaceDateTimeModel model) {
		out.println(model);
		out.println("Prima ENTER para prosseguir...");
		Input.readString();
	}

	public static void insertTask(InterfaceDateTimeModel model) {
		String task=null;
		LocalDate day=null;
		LocalTime initHour=null;
		LocalTime finalHour=null;
		day = DateTimeInputController.inputDate();
		getDay(model,day);
		task = ScheduleFlowController.getTask();
		boolean ok=false;
		while(!ok) {
			out.println("Hora de começo");
			initHour = DateTimeInputController.inputHour();
			out.println("Hora de fim");
			finalHour = DateTimeInputController.inputHour();
			if(initHour.isBefore(finalHour))
				ok=true;
			else
				out.println("Hora de começo é depois da hora de fim, tente de novo!");
		}
		if(model.insertTask(day, initHour, finalHour, task)) {
			out.println("Inseriu "+task+".\nComeça às: "+initHour+".\nTermina às: "+finalHour+"\n");
		} else
			out.println("Impossível inserir esse evento");
		out.println("Prima ENTER para prosseguir...");
		Input.readString();
	}

	public static void consultDay(InterfaceDateTimeModel model) {
		LocalDate day;
		day = DateTimeInputController.inputDate();
		getDay(model,day);
		out.println("Prima ENTER para prosseguir...");
		Input.readString();
	}

	public static void alterTask(InterfaceDateTimeModel model) {
		String task;
		LocalDate day;
		int index;
		day = DateTimeInputController.inputDate();
		getDay(model,day);
		if(model.getSchedule().containsKey(day)) {
			do {
				index = ScheduleFlowController.getIndex();
				if(model.getSchedule().get(day).getSlots().size()-1<index)
					out.println("Indíce errado.");
			}while(model.getSchedule().get(day).getSlots().size()-1<index);
			task = ScheduleFlowController.getTask();
			model.alterTask(day, index, task);
			out.println("Alterou "+model.getSchedule().get(day).getSlots().get(index).getTask()+".\nComeça às: "+model.getSchedule().get(day).getSlots().get(index).getInitHour()+".\nTermina às: "+model.getSchedule().get(day).getSlots().get(index).getFinalHour()+"\n");
		}
		out.println("Prima ENTER para prosseguir...");
		Input.readString();
	}

	public static void deleteTask(InterfaceDateTimeModel model) {
		LocalDate day;
		int index;
		day = DateTimeInputController.inputDate();
		getDay(model,day);
		if(model.getSchedule().containsKey(day)) {
			do {
				index = ScheduleFlowController.getIndex();
				if(model.getSchedule().get(day).getSlots().size()-1<index)
					out.println("Indíce errado.");
			}while(model.getSchedule().get(day).getSlots().size()-1<index);
			model.deleteTask(day, index);
			out.println("Apagou "+model.getSchedule().get(day).getSlots().get(index).getTask()+".\nComeça às: "+model.getSchedule().get(day).getSlots().get(index).getInitHour()+".\nTermina às: "+model.getSchedule().get(day).getSlots().get(index).getFinalHour()+".\n");
		}
		out.println("Prima ENTER para prosseguir...");
		Input.readString();
	}
}