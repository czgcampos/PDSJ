import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SomaView {

	private JFrame myFrame = new JFrame();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNum;
	private JLabel lblNum_1;
	private JTextField textField_2;
	private JLabel lblSoma;
	private JButton btnJbutton;
	private JButton btnJbutton_1;
	private JButton btnJbutton_2;

	/**
	 * Create the frame.
	 */
	public SomaView() {
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		myFrame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(53, 25, 345, 207);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCalculadoraDeSomas = new JLabel("Calculadora de Somas");
		lblCalculadoraDeSomas.setBounds(12, 12, 180, 15);
		panel.add(lblCalculadoraDeSomas);
		
		textField = new JTextField();
		textField.setBounds(147, 54, 114, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(147, 85, 114, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		lblNum = new JLabel("Num1");
		lblNum.setBounds(59, 56, 70, 15);
		panel.add(lblNum);
		
		lblNum_1 = new JLabel("Num2");
		lblNum_1.setBounds(59, 87, 70, 15);
		panel.add(lblNum_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(219, 116, 114, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		lblSoma = new JLabel("Soma");
		lblSoma.setBounds(131, 116, 70, 15);
		panel.add(lblSoma);
		
		btnJbutton = new JButton("Soma");
		btnJbutton.setBounds(12, 170, 117, 25);
		panel.add(btnJbutton);
		
		btnJbutton_1 = new JButton("Limpa");
		btnJbutton_1.setBounds(216, 170, 117, 25);
		panel.add(btnJbutton_1);
		
		btnJbutton_2 = new JButton("Sair");
		btnJbutton_2.setBounds(281, 244, 117, 25);
		contentPane.add(btnJbutton_2);
		myFrame.setVisible(true);
	}
	
	public JFrame getFrame() {
		return myFrame;
	}
	public JPanel getContentPane() {
		return contentPane;
	}
	public JTextField getNum1() {
		return textField;
	}
	public JTextField getNum2() {
		return textField_1;
	}
	public JTextField getNum3() {
		return textField_2;
	}
	public JLabel getLblSoma() {
		return lblSoma;
	}
	public JLabel getLblNum() {
		return lblNum;
	}
	public JLabel getLblNum_1() {
		return lblNum_1;
	}
	public void setMyFrame(JFrame f) {
		myFrame=f;
	}
	public void getContentPane(JPanel p) {
		contentPane=p;
	}
	public void setTexteField(JTextField tf) {
		textField=tf;
	}
	public void setTexteField_1(JTextField tf) {
		textField_1=tf;
	}
	public void setTexteField_2(JTextField tf) {
		textField_2=tf;
	}
	public void setLblSoma(JLabel jl) {
		lblSoma=jl;
	}
	public void setLblNum(JLabel jl) {
		lblNum=jl;
	}
	public void setLblNum_1(JLabel jl) {
		lblNum_1=jl;
	}

	public JButton getBtSoma() {
		return btnJbutton;
	}

	public JButton getBtLimpa() {
		return btnJbutton_1;
	}

	public JButton getBtSair() {
		return btnJbutton_2;
	}
}
