package View;

import java.util.List;

public class Menu {

	private String title;
	private List<Option> options;
	
	public Menu(List<Option> lines, String string) {
		this.title=string;
		this.options=lines;
	}

	public void show() {
		System.out.println(this.title);
		for(Option o : this.options)
			System.out.println(o.toString());
	}
}