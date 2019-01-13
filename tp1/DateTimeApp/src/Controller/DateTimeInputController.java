package Controller;

import static java.lang.System.out;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeInputController {

	public static LocalDate inputDate() {
		LocalDate date=null;
		boolean ok = false; 
		while(!ok) {
			try {
				out.print("Digite os campos da data\nDia: ");
				int day=Input.readPositiveInt();
				out.print("Mês: ");
				int month=Input.readPositiveInt();
				out.print("Ano: ");
				int ano=Input.readPositiveInt();
				date = LocalDate.of(ano, month, day);
				ok = true;
			}catch(DateTimeException e) {
				out.println(e);
			}
		}
		return date;
	}

	public static LocalTime inputHour() {
		LocalTime hour=null;
		boolean ok = false; 
		while(!ok) {
			try {
				out.print("Digite os campos da hora\nHora: ");
				int hours=Input.readPositiveInt();
				out.print("Minutos: ");
				int minute=Input.readPositiveInt();
				hour = LocalTime.of(hours, minute);	
				ok = true;
			}catch(DateTimeException e) {
				out.println(e);
			}
		}
		return hour;
	}

	public static LocalTime inputTime() {
		LocalTime time=null;
		boolean ok = false; 
		while(!ok) {
			try {
				out.print("Digite os campos da hora\nHora: ");
				int hour=Input.readPositiveInt();
				out.print("Minutos: ");
				int minute=Input.readPositiveInt();
				out.print("Segundos: ");
				int second=Input.readPositiveInt();
				time = LocalTime.of(hour, minute, second);	
				ok = true;
			}catch(DateTimeException e) {
				out.println(e);
			}
		}
		return time;
	}

	public static LocalDateTime inputDateTime() {
		LocalDateTime dateTime=null;
		LocalDate date = inputDate();
		LocalTime time = inputTime();
		dateTime = LocalDateTime.of(date, time);
		return dateTime;
	}

	private static final String exemplosFusos=("Lista de alguns exemplos de fusos horários:\n"+
			"EST - -05:00\n" +
			"HST - -10:00\n" +
			"MST - -07:00\n" +
			"ACT - Australia/Darwin\n" +
			"AET - Australia/Sydney\n" +
			"AGT - America/Argentina/Buenos_Aires\n" +
			"ART - Africa/Cairo\n" +
			"BET - America/Sao_Paulo\n" +
			"CST - America/Chicago\n" +
			"CTT - Asia/Shanghai\n" +
			"EAT - Africa/Addis_Ababa\n" +
			"ECT - Europe/Paris\n" +
			"JST - Asia/Tokyo\n" +
			"NST - Pacific/Auckland\n" +
			"PST - America/Los_Angeles");

	private static String zoneSwitch(String opcao){
		switch(opcao) {
			case "EST": return "-5:00";
			case "HST": return "-10:00";
			case "MST": return "-07:00";
			case "ACT": return "Australia/Darwin";
			case "AET": return "Australia/Sydney";
			case "AGT": return "America/Argentina/Buenos_Aires";
			case "ART": return "Africa/Cairo";
			case "BET": return "America/Sao_Paulo";
			case "CST": return "America/Chicago";
			case "CTT": return "Asia/Shanghai";
			case "EAT": return "Africa/Addis_Ababa";
			case "ECT": return "Europe/Paris";
			case "JST": return "Asia/Tokyo";
			case "NST": return "Pacific/Auckland";
			case "PST": return "America/Los_Angeles";
			default: return opcao;
		}
	}

	public static ZoneId inputZoneId(){
		ZoneId nzid = null;
		boolean ok=false;
		String option="";
		out.println(exemplosFusos);
		while(!ok){
			try {
				option = zoneSwitch(Input.readString());
				nzid = ZoneId.of(option);
				ok=true;
			} catch (DateTimeException e) {
				out.println(e);
			}
		}
		return nzid;
	}

	public static ZonedDateTime inputZonedDateTime(){
		ZoneId zid=inputZoneId();
		LocalDate ld=inputDate();
		LocalTime lt=inputHour();
		ZonedDateTime nzdt=ZonedDateTime.of(ld,lt,zid);
		return nzdt;
	}
	
	public static Month inputMonth() {
		Month month=null;
		boolean ok = false; 
		while(!ok) {
			try {
				out.print("Digite o número do mês: ");
				int m=Input.readPositiveInt();
				month = Month.of(m);
				ok = true;
			}catch(DateTimeException e) {
				out.println(e);
			}
		}
		return month;
	}

	public static Year inputYear() {
		Year year=null;
		boolean ok = false; 
		while(!ok) {
			try {
				out.print("Digite o ano: ");
				int y=Input.readPositiveInt();
				year = Year.of(y);
				ok = true;
			}catch(DateTimeException e) {
				out.println(e);
			}
		}
		return year;
	}
}