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
import br.edu.unifacear.bo.IngredientesBO;
import br.edu.unifacear.classes.Cerveja;
import br.edu.unifacear.classes.Fermento;
import br.edu.unifacear.classes.Ingredientes;
import br.edu.unifacear.classes.Lupulo;
import br.edu.unifacear.classes.Pais;
import br.edu.unifacear.classes.Sabor;
import br.edu.unifacear.classes.TipoCerveja;
import br.edu.unifacear.classes.Usuario;
import br.edu.unifacear.validators.CervejaValidator;
import br.edu.unifacear.validators.IngredientesValidator;

import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;

public class TelaCadastroCerveja {
	private static final long serialVersionUID = 1L;
	private static JFrame frameCadastro;
	private static JTextField nameField;
	private static JTextField typeField;
	private static JTextField flavorField;
	private static JTextField originField;
	private static JTextField creatorNameField;
	private static JTextField textCevada;
	private static JTextField textAlchool;
	private static JRadioButton rdbtnComAlchool;
	private static JTextField textFieldLupo;
	private static JTextField textFieldFermento;
	private static JCheckBox chckbxNao;

	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public static void telaCadastro() throws Exception {

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
					TelaMenuCervejeiro.telaMenuUser();

				} catch (Exception e1) {

					e1.printStackTrace();
				}
				frameCadastro.dispose();

			}
		});
		btnVolta.setBounds(10, 21, 89, 23);
		panel.add(btnVolta);

		JLabel lblTitle = new JLabel("Grogos");
		lblTitle.setForeground(Color.RED);
		lblTitle.setBounds(457, 25, 46, 14);
		panel.add(lblTitle);

		nameField = new JTextField();
		nameField.setBounds(145, 123, 178, 20);
		panel.add(nameField);
		nameField.setColumns(10);

		typeField = new JTextField();
		typeField.setBounds(145, 154, 178, 20);
		panel.add(typeField);
		typeField.setColumns(10);

		flavorField = new JTextField();
		flavorField.setBounds(145, 191, 178, 20);
		panel.add(flavorField);
		flavorField.setColumns(10);

		originField = new JTextField();
		originField.setBounds(145, 222, 178, 20);
		panel.add(originField);
		originField.setColumns(10);

		creatorNameField = new JTextField();
		creatorNameField.setBounds(145, 257, 178, 20);
		panel.add(creatorNameField);
		creatorNameField.setColumns(10);

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

		JLabel lblCreatorName = new JLabel("Criador:");
		lblCreatorName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCreatorName.setBounds(84, 260, 51, 14);
		panel.add(lblCreatorName);

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
			@Override
			public void mouseClicked(MouseEvent e) {

				if (rdbtnComAlchool.isSelected() == true) {
					textAlchool.disable();
					rdbtnComAlchool.setSelected(false);
					textAlchool.setText("");
				} else if (textAlchool.isEnabled() == false && rdbtnComAlchool.isSelected() == false) {
					rdbtnComAlchool.setSelected(true);
					textAlchool.enable();
					rdbtnAlchool.setSelected(false);
				}
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

		JLabel lblPorcentagem_1 = new JLabel("%");
		lblPorcentagem_1.setBounds(725, 156, 22, 14);
		panel.add(lblPorcentagem_1);

		rdbtnComAlchool = new JRadioButton("Com Alcool");
		rdbtnComAlchool.setSelected(true);
		rdbtnComAlchool.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (textAlchool.isEnabled() == true) {
					textAlchool.setText("");
					textAlchool.disable();
					rdbtnAlchool.setSelected(true);

				} else if (textAlchool.isEnabled() == false && rdbtnAlchool.isSelected() == true) {
					textAlchool.enable();
					rdbtnAlchool.setSelected(false);
				}
			}
		});

		rdbtnComAlchool.setBounds(570, 123, 109, 23);
		panel.add(rdbtnComAlchool);

		JLabel lblLupo = new JLabel("Tipo de Lupulo:");
		lblLupo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLupo.setBounds(570, 260, 89, 14);
		panel.add(lblLupo);

		textFieldLupo = new JTextField();
		textFieldLupo.setBounds(671, 257, 109, 20);
		panel.add(textFieldLupo);
		textFieldLupo.setColumns(10);

		JLabel lblTipoDeFermento = new JLabel("Tipo de Fermento:");
		lblTipoDeFermento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoDeFermento.setBounds(550, 291, 109, 14);
		panel.add(lblTipoDeFermento);

		textFieldFermento = new JTextField();
		textFieldFermento.setColumns(10);
		textFieldFermento.setBounds(671, 288, 109, 20);
		panel.add(textFieldFermento);

		JLabel lblEspeciariasAdicionais = new JLabel("Especiarias Adicionais:");
		lblEspeciariasAdicionais.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEspeciariasAdicionais.setBounds(513, 319, 145, 14);
		panel.add(lblEspeciariasAdicionais);
		
		JEditorPane descricaoPane = new JEditorPane();
		descricaoPane.setBackground(Color.WHITE);
		descricaoPane.setBounds(101, 344, 252, 141);
		descricaoPane.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.add(descricaoPane);
		
		JEditorPane especiariaPane = new JEditorPane();
		especiariaPane.setBackground(Color.WHITE);
		especiariaPane.setBounds(550, 344, 269, 141);
		especiariaPane.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.add(especiariaPane);

		JTextPane txtpnTodosOuCampos = new JTextPane();
		txtpnTodosOuCampos.setText(
				"Forjar informa\u00E7\u00F5es ou atribuir informa\u00E7\u00F5es n\u00E3o relacionadas a cerveja ou ingredientes podem levar ao banimento da plataforma!!!\r\n\r\nCADASTRE CONSCIENTE!\r\n\r\n");
		txtpnTodosOuCampos.setBounds(546, 509, 277, 93);
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
		lblCadastro.setBounds(26, 598, 459, 14);
		panel.add(lblCadastro);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Ingredientes ingredientes = new Ingredientes();
				Cerveja cerveja = new Cerveja();
				Pais pais = new Pais();
				Sabor sabor  = new Sabor();
				TipoCerveja tipoCerveja = new TipoCerveja();
				Lupulo lupulo = new Lupulo();
				Fermento fermento = new Fermento();

				CervejaBO cbo = new CervejaBO();
				IngredientesBO ibo = new IngredientesBO();
				if (!CervejaValidator.validar(nameField.getText(), typeField.getText(), flavorField.getText(),
						originField.getText(), creatorNameField.getText(), descricaoPane.getText())) {
					lblCadastro.setText("Dados invalidos, verifique se todos os campos foram preenchidos e tente novamente");
					return;
				}
				if(!IngredientesValidator.validar( textAlchool.getText(), textCevada.getText(), textFieldLupo.getText(), textFieldFermento.getText(), especiariaPane.getText())) {
					lblCadastro.setText("Dados invalidos, verifique se todos os campos foram preenchidos e tente novamente");
					return;
				}
				// ingredientes - extrair metodo
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

				ingredientes.setLupulo(lupulo);
				ingredientes.setFermento(fermento);
				ingredientes.setEspeciarias(especiariaPane.getText());
				ingredientes.setNome(nameField.getText());

				// cerveja - extrair metodo

				cerveja.setNome(nameField.getText());
				cerveja.setType(tipoCerveja);
				cerveja.setFlavor(sabor);
				cerveja.setCountryOrigin(pais);
				cerveja.setDescription(descricaoPane.getText());
				Usuario usuarioLogado = new Usuario();
				usuarioLogado.setEmail(TelaLogin.usuarioLogado);
				cerveja.setUsuario(usuarioLogado);

				boolean cadastrar = false;
				boolean cadastrarIngredientes = false;
				try {
					cadastrarIngredientes = ibo.salvar(ingredientes);

					cerveja.setIngredientes(ingredientes);

				} catch (Exception e1) {

					e1.printStackTrace();
				} finally {
					try {
						cadastrar = cbo.salvar(cerveja);
					} catch (Exception e1) {

						e1.printStackTrace();
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
		TipoCerveja tipoCerveja = new TipoCerveja();
		tipoCerveja.setNome("uwu");
		tipoCerveja.setId(1);
		JComboBox<TipoCerveja> comboBoxTipo = new JComboBox<TipoCerveja>();
		comboBoxTipo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		comboBoxTipo.addItem(tipoCerveja);
		comboBoxTipo.setBounds(338, 153, 112, 22);
		panel.add(comboBoxTipo);
		
		JComboBox<TipoCerveja> comboBoxSabor = new JComboBox<TipoCerveja>();
		comboBoxSabor.setBounds(338, 190, 112, 22);
		panel.add(comboBoxSabor);
		
		JComboBox<TipoCerveja> comboBoxPais = new JComboBox<TipoCerveja>();
		comboBoxPais.setBounds(338, 221, 112, 22);
		panel.add(comboBoxPais);
		
		

		frameCadastro.setVisible(true);

	}
}
