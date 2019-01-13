package Controller;

import static java.lang.System.out;
import static java.time.temporal.TemporalAdjusters.ofDateAdjuster;
import static java.time.DayOfWeek.*;
import static java.time.temporal.TemporalAdjusters.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.temporal.TemporalAdjuster;

public class DateTimeFlowController {

	public static void datesDif() {
		LocalDate d1=DateTimeInputController.inputDate();
		LocalDate d2=DateTimeInputController.inputDate();
		Period dif=null;
		if(d1.isBefore(d2))
			dif=Period.between(d1,d2);
		else
			dif=Period.between(d2,d1);
		out.println("Diferença: " + dif.getDays() + " dias, " + dif.getMonths() + " meses, " + dif.getYears() + " anos");
		out.println("Prima ENTER para prosseguir...");
		Input.readString();
	}

	private static int getDays() {
		out.print("Dia: ");
		return Input.readPositiveInt();
	}

	private static int getMonths() {
		out.print("Mês: ");
		return Input.readPositiveInt();
	}

	private static int getYears() {
		out.print("Ano: ");
		return Input.readPositiveInt();
	}

	public static void datesAdd() {
		LocalDate data = DateTimeInputController.inputDate();
		out.println("Tempo a somar");
		TemporalAdjuster addDate = ofDateAdjuster(date -> date.plusDays(getDays()).plusMonths(getMonths()).plusYears(getYears()));
		LocalDate dateAdd = data.with(addDate);
		out.println("Resultado: " + dateAdd.getDayOfMonth() + " / " + dateAdd.getMonthValue()+ " / " + dateAdd.getYear());
	}
	
	public static void datesSub() {
		LocalDate data = DateTimeInputController.inputDate();
		out.println("Tempo a subtrair");
		TemporalAdjuster subDate = ofDateAdjuster(date -> date.minusDays(getDays()).minusMonths(getMonths()).minusYears(getYears()));
		LocalDate dateSub = data.with(subDate);
		out.println("Resultado: " + dateSub.getDayOfMonth() + " / " + dateSub.getMonthValue() + " / " + dateSub.getYear());
	}

	public static void datesAddOrSub() {
		String opcao;
		do {
			out.print("Quer somar (+), subtrair (-) ou voltar ao menu anterior (0)? ");
			opcao = Input.readString(); 
			opcao = opcao.toUpperCase();
			switch(opcao) {
				case "+" : datesAdd(); break;
				case "-" : datesSub(); break;
				case "0" : break;
				default: out.println("Opcão Inválida !"); break;
			}
		}
		while(!opcao.equals("0"));
	}

	public static void AgeCalc() {
		out.print("Data de nascimento -> ");
		Period dif=Period.between(DateTimeInputController.inputDate(), LocalDate.now());
		out.println("Idade: " + dif.getYears() + " anos, " + dif.getMonths() + " meses, " + dif.getDays() + " dias, ");
		out.println("Prima ENTER para prosseguir...");
		Input.readString();
	}

	public static void timeDif() {
		LocalTime t1 = DateTimeInputController.inputTime();
		LocalTime t2 = DateTimeInputController.inputTime();
		Duration dif=null;
		if(t1.isBefore(t2))
			dif = Duration.between(t1,t2);
		else
			dif = Duration.between(t2,t1);
		out.println("Diferença: " + dif.getSeconds()/3600 + " horas, " + (dif.getSeconds()%3600)/60 + " minutos, " + dif.getSeconds()%60 + " segundos");
		out.println("Prima ENTER para prosseguir...");
		Input.readString();
	}

	public static void timeAdd() {
		LocalTime time = DateTimeInputController.inputTime();
		out.print("Tempo a somar\nHoras ");
		int horasAdd=Input.readInt();
		out.print("Minutos: ");
		int minsAdd=Input.readInt();
		out.print("Segundos: ");
		int segsAdd=Input.readInt();
		LocalTime timeAdd = time.plusHours(horasAdd).plusMinutes(minsAdd).plusSeconds(segsAdd);
		out.println("Resultado: " + timeAdd.getHour() + " horas, " + timeAdd.getMinute() + " minutos, " + timeAdd.getSecond() + "segundos");
	}

