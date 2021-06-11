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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;

import br.edu.unifacear.bo.CervejaBO;
import br.edu.unifacear.bo.CervejeiroBO;
import br.edu.unifacear.bo.ColoracaoBO;
import br.edu.unifacear.bo.FermentoBO;
import br.edu.unifacear.bo.IngredientesBO;
import br.edu.unifacear.bo.LupuloBO;
import br.edu.unifacear.bo.MalteBO;
import br.edu.unifacear.bo.PaisBO;
import br.edu.unifacear.bo.SaborBO;
import br.edu.unifacear.bo.TipoCervejaBO;
import br.edu.unifacear.classes.Cerveja;
import br.edu.unifacear.classes.Cervejeiro;
import br.edu.unifacear.classes.Coloracao;
import br.edu.unifacear.classes.Fermento;
import br.edu.unifacear.classes.Ingredientes;
import br.edu.unifacear.classes.Lupulo;
import br.edu.unifacear.classes.Malte;
import br.edu.unifacear.classes.Pais;
import br.edu.unifacear.classes.Sabor;
import br.edu.unifacear.classes.TipoCerveja;
import br.edu.unifacear.validators.CervejaValidator;
import br.edu.unifacear.validators.IngredientesValidator;

import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;

public class TelaCadastroCerveja {

