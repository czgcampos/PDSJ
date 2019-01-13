/**
 *
 * @author PDSJ 2018
 */

package gestAcademia;

import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.lang.ExceptionInInitializerError;
import java.util.*;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;


public class GestAcademicaController {
    
    private GestAcademicaModel model;
    private GestAcademicaView view;
    private Aluno alunoBuffer = null;
    
    public GestAcademicaController()  { }
    
    // Aqui são injectados o model e a view neste controlador
    // Por questões de consistência não faz sentido injectar apenas
    // um deles.
    public void setModelViewPair(GestAcademicaModel m, GestAcademicaView v) {
        model = m; view = v;
    }
    
    public void initController() {
        if(model == null || view == null) throw new ExceptionInInitializerError("Erro Model/View");
        this.initView();  
    }
    
    public void setListeners() {
        // ComboBox ActionListener
        view.getComboBox().addActionListener(e -> getAlunosCurso());
        
        // ListSelectionListener
        // Mostra a ficha do aluno seleccionada na JList
        view.getJList().addListSelectionListener(ev -> getAndShowSelected());
        
        // JField ActionListeners de validação
        view.getTxFieldCod().addActionListener(ev -> codValidator());
        view.getTxFieldCurso().addActionListener(ev -> cursoValidator());
        view.getTxFieldMedia().addActionListener(ev -> doubleValidator());
         
        // Botoes -> ActionListeners
        view.getNovoButton().addActionListener(ev -> novoAlunoView());
        view.getSaveButton().addActionListener(ev -> getAlunoAndSave());
        view.getRemoveButton().addActionListener(ev -> removeAluno());
    }
    
    public void initView() { 
        
        // JList
        view.getJList().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        
        ////-------  INICIALIZA a COMBOBOX e a JLIST  ---------------------
        // ComboBox Cursos
        List<String> crs = new ArrayList<>(model.cursos());
        crs.add(0, "Todos");  // para a lista geral de alunos
        String[] cs = new String[crs.size()]; 
        crs.toArray(cs);
        // Insere Lista de Cursos na ComboBox
        view.getComboBox().setModel(new javax.swing.DefaultComboBoxModel(cs));
        
        // Inicializa a JList
        view.getJList().setListData((Object[])model.toArray());
        view.getJList().setSelectedIndex(0);
        
        // Inicializa JPanel de Aluno
        // Aluno seleccionado -> podia ser colocada em alunoBuffer mas => sincronizar sempre !
        Aluno alunoView = (Aluno) view.getJList().getSelectedValue();   
        // Mostra a ficha do aluno seleccionado no JPanel 
        this.showSelectedAluno(alunoView);
        
        /// ----    DEFINE TODOS OS LISTENERS    ----------------------
        this.setListeners();
        
        // Sempre que há actualizações na View fazer REFRESH
        // em especial depois dos eventos que geram novo estado da view 
        view.getFrame().setVisible(true);
    }
    
    
    //// Tratamento dos eventos  
    
    // Refresh da ComboBox por mudança de Curso
    public void getAlunosCurso() {
        String curso = (String) view.getComboBox().getSelectedItem();
        view.getJList().setListData((Object[])model.toArrayCurso(curso));
        view.getJList().setSelectedIndex(0);  // implica e -> getAndShowSelected   
    }
    
    // Método associado ao ListSelectionListener
    public void getAndShowSelected() {
        Aluno alunoView = (Aluno) view.getJList().getSelectedValue(); 
        if(alunoView == null) { return; }
        // Mostra a ficha do aluno seleccionado no JPanel 
        this.showSelectedAluno(alunoView);  
    }
    
    public void showSelectedAluno(Aluno aluno) { 
        // Mostra a ficha do aluno seleccionado 
        view.getTxFieldCod().setText(aluno.getCodigo());
        view.getTxFieldNome().setText(aluno.getNome());
        view.getTxFieldCurso().setText(aluno.getCurso());
        view.getTxFieldMedia().setText(aluno.getStrMedia());
        view.getTxFieldIdade().setText(aluno.getStrIdade());
        view.getFrame().setVisible(true);
    }
    