	public static void timeSub() {
		LocalTime time = DateTimeInputController.inputTime();
		out.print("Tempo a subtrair\nHoras ");
		int horasSub=Input.readInt();
		out.print("Minutos: ");
		int minsSub=Input.readInt();
		out.print("Segundos: ");
		int segsSub=Input.readInt();
		LocalTime timeSub = time.minusHours(horasSub).minusMinutes(minsSub).minusSeconds(segsSub);
		out.println("Resultado: " + timeSub.getHour() + " horas, " + timeSub.getMinute() + " minutos, " + timeSub.getSecond() + "segundos");
	}

	public static void timeAddOrSub() {
		String opcao;
		do {
			out.println("Quer somar (+), subtrair (-) ou voltar ao menu anterior (0)?");
			opcao = Input.readString(); 
			opcao = opcao.toUpperCase();
			switch(opcao) {
				case "+" : timeAdd(); break;
				case "-" : timeSub(); break;
				case "0" : break;
				default: out.println("Opcão Inválida !"); break;
			}
		}
		while(!opcao.equals("0"));
	}

	public static void lastBusinessDayInMonth() {
		Month month = DateTimeInputController.inputMonth();
		Year year = DateTimeInputController.inputYear();
		LocalDate lastDay = LocalDate.now().with(lastDayOfMonth()).withMonth(month.getValue()).withYear(year.getValue());
		TemporalAdjuster lastBDay = ofDateAdjuster(date -> {if(lastDay.getDayOfWeek().equals(SATURDAY)) return date.minusDays(1);
															else if(lastDay.getDayOfWeek().equals(SUNDAY)) return date.minusDays(2);
															else return date;});
		LocalDate lastBussinessDay = lastDay.with(lastBDay);
		out.println("Ultimo dia útil do mês é: "+lastBussinessDay.getDayOfMonth()+"/"+lastBussinessDay.getMonthValue()+"/"+lastBussinessDay.getYear());
		out.println("Prima ENTER para prosseguir...");
		Input.readString();
	}
	
	public static void businessDaysBetween(){
		LocalDate date1 = DateTimeInputController.inputDate();
		LocalDate date2 = DateTimeInputController.inputDate();
		int workdays = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("Entre as datas " + date1 + " e " + date2);
		if(date1.isBefore(date2)) {
			for (;date1.isBefore(date2);date1 = date1.plusDays(1))
				if (!date1.getDayOfWeek().equals(SATURDAY) && !date1.getDayOfWeek().equals(SUNDAY))
					workdays++;
		} else {
			for (;!date2.isAfter(date1);date2 = date2.plusDays(1))
				if (!date2.getDayOfWeek().equals(SATURDAY) && !date2.getDayOfWeek().equals(SUNDAY))
					workdays++;
		}
		sb.append(" existem " + workdays + " dias úteis.");
		out.println(sb);
		out.println("Prima ENTER para prosseguir...");
		Input.readString();
	}
	
	public static void addBusinessDays() {
		LocalDate date = DateTimeInputController.inputDate();
		out.print("Número de dias a adicionar: ");
		int nDays = Input.readPositiveInt();
		while (nDays>0) {
			if (date.getDayOfWeek().equals(SATURDAY) || date.getDayOfWeek().equals(SUNDAY))
				date = date.plusDays(1);
			else if (date.getDayOfWeek().equals(FRIDAY)) {
				date = date.plusDays(3);
				nDays--;
			}
			else {
				date = date.plusDays(1);
				nDays--;
			}
		}
		out.println("Resultado: " + date.getDayOfMonth() + " / " + date.getMonthValue() + " / " + date.getYear());
		out.println("Prima ENTER para prosseguir...");
		Input.readString();
	}
}