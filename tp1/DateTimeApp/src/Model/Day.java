package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Day implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Slot> slots = new ArrayList<Slot>();
	
	public static Day of() {
		return new Day();
	}

	public static Day of(List<Slot> slots) {
		return new Day(slots);
	}

	public static Day of(Day day) {
		return new Day(day);
	}
	
	private Day(){
		this.slots.add(Slot.of());
	}

	private Day(List<Slot> s){
		this.setSlots(s);
	}

	private Day(Day day){
		this.slots=day.getSlots();
	}
	
	public List<Slot> getSlots() {
		List<Slot> res = new ArrayList<Slot>(this.slots.size());
		for(Slot s : this.slots) 
			res.add(s.clone());
		return res;
	}

	public void setSlots(List<Slot> slots) {
		this.slots.clear();
		for(Slot s : slots) 
			this.slots.add(Slot.of(s));
	}
	
	public void insertSlot(int index, Slot slot) {
		this.slots.add(index, Slot.of(slot));
	}

	public void alterSlot(int index, String task) {
		this.slots.get(index).setTask(task);
	}

	public void deleteSlot(int index) {
		this.slots.remove(index);
	}
	
	public Day clone() {
		return new Day(this);
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		for(Slot slot : this.slots) 
			s.append(this.slots.indexOf(slot)+"."+slot.toString()+"\n");
		return s.toString();
	}

	public boolean equals(Object obj) {
		if(obj == this)
			return true;
		if(obj == null || obj.getClass() != this.getClass())
			return false;
		Day d = (Day) obj;
		return d.getSlots().equals(this.slots);
	}
}