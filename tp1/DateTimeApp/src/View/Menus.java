package View;

import java.util.HashMap;

public class Menus {

	private HashMap<Integer,Menu> menus;
	
	public Menus() {
		this.menus = new HashMap<Integer,Menu>();
	}	

	public void addMenu(int index, Menu menu) {
		this.menus.put(index, menu);
	}

	public Menu getMenu(int index){
		return this.menus.get(index);
	}
}