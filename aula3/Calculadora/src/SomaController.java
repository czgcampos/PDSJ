import java.awt.event.WindowEvent;

public class SomaController {

    private SomaModel model;
    private SomaView view;
    
    public void setModel(SomaModel sm) { model = sm; }
    public void setView(SomaView sv) { view = sv; }

    // Inicializar a View; Valores dos campos de texto
    public void initView() {
        view.getNum1().setText("");
        view.getNum2().setText("");
        view.getNum3().setText("");
        view.getFrame().setVisible(true);
    }
    
    // Inicializar o controlador = fazer set dos Listeners + inicializar a View
    public void initController() {
        this.setListeners(); 
        this.initView();   
    }
    
    private void setListeners() {
       view.getBtSoma().addActionListener(ev -> somarCtrl());
       view.getBtLimpa().addActionListener(ev -> limparCtrl());
       view.getBtSair().addActionListener(ev -> sairCtrl()); 
    }
    
    // Codificar os métodos associados aos eventos
    private void sairCtrl() { System.out.println("SAIR ....");view.getFrame().dispatchEvent(new WindowEvent(view.getFrame(),WindowEvent.WINDOW_CLOSING)); }
    
    private void limparCtrl() {
        view.getNum1().setText("");
        view.getNum2().setText("");
        view.getNum3().setText("");
    }
    
    private void somarCtrl() {
        int res = Integer.parseInt(view.getNum1().getText())+Integer.parseInt(view.getNum2().getText());
        view.getNum3().setText(Integer.toString(res));
    }
}