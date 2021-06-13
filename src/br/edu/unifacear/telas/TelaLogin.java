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
	public static Object usuarioLogado = new Object();

	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public void telaInicial() throws Exception {

		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(new Color(244, 164, 96));
		frameMain = new JFrame();
		frameMain.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\leo4_\\Desktop\\GrogosPesq.jpg"));
		frameMain.setSize(963, 644);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.setLocation(500, 250);

		frameMain.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnCadastrarApreciador = new JButton("Cadastrar");
		btnCadastrarApreciador.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnCadastrarApreciador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaCadastroApreciador tCadastro = new TelaCadastroApreciador();
					tCadastro.telaCadastro();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frameMain.dispose();
			}

		});

		btnCadastrarApreciador.setBounds(88, 535, 138, 23);
		panel.add(btnCadastrarApreciador);

		JLabel lblLoginFail = new JLabel("");
		lblLoginFail.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginFail.setBounds(105, 267, 213, 36);
		panel.add(lblLoginFail);

		JButton btnLogar = new JButton("Logar");
		btnLogar.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				efetuarLogin(lblLoginFail);
			}
		});
		btnLogar.setBounds(155, 235, 89, 23);
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
		txtEmail.setBounds(115, 159, 175, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblCadastrarApreciador = new JLabel("Novo Apreciador?  Cadastre-se aqui");
		lblCadastrarApreciador.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarApreciador.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastrarApreciador.setBounds(53, 510, 237, 14);
		panel.add(lblCadastrarApreciador);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(56, 162, 46, 14);
		panel.add(lblEmail);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(32, 207, 71, 14);
		panel.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(115, 204, 175, 20);
		panel.add(passwordField);
		
		ImageIcon grogos = new ImageIcon(TelaLogin.class.getResource("/Grogos_Final_Edition.png"));
		JLabel lblGrogosImg = new JLabel(grogos);
		lblGrogosImg.setBackground(new Color(255, 204, 153));
		lblGrogosImg.setBounds(470, 11, 467, 386);
		panel.add(lblGrogosImg);

		JLabel lblJPossuiPasse = new JLabel("J\u00E1 possui passe de Cervejeiro?  Cadastre-se aqui");
		lblJPossuiPasse.setHorizontalAlignment(SwingConstants.CENTER);
		lblJPossuiPasse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblJPossuiPasse.setBounds(609, 510, 300, 14);
		panel.add(lblJPossuiPasse);

		JButton btnCadastrarCervejeiro = new JButton("Cadastrar");
		btnCadastrarCervejeiro.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnCadastrarCervejeiro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					TelaCadastroCervejeiro tCadastro = new TelaCadastroCervejeiro();
					tCadastro.telaCadastro();
				} catch (Exception e1) {

					e1.printStackTrace();
				}

				frameMain.dispose();

			}
		});
		btnCadastrarCervejeiro.setBounds(727, 535, 131, 23);
		panel.add(btnCadastrarCervejeiro);

		JTextPane txtpnVocUm = new JTextPane();
		txtpnVocUm.setBackground(new Color(244, 164, 96));
		txtpnVocUm.setEditable(false);
		txtpnVocUm.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtpnVocUm.setText(
				"Voc\u00EA \u00E9 um novo Cervejeiro?\r\nEntre em contato via email \r\npara solicitar\r\nseu Passe Cervejeiro!\r\n\r\nemail: grogosadm@email.com");
		txtpnVocUm.setBounds(651, 395, 217, 128);
		panel.add(txtpnVocUm);

		JLabel lblEfetueSeuLogin = new JLabel("Efetue seu Login");
		lblEfetueSeuLogin.setForeground(new Color(0, 0, 0));
		lblEfetueSeuLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEfetueSeuLogin.setBounds(115, 108, 227, 23);
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
					TelaPrincipalApreciador tPrincipal = new TelaPrincipalApreciador();
					tPrincipal.telaPrincipal();
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
					TelaMenuCervejeiro telaMenuCervejeiros = new TelaMenuCervejeiro();
					telaMenuCervejeiros.telaMenuCervejeiro();
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
