package br.edu.unifacear.telas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import br.edu.unifacear.bo.ApreciadorBO;
import br.edu.unifacear.bo.TipoCervejaBO;
import br.edu.unifacear.classes.Apreciador;
import br.edu.unifacear.classes.Estado;
import br.edu.unifacear.classes.TipoCerveja;
import br.edu.unifacear.validators.ApreciadorValidator;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class TelaCadastroApreciador extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JFrame frameCadastro;
	private static JTextField emailField;
	private static JPasswordField passwordField;
	private static JTextField ageField;
	private static JTextField nameField;

	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public static void telaCadastro() throws Exception {

		ApreciadorBO cadastro = new ApreciadorBO();
		TipoCervejaBO tipocervejabo = new TipoCervejaBO();
		ArrayList<TipoCerveja> tipos = new ArrayList<TipoCerveja>();

		// labels e botoes do jFrame
		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(Color.WHITE);
		frameCadastro = new JFrame();
		frameCadastro.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\leo4_\\Desktop\\GrogosPesq.jpg"));
		frameCadastro.setSize(918, 686);
		frameCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCadastro.setLocation(500, 250);

		frameCadastro.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblCadastroMsg = new JLabel("");
		lblCadastroMsg.setBounds(404, 586, 488, 50);
		panel.add(lblCadastroMsg);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.BLACK);
		btnCadastrar.setBackground(Color.LIGHT_GRAY);
		btnCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = nameField.getText();
				String email = emailField.getText();
				String senha = passwordField.getText();
				String idadeS = ageField.getText();

				int idade = 0;
				boolean cadastrar = false;
				if (ApreciadorValidator.validar(nome, idadeS, email, senha)) {
					idade = Integer.parseInt(ageField.getText());
					if (idade < 18) {
						lblCadastroMsg.setText("Aplicativo destinado a usúarios maiores de 18 anos");
						return;
					}

					Apreciador newUser = new Apreciador();
					newUser.setEmail(email);
					newUser.setIdade(idade);
					newUser.setNome(nome);
					newUser.setSenha(senha);
					newUser.setTipoCervejas(tipos);
					try {
						cadastrar = cadastro.registerUser(newUser);
					} catch (Exception e1) {
						JOptionPane.showInternalMessageDialog(null, "Erro ao cadastrar, tente novamente!");
						return;
					}
					if (cadastrar == true) {
						JOptionPane.showInternalMessageDialog(null, "Cadastrado com sucesso!");
						try {
							TelaLogin.telaInicial();
						} catch (Exception e1) {
							lblCadastroMsg.setText("Erro ao voltar a tela inicial, clique no botão voltar");
							return;
						}
						frameCadastro.dispose();
					} else {
						lblCadastroMsg.setText("Esse email já existe");
					}

				} else {
					lblCadastroMsg.setText("dados invalidos");
				}

			}

		});

		btnCadastrar.setBounds(678, 564, 154, 23);
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

		JLabel lblTitle = new JLabel("Cadastrar-se");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTitle.setForeground(new Color(204, 102, 51));
		lblTitle.setBounds(325, 25, 219, 14);
		panel.add(lblTitle);

		emailField = new JTextField();
		emailField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblCadastroMsg.setText("");
			}
		});
		emailField.setToolTipText("email");
		emailField.setForeground(Color.BLACK);
		emailField.setBackground(new Color(255, 255, 255));
		emailField.setBounds(146, 186, 175, 20);
		panel.add(emailField);
		emailField.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(90, 189, 46, 14);
		panel.add(lblEmail);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(65, 217, 71, 14);
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
		lblGrogosImg.setBounds(453, 37, 204, 263);
		panel.add(lblGrogosImg);

		ageField = new JTextField();
		ageField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblCadastroMsg.setText("");
			}
		});

		ageField.setToolTipText("idade");
		ageField.setForeground(Color.BLACK);
		ageField.setColumns(10);
		ageField.setBackground(Color.WHITE);
		ageField.setBounds(146, 153, 46, 20);
		panel.add(ageField);

		nameField = new JTextField();
		nameField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblCadastroMsg.setText("");
			}
		});
		nameField.setToolTipText("nome");
		nameField.setForeground(Color.BLACK);
		nameField.setColumns(10);
		nameField.setBackground(Color.WHITE);
		nameField.setBounds(146, 122, 175, 20);
		panel.add(nameField);

		JLabel lblAge = new JLabel("Idade:");
		lblAge.setBounds(90, 156, 46, 14);
		panel.add(lblAge);

		JLabel lblName = new JLabel("Nome:");
		lblName.setBounds(90, 125, 46, 14);
		panel.add(lblName);

		List listTipos = new List();
		listTipos.setForeground(Color.BLACK);
		listTipos.setFont(new Font("Arial Black", Font.BOLD, 12));
		listTipos.setBounds(104, 461, 149, 119);
		panel.add(listTipos);
		listTipos.setEnabled(false);
		

		JLabel lbltipomsg = new JLabel("");
		lbltipomsg.setBounds(104, 437, 247, 14);
		panel.add(lbltipomsg);

		JComboBox<TipoCerveja> comboBoxTipoCerveja = new JComboBox<TipoCerveja>();
		comboBoxTipoCerveja.setBounds(105, 404, 148, 22);
		panel.add(comboBoxTipoCerveja);

		JButton btnAddTipoCerveja = new JButton("Adicionar");
		btnAddTipoCerveja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TipoCerveja tc = (TipoCerveja) comboBoxTipoCerveja.getSelectedItem();

				if (!tipos.contains(tc)) {
					tipos.add(tc);
					listTipos.add(tc.getNome());
					
				} else {
					lbltipomsg.setText("item ja adicionado");
				}

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lbltipomsg.setText("");
			}
		});
		btnAddTipoCerveja.setBounds(263, 404, 89, 23);
		panel.add(btnAddTipoCerveja);
		
		JButton btnRemoverTipo = new JButton("Remover");
		btnRemoverTipo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TipoCerveja tc = (TipoCerveja) comboBoxTipoCerveja.getSelectedItem();
				if (tipos.contains(tc)) {
					tipos.remove(tc);
					listTipos.remove(tc.getNome());
				} else {
					lbltipomsg.setText("Item não está na lista");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbltipomsg.setText("");
			}
		});
		btnRemoverTipo.setBounds(262, 437, 89, 23);
		panel.add(btnRemoverTipo);
		
		JLabel lblCadastrar = new JLabel("Cadastrar Conta e Preferencias");
		lblCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrar.setBounds(628, 539, 230, 14);
		panel.add(lblCadastrar);
		
		JLabel lblAdicionarTipos = new JLabel("Escolha alguns Tipos de Cerveja de sua Preferencia");
		lblAdicionarTipos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionarTipos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdicionarTipos.setBounds(10, 377, 430, 14);
		panel.add(lblAdicionarTipos);

		for (TipoCerveja tc : tipocervejabo.tipos()) {

			comboBoxTipoCerveja.addItem(tc);

		}

		frameCadastro.setVisible(true);

	}
}
