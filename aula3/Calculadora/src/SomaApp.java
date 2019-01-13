public class SomaApp {
	public static void main(String[] args) {
		SomaModel model = new SomaModel();
	    SomaView view = new SomaView();
	    SomaController control = new SomaController();
	    control.setModel(model);
	    control.setView(view);
	    control.initController();
	}
}