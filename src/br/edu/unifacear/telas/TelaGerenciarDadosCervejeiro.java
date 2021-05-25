package br.edu.unifacear.telas;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import br.edu.unifacear.bo.CervejaBO;
import br.edu.unifacear.bo.CervejariaBO;
import br.edu.unifacear.bo.CervejeiroBO;
import br.edu.unifacear.bo.EnderecoBO;
import br.edu.unifacear.classes.Cerveja;
import br.edu.unifacear.classes.Cervejeiro;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class TelaGerenciarDadosCervejeiro {
	private static JFrame framePrincipal;
	private static JPasswordField passwordField;
	private static JTextField textFieldEmailAtual;
	private static JTextField textFieldEmailNovo;
	private static JTextField textFieldTelefoneNovo;
	private static JTextField textFieldTelefoneNovoConfirmar;
	private static JPasswordField textFieldSenhaAtual;
	private static JPasswordField textFieldSenhaNova;
	private static JPasswordField textFieldASenhaConfirmar;
	private static JLabel lblMsgErroSenha;
	private static JLabel lblMsgErroTelefone;
	private static JLabel lblMsgErroEmail;
	private static JLabel lblMsgErroSenhaDeletarConta;
	private static JPasswordField passwordFieldTelefone;
	private static JPasswordField passwordFieldEmail;

	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public static void telaGerenciarDadosCervejeiro() throws Exception {
		CervejeiroBO cbo = new CervejeiroBO();
		Cervejeiro cervLogado = (Cervejeiro) TelaLogin.usuarioLogado;
		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(Color.WHITE);
		framePrincipal = new JFrame();
		framePrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\leo4_\\Desktop\\GrogosPesq.jpg"));
		framePrincipal.setSize(971, 772);
		framePrincipal.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		framePrincipal.setLocation(500, 250);
		framePrincipal.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					TelaMenuCervejeiro.telaMenuCervejeiro();
				} catch (Exception e1) {
					// erro ao voltar
					e1.printStackTrace();
					return;
				}
				clearMsg();
				framePrincipal.dispose();
			}
		});
		btnVoltar.setBounds(21, 11, 89, 23);
		panel.add(btnVoltar);

		JLabel lblName = new JLabel("Nome:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(64, 84, 46, 14);
		panel.add(lblName);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(64, 109, 46, 14);
		panel.add(lblEmail);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setBounds(39, 134, 71, 14);
		panel.add(lblTelefone);

		JLabel lblDadosCervejaria = new JLabel("Dados da Cervejaria \r");
		lblDadosCervejaria.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDadosCervejaria.setBounds(51, 191, 160, 14);
		panel.add(lblDadosCervejaria);

		JLabel lblNomeCervejaria = new JLabel("Nome Cervejaria:");
		lblNomeCervejaria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeCervejaria.setBounds(7, 220, 103, 14);
		panel.add(lblNomeCervejaria);

		JLabel lblEmailCervejaria = new JLabel("Email:");
		lblEmailCervejaria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailCervejaria.setBounds(64, 244, 46, 14);
		panel.add(lblEmailCervejaria);

		JLabel lblTelefoneCervejaria = new JLabel("Telefone:");
		lblTelefoneCervejaria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefoneCervejaria.setBounds(39, 269, 71, 14);
		panel.add(lblTelefoneCervejaria);

		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereco.setBounds(39, 294, 71, 14);
		panel.add(lblEndereco);

		JLabel lblCervejariaEndereco = new JLabel("");
		lblCervejariaEndereco.setHorizontalAlignment(SwingConstants.LEFT);
		lblCervejariaEndereco.setBounds(120, 294, 386, 14);
		panel.add(lblCervejariaEndereco);

		JLabel lblCervejariaTelefone = new JLabel("");
		lblCervejariaTelefone.setHorizontalAlignment(SwingConstants.LEFT);
		lblCervejariaTelefone.setBounds(120, 269, 142, 14);
		panel.add(lblCervejariaTelefone);

		JLabel lblCervejariaEmail = new JLabel("");
		lblCervejariaEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblCervejariaEmail.setBounds(120, 244, 142, 14);
		panel.add(lblCervejariaEmail);

		JLabel lblCervejariaNome = new JLabel("");
		lblCervejariaNome.setBounds(120, 220, 142, 14);
		panel.add(lblCervejariaNome);

		JButton btnDadosCervejaria = new JButton("Gerenciar Dados  da Cervejaria");
		btnDadosCervejaria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					TelaGerenciarDadosCervejaria.telaGerenciarDadosCervejaria();
				} catch (Exception e1) {
					// error
					return;

				}
			
				framePrincipal.dispose();
			}
		});
		btnDadosCervejaria.setBounds(39, 342, 272, 23);
		panel.add(btnDadosCervejaria);

		if (cervLogado.getCervejaria() != null) {
			lblCervejariaEmail.setText(cervLogado.getCervejaria().getEmail());
			lblCervejariaNome.setText(cervLogado.getCervejaria().getNome());
			lblCervejariaTelefone.setText(cervLogado.getCervejaria().getTelefone());
			lblCervejariaEndereco.setText(cervLogado.getCervejaria().getEndereco().getNome() + ", "
					+ cervLogado.getCervejaria().getEndereco().getCidade().getNome() + ", "
					+ cervLogado.getCervejaria().getEndereco().getCidade().getEstado().getNome());
			
		} else {
			lblEmailCervejaria.setVisible(false);
			lblNomeCervejaria.setVisible(false);
			lblTelefoneCervejaria.setVisible(false);
			lblEndereco.setVisible(false);
			btnDadosCervejaria.setVisible(false);
			lblDadosCervejaria.setText("");
		}

		JLabel lblCervejeiroNome = new JLabel("");
		lblCervejeiroNome.setBounds(120, 84, 142, 14);
		panel.add(lblCervejeiroNome);
		lblCervejeiroNome.setText(cervLogado.getNome());

		JLabel lblCervejeiroEmail = new JLabel("");
		lblCervejeiroEmail.setBounds(120, 109, 142, 14);
		panel.add(lblCervejeiroEmail);
		lblCervejeiroEmail.setText(cervLogado.getEmail());

		JLabel lblCervejeiroTelefone = new JLabel("");
		lblCervejeiroTelefone.setBounds(120, 134, 142, 14);
		panel.add(lblCervejeiroTelefone);
		lblCervejeiroTelefone.setText(cervLogado.getTelefone());

		JLabel lblDeletarConta = new JLabel("Voc\u00EA deseja deletar sua conta?");
		lblDeletarConta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDeletarConta.setBounds(51, 490, 279, 14);
		panel.add(lblDeletarConta);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(39, 515, 46, 14);
		panel.add(lblSenha);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (!passwordField.getText().equals(cervLogado.getSenha())) {
					lblMsgErroSenhaDeletarConta.setForeground(Color.RED);
					lblMsgErroSenhaDeletarConta.setText("Senha incorreta");
					return;
				}
				
				int confirmar = JOptionPane.showConfirmDialog(null,
						"Ao DELETAR sua conta, Você tambem DELETA todas as cervejas cadastradas no sistema. Deseja continuar mesmo assim?",
						null, 0);
				if (confirmar == 0) {
					EnderecoBO enderecobo = new EnderecoBO();
					CervejariaBO cervejariabo = new CervejariaBO();
					CervejaBO cervejabo = new CervejaBO();
			
				

					try {
						if (cervLogado.getCervejaria() != null) {
							List<Cerveja> cervejas = cervejabo.findByUser(cervLogado);
		
							if (cervejas == null) {
								cbo.deletar(cervLogado);
								cervejariabo.deletar(cervLogado.getCervejaria());
								enderecobo.deletar(cervLogado.getCervejaria().getEndereco());
								framePrincipal.dispose();
								TelaLogin.telaInicial();
							} else {
								for (Cerveja c : cervejas) {
									cervejabo.deletar(c);
									
								}
								cbo.deletar(cervLogado);
								cervejariabo.deletar(cervLogado.getCervejaria());
								enderecobo.deletar(cervLogado.getCervejaria().getEndereco());
								framePrincipal.dispose();
								TelaLogin.telaInicial();
							}

						} else {
							List<Cerveja> cervejas = cervejabo.findByUser(cervLogado);
							if (cervejas == null) {
								cbo.deletar(cervLogado);
								framePrincipal.dispose();
								TelaLogin.telaInicial();
							}else {
								for (Cerveja c : cervejas) {
									cervejabo.deletar(c);
								}
								cbo.deletar(cervLogado);
								framePrincipal.dispose();
								TelaLogin.telaInicial();
							}
						}

					} catch (Exception e1) {
						lblMsgErroSenhaDeletarConta.setText("Erro ao Deletar sua Conta");
						return;
					}
				}else {
					lblMsgErroSenhaDeletarConta.setText("Erro ao Deletar sua Conta");
					return;
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				clearMsg();
			}
		});
		btnDeletar.setBounds(122, 544, 89, 23);
		panel.add(btnDeletar);

		passwordField = new JPasswordField();
		passwordField.setBounds(86, 515, 160, 20);
		panel.add(passwordField);

		JLabel lblVocDesejaAlterar = new JLabel("Voc\u00EA deseja alterar seu email?");
		lblVocDesejaAlterar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVocDesejaAlterar.setBounds(666, 44, 279, 14);
		panel.add(lblVocDesejaAlterar);

		JLabel lblEmailAlterar = new JLabel("Email Atual:");
		lblEmailAlterar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailAlterar.setBounds(546, 81, 134, 14);
		panel.add(lblEmailAlterar);

		textFieldEmailAtual = new JTextField();
		textFieldEmailAtual.setToolTipText("email");
		textFieldEmailAtual.setForeground(Color.BLACK);
		textFieldEmailAtual.setColumns(10);
		textFieldEmailAtual.setBackground(Color.WHITE);
		textFieldEmailAtual.setBounds(698, 78, 175, 20);
		panel.add(textFieldEmailAtual);

		JLabel lblNovoEmail = new JLabel("Novo Email:");
		lblNovoEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNovoEmail.setBounds(591, 106, 89, 14);
		panel.add(lblNovoEmail);

		textFieldEmailNovo = new JTextField();
		textFieldEmailNovo.setToolTipText("email");
		textFieldEmailNovo.setForeground(Color.BLACK);
		textFieldEmailNovo.setColumns(10);
		textFieldEmailNovo.setBackground(Color.WHITE);
		textFieldEmailNovo.setBounds(698, 103, 175, 20);
		panel.add(textFieldEmailNovo);
		
		lblMsgErroEmail = new JLabel("");
		lblMsgErroEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsgErroEmail.setBounds(641, 198, 265, 14);
		panel.add(lblMsgErroEmail);

		JButton btnEmailAlterar = new JButton("Alterar Email");
		btnEmailAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
				String emaillogado = ((Cervejeiro) TelaLogin.usuarioLogado).getEmail();

				if (textFieldEmailAtual.getText().equalsIgnoreCase(emaillogado)) {
					
					if(!passwordFieldEmail.getText().equals(cervLogado.getSenha())) {
						lblMsgErroEmail.setForeground(Color.RED);
						lblMsgErroEmail.setText("Senha incorreta");
						return;
					}
					
					
					if (!textFieldEmailNovo.getText().matches(regexEmail)) {
						lblMsgErroEmail.setForeground(Color.RED);
						lblMsgErroEmail.setText("Dados Invalidos");
						return;
					}

					Cervejeiro cervejeiro = new Cervejeiro();
					cervejeiro.setEmail(textFieldEmailAtual.getText());

					Cervejeiro novocerv = (Cervejeiro) cbo.findCervejeiro(cervejeiro);

					novocerv.setEmail(textFieldEmailNovo.getText());
					try {
						cbo.alterar(novocerv);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					((Cervejeiro) TelaLogin.usuarioLogado).setEmail(textFieldEmailNovo.getText());
					lblMsgErroEmail.setForeground(Color.GREEN);
					lblMsgErroEmail.setText("Email Alterado com Sucesso!");
					lblCervejeiroEmail.setText(textFieldEmailNovo.getText());
				} else {
					lblMsgErroEmail.setForeground(Color.RED);
					lblMsgErroEmail.setText("Dados Invalidos");
					return;
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				clearMsg();
			}
		});
		btnEmailAlterar.setBounds(710, 164, 153, 23);
		panel.add(btnEmailAlterar);

		JLabel lblAlterarTelefone = new JLabel("Voc\u00EA deseja alterar seu Telefone?");
		lblAlterarTelefone.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAlterarTelefone.setBounds(666, 236, 279, 14);
		panel.add(lblAlterarTelefone);

		textFieldTelefoneNovo = new JTextField();
		textFieldTelefoneNovo.setToolTipText("email");
		textFieldTelefoneNovo.setForeground(Color.BLACK);
		textFieldTelefoneNovo.setColumns(10);
		textFieldTelefoneNovo.setBackground(Color.WHITE);
		textFieldTelefoneNovo.setBounds(698, 270, 175, 20);
		panel.add(textFieldTelefoneNovo);

		JLabel lblNovoTelefone = new JLabel("Novo Telefone:");
		lblNovoTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNovoTelefone.setBounds(546, 273, 134, 14);
		panel.add(lblNovoTelefone);

		JLabel lblConfirmarTelefone = new JLabel("Confirmar novo Telefone:");
		lblConfirmarTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmarTelefone.setBounds(482, 304, 198, 14);
		panel.add(lblConfirmarTelefone);

		textFieldTelefoneNovoConfirmar = new JTextField();
		textFieldTelefoneNovoConfirmar.setToolTipText("telefone");
		textFieldTelefoneNovoConfirmar.setForeground(Color.BLACK);
		textFieldTelefoneNovoConfirmar.setColumns(10);
		textFieldTelefoneNovoConfirmar.setBackground(Color.WHITE);
		textFieldTelefoneNovoConfirmar.setBounds(698, 301, 175, 20);
		panel.add(textFieldTelefoneNovoConfirmar);
		
		lblMsgErroTelefone = new JLabel("");
		lblMsgErroTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsgErroTelefone.setBounds(618, 396, 327, 14);
		panel.add(lblMsgErroTelefone);

		JButton btnTelefoneAlterar = new JButton("Alterar Telefone");
		btnTelefoneAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String regexN = "[0-9]+";
				if(!passwordFieldTelefone.getText().equals(cervLogado.getSenha())) {
					lblMsgErroTelefone.setForeground(Color.RED);
					lblMsgErroTelefone.setText("Senha incorreta");
					return;
				}
				if (!textFieldTelefoneNovo.getText().matches(regexN)
						&& !textFieldTelefoneNovoConfirmar.getText().matches(regexN)) {
					lblMsgErroTelefone.setForeground(Color.RED);
					lblMsgErroTelefone.setText("Telefones só podem conter números");
					return;
				}

				if (!textFieldTelefoneNovo.getText().equals(textFieldTelefoneNovoConfirmar.getText())) {
					lblMsgErroTelefone.setForeground(Color.RED);
					lblMsgErroTelefone.setText("Telefones devem ser iguais");
					return;
				}
				Cervejeiro cervejeiro = cervLogado;
				cervejeiro.setTelefone(textFieldTelefoneNovo.getText());
				try {
					cbo.alterar(cervejeiro);
				} catch (Exception e1) {
					lblMsgErroTelefone.setForeground(Color.RED);
					lblMsgErroTelefone.setText("Erro ao Alterar Telefone");
					return;
				}
				cervLogado.setTelefone(textFieldTelefoneNovo.getText());
				lblMsgErroTelefone.setForeground(Color.GREEN);
				lblMsgErroTelefone.setText("Telefone Alterado com Sucesso!");
				lblCervejeiroTelefone.setText(cervLogado.getTelefone());

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				clearMsg();
			}
		});
		btnTelefoneAlterar.setBounds(708, 362, 153, 23);
		panel.add(btnTelefoneAlterar);

		JLabel lblAlterarSenha = new JLabel("Voc\u00EA deseja alterar sua Senha?");
		lblAlterarSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAlterarSenha.setBounds(666, 421, 279, 14);
		panel.add(lblAlterarSenha);

		JLabel lblSenhaAtual = new JLabel("Senha atual:");
		lblSenhaAtual.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenhaAtual.setBounds(577, 464, 103, 14);
		panel.add(lblSenhaAtual);

		textFieldSenhaAtual = new JPasswordField();
		textFieldSenhaAtual.setToolTipText("email");
		textFieldSenhaAtual.setForeground(Color.BLACK);
		textFieldSenhaAtual.setColumns(10);
		textFieldSenhaAtual.setBackground(Color.WHITE);
		textFieldSenhaAtual.setBounds(698, 461, 175, 20);
		panel.add(textFieldSenhaAtual);

		textFieldSenhaNova = new JPasswordField();
		textFieldSenhaNova.setToolTipText("email");
		textFieldSenhaNova.setForeground(Color.BLACK);
		textFieldSenhaNova.setColumns(10);
		textFieldSenhaNova.setBackground(Color.WHITE);
		textFieldSenhaNova.setBounds(698, 492, 175, 20);
		panel.add(textFieldSenhaNova);

		JLabel lblNovaSenha = new JLabel("Nova Senha:");
		lblNovaSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNovaSenha.setBounds(546, 495, 134, 14);
		panel.add(lblNovaSenha);
		
		lblMsgErroSenha = new JLabel("");
		lblMsgErroSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsgErroSenha.setBounds(546, 587, 327, 14);
		panel.add(lblMsgErroSenha);

		JButton btnAlterarSenha = new JButton("Alterar Senha");
		btnAlterarSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!textFieldSenhaAtual.getText().equals(cervLogado.getSenha())) {
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

				cervLogado.setSenha(textFieldSenhaNova.getText());
				try {
					cbo.alterar(cervLogado);
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

			@Override
			public void mouseEntered(MouseEvent e) {
				clearMsg();
			}
		});
		btnAlterarSenha.setBounds(708, 554, 153, 23);
		panel.add(btnAlterarSenha);

		textFieldASenhaConfirmar = new JPasswordField();
		textFieldASenhaConfirmar.setToolTipText("email");
		textFieldASenhaConfirmar.setForeground(Color.BLACK);
		textFieldASenhaConfirmar.setColumns(10);
		textFieldASenhaConfirmar.setBackground(Color.WHITE);
		textFieldASenhaConfirmar.setBounds(698, 523, 175, 20);
		panel.add(textFieldASenhaConfirmar);

		JLabel lblConfirmarNovaSenha = new JLabel("Confirmar nova Senha:");
		lblConfirmarNovaSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmarNovaSenha.setBounds(546, 526, 134, 14);
		panel.add(lblConfirmarNovaSenha);
		
		lblMsgErroSenhaDeletarConta = new JLabel("");
		lblMsgErroSenhaDeletarConta.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsgErroSenhaDeletarConta.setBounds(22, 578, 327, 14);
		panel.add(lblMsgErroSenhaDeletarConta);
		
		JLabel lblSenhaAtualTelefone = new JLabel("Senha atual:");
		lblSenhaAtualTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenhaAtualTelefone.setBounds(577, 336, 103, 14);
		panel.add(lblSenhaAtualTelefone);
		
		passwordFieldTelefone = new JPasswordField();
		passwordFieldTelefone.setToolTipText("email");
		passwordFieldTelefone.setForeground(Color.BLACK);
		passwordFieldTelefone.setColumns(10);
		passwordFieldTelefone.setBackground(Color.WHITE);
		passwordFieldTelefone.setBounds(698, 333, 175, 20);
		panel.add(passwordFieldTelefone);
		
		JLabel lblSenhaAtualEmail = new JLabel("Senha atual:");
		lblSenhaAtualEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenhaAtualEmail.setBounds(577, 136, 103, 14);
		panel.add(lblSenhaAtualEmail);
		
		passwordFieldEmail = new JPasswordField();
		passwordFieldEmail.setToolTipText("email");
		passwordFieldEmail.setForeground(Color.BLACK);
		passwordFieldEmail.setColumns(10);
		passwordFieldEmail.setBackground(Color.WHITE);
		passwordFieldEmail.setBounds(698, 133, 175, 20);
		panel.add(passwordFieldEmail);

		framePrincipal.setVisible(true);

	}

	private static void clearMsg() {
		lblMsgErroTelefone.setText("");
		lblMsgErroEmail.setText("");
		lblMsgErroSenha.setText("");
		lblMsgErroSenhaDeletarConta.setText("");
	}
}