	private static JFrame frameCadastro;
	private static JTextField nameField;
	private static JTextField textFieldTipoCerveja;
	private static JTextField textFieldSabor;
	private static JTextField textFieldPais;
	private static JTextField textFieldColoracao;
	private static JTextField textCevada;
	private static JTextField textAlchool;
	private static JRadioButton rdbtnComAlchool;
	private static JTextField textFieldLupulo;
	private static JTextField textFieldFermento;
	private static JCheckBox chckbxNao;
	private static JTextField textFieldMalte;

	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public static void telaCadastro() throws Exception {
		TipoCervejaBO tipocervejabo = new TipoCervejaBO();

		// labels e botoes do jFrame
		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(Color.WHITE);
		frameCadastro = new JFrame();
		frameCadastro.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\leo4_\\Desktop\\GrogosPesq.jpg"));
		frameCadastro.setSize(1000, 700);
		frameCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCadastro.setLocation(500, 150);

		frameCadastro.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnVolta = new JButton("Voltar");
		btnVolta.setForeground(Color.BLACK);
		btnVolta.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		btnVolta.setBackground(Color.LIGHT_GRAY);
		btnVolta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaMenuCervejeiro.telaMenuCervejeiro();

				} catch (Exception e1) {

					e1.printStackTrace();
				}
				frameCadastro.dispose();

			}
		});
		btnVolta.setBounds(10, 21, 89, 23);
		panel.add(btnVolta);

		JLabel lblTitle = new JLabel("Cadastre sua Cerveja");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTitle.setForeground(new Color(255, 102, 51));
		lblTitle.setBounds(394, 25, 218, 14);
		panel.add(lblTitle);

		nameField = new JTextField();
		nameField.setBounds(145, 123, 178, 20);
		panel.add(nameField);
		nameField.setColumns(10);

		textFieldTipoCerveja = new JTextField();
		textFieldTipoCerveja.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldTipoCerveja.setEditable(false);
		textFieldTipoCerveja.setBounds(145, 154, 178, 20);
		panel.add(textFieldTipoCerveja);
		textFieldTipoCerveja.setColumns(10);

		textFieldSabor = new JTextField();
		textFieldSabor.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldSabor.setEditable(false);
		textFieldSabor.setBounds(145, 191, 178, 20);
		panel.add(textFieldSabor);
		textFieldSabor.setColumns(10);

		textFieldPais = new JTextField();
		textFieldPais.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldPais.setEditable(false);
		textFieldPais.setBounds(145, 222, 178, 20);
		panel.add(textFieldPais);
		textFieldPais.setColumns(10);

		textFieldColoracao = new JTextField();
		textFieldColoracao.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldColoracao.setEditable(false);
		textFieldColoracao.setBounds(145, 257, 178, 20);
		panel.add(textFieldColoracao);
		textFieldColoracao.setColumns(10);

		JLabel lblName = new JLabel("Nome:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(89, 126, 46, 14);
		panel.add(lblName);

		JLabel lblType = new JLabel("Tipo:");
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblType.setBounds(89, 157, 46, 14);
		panel.add(lblType);

		JLabel lblFlavor = new JLabel("Sabor:");
		lblFlavor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFlavor.setBounds(89, 194, 46, 14);
		panel.add(lblFlavor);

		JLabel lblOrigin = new JLabel("Pais de Origem:");
		lblOrigin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrigin.setBounds(26, 225, 109, 14);
		panel.add(lblOrigin);

		JLabel lblColoracao = new JLabel("Colora\u00E7\u00E3o:");
		lblColoracao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblColoracao.setBounds(62, 260, 73, 14);
		panel.add(lblColoracao);

		JLabel lblDescription = new JLabel("Descri\u00E7\u00E3o:");
		lblDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescription.setBounds(62, 319, 89, 14);
		panel.add(lblDescription);

		JLabel lblCerveja = new JLabel("Sobre a sua Cerveja");
		lblCerveja.setBounds(145, 81, 178, 14);
		panel.add(lblCerveja);

		JLabel lblIngredientes = new JLabel("Ingredientes");
		lblIngredientes.setBounds(671, 81, 178, 14);
		panel.add(lblIngredientes);

		textCevada = new JTextField();
		textCevada.setToolTipText("apenas n\u00FAmeros de 0 a 9");
		textCevada.setBounds(669, 191, 46, 20);
		panel.add(textCevada);
		textCevada.setColumns(10);

		JLabel lblCevada = new JLabel("Cevada:");
		lblCevada.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCevada.setBounds(613, 194, 46, 14);
		panel.add(lblCevada);

		JLabel lblPorcentagem = new JLabel("%");
		lblPorcentagem.setBounds(725, 194, 22, 14);
		panel.add(lblPorcentagem);

		JRadioButton rdbtnAlchool = new JRadioButton("Sem Alcool");
		rdbtnAlchool.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbtnComAlchool.setSelected(false);
				textAlchool.setText("0");
				textAlchool.disable();
		
			}
		});

		rdbtnAlchool.setBounds(710, 123, 109, 23);
		panel.add(rdbtnAlchool);

		JLabel lblAlchool = new JLabel("Teor Alco\u00F3lico:");
		lblAlchool.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlchool.setBounds(570, 156, 89, 14);
		panel.add(lblAlchool);

		textAlchool = new JTextField();
		textAlchool.setToolTipText("apenas n\u00FAmeros de 0 a 9");
		textAlchool.setColumns(10);
		textAlchool.setBounds(669, 153, 46, 20);
		panel.add(textAlchool);
		textAlchool.setText("0");

		JLabel lblPorcentagem_1 = new JLabel("%");
		lblPorcentagem_1.setBounds(725, 156, 22, 14);
		panel.add(lblPorcentagem_1);

		rdbtnComAlchool = new JRadioButton("Com Alcool");
		rdbtnComAlchool.setSelected(true);
		rdbtnComAlchool.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbtnAlchool.setSelected(false);
				textAlchool.enable();
				
			}
		});

		rdbtnComAlchool.setBounds(570, 123, 109, 23);
		panel.add(rdbtnComAlchool);

		JLabel lblLupo = new JLabel("Tipo de Lupulo:");
		lblLupo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLupo.setBounds(570, 260, 89, 14);
		panel.add(lblLupo);

		textFieldLupulo = new JTextField();
		textFieldLupulo.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldLupulo.setEditable(false);
		textFieldLupulo.setBounds(671, 257, 167, 20);
		panel.add(textFieldLupulo);
		textFieldLupulo.setColumns(10);

		JLabel lblTipoDeFermento = new JLabel("Tipo de Fermento:");
		lblTipoDeFermento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoDeFermento.setBounds(550, 291, 109, 14);
		panel.add(lblTipoDeFermento);

		textFieldFermento = new JTextField();
		textFieldFermento.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldFermento.setEditable(false);
		textFieldFermento.setColumns(10);
		textFieldFermento.setBounds(671, 288, 167, 20);
		panel.add(textFieldFermento);

		JLabel lblEspeciariasAdicionais = new JLabel("Especiarias Adicionais:");
		lblEspeciariasAdicionais.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEspeciariasAdicionais.setBounds(539, 378, 145, 14);
		panel.add(lblEspeciariasAdicionais);

		JEditorPane descricaoPane = new JEditorPane();
		descricaoPane.setBackground(Color.WHITE);
		descricaoPane.setBounds(101, 344, 252, 141);
		descricaoPane.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.add(descricaoPane);

		JEditorPane especiariaPane = new JEditorPane();
		especiariaPane.setBackground(Color.WHITE);
		especiariaPane.setBounds(576, 403, 269, 141);
		especiariaPane.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.add(especiariaPane);

		JTextPane txtpnTodosOuCampos = new JTextPane();
		txtpnTodosOuCampos.setText(
				"Forjar informa\u00E7\u00F5es ou atribuir informa\u00E7\u00F5es n\u00E3o relacionadas a cerveja ou ingredientes podem levar ao banimento da plataforma!!!\r\n\r\nCADASTRE CONSCIENTE!\r\n\r\n");
		txtpnTodosOuCampos.setBounds(572, 568, 277, 93);
		panel.add(txtpnTodosOuCampos);

		JLabel lblMalte = new JLabel("Puro Malte:");
		lblMalte.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMalte.setBounds(550, 225, 109, 14);
		panel.add(lblMalte);

		JCheckBox chckbxSim = new JCheckBox("Sim");
		chckbxSim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (chckbxNao.isSelected() == true) {
					chckbxNao.setSelected(false);
				}
			}
		});
		chckbxSim.setBounds(671, 221, 51, 23);
		panel.add(chckbxSim);

		chckbxNao = new JCheckBox("N\u00E3o");
		chckbxNao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (chckbxSim.isSelected() == true) {
					chckbxSim.setSelected(false);
				}
			}
		});
		chckbxNao.setBounds(735, 221, 55, 23);
		panel.add(chckbxNao);
		chckbxNao.setSelected(true);

		JLabel lblCadastro = new JLabel("");
		lblCadastro.setBounds(10, 598, 552, 14);
		panel.add(lblCadastro);

		
		JComboBox<TipoCerveja> comboBoxTipo = new JComboBox<TipoCerveja>();
		comboBoxTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldTipoCerveja.setText(((TipoCerveja) comboBoxTipo.getSelectedItem()).getNome());
			}
		});
		
		comboBoxTipo.setBounds(338, 153, 112, 22);
		panel.add(comboBoxTipo);
		
		for (TipoCerveja tc : tipocervejabo.tipos()) {

			comboBoxTipo.addItem(tc);

		}

		JComboBox<Sabor> comboBoxSabor = new JComboBox<Sabor>();
		comboBoxSabor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSabor.setText(((Sabor) comboBoxSabor.getSelectedItem()).getNome());
			}
		});
		comboBoxSabor.setBounds(338, 190, 112, 22);
		panel.add(comboBoxSabor);

		SaborBO saborbo = new SaborBO();
		for (Sabor s : saborbo.sabores()) {

			comboBoxSabor.addItem(s);

		}

		JComboBox<Pais> comboBoxPais = new JComboBox<Pais>();
		comboBoxPais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldPais.setText(((Pais) comboBoxPais.getSelectedItem()).getNome());
			}
		});
		comboBoxPais.setBounds(338, 221, 112, 22);
		panel.add(comboBoxPais);
		
		PaisBO paisbo = new PaisBO();
		for (Pais p : paisbo.paises()) {

			comboBoxPais.addItem(p);

		}
		
		JComboBox<Coloracao> comboBoxColoracao = new JComboBox<Coloracao>();
		comboBoxColoracao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldColoracao.setText(((Coloracao) comboBoxColoracao.getSelectedItem()).getNome());
			}
		});
		comboBoxColoracao.setBounds(338, 256, 112, 22);
		panel.add(comboBoxColoracao);
		
		ColoracaoBO coloracaobo = new ColoracaoBO();
		for (Coloracao c : coloracaobo.cores()) {

			comboBoxColoracao.addItem(c);

		}

		JComboBox<Lupulo> comboBoxLupulo = new JComboBox<Lupulo>();
		comboBoxLupulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldLupulo.setText(((Lupulo) comboBoxLupulo.getSelectedItem()).getNome());
			}
		});
		comboBoxLupulo.setBounds(848, 256, 112, 22);
		panel.add(comboBoxLupulo);
		
		LupuloBO lupulobo = new LupuloBO();
		for (Lupulo l : lupulobo.lupulos()) {

			comboBoxLupulo.addItem(l);

		}

		JComboBox<Fermento> comboBoxFermento = new JComboBox<Fermento>();
		comboBoxFermento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldFermento.setText(((Fermento) comboBoxFermento.getSelectedItem()).getNome());
			}
		});
		comboBoxFermento.setBounds(848, 287, 112, 22);
		panel.add(comboBoxFermento);
		
		FermentoBO fermentobo = new FermentoBO();
		for (Fermento f : fermentobo.fermentos()) {

			comboBoxFermento.addItem(f);

		}

		JLabel lblTipoDeMalte = new JLabel("Tipo de Malte:");
		lblTipoDeMalte.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoDeMalte.setBounds(550, 325, 109, 14);
		panel.add(lblTipoDeMalte);

		textFieldMalte = new JTextField();
		textFieldMalte.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldMalte.setEditable(false);
		textFieldMalte.setColumns(10);
		textFieldMalte.setBounds(671, 322, 167, 20);
		panel.add(textFieldMalte);

		JComboBox<Malte> comboBoxMalte = new JComboBox<Malte>();
		comboBoxMalte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldMalte.setText(((Malte) comboBoxMalte.getSelectedItem()).getNome());
			}
		});
		comboBoxMalte.setBounds(848, 315, 112, 22);
		panel.add(comboBoxMalte);
		
		MalteBO maltebo = new MalteBO();
		for (Malte m : maltebo.maltes()) {

			comboBoxMalte.addItem(m);

		}

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Ingredientes ingredientes = new Ingredientes();
				Cerveja cerveja = new Cerveja();
			

				CervejaBO cbo = new CervejaBO();
				IngredientesBO ibo = new IngredientesBO();
				if (!CervejaValidator.validar(nameField.getText(), descricaoPane.getText())) {
					lblCadastro.setText(
							"Dados invalidos, verifique se todos os campos foram preenchidos e tente novamente");
					return;
				}
				if (!IngredientesValidator.validar(textAlchool.getText(), textCevada.getText(),
						especiariaPane.getText())) {
					lblCadastro.setText(
							"Dados invalidos, verifique se todos os campos foram preenchidos e tente novamente");
					return;
				}
				// ingredientes - extrair metodo
				setAlcoolAndCeveda(chckbxSim, ingredientes);

				setIngredientes(especiariaPane, comboBoxLupulo, comboBoxFermento, comboBoxMalte, ingredientes);

				// cerveja - extrair metodo

				setCerveja(descricaoPane, comboBoxTipo, comboBoxSabor, comboBoxPais, comboBoxColoracao, cerveja);

				boolean cadastrar = false;
				boolean cadastrarIngredientes = false;
				try {
					cadastrarIngredientes = ibo.salvar(ingredientes);

					cerveja.setIngredientes(ingredientes);

				} catch (Exception e1) {

					lblCadastro.setText("Erro Ao salvar ingredientes");
				} finally {
					try {
						cadastrar = cbo.salvar(cerveja);
					} catch (Exception e1) {

						lblCadastro.setText("Erro Ao salvar cervejas");

					}
				}

				if (cadastrar && cadastrarIngredientes) {
					lblCadastro.setText("Cerveja Cadastrada Com Sucesso");
				} else {
					lblCadastro.setText("Já existe uma cerveja com este nome, tente um nome diferente");
				}

			}
		});
		btnCadastrar.setBackground(Color.LIGHT_GRAY);
		btnCadastrar.setForeground(Color.BLACK);
		btnCadastrar.setBounds(168, 548, 124, 23);
		panel.add(btnCadastrar);


		frameCadastro.setVisible(true);

	}

	private static void setIngredientes(JEditorPane especiariaPane, JComboBox<Lupulo> comboBoxLupulo,
			JComboBox<Fermento> comboBoxFermento, JComboBox<Malte> comboBoxMalte, Ingredientes ingredientes) {
		ingredientes.setLupulo((Lupulo) comboBoxLupulo.getSelectedItem());
		ingredientes.setFermento((Fermento) comboBoxFermento.getSelectedItem());
		ingredientes.setMalte((Malte) comboBoxMalte.getSelectedItem());
		ingredientes.setEspeciarias(especiariaPane.getText());
		ingredientes.setNome(nameField.getText());
	}

	private static void setCerveja(JEditorPane descricaoPane, JComboBox<TipoCerveja> comboBoxTipo,
			JComboBox<Sabor> comboBoxSabor, JComboBox<Pais> comboBoxPais, JComboBox<Coloracao> comboBoxColoracao,
			Cerveja cerveja) {
		cerveja.setNome(nameField.getText());
		cerveja.setType((TipoCerveja) comboBoxTipo.getSelectedItem());
		cerveja.setFlavor((Sabor) comboBoxSabor.getSelectedItem());
		cerveja.setCountryOrigin((Pais) comboBoxPais.getSelectedItem());
		cerveja.setColoracao((Coloracao) comboBoxColoracao.getSelectedItem());
		cerveja.setDescription(descricaoPane.getText());
		CervejeiroBO cervejeirobo = new CervejeiroBO();
		Cervejeiro cervejeiro = new Cervejeiro();
		cervejeiro.setEmail(((Cervejeiro) TelaLogin.usuarioLogado).getEmail());
		cerveja.setCervejeiro((Cervejeiro) cervejeirobo.findCervejeiro(cervejeiro));
	}

	private static void setAlcoolAndCeveda(JCheckBox chckbxSim, Ingredientes ingredientes) {
		if (textAlchool.isEnabled() == true) {
			float alchool = Float.parseFloat(textAlchool.getText());
			ingredientes.setAlcool(true);
			ingredientes.setTeorAlcoolico(alchool);
		} else {
			ingredientes.setAlcool(false);
			ingredientes.setTeorAlcoolico(0);
		}

		ingredientes.setCevada(Float.parseFloat(textCevada.getText()));

		if (chckbxSim.isSelected() == true) {
			ingredientes.setPuroMalte(true);
		} else {
			ingredientes.setPuroMalte(false);
		}
	}
}
