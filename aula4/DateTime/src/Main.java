import java.time.*;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalUnit;

import static java.time.temporal.TemporalAdjusters.*;
import static java.time.temporal.ChronoField.*;
import static java.time.temporal.ChronoUnit.*;
import static java.time.temporal.TemporalUnit.*;
import static java.time.temporal.TemporalAdjusters.*;
import static java.time.DayOfWeek.*;
import static java.time.Month.*;
import static java.time.temporal.IsoFields.*;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		/*LocalDate hoje = LocalDate.now();
		LocalDate dataNascimento = LocalDate.of(1996,3,20);
		Period difTempo = dataNascimento.until(hoje);
		System.out.println(difTempo);
		System.out.println(dataNascimento.until(hoje, DAYS));
		System.out.println(DAYS.between(dataNascimento, hoje));*/
		
		//1
		//System.out.println(Utils_DateTime.ex1(LocalDate.of(1996, 3, 20),LocalDate.of(1952, 4, 23)));
		
		//2
		/*System.out.println(LocalDate.now().plusDays(7).getDayOfMonth());
		System.out.println(ChronoUnit.HOURS.between(LocalDateTime.now(), LocalDateTime.now().plusDays(7)));*/
		
		//3
		/*System.out.println(LocalDate.of(2000,10,10).getEra());
		System.out.println(LocalDate.of(2000,10,10).getYear()/100+1);
		System.out.println(LocalDate.of(2000,10,10).getYear()/1000);*/
		
		//4
		/*LocalDate nasciEu = LocalDate.of(1984, 7, 1);
		LocalDate nasciPai = nasciEu.minusYears(33).minusMonths(6);
		LocalDate nasciMae = nasciEu.minusYears(33).minusMonths(6);
		LocalDate hoje = LocalDate.now();
		System.out.println(eu.until(hoje, ChronoUnit.YEARS));
		System.out.println(pai.until(hoje, ChronoUnit.YEARS));
		System.out.println(mae.until(hoje, ChronoUnit.YEARS));
		LocalDate eu2=LocalDate.of(1996, 3, 20);
		LocalDate irma=eu2.plusYears(3).plusMonths(1).plusDays(25);
		System.out.println(eu2.until(LocalDate.now()));
		System.out.println(irma.until(LocalDate.now()));*/
		
		//5
		/*LocalDateTime d1=LocalDateTime.of(1996, 3, 20, 10, 0);
		LocalDateTime d2=LocalDateTime.now();
		Duration du;
		if(d1.isBefore(d2))
			du=Duration.between(d1, d2);
		else
			du=Duration.between(d2, d1);
		System.out.println(du);
		System.out.println(du.get(SECONDS));
		List<TemporalUnit> ltu = du.getUnits();
		for(TemporalUnit tu : ltu)
			System.out.println(tu);
		LocalDate ld1=d1.toLocalDate();
		LocalDate ld2=d2.toLocalDate();
		Period entreD = Period.between(ld1, ld2);
		System.out.println(entreD);*/
		
		//6
		/*LocalDateTime d1=LocalDateTime.of(1996, 3, 20, 10, 0);
		LocalDateTime d2=LocalDateTime.of(2018, 10, 31, 10, 0);
		long segundos = SECONDS.between(d1, d2);
		LocalDateTime d3 = d1.plusSeconds(segundos);
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
		System.out.println(d2.equals(d3));*/
				
		//9
		/*LocalTime hoje = LocalTime.now();
		System.out.println(hoje);
		ChronoUnit[] units = ChronoUnit.values();
		ChronoField[] fields = ChronoField.values();
		for(ChronoUnit cunit : units) {
			if(hoje.isSupported(cunit))
				System.out.println(cunit);
		}
		System.out.println("==================");
		for(ChronoField cfield : fields) {
			if(hoje.isSupported(cfield))
				System.out.println(cfield);
		}
		System.out.println(hoje.get(ChronoField.MINUTE_OF_DAY));
		System.out.println(hoje.range(ChronoField.MINUTE_OF_DAY));
		LocalDate n = LocalDate.now();
		System.out.println(n.now().isSupported(ChronoField.MINUTE_OF_DAY));*/
		
		//System.out.println(LocalDateTime.now().with(dayOfWeekInMonth(1,FRIDAY)));
		
		/*LocalDate segCarro = LocalDate.of(2017, DECEMBER, 17);
		LocalDate hoje = LocalDate.of(2017, 1, 1);
		System.out.println(segCarro);
		System.out.println(segCarro.getDayOfWeek());
		System.out.println(segCarro.with(previousOrSame(MONDAY)));*/
		
		//16
		/*LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		LocalDate proxQuarta = hoje.with(nextOrSame(WEDNESDAY));
		System.out.println(proxQuarta);
		LocalDate fimDoAno = hoje.with(lastDayOfYear());
		System.out.println(fimDoAno);
		LocalDate ultimaQuarta = fimDoAno.with(previousOrSame(WEDNESDAY));
		System.out.println(ultimaQuarta);
		System.out.println(5*(WEEKS.between(proxQuarta, ultimaQuarta)+1));*/
		
		//
		/*LocalDate ldt=LocalDate.of(2017,3,31);
        LocalDate ldt2=LocalDate.of(2017,3,31);
        for(int i=1;i<=3;i++){
            System.out.println("Pag("+(i+1)+"): "+ldt.plusMonths(3*i));
            System.out.println(QUARTER_OF_YEAR.adjustInto(ldt2,QUARTER_OF_YEAR.getFrom(ldt)+i));
        }*/
		
		//
        /*YearMonth ym=YearMonth.of(2017,12);
        LocalDate ldt2=ym.atDay(1).with(firstInMonth(MONDAY));
        System.out.println("A primeira semana de Dezembro comeca a " +ldt2);
        System.out.println("3d2s Dezembro: "+ldt2.plus(1,WEEKS).plus(2,DAYS));*/
		
		//23
		/*LocalDate ldt=LocalDate.now();
        for(int i=0;i<10;i++){
            ldt=ldt.plus(1,DAYS);
            DayOfWeek dd=ldt.getDayOfWeek();
            System.out.println("i="+i+" dd: "+dd);
            if(dd.equals(SATURDAY)||dd.equals(SUNDAY)){
                i--;
            }
        }*/
		
		//28
		TemporalAdjuster menos15Dias = ofDateAdjuster((LocalDate data) -> data.minusDays(15));
		TemporalAdjuster menos2Semanas = ofDateAdjuster((LocalDate data) -> data.minusWeeks(2));
		LocalDate hoje = LocalDate.now();
		LocalDate hojeMenos15D = hoje.with(menos15Dias); 
		LocalDate hojeMenos2S = hoje.with(menos2Semanas); 
		System.out.println(" Hoje " + hoje); 
		System.out.println(" Hoje - 15D : " + hojeMenos15D);
		System.out.println(" Hoje - 2S : " + hojeMenos2S);
	
		//24
		/*int ano = 2018;
		int diasDoAno = Year.of(ano).length();
		LocalDate.ofYearDay(ano, diasDoAno/2);
		LocalDate inicioAno = LocalDate.now().with(firstDayOfYear());
		LocalDate meioDoAno = inicioAno.plusDays(diasDoAno/2);
		System.out.println(meioDoAno);*/
	}
}