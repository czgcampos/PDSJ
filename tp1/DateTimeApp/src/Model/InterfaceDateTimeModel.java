package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public interface InterfaceDateTimeModel extends Serializable{
	public Map<LocalDate, Day> getSchedule();
	public void setSchedule(Map<LocalDate, Day> schedule);
	public boolean insertTask(LocalDate date, LocalTime initHour, LocalTime finalHour, String task);
	public Day consultDay(LocalDate date);
	public void alterTask(LocalDate date, int index, String task);
	public void deleteTask(LocalDate date, int index);
	public DateTimeModel clone();
	public String toString();
}