package br.edu.unifacear.telas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import br.edu.unifacear.bo.Login;
import br.edu.unifacear.classes.Usuario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JFrame frameMain;
	private static JTextField txtEmail;
	private static JPasswordField passwordField;
	public static String usuarioLogado;

	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public static void telaInicial() throws Exception {

		Login login = new Login();

//		cadastro.registerUser(nome, senha, idade, email);

		// imagem

		// labels e botoes do jFrame
		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(Color.WHITE);
		frameMain = new JFrame();
		frameMain.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\leo4_\\Desktop\\GrogosPesq.jpg"));
		frameMain.setSize(750, 500);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.setLocation(500, 250);

		frameMain.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaCadastroUsuario.telaCadastro();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frameMain.dispose();
			}

		});

		btnCadastrar.setBounds(513, 346, 131, 23);
		panel.add(btnCadastrar);

		JLabel lblLoginFail = new JLabel("");
		lblLoginFail.setBounds(146, 194, 196, 45);
		panel.add(lblLoginFail);

		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario user = new Usuario();
				user.setEmail(txtEmail.getText());
				user.setSenha(passwordField.getText());
				boolean auth = login.login(user);

				if (auth == true) {
					try {
						usuarioLogado = user.getEmail();
						TelaMenuUsuario.telaMenuUser();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frameMain.dispose();
				} else {
					lblLoginFail.setText("email ou senha incorreto/a");
				}
			}
		});
		btnLogar.setBounds(172, 160, 89, 23);
		panel.add(btnLogar);

		JLabel lblTitle = new JLabel("Grogos");
		lblTitle.setForeground(Color.RED);
		lblTitle.setBounds(292, 25, 46, 14);
		panel.add(lblTitle);

		txtEmail = new JTextField();
		txtEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblLoginFail.setText("");
			}
		});
		txtEmail.setToolTipText("email");
		txtEmail.setForeground(Color.BLACK);
		txtEmail.setBackground(new Color(255, 255, 255));
		txtEmail.setBounds(146, 84, 175, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblCadastrar = new JLabel("Caso nao tenha conta cadastre aqui");
		lblCadastrar.setBounds(488, 321, 236, 14);
		panel.add(lblCadastrar);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(105, 87, 46, 14);
		panel.add(lblEmail);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(80, 132, 71, 14);
		panel.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(146, 129, 175, 20);
		panel.add(passwordField);

		JLabel lblGrogosImg = new JLabel("");
		lblGrogosImg.setIcon(new ImageIcon("C:\\Users\\leo4_\\Desktop\\gragas.png"));
		lblGrogosImg.setBounds(453, 37, 204, 263);
		panel.add(lblGrogosImg);

		frameMain.setVisible(true);

	}
}
