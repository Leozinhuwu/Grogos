package br.edu.unifacear.telas;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.edu.unifacear.bo.ApreciadorBO;
import br.edu.unifacear.classes.Apreciador;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaGerenciarDadosApreciador {
	private static JFrame framePrincipal;
	private static JTextField textFieldEmailAtual;
	private static JTextField textFieldEmailNovo;
	private static JPasswordField passwordFieldEmail;
	private static JPasswordField textFieldSenhaAtual;
	private static JPasswordField textFieldSenhaNova;
	private static JPasswordField textFieldASenhaConfirmar;
	private static JPasswordField passwordField;
	private static JLabel lblMsgErroEmail;
	private static JLabel lblMsgErroSenha;
	private static JLabel lblMsgErroSenhaDeletarConta;

	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public static void telaGerenciarDadosApreciador() throws Exception {

		Apreciador apreLogado = (Apreciador) TelaLogin.usuarioLogado;
		ApreciadorBO abo = new ApreciadorBO();

		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(Color.WHITE);
		framePrincipal = new JFrame();
		framePrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\leo4_\\Desktop\\GrogosPesq.jpg"));
		framePrincipal.setSize(971, 772);
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrincipal.setLocation(500, 250);

		framePrincipal.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					TelaPrincipalApreciador.telaPrincipal();
				} catch (Exception e1) {
					// erro ao voltar
					e1.printStackTrace();
					return;
				}
				framePrincipal.dispose();
			}
		});
		btnVoltar.setBounds(21, 11, 89, 23);
		panel.add(btnVoltar);

		JLabel lblBemVindo = new JLabel("Bem vindo " + apreLogado.getNome());
		lblBemVindo.setBounds(31, 59, 323, 14);
		panel.add(lblBemVindo);

		JLabel lblVocDesejaAlterar = new JLabel("Voc\u00EA deseja alterar seu email?");
		lblVocDesejaAlterar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVocDesejaAlterar.setBounds(120, 229, 279, 14);
		panel.add(lblVocDesejaAlterar);

		JLabel lblEmailAlterar = new JLabel("Email Atual:");
		lblEmailAlterar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailAlterar.setBounds(0, 266, 134, 14);
		panel.add(lblEmailAlterar);

		textFieldEmailAtual = new JTextField();
		textFieldEmailAtual.setToolTipText("email");
		textFieldEmailAtual.setForeground(Color.BLACK);
		textFieldEmailAtual.setColumns(10);
		textFieldEmailAtual.setBackground(Color.WHITE);
		textFieldEmailAtual.setBounds(152, 263, 175, 20);
		panel.add(textFieldEmailAtual);

		JLabel lblNovoEmail = new JLabel("Novo Email:");
		lblNovoEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNovoEmail.setBounds(45, 291, 89, 14);
		panel.add(lblNovoEmail);

		textFieldEmailNovo = new JTextField();
		textFieldEmailNovo.setToolTipText("email");
		textFieldEmailNovo.setForeground(Color.BLACK);
		textFieldEmailNovo.setColumns(10);
		textFieldEmailNovo.setBackground(Color.WHITE);
		textFieldEmailNovo.setBounds(152, 288, 175, 20);
		panel.add(textFieldEmailNovo);

		JLabel lblSenhaAtualEmail = new JLabel("Senha atual:");
		lblSenhaAtualEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenhaAtualEmail.setBounds(31, 321, 103, 14);
		panel.add(lblSenhaAtualEmail);

		passwordFieldEmail = new JPasswordField();
		passwordFieldEmail.setToolTipText("email");
		passwordFieldEmail.setForeground(Color.BLACK);
		passwordFieldEmail.setColumns(10);
		passwordFieldEmail.setBackground(Color.WHITE);
		passwordFieldEmail.setBounds(152, 318, 175, 20);
		panel.add(passwordFieldEmail);

		JLabel lblApreciadorEmail = new JLabel(apreLogado.getEmail());
		lblApreciadorEmail.setBounds(77, 151, 142, 14);
		panel.add(lblApreciadorEmail);

		JButton btnEmailAlterar = new JButton("Alterar Email");
		btnEmailAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocarEmail(apreLogado, abo, lblApreciadorEmail);

			}
		});
		btnEmailAlterar.setBounds(164, 349, 153, 23);
		panel.add(btnEmailAlterar);

		JLabel lblSenhaAtual = new JLabel("Senha atual:");
		lblSenhaAtual.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenhaAtual.setBounds(41, 457, 103, 14);
		panel.add(lblSenhaAtual);

		textFieldSenhaAtual = new JPasswordField();
		textFieldSenhaAtual.setToolTipText("email");
		textFieldSenhaAtual.setForeground(Color.BLACK);
		textFieldSenhaAtual.setColumns(10);
		textFieldSenhaAtual.setBackground(Color.WHITE);
		textFieldSenhaAtual.setBounds(162, 454, 175, 20);
		panel.add(textFieldSenhaAtual);

		JLabel lblNovaSenha = new JLabel("Nova Senha:");
		lblNovaSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNovaSenha.setBounds(10, 488, 134, 14);
		panel.add(lblNovaSenha);

		textFieldSenhaNova = new JPasswordField();
		textFieldSenhaNova.setToolTipText("email");
		textFieldSenhaNova.setForeground(Color.BLACK);
		textFieldSenhaNova.setColumns(10);
		textFieldSenhaNova.setBackground(Color.WHITE);
		textFieldSenhaNova.setBounds(162, 485, 175, 20);
		panel.add(textFieldSenhaNova);

		JLabel lblConfirmarNovaSenha = new JLabel("Confirmar nova Senha:");
		lblConfirmarNovaSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmarNovaSenha.setBounds(10, 519, 134, 14);
		panel.add(lblConfirmarNovaSenha);

		textFieldASenhaConfirmar = new JPasswordField();
		textFieldASenhaConfirmar.setToolTipText("email");
		textFieldASenhaConfirmar.setForeground(Color.BLACK);
		textFieldASenhaConfirmar.setColumns(10);
		textFieldASenhaConfirmar.setBackground(Color.WHITE);
		textFieldASenhaConfirmar.setBounds(162, 516, 175, 20);
		panel.add(textFieldASenhaConfirmar);

		JButton btnAlterarSenha = new JButton("Alterar Senha");
		btnAlterarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarSenha(apreLogado, abo);
			}
		});
		btnAlterarSenha.setBounds(172, 547, 153, 23);
		panel.add(btnAlterarSenha);

		JButton btnDesativar = new JButton("Desativar");
		btnDesativar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletarConta(apreLogado, abo);
			}
		});
		btnDesativar.setBounds(737, 699, 89, 23);
		panel.add(btnDesativar);

		passwordField = new JPasswordField();
		passwordField.setBounds(701, 670, 160, 20);
		panel.add(passwordField);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(654, 670, 46, 14);
		panel.add(lblSenha);

		JLabel lblDesativarConta = new JLabel("Voc\u00EA deseja Desativar sua conta?");
		lblDesativarConta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDesativarConta.setBounds(666, 645, 279, 14);
		panel.add(lblDesativarConta);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(21, 151, 46, 14);
		panel.add(lblEmail);

		JLabel lblName = new JLabel("Nome:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(21, 126, 46, 14);
		panel.add(lblName);

		JLabel lblApreciadorNome = new JLabel(apreLogado.getNome());
		lblApreciadorNome.setBounds(77, 126, 142, 14);
		panel.add(lblApreciadorNome);

		JLabel lblGerenciarSeusDados = new JLabel("Gerenciar seus Dados!");
		lblGerenciarSeusDados.setForeground(new Color(255, 102, 51));
		lblGerenciarSeusDados.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGerenciarSeusDados.setBounds(332, 11, 228, 14);
		panel.add(lblGerenciarSeusDados);

		lblMsgErroSenhaDeletarConta = new JLabel("");
		lblMsgErroSenhaDeletarConta.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsgErroSenhaDeletarConta.setBounds(39, 708, 327, 14);
		panel.add(lblMsgErroSenhaDeletarConta);

		lblMsgErroSenha = new JLabel("");
		lblMsgErroSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsgErroSenha.setBounds(27, 580, 327, 14);
		panel.add(lblMsgErroSenha);

		lblMsgErroEmail = new JLabel("");
		lblMsgErroEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsgErroEmail.setBounds(101, 383, 265, 14);
		panel.add(lblMsgErroEmail);
		
		JLabel lblVocDesejaAlterar_2 = new JLabel("Voc\u00EA deseja alterar sua Senha?");
		lblVocDesejaAlterar_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVocDesejaAlterar_2.setBounds(120, 409, 279, 14);
		panel.add(lblVocDesejaAlterar_2);
		
		JLabel lblGrogosImg = new JLabel("");
		lblGrogosImg.setIcon(new ImageIcon("C:\\Users\\leo4_\\Desktop\\GrogosPesq.jpg"));
		lblGrogosImg.setBounds(313, 142, 632, 452);
		panel.add(lblGrogosImg);

		framePrincipal.setVisible(true);

	}

	@SuppressWarnings("deprecation")
	private static void trocarEmail(Apreciador apreLogado, ApreciadorBO abo, JLabel lblApreciadorEmail) {
		String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
		String emaillogado = ((Apreciador) TelaLogin.usuarioLogado).getEmail();

		if (textFieldEmailAtual.getText().equalsIgnoreCase(emaillogado)) {

			if (!passwordFieldEmail.getText().equals(apreLogado.getSenha())) {
				lblMsgErroEmail.setForeground(Color.RED);
				lblMsgErroEmail.setText("Senha incorreta");
				return;
			}

			if (!textFieldEmailNovo.getText().matches(regexEmail)) {
				lblMsgErroEmail.setForeground(Color.RED);
				lblMsgErroEmail.setText("Dados Invalidos");
				return;
			}

			if (abo.autenticarEmail(textFieldEmailNovo.getText())) {
				lblMsgErroEmail.setForeground(Color.RED);
				lblMsgErroEmail.setText("Novo email inválido");
				return;
			}

			Apreciador apreciador = new Apreciador();
			apreciador.setEmail(textFieldEmailAtual.getText());

			Apreciador novoapre = (Apreciador) abo.findApreciador(apreciador);

			novoapre.setEmail(textFieldEmailNovo.getText());

			try {
				abo.alterar(novoapre);
			} catch (Exception e1) {
				lblMsgErroEmail.setForeground(Color.RED);
				lblMsgErroEmail.setText("Erro ao alterar email");
				
				e1.printStackTrace();
				return;
			}


			((Apreciador) TelaLogin.usuarioLogado).setEmail(textFieldEmailNovo.getText());
			lblMsgErroEmail.setForeground(Color.GREEN);
			lblMsgErroEmail.setText("Email Alterado com Sucesso!");
			lblApreciadorEmail.setText(textFieldEmailNovo.getText());

		} else {
			lblMsgErroEmail.setForeground(Color.RED);
			lblMsgErroEmail.setText("Dados Invalidos");
			return;
		}
	}

	@SuppressWarnings("deprecation")
	private static void alterarSenha(Apreciador apreLogado, ApreciadorBO abo) {
		if (!textFieldSenhaAtual.getText().equals(apreLogado.getSenha())) {
			lblMsgErroSenha.setForeground(Color.RED);
			lblMsgErroSenha.setText("Senha incorreta");
			return;
		}

		if (textFieldSenhaNova.getText().length() < 6) {
			lblMsgErroSenha.setForeground(Color.RED);
			lblMsgErroSenha.setText("Senha deve conter no minimo 6 caracteries");
			return;
		}

		if (!textFieldSenhaNova.getText().equals(textFieldASenhaConfirmar.getText())) {
			lblMsgErroSenha.setForeground(Color.RED);
			lblMsgErroSenha.setText("Erro ao confirmar nova senha");
			return;
		}

		apreLogado.setSenha(textFieldSenhaNova.getText());
		try {
			abo.alterar(apreLogado);
		} catch (Exception e1) {
			lblMsgErroSenha.setForeground(Color.RED);
			lblMsgErroSenha.setText("Erro ao Alterar senha");
			return;
		}

		lblMsgErroSenha.setForeground(Color.GREEN);
		lblMsgErroSenha.setText("Senha Alterada com Sucesso!");
		textFieldSenhaNova.setText("");
		textFieldASenhaConfirmar.setText("");
		textFieldSenhaAtual.setText("");
	}

	@SuppressWarnings("deprecation")
	private static void deletarConta(Apreciador apreLogado, ApreciadorBO abo) {
		if (!passwordField.getText().equals(apreLogado.getSenha())) {
			lblMsgErroSenhaDeletarConta.setForeground(Color.RED);
			lblMsgErroSenhaDeletarConta.setText("Senha incorreta");
			return;
		}
		
		int confirmar = JOptionPane.showConfirmDialog(null,
				"Ao Desativar sua conta, Você perde o acesso ao sistema com este Email. Deseja continuar mesmo assim?",
				null, 0);
		if (confirmar == 0) {
			try {
				apreLogado.setStatus("Desativado");
				abo.alterar(apreLogado);
			} catch (Exception e1) {
				lblMsgErroSenha.setForeground(Color.RED);
				lblMsgErroSenha.setText("Erro ao Desativar Conta");
				
				e1.printStackTrace();
				return;
			}
			
			try {
				TelaLogin.telaInicial();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			framePrincipal.dispose();
			
		}else {
			return;
		}
	}
}
