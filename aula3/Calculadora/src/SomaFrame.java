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

public class SomaFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNum;
	private JLabel lblNum_1;
	private JTextField textField_2;
	private JLabel lblSoma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SomaFrame frame = new SomaFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SomaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
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
		
		JButton btnJbutton = new JButton("JButton1");
		btnJbutton.setBounds(12, 170, 117, 25);
		panel.add(btnJbutton);
		
		JButton btnJbutton_1 = new JButton("JButton2");
		btnJbutton_1.setBounds(216, 170, 117, 25);
		panel.add(btnJbutton_1);
		
		JButton btnJbutton_2 = new JButton("JButton3");
		btnJbutton_2.setBounds(281, 244, 117, 25);
		contentPane.add(btnJbutton_2);
	}
}
