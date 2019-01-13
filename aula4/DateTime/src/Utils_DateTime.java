import java.time.*;

public class Utils_DateTime {
	public static Period ex1(LocalDate data1,LocalDate data2){
		return Period.between(data1, data2);
	}
}
