package View;
import java.util.List;

public class Menu {

	private String titulo;
	private List<Opcao> opcoes;
	
	public Menu(List<Opcao> linhas, String string) {
		titulo=string;
		opcoes=linhas;
	}

	public void show() {
		System.out.println(titulo);
		for(Opcao o : opcoes) {
			System.out.println(o.toString());
		}
	}
}