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
import br.edu.unifacear.classes.Coloracao;
import br.edu.unifacear.classes.Ingredientes;
import br.edu.unifacear.classes.Pais;
import br.edu.unifacear.classes.Sabor;
import br.edu.unifacear.classes.TipoCerveja;
import br.edu.unifacear.classes.Apreciador;
import br.edu.unifacear.validators.CervejaValidator;
import br.edu.unifacear.validators.IngredientesValidator;
import javax.swing.JComboBox;

public class TelaPesquisa {
	

	private static JFrame framePesquisa;
	private static JTextField textFieldNome;

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
					TelaPrincipalApreciador.telaPrincipal();

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
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(44, 154, 60, 14);
		panel.add(lblNome);
		
		JRadioButton rdbtnPorNome = new JRadioButton("Por Nome");
		rdbtnPorNome.setBounds(80, 107, 113, 23);
		panel.add(rdbtnPorNome);
		
		JRadioButton rdbtnPorTipo = new JRadioButton("Por Tipo");
		rdbtnPorTipo.setBounds(329, 107, 108, 23);
		panel.add(rdbtnPorTipo);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(288, 154, 60, 14);
		panel.add(lblTipo);
		
		JRadioButton rdbtnPorPais = new JRadioButton("Por Pa\u00EDs");
		rdbtnPorPais.setBounds(661, 107, 108, 23);
		panel.add(rdbtnPorPais);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(80, 151, 113, 20);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JComboBox<TipoCerveja> comboBoxTipo = new JComboBox<TipoCerveja>();
		comboBoxTipo.setBounds(329, 150, 118, 22);
		panel.add(comboBoxTipo);
		
		JComboBox<Pais> comboBoxPais = new JComboBox<Pais>();
		comboBoxPais.setBounds(661, 146, 118, 22);
		panel.add(comboBoxPais);
		
		JLabel lblPais = new JLabel("Pa\u00EDs:");
		lblPais.setBounds(620, 150, 60, 14);
		panel.add(lblPais);
		
		JRadioButton rdbtnPorSabor = new JRadioButton("Por Sabor");
		rdbtnPorSabor.setBounds(85, 201, 108, 23);
		panel.add(rdbtnPorSabor);
		
		JComboBox<Sabor> comboBoxSabor = new JComboBox<Sabor>();
		comboBoxSabor.setBounds(85, 240, 118, 22);
		panel.add(comboBoxSabor);
		
		JLabel lblSabor = new JLabel("Sabor:");
		lblSabor.setBounds(44, 244, 60, 14);
		panel.add(lblSabor);
		
		JLabel lblColoracao = new JLabel("Colora\u00E7\u00E3o:");
		lblColoracao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblColoracao.setBounds(259, 244, 60, 14);
		panel.add(lblColoracao);
		
		JComboBox<Coloracao> comboBoxColoracao = new JComboBox<Coloracao>();
		comboBoxColoracao.setBounds(329, 240, 118, 22);
		panel.add(comboBoxColoracao);
		
		JRadioButton rdbtnPorColoracao = new JRadioButton("Por Colora\u00E7\u00E3o");
		rdbtnPorColoracao.setBounds(329, 201, 108, 23);
		panel.add(rdbtnPorColoracao);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TelaResultadoPesquisa.telaResultado(parametros);
			}
		});
		btnPesquisar.setBounds(196, 375, 89, 23);
		panel.add(btnPesquisar);
		
		JLabel lblMsgPesquisar = new JLabel("Selecione no m\u00EDnimo 1 campo realizar a pesquisa\r");
		lblMsgPesquisar.setBounds(84, 429, 363, 14);
		panel.add(lblMsgPesquisar);
		
		

		framePesquisa.setVisible(true);

	}
}
