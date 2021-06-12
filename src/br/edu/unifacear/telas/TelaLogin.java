package br.edu.unifacear.telas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import br.edu.unifacear.bo.ApreciadorBO;
import br.edu.unifacear.bo.CervejeiroBO;
import br.edu.unifacear.classes.Apreciador;
import br.edu.unifacear.classes.Cervejeiro;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JFrame frameMain;
	private static JTextField txtEmail;
	private static JPasswordField passwordField;
	public static Object usuarioLogado;

	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public static void telaInicial() throws Exception {

		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(new Color(244, 164, 96));
		frameMain = new JFrame();
		frameMain.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\leo4_\\Desktop\\GrogosPesq.jpg"));
		frameMain.setSize(931, 537);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.setLocation(500, 250);

		frameMain.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnCadastrarApreciador = new JButton("Cadastrar");
		btnCadastrarApreciador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaCadastroApreciador.telaCadastro();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frameMain.dispose();
			}

		});

		btnCadastrarApreciador.setBounds(35, 436, 131, 23);
		panel.add(btnCadastrarApreciador);

		JLabel lblLoginFail = new JLabel("");
		lblLoginFail.setBounds(146, 194, 196, 45);
		panel.add(lblLoginFail);

		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				efetuarLogin(lblLoginFail);
			}
		});
		btnLogar.setBounds(197, 160, 89, 23);
		panel.add(btnLogar);

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

		JLabel lblCadastrarApreciador = new JLabel("Novo Apreciador?  Cadastre-se aqui");
		lblCadastrarApreciador.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastrarApreciador.setBounds(10, 410, 237, 14);
		panel.add(lblCadastrarApreciador);

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
		lblGrogosImg.setBackground(new Color(255, 204, 153));
		lblGrogosImg.setIcon(new ImageIcon("C:\\Users\\leo4_\\Desktop\\gragas.png"));
		lblGrogosImg.setBounds(644, 25, 204, 263);
		panel.add(lblGrogosImg);

		JLabel lblJPossuiPasse = new JLabel("J\u00E1 possui passe de Cervejeiro?  Cadastre-se aqui");
		lblJPossuiPasse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblJPossuiPasse.setBounds(590, 411, 300, 14);
		panel.add(lblJPossuiPasse);

		JButton btnCadastrarCervejeiro = new JButton("Cadastrar");
		btnCadastrarCervejeiro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					TelaCadastroCervejeiro.telaCadastro();
				} catch (Exception e1) {

					e1.printStackTrace();
				}

				frameMain.dispose();

			}
		});
		btnCadastrarCervejeiro.setBounds(708, 436, 131, 23);
		panel.add(btnCadastrarCervejeiro);

		JTextPane txtpnVocUm = new JTextPane();
		txtpnVocUm.setBackground(new Color(244, 164, 96));
		txtpnVocUm.setEditable(false);
		txtpnVocUm.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnVocUm.setText(
				"Voc\u00EA \u00E9 um novo Cervejeiro?\r\nEntre em contato via email \r\npara solicitar\r\nseu Passe Cervejeiro!\r\n\r\nemail: grogosadm@email.com");
		txtpnVocUm.setBounds(644, 256, 217, 128);
		panel.add(txtpnVocUm);

		JLabel lblEfetueSeuLogin = new JLabel("Efetue seu Login");
		lblEfetueSeuLogin.setForeground(new Color(0, 0, 0));
		lblEfetueSeuLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEfetueSeuLogin.setBounds(168, 51, 228, 14);
		panel.add(lblEfetueSeuLogin);

		frameMain.setVisible(true);

	}

	@SuppressWarnings("deprecation")
	private static void efetuarLogin(JLabel lblLoginFail) {
		Apreciador user = new Apreciador();
		ApreciadorBO aprebo = new ApreciadorBO();
		user.setEmail(txtEmail.getText());
		user.setSenha(passwordField.getText());
		
		Cervejeiro usercer = new Cervejeiro();
		CervejeiroBO cerbo = new CervejeiroBO();
		usercer.setEmail(txtEmail.getText());
		usercer.setSenha(passwordField.getText());

		boolean authapre = aprebo.login(user);
		boolean authcerv = cerbo.login(usercer);

		if (authapre == true || authcerv == true) {
			
			
			
			if (authapre == true) {
				Apreciador usera =  (Apreciador) aprebo.findApreciador(user);
				if(usera.getStatus().equals("Desativado")) {
					JOptionPane.showInternalMessageDialog(null, "Conta Desativada. Entre em contato com a administração");
					return;
				}
				try {
					usuarioLogado = aprebo.findApreciador(user);
					TelaPrincipalApreciador.telaPrincipal();
				} catch (Exception e1) {
					e1.printStackTrace();
					lblLoginFail.setText("Erro ao logar, tente novamente");
					return;
				}
				frameMain.dispose();
			}
			if (authcerv == true) {
				
				Cervejeiro usercera =  (Cervejeiro) cerbo.findCervejeiro(usercer);
				if(usercera.getStatus().equals("Desativado")) {
					JOptionPane.showInternalMessageDialog(null, "Conta Desativada. Entre em contato com a administração");
					return;
				}
				try {
					usuarioLogado = cerbo.findCervejeiro(usercer);
					TelaMenuCervejeiro.telaMenuCervejeiro();
				} catch (Exception e1) {
					e1.printStackTrace();
					lblLoginFail.setText("Erro ao logar, tente novamente");
					return;
				}
				frameMain.dispose();
			}
		} else {
			lblLoginFail.setText("Dados inválidos");
		}
	}
}
