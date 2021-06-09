package br.edu.unifacear.telas;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import br.edu.unifacear.bo.ColoracaoBO;
import br.edu.unifacear.bo.EnderecoBO;
import br.edu.unifacear.bo.EstadoBO;
import br.edu.unifacear.bo.FermentoBO;
import br.edu.unifacear.bo.LupuloBO;
import br.edu.unifacear.bo.MalteBO;
import br.edu.unifacear.bo.PaisBO;
import br.edu.unifacear.bo.SaborBO;
import br.edu.unifacear.bo.TokenBO;
import br.edu.unifacear.classes.Apreciador;
import br.edu.unifacear.classes.Cervejeiro;
import br.edu.unifacear.classes.Cidade;
import br.edu.unifacear.classes.Coloracao;
import br.edu.unifacear.classes.Estado;
import br.edu.unifacear.classes.Fermento;
import br.edu.unifacear.classes.Lupulo;
import br.edu.unifacear.classes.Malte;
import br.edu.unifacear.classes.Pais;
import br.edu.unifacear.classes.Sabor;
import br.edu.unifacear.classes.Token;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;

public class TelaAdm {

	private static JFrame frameMain;
	private static JTextField textToken;
	private static JTextField textEmailCervejeiro;
	private static JTextField textEmailApreciador;
	private static JTextField textFieldNovoEstado;
	private static JTextField textFieldNovaCidade;
	private static JLabel lblMsgCervejeiro = new JLabel("");
	private static JLabel lblMsgApreciador = new JLabel("");
	private static JLabel lblCadastroMsgEstado = new JLabel("");
	private static JLabel lblCadastroMsgCidade = new JLabel("");
	private static JTextField textFieldPais;
	private static JLabel lblCadastroMsgPais = new JLabel("");
	private static JTextField textFieldColoracao;
	private static JTextField textFieldSabor;
	private static JTextField textFieldMalte;
	private static JTextField textFieldFermento;
	private static JTextField textFieldLupulo;
	private static JLabel lblCadastroMsgColoracao = new JLabel("");
	private static JLabel lblCadastroMsgLupulo = new JLabel("");
	private static JLabel lblCadastroMsgFermento = new JLabel("");
	private static JLabel lblCadastroMsgMalte = new JLabel("");
	private static JLabel lblCadastroMsgSabor = new JLabel("");

	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public static void telaAdm() throws Exception {

		EstadoBO estadobo = new EstadoBO();

		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(Color.WHITE);
		frameMain = new JFrame();
		frameMain.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\leo4_\\Desktop\\GrogosPesq.jpg"));
		frameMain.setSize(977, 839);
		frameMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameMain.setLocation(500, 100);

		frameMain.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblTitle = new JLabel("Gerenciamento");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(255, 102, 0));
		lblTitle.setBounds(336, 11, 183, 14);
		panel.add(lblTitle);

		JLabel lblDeletarCervejeiro = new JLabel("Deletar conta Cervejeiro");
		lblDeletarCervejeiro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDeletarCervejeiro.setBounds(385, 97, 177, 14);
		panel.add(lblDeletarCervejeiro);

