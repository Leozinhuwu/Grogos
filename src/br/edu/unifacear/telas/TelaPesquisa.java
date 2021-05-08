package br.edu.unifacear.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import br.edu.unifacear.bo.CervejaBO;
import br.edu.unifacear.bo.IngredientesBO;
import br.edu.unifacear.classes.Cerveja;
import br.edu.unifacear.classes.Ingredientes;
import br.edu.unifacear.classes.Usuario;
import br.edu.unifacear.validators.CervejaValidator;
import br.edu.unifacear.validators.IngredientesValidator;

public class TelaPesquisa {
	
	private static final long serialVersionUID = 1L;
	private static JFrame framePesquisa;
	private static JTextField textNome;
	private static JTextField textPais;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_4;
	private static JTextField textField_5;

	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public static void telaPesquisa() throws Exception {

		// labels e botoes do jFrame
		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(Color.WHITE);
		framePesquisa = new JFrame();
		framePesquisa.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\leo4_\\Desktop\\GrogosPesq.jpg"));
		framePesquisa.setSize(1000, 700);
		framePesquisa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePesquisa.setLocation(500, 150);

		framePesquisa.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnVolta = new JButton("Voltar");
		btnVolta.setForeground(Color.BLACK);
		btnVolta.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		btnVolta.setBackground(Color.LIGHT_GRAY);
		btnVolta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaMenuUsuario.telaMenuUser();

				} catch (Exception e1) {

					e1.printStackTrace();
				}
				framePesquisa.dispose();

			}
		});
		btnVolta.setBounds(10, 21, 89, 23);
		panel.add(btnVolta);

		JLabel lblTitle = new JLabel("Grogos");
		lblTitle.setForeground(Color.RED);
		lblTitle.setBounds(457, 25, 46, 14);
		panel.add(lblTitle);
		
		JLabel lblPorNome = new JLabel("Por Nome");
		lblPorNome.setBounds(26, 163, 60, 14);
		panel.add(lblPorNome);
		
		JRadioButton rdbtnCerveja = new JRadioButton("Pesquisar Por Cerveja");
		rdbtnCerveja.setBounds(80, 107, 146, 23);
		panel.add(rdbtnCerveja);
		
		textNome = new JTextField();
		textNome.setBounds(96, 160, 130, 20);
		panel.add(textNome);
		textNome.setColumns(10);
		
		textPais = new JTextField();
		textPais.setColumns(10);
		textPais.setBounds(96, 194, 130, 20);
		panel.add(textPais);
		
		JLabel lblPorNome_1 = new JLabel("Por Nome");
		lblPorNome_1.setBounds(26, 197, 60, 14);
		panel.add(lblPorNome_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(96, 225, 130, 20);
		panel.add(textField_2);
		
		JLabel lblPorNome_2 = new JLabel("Por Nome");
		lblPorNome_2.setBounds(26, 228, 60, 14);
		panel.add(lblPorNome_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(96, 256, 130, 20);
		panel.add(textField_3);
		
		JLabel lblPorNome_3 = new JLabel("Por Nome");
		lblPorNome_3.setBounds(26, 259, 60, 14);
		panel.add(lblPorNome_3);
		
		JRadioButton rdbtnIngrediente = new JRadioButton("Pesquisar Por Ingrediente");
		rdbtnIngrediente.setBounds(601, 107, 165, 23);
		panel.add(rdbtnIngrediente);
		
		JLabel lblPorNome_4 = new JLabel("Por Nome");
		lblPorNome_4.setBounds(588, 163, 60, 14);
		panel.add(lblPorNome_4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(658, 160, 130, 20);
		panel.add(textField);
		
		JLabel lblPorNome_1_1 = new JLabel("Por Nome");
		lblPorNome_1_1.setBounds(588, 197, 60, 14);
		panel.add(lblPorNome_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(658, 225, 130, 20);
		panel.add(textField_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(658, 194, 130, 20);
		panel.add(textField_4);
		
		JLabel lblPorNome_2_1 = new JLabel("Por Nome");
		lblPorNome_2_1.setBounds(588, 228, 60, 14);
		panel.add(lblPorNome_2_1);
		
		JLabel lblPorNome_3_1 = new JLabel("Por Nome");
		lblPorNome_3_1.setBounds(588, 259, 60, 14);
		panel.add(lblPorNome_3_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(658, 256, 130, 20);
		panel.add(textField_5);
		
		

		framePesquisa.setVisible(true);

	}
}
