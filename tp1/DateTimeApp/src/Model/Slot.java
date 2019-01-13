package Model;

import java.io.Serializable;
import java.time.LocalTime;

public class Slot implements Serializable{

	private static final long serialVersionUID = 1L;
	private LocalTime initHour;
	private LocalTime finalHour;
	private String task;

	public static Slot of() {
		return new Slot();
	}

	public static Slot of(LocalTime initHour, LocalTime finalHour, String task) {
		return new Slot(initHour,finalHour,task);
	}

	public static Slot of(Slot slot) {
		return new Slot(slot);
	}
	
	private Slot() {
		this.initHour=LocalTime.of(8, 0);
		this.finalHour=LocalTime.of(22, 0);
		this.task="";
	}

	private Slot(LocalTime hI, LocalTime hF, String t) {
		this.initHour=hI;
		this.finalHour=hF;
		this.task=t;
	}

	private Slot(Slot slot) {
		this.initHour=slot.getInitHour();
		this.finalHour=slot.getFinalHour();
		this.task=slot.getTask();
	}
	
	public LocalTime getInitHour() {
		return this.initHour;
	}

	public void setInitHour(LocalTime initHour) {
		this.initHour = initHour;
	}

	public LocalTime getFinalHour() {
		return this.finalHour;
	}

	public void setFinalHour(LocalTime finalHour) {
		this.finalHour = finalHour;
	}

	public String getTask() {
		return this.task;
	}

	public void setTask(String task) {
		this.task = task;
	}	
	
	public Slot clone() {
		return new Slot(this);
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(this.initHour.toString()+" -> "+this.finalHour.toString()+" ==> "+this.task);
		return s.toString();
	}

	public boolean equals(Object obj) {
		if(obj == this)
			return true;
		if(obj == null || obj.getClass() != this.getClass())
			return false;
		Slot s = (Slot) obj;
		return s.getInitHour().equals(this.initHour) && s.getFinalHour().equals(this.finalHour) && s.getTask().equals(this.task);
	}
}