		textToken = new JTextField();
		textToken.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearmsg();
			}
		});
		textToken.setBounds(88, 122, 148, 20);
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
		btnGerar.setBounds(98, 153, 124, 23);
		panel.add(btnGerar);

		JLabel lblTokenText = new JLabel("Token:");
		lblTokenText.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTokenText.setBounds(21, 125, 46, 14);
		panel.add(lblTokenText);

		JLabel lblGerarPasse_1 = new JLabel("Gerar passe para Cervejeiro");
		lblGerarPasse_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGerarPasse_1.setBounds(78, 97, 177, 14);
		panel.add(lblGerarPasse_1);

		JLabel lblEmailCervejeiro = new JLabel("Email Cervejeiro:");
		lblEmailCervejeiro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailCervejeiro.setBounds(274, 126, 106, 14);
		panel.add(lblEmailCervejeiro);

		textEmailCervejeiro = new JTextField();
		textEmailCervejeiro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearmsg();
			}
		});
		textEmailCervejeiro.setColumns(10);
		textEmailCervejeiro.setBounds(385, 123, 148, 20);
		panel.add(textEmailCervejeiro);

		lblMsgCervejeiro.setBounds(358, 189, 204, 14);
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
						} else {
							cbo.deletar(cerv);
						}
						lblMsgCervejeiro.setText("Cervejeiro deletado");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		btnDeletarCervejeiro.setBounds(395, 155, 124, 23);
		panel.add(btnDeletarCervejeiro);

		lblMsgApreciador.setBounds(681, 189, 204, 14);
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
		btnDeletarApreciador.setBounds(709, 155, 124, 23);
		panel.add(btnDeletarApreciador);

		textEmailApreciador = new JTextField();
		textEmailApreciador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearmsg();
			}
		});
		textEmailApreciador.setColumns(10);
		textEmailApreciador.setBounds(699, 123, 148, 20);
		panel.add(textEmailApreciador);

		JLabel lblEmailApreciador = new JLabel("Email Apreciador:");
		lblEmailApreciador.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailApreciador.setBounds(583, 126, 106, 14);
		panel.add(lblEmailApreciador);

		JLabel lblDeletarContaApreciador = new JLabel("Deletar conta Apreciador");
		lblDeletarContaApreciador.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDeletarContaApreciador.setBounds(699, 97, 177, 14);
		panel.add(lblDeletarContaApreciador);

		textFieldNovoEstado = new JTextField();
		textFieldNovoEstado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearmsg();
			}
		});
		textFieldNovoEstado.setBounds(107, 304, 148, 20);
		panel.add(textFieldNovoEstado);
		textFieldNovoEstado.setColumns(10);

		lblCadastroMsgEstado.setBounds(107, 371, 177, 14);
		panel.add(lblCadastroMsgEstado);

		JButton btnNovoEstado = new JButton("Cadastrar");
		btnNovoEstado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Estado estado = new Estado();
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
		btnNovoEstado.setBounds(120, 337, 120, 23);
		panel.add(btnNovoEstado);

		JLabel lblCadastrarNoEstado = new JLabel("Cadastrar novo Estado");
		lblCadastrarNoEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastrarNoEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarNoEstado.setBounds(89, 278, 177, 14);
		panel.add(lblCadastrarNoEstado);

		JLabel lblNovoEstado = new JLabel("Novo Estado:");
		lblNovoEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNovoEstado.setBounds(10, 307, 89, 14);
		panel.add(lblNovoEstado);

		JLabel lblCadastrarNovaCidade = new JLabel("Cadastrar nova Cidade");
		lblCadastrarNovaCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastrarNovaCidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarNovaCidade.setBounds(390, 278, 177, 14);
		panel.add(lblCadastrarNovaCidade);

		JLabel lblNovaCidade = new JLabel("Nova Cidade:");
		lblNovaCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNovaCidade.setBounds(309, 331, 89, 14);
		panel.add(lblNovaCidade);

		JComboBox<Estado> comboBoxEstado = new JComboBox<Estado>();
		comboBoxEstado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				comboBoxEstado.removeAllItems();
				try {
					for (Estado ee : estadobo.estados()) {

						comboBoxEstado.addItem(ee);

					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		comboBoxEstado.setBounds(408, 304, 148, 22);
		panel.add(comboBoxEstado);

		textFieldNovaCidade = new JTextField();
		textFieldNovaCidade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearmsg();

			}
		});
		textFieldNovaCidade.setColumns(10);
		textFieldNovaCidade.setBounds(408, 328, 148, 20);
		panel.add(textFieldNovaCidade);

		lblCadastroMsgCidade.setBounds(390, 393, 177, 14);
		panel.add(lblCadastroMsgCidade);

		for (Estado e : estadobo.estados()) {
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
		btnNovaCidade.setBounds(429, 359, 107, 23);
		panel.add(btnNovaCidade);

		JLabel lblSelecioneEstado = new JLabel("Selecione Estado:");
		lblSelecioneEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSelecioneEstado.setBounds(294, 304, 106, 14);
		panel.add(lblSelecioneEstado);

		JButton btnNovoPais = new JButton("Cadastrar");
		btnNovoPais.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PaisBO paisbo = new PaisBO();
				Pais pais = new Pais();
				pais.setNome(textFieldPais.getText());
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
		btnNovoPais.setBounds(124, 523, 120, 23);
		panel.add(btnNovoPais);

		textFieldPais = new JTextField();
		textFieldPais.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearmsg();
			}
		});
		textFieldPais.setColumns(10);
		textFieldPais.setBounds(107, 492, 148, 20);
		panel.add(textFieldPais);

		JLabel lblNovoPais = new JLabel("Novo Pa\u00EDs:");
		lblNovoPais.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNovoPais.setBounds(10, 492, 89, 14);
		panel.add(lblNovoPais);

		JLabel lblCadastrarNovoPais = new JLabel("Cadastrar novo Pa\u00EDs");
		lblCadastrarNovoPais.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastrarNovoPais.setBounds(120, 466, 177, 14);
		panel.add(lblCadastrarNovoPais);
		lblCadastroMsgPais.setHorizontalAlignment(SwingConstants.CENTER);

		lblCadastroMsgPais.setBounds(89, 557, 177, 14);
		panel.add(lblCadastroMsgPais);

		JLabel lblCadastrarNovaColoracao = new JLabel("Cadastrar nova Colora\u00E7\u00E3o");
		lblCadastrarNovaColoracao.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarNovaColoracao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastrarNovaColoracao.setBounds(367, 466, 204, 14);
		panel.add(lblCadastrarNovaColoracao);

		JLabel lblNovaColorao = new JLabel("Nova Colora\u00E7\u00E3o:");
		lblNovaColorao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNovaColorao.setBounds(277, 492, 124, 14);
		panel.add(lblNovaColorao);

		textFieldColoracao = new JTextField();
		textFieldColoracao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearmsg();
			}
		});
		textFieldColoracao.setColumns(10);
		textFieldColoracao.setBounds(409, 492, 148, 20);
		panel.add(textFieldColoracao);

		JButton btnColoracao = new JButton("Cadastrar");
		btnColoracao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ColoracaoBO colorocaobo = new ColoracaoBO();
				Coloracao coloracao = new Coloracao();
				coloracao.setNome(textFieldColoracao.getText());
				Boolean cadastrar = false;
				try {
					cadastrar = colorocaobo.saveColoracao(coloracao);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (cadastrar == true) {
					lblCadastroMsgColoracao.setText("Cadastrado com Sucesso");
				} else {
					lblCadastroMsgColoracao.setText("Essa colacao já existe");
				}
			}
		});
		btnColoracao.setBounds(426, 523, 120, 23);
		panel.add(btnColoracao);

		lblCadastroMsgColoracao = new JLabel("");
		lblCadastroMsgColoracao.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroMsgColoracao.setBounds(390, 557, 177, 14);
		panel.add(lblCadastroMsgColoracao);

		JLabel lblCadastrarNovoSabor = new JLabel("Cadastrar novo Sabor");
		lblCadastrarNovoSabor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarNovoSabor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastrarNovoSabor.setBounds(670, 466, 204, 14);
		panel.add(lblCadastrarNovoSabor);

		JLabel lblNovoSabor = new JLabel("Novo Sabor:");
		lblNovoSabor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNovoSabor.setBounds(580, 492, 124, 14);
		panel.add(lblNovoSabor);

		textFieldSabor = new JTextField();
		textFieldSabor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearmsg();
			}
		});
		textFieldSabor.setColumns(10);
		textFieldSabor.setBounds(712, 492, 148, 20);
		panel.add(textFieldSabor);

		JButton btnSabor = new JButton("Cadastrar");
		btnSabor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaborBO saborbo = new SaborBO();
				Sabor sabor = new Sabor();
				sabor.setNome(textFieldSabor.getText());
				Boolean cadastrar = false;
				try {
					cadastrar = saborbo.saveSabor(sabor);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (cadastrar == true) {
					lblCadastroMsgSabor.setText("Cadastrado com Sucesso");
				} else {
					lblCadastroMsgSabor.setText("Esse Sabor já existe");
				}
			}
		});
		btnSabor.setBounds(729, 523, 120, 23);
		panel.add(btnSabor);

		lblCadastroMsgSabor = new JLabel("");
		lblCadastroMsgSabor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroMsgSabor.setBounds(693, 557, 177, 14);
		panel.add(lblCadastroMsgSabor);

		JLabel lblDadosCerveja = new JLabel("Adicionar informa\u00E7\u00F5es para cadastro de Cerveja");
		lblDadosCerveja.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDadosCerveja.setHorizontalAlignment(SwingConstants.CENTER);
		lblDadosCerveja.setBounds(203, 418, 433, 20);
		panel.add(lblDadosCerveja);

		JLabel lblDadosCervejaria = new JLabel("Adicionar informa\u00E7\u00F5es para cadastro de Cervejaria");
		lblDadosCervejaria.setHorizontalAlignment(SwingConstants.CENTER);
		lblDadosCervejaria.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDadosCervejaria.setBounds(185, 226, 433, 20);
		panel.add(lblDadosCervejaria);

		JLabel lblDadosIngredientes = new JLabel("Adicionar informa\u00E7\u00F5es para cadastro de Ingredientes");
		lblDadosIngredientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblDadosIngredientes.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDadosIngredientes.setBounds(214, 615, 433, 20);
		panel.add(lblDadosIngredientes);

		JLabel lblCadastrarNovoTipo = new JLabel("Cadastrar novo Tipo L\u00FApulo ");
		lblCadastrarNovoTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarNovoTipo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastrarNovoTipo.setBounds(107, 663, 177, 14);
		panel.add(lblCadastrarNovoTipo);

		JLabel lblCadastrarNovoFermento = new JLabel("Cadastrar novo Fermento");
		lblCadastrarNovoFermento.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarNovoFermento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastrarNovoFermento.setBounds(378, 663, 204, 14);
		panel.add(lblCadastrarNovoFermento);

		JLabel lblCadastrarNovoMalte = new JLabel("Cadastrar novo Malte");
		lblCadastrarNovoMalte.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarNovoMalte.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastrarNovoMalte.setBounds(681, 663, 204, 14);
		panel.add(lblCadastrarNovoMalte);

		textFieldMalte = new JTextField();
		textFieldMalte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearmsg();
			}
		});
		textFieldMalte.setColumns(10);
		textFieldMalte.setBounds(723, 689, 148, 20);
		panel.add(textFieldMalte);

		JLabel lblNovoMalte = new JLabel("Novo Malte:");
		lblNovoMalte.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNovoMalte.setBounds(591, 689, 124, 14);
		panel.add(lblNovoMalte);

		textFieldFermento = new JTextField();
		textFieldFermento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearmsg();
			}
		});
		textFieldFermento.setColumns(10);
		textFieldFermento.setBounds(420, 689, 148, 20);
		panel.add(textFieldFermento);

		JLabel lblNovoFermento = new JLabel("Nova Fermento:");
		lblNovoFermento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNovoFermento.setBounds(288, 689, 124, 14);
		panel.add(lblNovoFermento);

		textFieldLupulo = new JTextField();
		textFieldLupulo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearmsg();
			}
		});
		textFieldLupulo.setColumns(10);
		textFieldLupulo.setBounds(118, 689, 148, 20);
		panel.add(textFieldLupulo);

		JLabel lblNovoLupulo = new JLabel("Novo L\u00FApulo:");
		lblNovoLupulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNovoLupulo.setBounds(21, 689, 89, 14);
		panel.add(lblNovoLupulo);

		JButton btnNovoLupulo = new JButton("Cadastrar");
		btnNovoLupulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LupuloBO lupulobo = new LupuloBO();
				Lupulo lupulo = new Lupulo();
				lupulo.setNome(textFieldLupulo.getText());
				Boolean cadastrar = false;
				try {
					cadastrar = lupulobo.saveLupulo(lupulo);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (cadastrar == true) {
					lblCadastroMsgLupulo.setText("Cadastrado com Sucesso");
				} else {
					lblCadastroMsgLupulo.setText("Esse Lúpulo já existe");
				}
			}
		});
		btnNovoLupulo.setBounds(135, 720, 120, 23);
		panel.add(btnNovoLupulo);

		lblCadastroMsgLupulo = new JLabel("");
		lblCadastroMsgLupulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroMsgLupulo.setBounds(100, 754, 177, 14);
		panel.add(lblCadastroMsgLupulo);

		lblCadastroMsgFermento = new JLabel("");
		lblCadastroMsgFermento.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroMsgFermento.setBounds(401, 754, 177, 14);
		panel.add(lblCadastroMsgFermento);

		lblCadastroMsgMalte = new JLabel("");
		lblCadastroMsgMalte.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroMsgMalte.setBounds(704, 754, 177, 14);
		panel.add(lblCadastroMsgMalte);

		JButton btnFermento = new JButton("Cadastrar");
		btnFermento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FermentoBO fermentobo = new FermentoBO();
				Fermento fermento = new Fermento();
				fermento.setNome(textFieldFermento.getText());
				Boolean cadastrar = false;
				try {
					cadastrar = fermentobo.saveFermento(fermento);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (cadastrar == true) {
					lblCadastroMsgFermento.setText("Cadastrado com Sucesso");
				} else {
					lblCadastroMsgFermento.setText("Esse Fermento já existe");
				}
			}
		});
		btnFermento.setBounds(437, 720, 120, 23);
		panel.add(btnFermento);

		JButton btnMalte = new JButton("Cadastrar");
		btnMalte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MalteBO maltebo = new MalteBO();
				Malte malte = new Malte();
				malte.setNome(textFieldMalte.getText());
				Boolean cadastrar = false;
				try {
					cadastrar = maltebo.saveMalte(malte);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (cadastrar == true) {
					lblCadastroMsgMalte.setText("Cadastrado com Sucesso");
				} else {
					lblCadastroMsgMalte.setText("Esse Malte já existe");
				}
			}
		});
		btnMalte.setBounds(740, 720, 120, 23);
		panel.add(btnMalte);
		frameMain.setVisible(true);
	}

	protected static void clearmsg() {
		
		lblCadastroMsgCidade.setText("");
		lblCadastroMsgEstado.setText("");
		lblMsgApreciador.setText("");
		lblMsgCervejeiro.setText("");
		lblCadastroMsgColoracao.setText("");
		lblCadastroMsgLupulo.setText("");
		lblCadastroMsgFermento.setText("");
		lblCadastroMsgMalte.setText("");
		lblCadastroMsgSabor.setText("");
		
	}
}
