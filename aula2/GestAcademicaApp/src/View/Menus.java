package View;
import java.util.HashMap;

public class Menus {

	private HashMap<Integer,Menu> menus;
	
	public Menus() {
		menus = new HashMap<Integer,Menu>();
	}
	
	public void addMenu(int i, Menu m) {
		menus.put(i, m);
	}
	
	public Menu getMenu(int i){
		return menus.get(i);
	}
}