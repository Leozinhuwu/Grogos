package br.edu.unifacear.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.edu.unifacear.bo.CervejariaBO;
import br.edu.unifacear.bo.CervejeiroBO;
import br.edu.unifacear.bo.CidadeBO;
import br.edu.unifacear.bo.EnderecoBO;
import br.edu.unifacear.bo.EstadoBO;
import br.edu.unifacear.bo.TokenBO;
import br.edu.unifacear.classes.Cervejaria;
import br.edu.unifacear.classes.Cervejeiro;
import br.edu.unifacear.classes.Cidade;
import br.edu.unifacear.classes.Endereco;
import br.edu.unifacear.classes.Estado;
import br.edu.unifacear.classes.Token;
import br.edu.unifacear.validators.CervejariaValidator;
import br.edu.unifacear.validators.CervejeiroValidator;

import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class TelaCadastroCervejeiro {

	private static JFrame frameCadastro;
	private static JTextField textFieldEmail;
	private static JPasswordField passwordField;
	private static JTextField textFieldIdade;
	private static JTextField textFieldNome;
	private static JTextField textFieldTelefone;
	private static JTextField textToken;
	private static JTextField textNomeCervejaria;
	private static JTextField textFieldEmailCervejaria;
	private static JTextField textFieldEndereco;
	private static JTextField textFieldTelefoneCervejaria;

	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public void telaCadastro() throws Exception {

		CervejeiroBO cadastro = new CervejeiroBO();
		EstadoBO estadobo = new EstadoBO();
		CidadeBO cidadebo = new CidadeBO();

		// labels e botoes do jFrame
		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(new Color(244, 164, 96));
		frameCadastro = new JFrame();
		frameCadastro.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\leo4_\\Desktop\\GrogosPesq.jpg"));
		frameCadastro.setSize(923, 751);
		frameCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCadastro.setLocation(500, 250);

		frameCadastro.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblCadastroMsg = new JLabel("");
		lblCadastroMsg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCadastroMsg.setBounds(518, 651, 336, 23);
		panel.add(lblCadastroMsg);

		JComboBox<Cidade> comboBoxCidade = new JComboBox<Cidade>();
		comboBoxCidade.setBounds(134, 585, 175, 22);
		panel.add(comboBoxCidade);

		JComboBox<Estado> comboBoxEstado = new JComboBox<Estado>();
		comboBoxEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					comboBoxCidade.removeAllItems();
					for (Cidade c : cidadebo.cidades((Estado) comboBoxEstado.getSelectedItem())) {
						comboBoxCidade.addItem(c);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		comboBoxEstado.setBounds(134, 553, 175, 22);
		panel.add(comboBoxEstado);

		for (Estado e : estadobo.estados()) {
			comboBoxEstado.addItem(e);

		}

		JButton btnVolta = new JButton("Voltar");
		btnVolta.setForeground(Color.BLACK);
		btnVolta.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnVolta.setBackground(Color.LIGHT_GRAY);
		btnVolta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaLogin telaIanicial = new TelaLogin();
					telaIanicial.telaInicial();

				} catch (Exception e1) {

					e1.printStackTrace();
				}
				frameCadastro.dispose();

			}
		});
		btnVolta.setBounds(10, 21, 89, 23);
		panel.add(btnVolta);

		JLabel lblTitle = new JLabel("Cadastrar-se ");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(255, 69, 0));
		lblTitle.setBounds(343, 25, 281, 14);
		panel.add(lblTitle);

		textFieldEmail = new JTextField();
		textFieldEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblCadastroMsg.setText("");
			}
		});
		textFieldEmail.setToolTipText("email");
		textFieldEmail.setForeground(Color.BLACK);
		textFieldEmail.setBackground(new Color(255, 255, 255));
		textFieldEmail.setBounds(146, 186, 175, 20);
		panel.add(textFieldEmail);
		textFieldEmail.setColumns(10);

		JLabel lblEmail = new JLabel("*Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(67, 189, 61, 14);
		panel.add(lblEmail);

		JLabel lblPassword = new JLabel("*Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(49, 217, 79, 14);
		panel.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblCadastroMsg.setText("");
			}
		});
		passwordField.setToolTipText("password");
		passwordField.setBounds(146, 214, 175, 20);
		panel.add(passwordField);

		ImageIcon grogos = new ImageIcon(TelaCadastroCervejeiro.class.getResource("/Grogos_Final_Edition.png"));

		JLabel lblGrogosImg = new JLabel(grogos);

		lblGrogosImg.setBounds(499, 78, 398, 404);
		panel.add(lblGrogosImg);

		textFieldIdade = new JTextField();
		textFieldIdade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblCadastroMsg.setText("");
			}
		});

		textFieldIdade.setToolTipText("idade");
		textFieldIdade.setForeground(Color.BLACK);
		textFieldIdade.setColumns(10);
		textFieldIdade.setBackground(Color.WHITE);
		textFieldIdade.setBounds(146, 153, 46, 20);
		panel.add(textFieldIdade);

		textFieldNome = new JTextField();
		textFieldNome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblCadastroMsg.setText("");
			}
		});
		textFieldNome.setToolTipText("nome");
		textFieldNome.setForeground(Color.BLACK);
		textFieldNome.setColumns(10);
		textFieldNome.setBackground(Color.WHITE);
		textFieldNome.setBounds(146, 122, 175, 20);
		panel.add(textFieldNome);

		JLabel lblAge = new JLabel("*Idade:");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setBounds(57, 156, 71, 14);
		panel.add(lblAge);

		JLabel lblName = new JLabel("*Nome:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(49, 125, 79, 14);
		panel.add(lblName);

		JLabel lblTelefone = new JLabel("*Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setBounds(57, 248, 71, 14);
		panel.add(lblTelefone);

		textFieldTelefone = new JTextField();
		textFieldTelefone.setToolTipText("telefone");
		textFieldTelefone.setForeground(Color.BLACK);
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBackground(Color.WHITE);
		textFieldTelefone.setBounds(146, 245, 175, 20);
		panel.add(textFieldTelefone);

		textToken = new JTextField();
		textToken.setToolTipText("nome");
		textToken.setForeground(Color.BLACK);
		textToken.setColumns(10);
		textToken.setBackground(Color.WHITE);
		textToken.setBounds(679, 586, 175, 20);
		panel.add(textToken);

		JLabel lblToken = new JLabel("*Passe:");
		lblToken.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblToken.setHorizontalAlignment(SwingConstants.RIGHT);
		lblToken.setBounds(599, 589, 71, 14);
		panel.add(lblToken);

		JLabel lblAutonomo = new JLabel(
				"Caso n\u00E3o tenha/trabalhe em uma cervejaria, selecione a op\u00E7\u00E3o Aut\u00F4nomo");
		lblAutonomo.setFont(new Font("Arial", Font.BOLD, 11));
		lblAutonomo.setBounds(67, 339, 487, 14);
		panel.add(lblAutonomo);

		JCheckBox chckbxAutonomo = new JCheckBox("Sou Aut\u00F4nomo");
		chckbxAutonomo.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxAutonomo.setBounds(66, 367, 126, 23);
		panel.add(chckbxAutonomo);

		JLabel lblDadosCervejaria = new JLabel("Dados da Cervejaria \r");
		lblDadosCervejaria.setHorizontalAlignment(SwingConstants.CENTER);
		lblDadosCervejaria.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblDadosCervejaria.setBounds(122, 425, 183, 23);
		panel.add(lblDadosCervejaria);

		JLabel lblNomeCervejaria = new JLabel("*Nome Cervejaria:");
		lblNomeCervejaria.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNomeCervejaria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeCervejaria.setBounds(10, 468, 114, 14);
		panel.add(lblNomeCervejaria);

		textNomeCervejaria = new JTextField();
		textNomeCervejaria.setToolTipText("nome");
		textNomeCervejaria.setForeground(Color.BLACK);
		textNomeCervejaria.setColumns(10);
		textNomeCervejaria.setBackground(Color.WHITE);
		textNomeCervejaria.setBounds(134, 465, 175, 20);
		panel.add(textNomeCervejaria);

		JLabel lblEmailCervejaria = new JLabel("*Email:");
		lblEmailCervejaria.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmailCervejaria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailCervejaria.setBounds(49, 499, 67, 14);
		panel.add(lblEmailCervejaria);

		textFieldEmailCervejaria = new JTextField();
		textFieldEmailCervejaria.setToolTipText("email");
		textFieldEmailCervejaria.setForeground(Color.BLACK);
		textFieldEmailCervejaria.setColumns(10);
		textFieldEmailCervejaria.setBackground(Color.WHITE);
		textFieldEmailCervejaria.setBounds(134, 496, 175, 20);
		panel.add(textFieldEmailCervejaria);

		JLabel lblEstado = new JLabel("*Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstado.setBounds(49, 557, 71, 14);
		panel.add(lblEstado);

		JLabel lblCidade = new JLabel("*Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setBounds(49, 589, 71, 14);
		panel.add(lblCidade);

		JLabel lblEndereco = new JLabel("*Endere\u00E7o:");
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereco.setBounds(37, 614, 83, 14);
		panel.add(lblEndereco);

		textFieldEndereco = new JTextField();
		textFieldEndereco.setBounds(134, 611, 359, 20);
		panel.add(textFieldEndereco);
		textFieldEndereco.setColumns(10);

		JLabel lblTelefoneCervejaria = new JLabel("*Telefone:");
		lblTelefoneCervejaria.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefoneCervejaria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefoneCervejaria.setBounds(37, 527, 79, 14);
		panel.add(lblTelefoneCervejaria);

		textFieldTelefoneCervejaria = new JTextField();
		textFieldTelefoneCervejaria.setToolTipText("telefone");
		textFieldTelefoneCervejaria.setForeground(Color.BLACK);
		textFieldTelefoneCervejaria.setColumns(10);
		textFieldTelefoneCervejaria.setBackground(Color.WHITE);
		textFieldTelefoneCervejaria.setBounds(134, 524, 175, 20);
		panel.add(textFieldTelefoneCervejaria);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCadastroMsg.setText("");
			}
		});
		btnCadastrar.setForeground(Color.BLACK);
		btnCadastrar.setBackground(Color.LIGHT_GRAY);
		btnCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Token token = new Token();
				TokenBO tkbo = new TokenBO();
				token.setNome(textToken.getText());
				token = (Token) tkbo.findToken(token);

				if (token == null || token.getStatus() == "invalid") {
					lblCadastroMsg.setText("Passe invalido");
					return;
				}

				if (chckbxAutonomo.isSelected()) {
					cadastrarCervejeiro(cadastro, lblCadastroMsg, comboBoxEstado, null, token);
				} else {

					Estado estado = (Estado) comboBoxEstado.getSelectedItem();
					Cidade cidade = (Cidade) comboBoxCidade.getSelectedItem();
					String nomeCervejaria = textNomeCervejaria.getText();
					String telefoneCervejaria = textFieldTelefoneCervejaria.getText();
					String enderecoCervejaria = textFieldEndereco.getText();
					String emailCervejaria = textFieldEmailCervejaria.getText();

					String nome = textFieldNome.getText();
					String email = textFieldEmail.getText();
					@SuppressWarnings("deprecation")
					String senha = passwordField.getText();
					String idadeS = textFieldIdade.getText();
					String telefone = textFieldTelefone.getText();

					if (CervejariaValidator.validar(nomeCervejaria, emailCervejaria, telefoneCervejaria,
							enderecoCervejaria)) {
						if (!CervejeiroValidator.validar(nome, idadeS, email, senha, telefone)) {
							lblCadastroMsg.setText("Dados do Cervejeiro invalidos");
							return;
						}
						Cervejaria newCervejaria = new Cervejaria();
						Endereco endereco = new Endereco();
						endereco.setNome(enderecoCervejaria);
						cidade.setEstado(estado);
						endereco.setCidade(cidade);

						newCervejaria.setNome(nomeCervejaria);
						newCervejaria.setEmail(emailCervejaria);
						newCervejaria.setTelefone(telefoneCervejaria);
						newCervejaria.setEndereco(endereco);
						cadastrarCervejeiro(cadastro, lblCadastroMsg, comboBoxEstado, newCervejaria, token);
					} else {
						lblCadastroMsg.setText("Dados da Cervejaria invalidos");
					}

				}

			}

		});

		btnCadastrar.setBounds(691, 617, 154, 23);
		panel.add(btnCadastrar);

		frameCadastro.setVisible(true);

	}

	private static void cadastrarCervejeiro(CervejeiroBO cadastro, JLabel lblCadastroMsg,
			JComboBox<Estado> comboBoxEstado, Cervejaria cervejaria, Token token) {
		String nome = textFieldNome.getText();
		String email = textFieldEmail.getText();
		@SuppressWarnings("deprecation")
		String senha = passwordField.getText();
		String idadeS = textFieldIdade.getText();
		String telefone = textFieldTelefone.getText();

		int idade = 0;
		boolean cadastrar = false;
		if (CervejeiroValidator.validar(nome, idadeS, email, senha, telefone)) {
			idade = Integer.parseInt(textFieldIdade.getText());
			if (idade < 18) {
				lblCadastroMsg.setText("Aplicativo destinado a usúarios maiores de 18 anos");
				return;
			}

			Cervejeiro newCervejeiro = new Cervejeiro();
			newCervejeiro.setEmail(email);
			newCervejeiro.setIdade(idade);
			newCervejeiro.setNome(nome);
			newCervejeiro.setSenha(senha);
			newCervejeiro.setTelefone(telefone);

			if (cervejaria != null) {
				EnderecoBO endbo = new EnderecoBO();
				try {
					endbo.saveEndereco(cervejaria.getEndereco());
				} catch (Exception e1) {
					lblCadastroMsg.setText("Endereço invalido");
				}

				CervejariaBO cbo = new CervejariaBO();
				try {
					cbo.saveCervejaria(cervejaria);
				} catch (Exception e) {
					lblCadastroMsg.setText("Cervejaria invalida");
					return;
				}
				newCervejeiro.setCervejaria(cervejaria);

			}

			try {
				cadastrar = cadastro.registerCervejeiro(newCervejeiro);
			} catch (Exception e1) {
				lblCadastroMsg.setText("Erro ao salvar Cervejeiro");
				return;
			}
			if (cadastrar == true) {

				token.setStatus("invalid");
				TokenBO tkbo = new TokenBO();
				try {
					tkbo.alterar(token);
				} catch (Exception e1) {

				}
				newCervejeiro.addToken(token);
				try {
					cadastro.alterar(newCervejeiro);
				} catch (Exception e) {

				}
				JOptionPane.showInternalMessageDialog(null, "Cadastrado com sucesso!");
				try {
					TelaLogin telaIanicial = new TelaLogin();
					telaIanicial.telaInicial();
				} catch (Exception e1) {
					lblCadastroMsg.setText("Erro ao voltar a tela inicial, clique no botão voltar");
					return;
				}
				frameCadastro.dispose();
			} else {
				lblCadastroMsg.setText("Esse email já existe");
			}
		} else {
			lblCadastroMsg.setText("Dados de Cervejeiro Inválidos");
		}
	}
}
