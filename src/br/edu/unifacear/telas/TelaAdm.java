package br.edu.unifacear.telas;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Random;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.unifacear.bo.ApreciadorBO;
import br.edu.unifacear.bo.CervejariaBO;
import br.edu.unifacear.bo.CervejeiroBO;
import br.edu.unifacear.bo.CidadeBO;
import br.edu.unifacear.bo.EnderecoBO;
import br.edu.unifacear.bo.EstadoBO;
import br.edu.unifacear.bo.PaisBO;
import br.edu.unifacear.bo.TokenBO;
import br.edu.unifacear.classes.Apreciador;
import br.edu.unifacear.classes.Cervejeiro;
import br.edu.unifacear.classes.Cidade;
import br.edu.unifacear.classes.Estado;
import br.edu.unifacear.classes.Pais;
import br.edu.unifacear.classes.Token;
import javax.swing.JComboBox;

public class TelaAdm {

	private static JFrame frameMain;
	public static String usuarioLogado;
	private static JTextField textToken;
	private static JTextField textEmailCervejeiro;
	private static JTextField textEmailApreciador;
	private static JTextField textFieldNovoEstado;
	private static JTextField textFieldNovaCidade;
	private static JLabel lblMsgCervejeiro = new JLabel("");
	private static JLabel lblMsgApreciador = new JLabel("");
	private static JLabel lblCadastroMsgEstado = new JLabel("");
	private static JLabel lblCadastroMsgCidade = new JLabel("");
	private static JTextField textFieldNovoPais;
	private static JLabel lblCadastroMsgPais = new JLabel("");

	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public static void telaAdm() throws Exception {
		
		EstadoBO estadobo = new EstadoBO();
//		cadastro.registerUser(nome, senha, idade, email);

		// imagem

		// labels e botoes do jFrame
		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(Color.WHITE);
		frameMain = new JFrame();
		frameMain.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\leo4_\\Desktop\\GrogosPesq.jpg"));
		frameMain.setSize(857, 557);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.setLocation(500, 250);

		frameMain.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblTitle = new JLabel("Grogos");
		lblTitle.setForeground(Color.RED);
		lblTitle.setBounds(292, 25, 46, 14);
		panel.add(lblTitle);

		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frameMain.dispose();
			}
		});
		btnSair.setBounds(21, 37, 89, 23);
		panel.add(btnSair);

		JLabel lblDeletarCervejeiro = new JLabel("Deletar conta cervejeiro");
		lblDeletarCervejeiro.setBounds(78, 221, 177, 14);
		panel.add(lblDeletarCervejeiro);

		textToken = new JTextField();
		textToken.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearmsg();
			}
		});
		textToken.setBounds(78, 156, 148, 20);
		panel.add(textToken);
		textToken.setColumns(10);

		JButton btnGerar = new JButton("Gerar");
		btnGerar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Token tokenc = new Token();
				TokenBO tokenbo = new TokenBO();
				tokenc.setStatus("valido");
				tokenc.setNome(getGerarToken());

				try {
					tokenbo.salvar(tokenc);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				textToken.setText(tokenc.getNome());

			}

			private String getGerarToken() {
				Random rand = new Random(); // instance of random class
				int upperbound = 99999;
				Integer int_random = rand.nextInt(upperbound);
				String token = "grogosToken" + int_random.toString();

				return token;

			}
		});
		btnGerar.setBounds(78, 122, 124, 23);
		panel.add(btnGerar);

		JLabel lblTokenText = new JLabel("Token:");
		lblTokenText.setBounds(21, 156, 46, 14);
		panel.add(lblTokenText);

		JLabel lblGerarPasse_1 = new JLabel("Gerar passe para Cervejeiro");
		lblGerarPasse_1.setBounds(78, 97, 177, 14);
		panel.add(lblGerarPasse_1);

		JLabel lblEmailCervejeiro = new JLabel("Email Cervejeiro:");
		lblEmailCervejeiro.setBounds(21, 250, 106, 14);
		panel.add(lblEmailCervejeiro);

		textEmailCervejeiro = new JTextField();
		textEmailCervejeiro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearmsg();
			}
		});
		textEmailCervejeiro.setColumns(10);
		textEmailCervejeiro.setBounds(148, 247, 148, 20);
		panel.add(textEmailCervejeiro);

		
		lblMsgCervejeiro.setBounds(39, 322, 204, 14);
		panel.add(lblMsgCervejeiro);

		JButton btnDeletarCervejeiro = new JButton("Deletar");
		btnDeletarCervejeiro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				EnderecoBO enderecobo = new EnderecoBO();
				CervejariaBO cervejariabo = new CervejariaBO();
				Cervejeiro cervejeiro = new Cervejeiro();

				CervejeiroBO cbo = new CervejeiroBO();
				cervejeiro.setEmail(textEmailCervejeiro.getText());

				Cervejeiro cerv = (Cervejeiro) cbo.findCervejeiro(cervejeiro);

				if (cerv == null) {
					lblMsgCervejeiro.setText("Cervejeiro não encontrado");
				} else {
					try {
						if (cerv.getCervejaria() != null) {
							cbo.deletar(cerv);
							cervejariabo.deletar(cerv.getCervejaria());
							enderecobo.deletar(cerv.getCervejaria().getEndereco());
						}else {
							cbo.deletar(cerv);
						}
						lblMsgCervejeiro.setText("Cervejeiro deletado");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		btnDeletarCervejeiro.setBounds(78, 289, 124, 23);
		panel.add(btnDeletarCervejeiro);

		
		lblMsgApreciador.setBounds(51, 439, 204, 14);
		panel.add(lblMsgApreciador);

		JButton btnDeletarApreciador = new JButton("Deletar");
		btnDeletarApreciador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Apreciador apreciador = new Apreciador();
				ApreciadorBO abo = new ApreciadorBO();
				apreciador.setEmail(textEmailApreciador.getText());
				Apreciador apre = (Apreciador) abo.findApreciador(apreciador);

				if (apre == null) {
					lblMsgApreciador.setText("Apreciador não encontrado");
				} else {
					try {

						abo.deletar(apre);
						lblMsgApreciador.setText("Apreciador deletado");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		btnDeletarApreciador.setBounds(78, 405, 124, 23);
		panel.add(btnDeletarApreciador);

		textEmailApreciador = new JTextField();
		textEmailApreciador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearmsg();
			}
		});
		textEmailApreciador.setColumns(10);
		textEmailApreciador.setBounds(148, 363, 148, 20);
		panel.add(textEmailApreciador);

		JLabel lblEmailApreciador = new JLabel("Email Apreciador:");
		lblEmailApreciador.setBounds(21, 366, 106, 14);
		panel.add(lblEmailApreciador);

		JLabel lblDeletarContaApreciador = new JLabel("Deletar conta apreciador");
		lblDeletarContaApreciador.setBounds(78, 337, 177, 14);
		panel.add(lblDeletarContaApreciador);
		
		textFieldNovoEstado = new JTextField();
		textFieldNovoEstado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearmsg();
			}
		});
		textFieldNovoEstado.setBounds(641, 123, 148, 20);
		panel.add(textFieldNovoEstado);
		textFieldNovoEstado.setColumns(10);
		
		
		lblCadastroMsgEstado.setBounds(641, 190, 177, 14);
		panel.add(lblCadastroMsgEstado);
		
		JButton btnNovoEstado = new JButton("Cadastrar");
		btnNovoEstado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Estado estado = new  Estado();
				estado.setNome(textFieldNovoEstado.getText());
				Boolean cadastrar = false;
				try {
					cadastrar = estadobo.saveEstado(estado);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (cadastrar == true) {
					lblCadastroMsgEstado.setText("Cadastrado com Sucesso");
				} else {
					lblCadastroMsgEstado.setText("Esse Estado já existe");
				}
			}
		});
		btnNovoEstado.setBounds(672, 156, 89, 23);
		panel.add(btnNovoEstado);
		
		JLabel lblCadastrarNoEstado = new JLabel("Cadastrar no estado");
		lblCadastrarNoEstado.setBounds(654, 97, 177, 14);
		panel.add(lblCadastrarNoEstado);
		
		JLabel lblNovoEstado = new JLabel("Novo Estado:");
		lblNovoEstado.setBounds(563, 126, 89, 14);
		panel.add(lblNovoEstado);
		
		JLabel lblCadastrarNovaCidade = new JLabel("Cadastrar nova Cidade");
		lblCadastrarNovaCidade.setBounds(641, 216, 177, 14);
		panel.add(lblCadastrarNovaCidade);
		
		JLabel lblNovaCidade = new JLabel("Nova Cidade:");
		lblNovaCidade.setBounds(563, 268, 89, 14);
		panel.add(lblNovaCidade);
		
		JComboBox<Estado> comboBoxEstado = new JComboBox<Estado>();
		comboBoxEstado.setBounds(641, 241, 148, 22);
		panel.add(comboBoxEstado);
		
		textFieldNovaCidade = new JTextField();
		textFieldNovaCidade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearmsg();
				comboBoxEstado.removeAllItems();
				try {
					for(Estado ee: estadobo.estados()) {
						
						comboBoxEstado.addItem(ee);

					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		textFieldNovaCidade.setColumns(10);
		textFieldNovaCidade.setBounds(641, 265, 148, 20);
		panel.add(textFieldNovaCidade);
		
		
		lblCadastroMsgCidade.setBounds(641, 337, 177, 14);
		panel.add(lblCadastroMsgCidade);
		
		for(Estado e: estadobo.estados()) {
			comboBoxEstado.addItem(e);

		}
		
		JButton btnNovaCidade = new JButton("Cadastrar");
		btnNovaCidade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cidade cidade = new Cidade();
				CidadeBO cidadebo = new CidadeBO();
				cidade.setNome(textFieldNovaCidade.getText());
				cidade.setEstado((Estado) comboBoxEstado.getSelectedItem());
				Boolean cadastrar = false;
				try {
					cadastrar = cidadebo.saveCidade(cidade);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (cadastrar == true) {
					lblCadastroMsgCidade.setText("Cadastrada com Sucesso");
				} else {
					lblCadastroMsgCidade.setText("Essa Cidade já existe neste estado");
				}
			}
		});
		btnNovaCidade.setBounds(672, 302, 89, 23);
		panel.add(btnNovaCidade);
		
		JLabel lblSelecioneEstado = new JLabel("Selecione Estado:");
		lblSelecioneEstado.setBounds(527, 241, 106, 14);
		panel.add(lblSelecioneEstado);
		
		JButton btnNovoPais = new JButton("Cadastrar");
		btnNovoPais.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PaisBO paisbo = new PaisBO();
				Pais pais = new Pais();
				pais.setNome(textFieldNovoPais.getText());
				Boolean cadastrar = false;
				try {
					cadastrar = paisbo.savePais(pais);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (cadastrar == true) {
					lblCadastroMsgPais.setText("Cadastrado com Sucesso");
				} else {
					lblCadastroMsgPais.setText("Esse Pais já existe");
				}
				
			}
		});
		btnNovoPais.setBounds(672, 430, 89, 23);
		panel.add(btnNovoPais);
		
		textFieldNovoPais = new JTextField();
		textFieldNovoPais.setColumns(10);
		textFieldNovoPais.setBounds(641, 397, 148, 20);
		panel.add(textFieldNovoPais);
		
		JLabel lblNovoPais = new JLabel("Novo Pa\u00EDs:");
		lblNovoPais.setBounds(563, 400, 89, 14);
		panel.add(lblNovoPais);
		
		JLabel lblCadastrarNovoPais = new JLabel("Cadastrar novo Pa\u00EDs");
		lblCadastrarNovoPais.setBounds(654, 371, 177, 14);
		panel.add(lblCadastrarNovoPais);
		
		
		lblCadastroMsgPais.setBounds(641, 462, 177, 14);
		panel.add(lblCadastroMsgPais);
		
		
		frameMain.setVisible(true);

	}

	protected static void clearmsg() {
		lblCadastroMsgCidade.setText("");
		lblCadastroMsgEstado.setText("");
		lblMsgApreciador.setText("");
		lblMsgCervejeiro.setText("");	
	}
}
