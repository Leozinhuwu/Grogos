package br.edu.unifacear.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.edu.unifacear.bo.ApreciadorBO;
import br.edu.unifacear.classes.Apreciador;
import br.edu.unifacear.validators.UsuarioValidator;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;

public class TelaCadastroCervejeiro {
	
	private static final long serialVersionUID = 1L;
	private static JFrame frameCadastro;
	private static JTextField textFieldEmail;
	private static JPasswordField passwordField;
	private static JTextField textFieldIdade;
	private static JTextField textFieldNome;
	private static JTextField textFieldTelefone;
	private static JTextField textToken;
	private static JTextField textNomeCervejaria;
	private static JTextField textFieldEmailCervejaria;
	private static JTextField textField;
	private static JTextField textFieldTelefoneCervejaria;

	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public static void telaCadastro() throws Exception {

		ApreciadorBO cadastro = new ApreciadorBO();

		// labels e botoes do jFrame
		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(Color.WHITE);
		frameCadastro = new JFrame();
		frameCadastro.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\leo4_\\Desktop\\GrogosPesq.jpg"));
		frameCadastro.setSize(923, 751);
		frameCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCadastro.setLocation(500, 250);

		frameCadastro.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblCadastroMsg = new JLabel("");
		lblCadastroMsg.setBounds(125, 303, 488, 50);
		panel.add(lblCadastroMsg);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.BLACK);
		btnCadastrar.setBackground(Color.LIGHT_GRAY);
		btnCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = textFieldNome.getText();
				String email = textFieldEmail.getText();
				String senha = passwordField.getText();
				String idadeS = textFieldIdade.getText();

				int idade = 0;
				boolean cadastrar = false;
				if (UsuarioValidator.validar(nome, idadeS, email, senha)) {
					idade = Integer.parseInt(textFieldIdade.getText());
					if(idade < 18) {
						lblCadastroMsg.setText("Aplicativo destinado a usúarios maiores de 18 anos");
						return;
					}
					
					Apreciador newUser = new Apreciador();
					newUser.setEmail(email);
					newUser.setIdade(idade);
					newUser.setNome(nome);
					newUser.setSenha(senha);
					try {
						cadastrar = cadastro.registerUser(newUser);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (cadastrar == true) {
						lblCadastroMsg.setText("Cadastrado com Sucesso");
					} else {
						lblCadastroMsg.setText("Esse email já existe");
					}

				} else {
					lblCadastroMsg.setText("dados invalidos");
				}

			}

		});

		btnCadastrar.setBounds(655, 560, 154, 23);
		panel.add(btnCadastrar);

		JButton btnVolta = new JButton("Voltar");
		btnVolta.setForeground(Color.BLACK);
		btnVolta.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		btnVolta.setBackground(Color.LIGHT_GRAY);
		btnVolta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaLogin.telaInicial();

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
		lblTitle.setBounds(292, 25, 46, 14);
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

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(82, 189, 46, 14);
		panel.add(lblEmail);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(57, 217, 71, 14);
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

		JLabel lblGrogosImg = new JLabel("");
		lblGrogosImg.setIcon(new ImageIcon("C:\\Users\\leo4_\\Desktop\\gragas.png"));
		lblGrogosImg.setBounds(643, 46, 204, 263);
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

		JLabel lblAge = new JLabel("Idade:");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setBounds(82, 156, 46, 14);
		panel.add(lblAge);

		JLabel lblName = new JLabel("Nome:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(82, 125, 46, 14);
		panel.add(lblName);
		
		JLabel lblTelefone = new JLabel("Telefone:");
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
		textToken.setBounds(643, 529, 175, 20);
		panel.add(textToken);
		
		JLabel lblToken = new JLabel("Passe:");
		lblToken.setBounds(596, 532, 46, 14);
		panel.add(lblToken);
		
		JLabel lblAutonomo = new JLabel("Caso n\u00E3o tenha/trabalhe em uma cervejaria, selecione a op\u00E7\u00E3o Aut\u00F4nomo");
		lblAutonomo.setBounds(67, 339, 405, 14);
		panel.add(lblAutonomo);
		
		JCheckBox chckbxAutonomo = new JCheckBox("Aut\u00F4nomo");
		chckbxAutonomo.setBounds(66, 367, 97, 23);
		panel.add(chckbxAutonomo);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(880, 158, 17, 48);
		panel.add(scrollBar);
		
		JLabel lblDadosCervejaria = new JLabel("Dados da Cervejaria \r");
		lblDadosCervejaria.setBounds(146, 426, 160, 14);
		panel.add(lblDadosCervejaria);
		
		JLabel lblNomeCervejaria = new JLabel("Nome Cervejaria:");
		lblNomeCervejaria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeCervejaria.setBounds(10, 469, 93, 14);
		panel.add(lblNomeCervejaria);
		
		textNomeCervejaria = new JTextField();
		textNomeCervejaria.setToolTipText("nome");
		textNomeCervejaria.setForeground(Color.BLACK);
		textNomeCervejaria.setColumns(10);
		textNomeCervejaria.setBackground(Color.WHITE);
		textNomeCervejaria.setBounds(113, 466, 175, 20);
		panel.add(textNomeCervejaria);
		
		JLabel lblEmailCervejaria = new JLabel("Email:");
		lblEmailCervejaria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailCervejaria.setBounds(49, 500, 46, 14);
		panel.add(lblEmailCervejaria);
		
		textFieldEmailCervejaria = new JTextField();
		textFieldEmailCervejaria.setToolTipText("email");
		textFieldEmailCervejaria.setForeground(Color.BLACK);
		textFieldEmailCervejaria.setColumns(10);
		textFieldEmailCervejaria.setBackground(Color.WHITE);
		textFieldEmailCervejaria.setBounds(113, 497, 175, 20);
		panel.add(textFieldEmailCervejaria);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstado.setBounds(53, 558, 46, 14);
		panel.add(lblEstado);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(113, 554, 175, 22);
		panel.add(comboBox);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setBounds(53, 590, 46, 14);
		panel.add(lblCidade);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(113, 586, 175, 22);
		panel.add(comboBox_1);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereco.setBounds(28, 615, 71, 14);
		panel.add(lblEndereco);
		
		textField = new JTextField();
		textField.setBounds(113, 612, 359, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblTelefoneCervejaria = new JLabel("Telefone:");
		lblTelefoneCervejaria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefoneCervejaria.setBounds(24, 528, 71, 14);
		panel.add(lblTelefoneCervejaria);
		
		textFieldTelefoneCervejaria = new JTextField();
		textFieldTelefoneCervejaria.setToolTipText("telefone");
		textFieldTelefoneCervejaria.setForeground(Color.BLACK);
		textFieldTelefoneCervejaria.setColumns(10);
		textFieldTelefoneCervejaria.setBackground(Color.WHITE);
		textFieldTelefoneCervejaria.setBounds(113, 525, 175, 20);
		panel.add(textFieldTelefoneCervejaria);

		frameCadastro.setVisible(true);

	}
}
