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
import br.edu.unifacear.bo.ColoracaoBO;
import br.edu.unifacear.bo.IngredientesBO;
import br.edu.unifacear.bo.PaisBO;
import br.edu.unifacear.bo.SaborBO;
import br.edu.unifacear.bo.TipoCervejaBO;
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
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(10, 154, 60, 14);
		panel.add(lblNome);
		
		JCheckBox rdbtnPorNome = new JCheckBox("Por Nome");
		rdbtnPorNome.setBounds(80, 107, 113, 23);
		panel.add(rdbtnPorNome);
		
		JCheckBox rdbtnPorTipo = new JCheckBox("Por Tipo");
		
		rdbtnPorTipo.setBounds(329, 107, 108, 23);
		panel.add(rdbtnPorTipo);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo.setBounds(256, 154, 60, 14);
		panel.add(lblTipo);
		
		JCheckBox rdbtnPorPais = new JCheckBox("Por Pa\u00EDs");
		rdbtnPorPais.setBounds(661, 107, 108, 23);
		panel.add(rdbtnPorPais);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(80, 151, 113, 20);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JComboBox<TipoCerveja> comboBoxTipo = new JComboBox<TipoCerveja>();
		comboBoxTipo.setBounds(329, 150, 118, 22);
		panel.add(comboBoxTipo);
		
		TipoCervejaBO tipocervejabo = new TipoCervejaBO();
		for (TipoCerveja tc : tipocervejabo.tipos()) {

			comboBoxTipo.addItem(tc);

		}
		
		JComboBox<Pais> comboBoxPais = new JComboBox<Pais>();
		comboBoxPais.setBounds(661, 150, 118, 22);
		panel.add(comboBoxPais);
		
		PaisBO paisbo = new PaisBO();
		for (Pais p : paisbo.paises()) {
			comboBoxPais.addItem(p);
		}
		
		JLabel lblPais = new JLabel("Pa\u00EDs:");
		lblPais.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPais.setBounds(589, 154, 60, 14);
		panel.add(lblPais);
		
		JCheckBox rdbtnPorSabor = new JCheckBox("Por Sabor");
		rdbtnPorSabor.setBounds(85, 201, 108, 23);
		panel.add(rdbtnPorSabor);
		
		JComboBox<Sabor> comboBoxSabor = new JComboBox<Sabor>();
		comboBoxSabor.setBounds(85, 240, 118, 22);
		panel.add(comboBoxSabor);
		
		SaborBO saborbo = new SaborBO();
		for (Sabor s : saborbo.sabores()) {
			comboBoxSabor.addItem(s);
		}
		
		JLabel lblSabor = new JLabel("Sabor:");
		lblSabor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSabor.setBounds(10, 244, 60, 14);
		panel.add(lblSabor);
		
		JLabel lblColoracao = new JLabel("Colora\u00E7\u00E3o:");
		lblColoracao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblColoracao.setBounds(230, 244, 89, 14);
		panel.add(lblColoracao);
		
		JComboBox<Coloracao> comboBoxColoracao = new JComboBox<Coloracao>();
		comboBoxColoracao.setBounds(329, 240, 118, 22);
		panel.add(comboBoxColoracao);
		
		ColoracaoBO coloracaobo = new ColoracaoBO();
		for (Coloracao c : coloracaobo.cores()) {
			comboBoxColoracao.addItem(c);
		}
		
		JCheckBox rdbtnPorColoracao = new JCheckBox("Por Colora\u00E7\u00E3o");
		rdbtnPorColoracao.setBounds(329, 201, 108, 23);
		panel.add(rdbtnPorColoracao);
		
		JLabel lblMsgPesquisar = new JLabel("Selecione no m\u00EDnimo 1 campo realizar a pesquisa\r");
		lblMsgPesquisar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsgPesquisar.setBounds(301, 424, 363, 14);
		panel.add(lblMsgPesquisar);
		
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nome = null; 
				String tipo = null; 
				String sabor = null; 
				String coloracao = null; 
				String pais = null;
				
				if(textFieldNome.getText().isBlank() && rdbtnPorNome.isSelected()) {
					lblMsgPesquisar.setForeground(Color.RED);
					lblMsgPesquisar.setText("preencha o campo nome corretamente");
					return;
				}
				
				if(!textFieldNome.getText().isBlank() && rdbtnPorNome.isSelected()) {
					nome = textFieldNome.getText();
				}
				
				if(rdbtnPorTipo.isSelected()) {
					 tipo = String.valueOf(((TipoCerveja) comboBoxTipo.getSelectedItem()).getId());
				}
				
				if(rdbtnPorSabor.isSelected()) {
					sabor = String.valueOf(((Sabor) comboBoxSabor.getSelectedItem()).getId());
				}
				
				if(rdbtnPorColoracao.isSelected()) {
					coloracao = String.valueOf(((Coloracao) comboBoxColoracao.getSelectedItem()).getId());
				}
				
				if(rdbtnPorPais.isSelected()) {
					pais = String.valueOf(((Pais) comboBoxPais.getSelectedItem()).getId());
				}
				
				if(nome == null && tipo == null && sabor == null && coloracao == null && pais == null) {
					lblMsgPesquisar.setForeground(Color.RED);
					lblMsgPesquisar.setText("selecione pelo menos 1 campo para realizar a pesquisa");
					return;
				}
				
				try {
					TelaResultadoPesquisa.telaResultadoPesquisa(nome, tipo, sabor, coloracao, pais);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				framePesquisa.dispose();
			}
		});
		btnPesquisar.setBounds(381, 377, 171, 23);
		panel.add(btnPesquisar);
		
		JLabel lblPesquiseUmaCerveja = new JLabel("Pesquise uma Cerveja!");
		lblPesquiseUmaCerveja.setForeground(new Color(255, 102, 51));
		lblPesquiseUmaCerveja.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPesquiseUmaCerveja.setBounds(329, 25, 228, 14);
		panel.add(lblPesquiseUmaCerveja);

		framePesquisa.setVisible(true);

	}
}
