package View;
public class Opcao {
	private String etiqueta;
	private	String linha;
	public Opcao(String e, String l) {
		etiqueta = new String(e);
		linha = new String(l);
	}
	public String toString() {
		return etiqueta+linha;
	}
}