    public void getAlunoAndSave() {   
        this.getAlunoFromView();
        System.out.println(alunoBuffer.toString());
        
        // Insere Aluno no model
        model.add(alunoBuffer);
        // Se for do curso que está seleccionado fazer REFRESH da JList
        String curso = (String) view.getComboBox().getSelectedItem();
        System.out.println("Curso Visivel: " + curso);
        System.out.println("Curso do Aluno: " + alunoBuffer.getCurso());
        if(curso.equals("Todos")) { 
               view.getJList().setListData((Object[])model.toArray());
               
        }
        else if(curso.equals(alunoBuffer.getCurso())) {
               view.getJList().setListData((Object[])model.toArrayCurso(curso));
        }
        view.getJList().setSelectedIndex(0);  // implica e -> getAndShowSelected 
        alunoBuffer = null;  // é uma opção apagar o buffer; outra seria ter "memoria".   
    }
    
    private Object[] opcoes_SIM_NAO = { "Sim", "Não" };
    
    public void removeAluno() { 
         
         int n = JOptionPane.showOptionDialog(view.getFrame(), "Confirma a remoção deste aluno?",
                 "Remove", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
                 opcoes_SIM_NAO, opcoes_SIM_NAO[0]);
         System.out.println(n);
         //
         // Remover da JList ou apenas fazer novo setModel() ?
         // Seleccionar na JCombo o curso do removido
         // Apresentar na JList os alunos que ficaram (mostrar pois que foi removido)
         
         if(n == 0) {
             String curso = (String) view.getComboBox().getSelectedItem();
             String cod = view.getTxFieldCod().getText();
             System.out.println("Remover :" + cod);
             model.removeAluno(cod);
             if(curso.equals("Todos")) { 
               view.getJList().setListData((Object[])model.toArray());
             }
             else {
               view.getJList().setListData((Object[])model.toArrayCurso(curso)); 
             }
             view.getJList().setSelectedIndex(0);  // implica e -> getAndShowSelected 
             // falta apenas colocar o foco na linha seleccionada !
             alunoBuffer = null;  // é uma opção apagar o buffer; outra seria ter "memoria". 
         }       
     }
    
    public void novoAlunoView() { 
        // Apaga os campos da ficha do aluno (não modifica original) 
        view.getTxFieldCod().setText("");
        view.getTxFieldNome().setText("");
        view.getTxFieldCurso().setText("");
        view.getTxFieldMedia().setText("");
        view.getTxFieldIdade().setText("");
        view.getTxFieldCod().requestFocusInWindow();
        view.getFrame().setVisible(true);
    }
             
    public void getAlunoFromView() {
        // Código já foi validado se é um NOVO
        String cod = view.getTxFieldCod().getText(); 
        // Se não foi lido mas apenas apresentado há que testar
        if(model.existeCod(cod)) {
            JOptionPane.showMessageDialog(view.getFrame(), "Aluno já registado !");
            // Tem que fazer refresh. Certos campos podem ter sido alterados.
            this.showSelectedAluno((Aluno) view.getJList().getSelectedValue());
        }
        
        // OK !!
        
        // Nome
        String nome = view.getTxFieldNome().getText();
        // Curso
        String crs = view.getTxFieldCurso().getText();
        // Média
        String med = view.getTxFieldMedia().getText();
        double media = Double.parseDouble(med);
        // Idade
        int idade = Integer.parseInt(view.getTxFieldIdade().getText());
        alunoBuffer = new Aluno(cod, nome, idade, crs, media);   
    }
    
    public void codValidator() {
        String cod = view.getTxFieldCod().getText();
        if(model.existeCod(cod)) { 
                 JOptionPane.showMessageDialog(view.getFrame(), "Código Já existe!");
                 view.getTxFieldCod().setText(""); 
        }
    }
    
    public void cursoValidator() {
        String crs = view.getTxFieldCurso().getText();
        if(!model.cursos().contains(crs)) { 
                 JOptionPane.showMessageDialog(view.getFrame(), "O Curso não existe!");
                  view.getTxFieldCurso().setText(""); 
        }
    }
    
    public void doubleValidator() {
        String med = view.getTxFieldMedia().getText();
        try {
              Double.parseDouble(med);
        }
        catch(NumberFormatException ex) {
                     JOptionPane.showMessageDialog(view.getFrame(), "!");
                     view.getTxFieldMedia().setText(""); 
        }
    }
}



