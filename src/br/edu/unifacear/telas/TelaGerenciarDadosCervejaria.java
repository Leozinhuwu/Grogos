package br.edu.unifacear.telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import br.edu.unifacear.bo.CervejariaBO;
import br.edu.unifacear.bo.CidadeBO;
import br.edu.unifacear.bo.EnderecoBO;
import br.edu.unifacear.bo.EstadoBO;
import br.edu.unifacear.classes.Cervejaria;
import br.edu.unifacear.classes.Cervejeiro;
import br.edu.unifacear.classes.Cidade;
import br.edu.unifacear.classes.Endereco;
import br.edu.unifacear.classes.Estado;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class TelaGerenciarDadosCervejaria {
	private static JFrame framePrincipal;
	public static String usuarioLogado;
	private static JTextField textFieldEmailAtual;
	private static JTextField textFieldEmailNovo;
	private static JLabel lblMsgErroEmail = new JLabel("");
	private static JTextField textFieldTelefoneNovoConfirmar;
	private static JTextField textFieldTelefoneNovo;
	private static JLabel lblMsgErroTelefone = new JLabel("");
	private static JPasswordField passwordFieldEmail;
	private static JPasswordField passwordFieldTelefone;
	private static JTextField textFieldEndereco;
	private static JPasswordField passwordFieldEndereco;
	private static JLabel lblMsgErroEndereco;

	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public void telaGerenciarDadosCervejaria() throws Exception {
		Cervejeiro cervLogado = (Cervejeiro) TelaLogin.usuarioLogado;
		CervejariaBO cbo = new CervejariaBO();
		CidadeBO cidadebo = new CidadeBO();
		EstadoBO estadobo = new EstadoBO();

		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(new Color(244, 164, 96));
		framePrincipal = new JFrame();
		framePrincipal.setSize(971, 772);
		framePrincipal.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		framePrincipal.setLocation(500, 150);

		framePrincipal.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					TelaGerenciarDadosCervejeiro tgDadosCervejeiro = new TelaGerenciarDadosCervejeiro();
					tgDadosCervejeiro.telaGerenciarDadosCervejeiro();
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

		JLabel lblDadosCervejaria = new JLabel("Dados da Cervejaria \r");
		lblDadosCervejaria.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDadosCervejaria.setBounds(65, 70, 160, 14);
		panel.add(lblDadosCervejaria);

		JLabel lblNomeCervejaria = new JLabel("Nome Cervejaria:");
		lblNomeCervejaria.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNomeCervejaria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeCervejaria.setBounds(21, 99, 103, 14);
		panel.add(lblNomeCervejaria);

		JLabel lblEmailCervejaria = new JLabel("Email:");
		lblEmailCervejaria.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmailCervejaria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailCervejaria.setBounds(78, 123, 46, 14);
		panel.add(lblEmailCervejaria);

		JLabel lblTelefoneCervejaria = new JLabel("Telefone:");
		lblTelefoneCervejaria.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefoneCervejaria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefoneCervejaria.setBounds(53, 148, 71, 14);
		panel.add(lblTelefoneCervejaria);

		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereco.setBounds(53, 173, 71, 14);
		panel.add(lblEndereco);

		JLabel lblCidade = new JLabel("");
		lblCidade.setHorizontalAlignment(SwingConstants.LEFT);
		lblCidade.setBounds(134, 196, 103, 14);
		panel.add(lblCidade);

		JLabel lblEstado = new JLabel("");
		lblEstado.setHorizontalAlignment(SwingConstants.LEFT);
		lblEstado.setBounds(241, 196, 103, 14);
		panel.add(lblEstado);

		JLabel lblCervejariaNome = new JLabel("");
		lblCervejariaNome.setBounds(134, 99, 142, 14);
		panel.add(lblCervejariaNome);

		JLabel lblCervejariaEmail = new JLabel("");
		lblCervejariaEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblCervejariaEmail.setBounds(134, 123, 142, 14);
		panel.add(lblCervejariaEmail);

		JLabel lblCervejariaTelefone = new JLabel("");
		lblCervejariaTelefone.setHorizontalAlignment(SwingConstants.LEFT);
		lblCervejariaTelefone.setBounds(134, 148, 142, 14);
		panel.add(lblCervejariaTelefone);

		JLabel lblCervejariaEndereco = new JLabel("");
		lblCervejariaEndereco.setHorizontalAlignment(SwingConstants.LEFT);
		lblCervejariaEndereco.setBounds(134, 173, 433, 14);
		panel.add(lblCervejariaEndereco);

		lblCervejariaEmail.setText(cervLogado.getCervejaria().getEmail());
		lblCervejariaNome.setText(cervLogado.getCervejaria().getNome());
		lblCervejariaTelefone.setText(cervLogado.getCervejaria().getTelefone());
		lblCervejariaEndereco.setText(cervLogado.getCervejaria().getEndereco().getNome() + ", "
				+ cervLogado.getCervejaria().getEndereco().getCidade().getNome() + ", "
				+ cervLogado.getCervejaria().getEndereco().getCidade().getEstado().getNome());

		JLabel lblDesejaAlterarEmail = new JLabel("Deseja alterar email da Cervejaria?");
		lblDesejaAlterarEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDesejaAlterarEmail.setBounds(90, 284, 279, 14);
		panel.add(lblDesejaAlterarEmail);

		JLabel lblEmailAlterar = new JLabel("Email Atual:");
		lblEmailAlterar.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblEmailAlterar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailAlterar.setBounds(10, 321, 134, 14);
		panel.add(lblEmailAlterar);

		JLabel lblNovoEmail = new JLabel("Novo Email:");
		lblNovoEmail.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNovoEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNovoEmail.setBounds(55, 352, 89, 14);
		panel.add(lblNovoEmail);

		JComboBox<Cidade> comboBoxCidade = new JComboBox<Cidade>();
		comboBoxCidade.setBounds(154, 569, 175, 22);
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
		comboBoxEstado.setBounds(154, 540, 175, 22);
		panel.add(comboBoxEstado);

		for (Estado e : estadobo.estados()) {
			comboBoxEstado.addItem(e);

		}

		textFieldEmailAtual = new JTextField();
		textFieldEmailAtual.setToolTipText("email");
		textFieldEmailAtual.setForeground(Color.BLACK);
		textFieldEmailAtual.setColumns(10);
		textFieldEmailAtual.setBackground(Color.WHITE);
		textFieldEmailAtual.setBounds(162, 318, 175, 20);
		panel.add(textFieldEmailAtual);

		textFieldEmailNovo = new JTextField();
		textFieldEmailNovo.setToolTipText("email");
		textFieldEmailNovo.setForeground(Color.BLACK);
		textFieldEmailNovo.setColumns(10);
		textFieldEmailNovo.setBackground(Color.WHITE);
		textFieldEmailNovo.setBounds(162, 349, 175, 20);
		panel.add(textFieldEmailNovo);

		JButton btnEmailAlterar = new JButton("Alterar Email");
		btnEmailAlterar.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnEmailAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alterarEmail(cervLogado, cbo, lblCervejariaEmail);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				clearMsg();
			}
		});
		btnEmailAlterar.setBounds(172, 414, 153, 23);
		panel.add(btnEmailAlterar);
		lblMsgErroEmail.setHorizontalAlignment(SwingConstants.CENTER);

		lblMsgErroEmail.setBounds(162, 448, 175, 14);
		panel.add(lblMsgErroEmail);

		lblMsgErroTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsgErroTelefone.setBounds(620, 448, 259, 14);
		panel.add(lblMsgErroTelefone);

		JButton btnTelefoneAlterar = new JButton("Alterar Telefone");
		btnTelefoneAlterar.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnTelefoneAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alterarTelefone(cervLogado, cbo, lblCervejariaTelefone);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				clearMsg();
			}
		});
		btnTelefoneAlterar.setBounds(676, 417, 153, 23);
		panel.add(btnTelefoneAlterar);

		textFieldTelefoneNovoConfirmar = new JTextField();
		textFieldTelefoneNovoConfirmar.setToolTipText("Telefone");
		textFieldTelefoneNovoConfirmar.setForeground(Color.BLACK);
		textFieldTelefoneNovoConfirmar.setColumns(10);
		textFieldTelefoneNovoConfirmar.setBackground(Color.WHITE);
		textFieldTelefoneNovoConfirmar.setBounds(666, 352, 175, 20);
		panel.add(textFieldTelefoneNovoConfirmar);

		JLabel lblConfirmarTelefone = new JLabel("Confirmar novo Telefone:");
		lblConfirmarTelefone.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblConfirmarTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmarTelefone.setBounds(450, 355, 198, 14);
		panel.add(lblConfirmarTelefone);

		JLabel lblNovoTelefone = new JLabel("Novo Telefone:");
		lblNovoTelefone.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNovoTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNovoTelefone.setBounds(514, 324, 134, 14);
		panel.add(lblNovoTelefone);

		textFieldTelefoneNovo = new JTextField();
		textFieldTelefoneNovo.setToolTipText("Telefone");
		textFieldTelefoneNovo.setForeground(Color.BLACK);
		textFieldTelefoneNovo.setColumns(10);
		textFieldTelefoneNovo.setBackground(Color.WHITE);
		textFieldTelefoneNovo.setBounds(666, 321, 175, 20);
		panel.add(textFieldTelefoneNovo);

		JLabel lblDesejaAlterarTelefone = new JLabel("Deseja alterar o Telefone da Cervejaria?");
		lblDesejaAlterarTelefone.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDesejaAlterarTelefone.setBounds(634, 284, 279, 14);
		panel.add(lblDesejaAlterarTelefone);

		JLabel lblSenhaAtualEmail = new JLabel("Senha atual:");
		lblSenhaAtualEmail.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblSenhaAtualEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenhaAtualEmail.setBounds(41, 377, 103, 14);
		panel.add(lblSenhaAtualEmail);

		passwordFieldEmail = new JPasswordField();
		passwordFieldEmail.setToolTipText("Sua senha");
		passwordFieldEmail.setForeground(Color.BLACK);
		passwordFieldEmail.setColumns(10);
		passwordFieldEmail.setBackground(Color.WHITE);
		passwordFieldEmail.setBounds(162, 377, 175, 20);
		panel.add(passwordFieldEmail);

		JLabel lblSenhaAtualTelefone = new JLabel("Senha atual:");
		lblSenhaAtualTelefone.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblSenhaAtualTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenhaAtualTelefone.setBounds(545, 382, 103, 14);
		panel.add(lblSenhaAtualTelefone);

		passwordFieldTelefone = new JPasswordField();
		passwordFieldTelefone.setToolTipText("Sua senha");
		passwordFieldTelefone.setForeground(Color.BLACK);
		passwordFieldTelefone.setColumns(10);
		passwordFieldTelefone.setBackground(Color.WHITE);
		passwordFieldTelefone.setBounds(666, 382, 175, 20);
		panel.add(passwordFieldTelefone);

		JLabel lblEstadoCervejaria = new JLabel("Estado:");
		lblEstadoCervejaria.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblEstadoCervejaria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstadoCervejaria.setBounds(90, 544, 54, 14);
		panel.add(lblEstadoCervejaria);

		JLabel lblCidadeCervejaria = new JLabel("Cidade:");
		lblCidadeCervejaria.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblCidadeCervejaria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidadeCervejaria.setBounds(90, 572, 54, 14);
		panel.add(lblCidadeCervejaria);

		JLabel lblEnderecoCervejaria = new JLabel("Endere\u00E7o:");
		lblEnderecoCervejaria.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblEnderecoCervejaria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnderecoCervejaria.setBounds(73, 601, 71, 14);
		panel.add(lblEnderecoCervejaria);

		textFieldEndereco = new JTextField();
		textFieldEndereco.setToolTipText("Endere\u00E7o");
		textFieldEndereco.setColumns(10);
		textFieldEndereco.setBounds(154, 598, 359, 20);
		panel.add(textFieldEndereco);

		JLabel lblSenhaAtualEndereco = new JLabel("Senha atual:");
		lblSenhaAtualEndereco.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblSenhaAtualEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenhaAtualEndereco.setBounds(41, 625, 103, 14);
		panel.add(lblSenhaAtualEndereco);

		passwordFieldEndereco = new JPasswordField();
		passwordFieldEndereco.setToolTipText("Sua senha");
		passwordFieldEndereco.setForeground(Color.BLACK);
		passwordFieldEndereco.setColumns(10);
		passwordFieldEndereco.setBackground(Color.WHITE);
		passwordFieldEndereco.setBounds(154, 623, 175, 20);
		panel.add(passwordFieldEndereco);

		JLabel lblDesejaAlterarEndereo = new JLabel("Deseja alterar Endere\u00E7o da Cervejaria?");
		lblDesejaAlterarEndereo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDesejaAlterarEndereo.setBounds(90, 515, 279, 14);
		panel.add(lblDesejaAlterarEndereo);

		JButton btnEnderecoAlterar = new JButton("Alterar Endere\u00E7o");
		btnEnderecoAlterar.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnEnderecoAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				alterarEndereco(cervLogado, lblCervejariaEndereco, comboBoxCidade, comboBoxEstado);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				clearMsg();
			}
		});
		btnEnderecoAlterar.setBounds(164, 654, 153, 23);
		panel.add(btnEnderecoAlterar);

		lblMsgErroEndereco = new JLabel("");
		lblMsgErroEndereco.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsgErroEndereco.setBounds(118, 688, 259, 14);
		panel.add(lblMsgErroEndereco);

		JLabel lblNewLabel = new JLabel("Gerenciar Cervejaria!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(new Color(255, 102, 51));
		lblNewLabel.setBounds(420, 15, 228, 14);
		panel.add(lblNewLabel);

		framePrincipal.setVisible(true);

	}

	private static void clearMsg() {
		lblMsgErroTelefone.setText("");
		lblMsgErroEmail.setText("");
		lblMsgErroEndereco.setText("");
	}

	@SuppressWarnings("deprecation")
	private static void alterarEmail(Cervejeiro cervLogado, CervejariaBO cbo, JLabel lblCervejariaEmail) {
		String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

		if (!textFieldEmailAtual.getText().equalsIgnoreCase(cervLogado.getCervejaria().getEmail())) {
			lblMsgErroEmail.setForeground(Color.RED);
			lblMsgErroEmail.setText("Dados Invalidos");
			return;
		}
		if (!textFieldEmailNovo.getText().matches(regexEmail)) {

			lblMsgErroEmail.setForeground(Color.RED);
			lblMsgErroEmail.setText("Dados Invalidos");
			return;
		}

		if (!passwordFieldEmail.getText().equals(cervLogado.getSenha())) {
			lblMsgErroEmail.setForeground(Color.RED);
			lblMsgErroEmail.setText("Senha incorreta");
			return;
		}

		Cervejaria cervejaria = cervLogado.getCervejaria();
		cervejaria.setEmail(textFieldEmailNovo.getText());
		try {
			cbo.alterar(cervejaria);
		} catch (Exception e1) {
			lblMsgErroEmail.setForeground(Color.RED);
			lblMsgErroEmail.setText("Erro ao alterar Cervejaria");
			return;
		}

		cervLogado.setCervejaria(cervejaria);
		((Cervejeiro) TelaLogin.usuarioLogado).setCervejaria(cervejaria);
		lblMsgErroEmail.setForeground(Color.GREEN);
		lblMsgErroEmail.setText("Email Alterado com Sucesso!");
		lblCervejariaEmail.setText(textFieldEmailNovo.getText());
	}

	@SuppressWarnings("deprecation")
	private static void alterarTelefone(Cervejeiro cervLogado, CervejariaBO cbo, JLabel lblCervejariaTelefone) {
		String regexN = "[0-9]+";
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

		if (!passwordFieldTelefone.getText().equals(cervLogado.getSenha())) {
			lblMsgErroTelefone.setForeground(Color.RED);
			lblMsgErroTelefone.setText("Senha incorreta");
			return;
		}

		Cervejaria cervejaria = cervLogado.getCervejaria();
		cervejaria.setTelefone(textFieldTelefoneNovo.getText());
		try {
			cbo.alterar(cervejaria);
		} catch (Exception e1) {
			lblMsgErroTelefone.setForeground(Color.RED);
			lblMsgErroTelefone.setText("Erro ao Alterar Telefone");
			return;
		}
		cervLogado.setCervejaria(cervejaria);
		((Cervejeiro) TelaLogin.usuarioLogado).setCervejaria(cervejaria);
		lblMsgErroTelefone.setForeground(Color.GREEN);
		lblMsgErroTelefone.setText("Telefone Alterado com Sucesso!");
		lblCervejariaTelefone.setText(textFieldTelefoneNovo.getText());
	}

	@SuppressWarnings("deprecation")
	private static void alterarEndereco(Cervejeiro cervLogado, JLabel lblCervejariaEndereco,
			JComboBox<Cidade> comboBoxCidade, JComboBox<Estado> comboBoxEstado) {
		if (!passwordFieldEndereco.getText().equals(cervLogado.getSenha())) {
			lblMsgErroEndereco.setForeground(Color.RED);
			lblMsgErroEndereco.setText("Senha incorreta");
			return;
		}

		if (textFieldEndereco.getText().isBlank()) {
			lblMsgErroEndereco.setForeground(Color.RED);
			lblMsgErroEndereco.setText("O campo Endereço não pode ficar em branco");
			return;
		}

		EnderecoBO enderecobo = new EnderecoBO();
		Endereco endereco = cervLogado.getCervejaria().getEndereco();
		endereco.setCidade((Cidade) comboBoxCidade.getSelectedItem());
		endereco.getCidade().setEstado((Estado) comboBoxEstado.getSelectedItem());
		endereco.setNome(textFieldEndereco.getText());
		try {
			enderecobo.alterar(endereco);
		} catch (Exception e1) {
			lblMsgErroEndereco.setForeground(Color.RED);
			lblMsgErroEndereco.setText("Erro ao alterar Endereço");
			return;
		}

		Cervejaria cervejaria = cervLogado.getCervejaria();
		cervejaria.setEndereco(endereco);
		cervLogado.setCervejaria(cervejaria);
		((Cervejeiro) TelaLogin.usuarioLogado).setCervejaria(cervejaria);
		lblMsgErroEndereco.setForeground(Color.GREEN);
		lblMsgErroEndereco.setText("Endereço Alterado com Sucesso!");

		lblCervejariaEndereco.setText(cervLogado.getCervejaria().getEndereco().getNome() + ", "
				+ cervLogado.getCervejaria().getEndereco().getCidade().getNome() + ", "
				+ cervLogado.getCervejaria().getEndereco().getCidade().getEstado().getNome());
	}
}
