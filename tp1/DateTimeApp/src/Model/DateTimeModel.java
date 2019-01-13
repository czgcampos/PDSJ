package Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toMap;

public class DateTimeModel implements InterfaceDateTimeModel {

	private static final long serialVersionUID = 1L;
	private Map<LocalDate,Day> schedule = new HashMap<>();
	
	public static DateTimeModel of() {
		return new DateTimeModel();
	}

	public static DateTimeModel of(Map<LocalDate,Day> tasks) {
		return new DateTimeModel(tasks);
	}

	public static DateTimeModel of(DateTimeModel dateTimeModel) {
		return new DateTimeModel(dateTimeModel);
	}

	private DateTimeModel() {}

	private DateTimeModel(Map<LocalDate,Day> tarefas) { 
		this.setSchedule(tarefas);
	}

	private DateTimeModel(DateTimeModel dm) {
		this.schedule=dm.getSchedule();
	}

	public Map<LocalDate, Day> getSchedule() {
		return  this.schedule
					.entrySet()
					.stream()
					.collect(toMap(e->e.getKey(), e->e.getValue().clone()));
	}

	public void setSchedule(Map<LocalDate, Day> schedule) {
		this.schedule = schedule.entrySet()
							.stream()
							.collect(toMap(e->e.getKey(), e->Day.of(e.getValue())));
	}
	
	public boolean insertTask(LocalDate date, LocalTime initHour, LocalTime finalHour, String task) {
		boolean res=false;
		List<Slot> slots = new ArrayList<Slot>();
		if(this.schedule.containsKey(date)) {
			slots=this.schedule.get(date).getSlots();
			for(int i=0;i<slots.size();i++) {
				if(i==0 && finalHour.isBefore(slots.get(i).getInitHour())) {
					this.schedule.get(date).insertSlot(i,Slot.of(initHour, finalHour, task));
					res=true;
					break;
				} else if(i==slots.size()-1 && initHour.isAfter(slots.get(i).getFinalHour()) ) {
					this.schedule.get(date).insertSlot(i+1,Slot.of(initHour, finalHour, task));
					res=true;
					break;
				} else if((i<slots.size()-1) && initHour.isAfter(slots.get(i).getFinalHour()) && finalHour.isBefore(slots.get(i+1).getInitHour())) {
					this.schedule.get(date).insertSlot(i+1,Slot.of(initHour, finalHour, task));
					res=true;
					break;
				}
			}
		} else {
			slots.add(Slot.of(initHour, finalHour, task));
			this.schedule.put(date, Day.of(slots));
			res=true;
		}
		return res;
	}

	public Day consultDay(LocalDate date) {
		return this.schedule.get(date);
	}

	public void alterTask(LocalDate date, int index, String task) {
		this.schedule.get(date).alterSlot(index,task);
	}

	public void deleteTask(LocalDate day, int index) {
		this.schedule.get(day).deleteSlot(index);
	}
	
	public DateTimeModel clone() {
		return new DateTimeModel(this);
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("\t\tAgenda\n");
		this.schedule.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(d -> s.append("\t"+d.getKey()+"\n"+d.getValue().toString()+"\n"));
		return s.toString();
	}

	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		}
		if(obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		DateTimeModel dm = (DateTimeModel) obj;
		return dm.getSchedule().equals(this.schedule);
	}
}