package Controller;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalQueries;
import static java.lang.System.out;

public class TimeZoneFlowController {

	public static void changeZone(){
		out.print("Indique o fuso horário: ");
		ZonedDateTime nzdt=ZonedDateTime.now().withZoneSameInstant(DateTimeInputController.inputZoneId());
		DateTimeFormatter form=DateTimeFormatter.ofPattern("'São' HH 'horas e' mm 'minutos do dia' dd/MM - O z");
		out.println("RESULTADO\n"+nzdt.format(form));
		out.println("Prima ENTER para prosseguir...");
		Input.readString();
	}

	public static void differenceBetweenZones(){
		out.print("Indique o fuso horário: ");
		ZoneOffset zo1=ZonedDateTime.ofInstant(Instant.now(),DateTimeInputController.inputZoneId()).query(TemporalQueries.offset());
		out.print("Indique o fuso horário: ");
		ZoneOffset zo2=ZonedDateTime.ofInstant(Instant.now(),DateTimeInputController.inputZoneId()).query(TemporalQueries.offset());
		int t1=zo1.get(ChronoField.OFFSET_SECONDS);
		int t2=zo2.get(ChronoField.OFFSET_SECONDS);
		int diff=Math.abs(t2-t1);
		out.println("Fuso 1: "+zo1+"\nFuso 2: "+zo2+"\nDiferença: "+diff/3600+"h"+(diff%3600)/60+"m");
		out.println("Prima ENTER para prosseguir...");
		Input.readString();
	}

	public static void calculateArrivalTime(){
		out.print("\nNúmero de horas de viagem: ");
		int hours=Input.readInt();
		DateTimeFormatter form=DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm - O z");
		out.print("Digite os campos de uma data de partida: ");
		ZonedDateTime departure=DateTimeInputController.inputZonedDateTime();
		out.print("Digite o fuso de chegada: ");
		ZonedDateTime arrival=departure.withZoneSameInstant(DateTimeInputController.inputZoneId()).plus(hours,ChronoUnit.HOURS);
		out.println("Partida: "+departure.format(form)+"\nChegada: "+arrival.format(form));
		out.println("Prima ENTER para prosseguir...");
		Input.readString();
	}

	public static void tripTime(){
		out.println("Digite os campos de uma data de partida\n");
		ZonedDateTime departure=DateTimeInputController.inputZonedDateTime();
		out.println("Digite os campos de uma data de chegada\n");
		ZonedDateTime arrival=DateTimeInputController.inputZonedDateTime();
		DateTimeFormatter form=DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm - O z");
		out.println("Partida: "+departure.format(form)+"\nChegada: "+arrival.format(form));
		if(departure.isBefore(arrival)) {
			Duration diff = Duration.between(departure, arrival);
			out.println("Diferença: " + diff.toMinutes()/60+" horas "+diff.toMinutes()%60+" minutos.");
		}
		else 
			out.println("Não é possível viajar atrás no tempo!");
		out.println("Prima ENTER para prosseguir...");
		Input.readString();
	}

	public static void offsetList(){
		out.format("%-35s| %-9s\n","Timezone","Offset");
		for(String zid: ZoneId.getAvailableZoneIds()){
			ZoneOffset zo1=ZonedDateTime.ofInstant(Instant.now(), ZoneId.of(zid)).query(TemporalQueries.offset());
			out.format("%-35s|%9s\n",zid,zo1);
		}
	}

	public static void listZCI(boolean bool){
		out.format("%-35s| %-9s\n","Timezone","Offset");
		for(String zid: ZoneId.getAvailableZoneIds()){
			ZoneOffset zoff=ZonedDateTime.ofInstant(Instant.now(), ZoneId.of(zid)).query(TemporalQueries.offset());
			if(!bool&&(zoff.get(ChronoField.OFFSET_SECONDS)%3600)!=0) out.format("%-35s|%9s\n",zid,zoff);
			if(bool&&(zoff.get(ChronoField.OFFSET_SECONDS)%3600)==0) out.format("%-35s|%9s\n",zid,zoff);
		}
	}

	public static void listZoneIds(){
		String opcao;
		do {
			out.println("1 - Listagem completa de Fusos Horários\n" +
					"2 - Listagem de Fusos Horários com Offsets incertos(Horas e Minutos)\n" +
					"3 - Listagem de Fusos Horários com Offsets certos(Horas)\n" +
					"Q - Voltar atrás");
			opcao = Input.readString();
			opcao = opcao.toUpperCase();
			switch(opcao) {
				case "1" : offsetList(); break;
				case "2" : listZCI(false); break;
				case "3" : listZCI(true); break;
				case "Q" : break;
				default: out.println("Opcão Inválida !"); break;
			}
		}
		while(!opcao.equals("Q"));
	}
}