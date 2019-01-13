package View;

public class Option {
	
	private String tag;
	private	String line;
	
	public Option(String tag, String line) {
		this.tag = new String(tag);
		this.line = new String(line);
	}

	public String toString() {
		return this.tag+this.line;
	}
}