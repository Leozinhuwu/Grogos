package br.edu.unifacear.telas;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.unifacear.bo.CidadeBO;
import br.edu.unifacear.bo.EstadoBO;
import br.edu.unifacear.bo.TokenBO;
import br.edu.unifacear.classes.Cidade;
import br.edu.unifacear.classes.Estado;
import br.edu.unifacear.classes.Token;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;

public class TelaAdmManterCadastroCervejeiroCervejaria {

	private static JFrame frameMain;
	private static JTextField textToken;
	private static JTextField textFieldNovoEstado;
	private static JTextField textFieldNovaCidade;
	private static JLabel lblCadastroMsgEstado = new JLabel("");
	private static JLabel lblCadastroMsgCidade = new JLabel("");
	private static JLabel lblCadastroMsgColoracao = new JLabel("");
	private static JLabel lblCadastroMsgLupulo = new JLabel("");
	private static JLabel lblCadastroMsgFermento = new JLabel("");
	private static JLabel lblCadastroMsgMalte = new JLabel("");
	private static JLabel lblCadastroMsgSabor = new JLabel("");

	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public void telaManterCervejeiro() throws Exception {

		EstadoBO estadobo = new EstadoBO();

		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(new Color(244, 164, 96));
		frameMain = new JFrame();
		frameMain.setSize(904, 647);
		frameMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameMain.setLocation(500, 100);

		frameMain.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblTitle = new JLabel("Gerenciamento Cadastro de Cerveja e Cervejaria");
		lblTitle.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(255, 69, 0));
		lblTitle.setBounds(242, 22, 418, 32);
		panel.add(lblTitle);

		textToken = new JTextField();
		textToken.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearmsg();
			}
		});
		textToken.setBounds(110, 144, 148, 20);
		panel.add(textToken);
		textToken.setColumns(10);

		JButton btnGerar = new JButton("Gerar");
		btnGerar.setFont(new Font("Arial Black", Font.PLAIN, 12));
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
		btnGerar.setBounds(120, 175, 124, 23);
		panel.add(btnGerar);

		JLabel lblTokenText = new JLabel("Token:");
		lblTokenText.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTokenText.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTokenText.setBounds(54, 147, 46, 14);
		panel.add(lblTokenText);

		JLabel lblGerarPasse_1 = new JLabel("Gerar Token de Casdatro Cervejeiro");
		lblGerarPasse_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblGerarPasse_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGerarPasse_1.setBounds(36, 119, 259, 14);
		panel.add(lblGerarPasse_1);

		textFieldNovoEstado = new JTextField();
		textFieldNovoEstado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearmsg();
			}
		});
		textFieldNovoEstado.setBounds(118, 339, 148, 20);
		panel.add(textFieldNovoEstado);
		textFieldNovoEstado.setColumns(10);
		lblCadastroMsgEstado.setHorizontalAlignment(SwingConstants.CENTER);

		lblCadastroMsgEstado.setBounds(100, 406, 185, 14);
		panel.add(lblCadastroMsgEstado);

		JButton btnNovoEstado = new JButton("Cadastrar");
		btnNovoEstado.setFont(new Font("Arial Black", Font.BOLD, 12));
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
		btnNovoEstado.setBounds(131, 372, 124, 23);
		panel.add(btnNovoEstado);

		JLabel lblCadastrarNoEstado = new JLabel("Cadastrar novo Estado");
		lblCadastrarNoEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastrarNoEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarNoEstado.setBounds(100, 313, 177, 14);
		panel.add(lblCadastrarNoEstado);

		JLabel lblNovoEstado = new JLabel("Novo Estado:");
		lblNovoEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNovoEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNovoEstado.setBounds(21, 342, 89, 14);
		panel.add(lblNovoEstado);

		JLabel lblCadastrarNovaCidade = new JLabel("Cadastrar nova Cidade");
		lblCadastrarNovaCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastrarNovaCidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarNovaCidade.setBounds(96, 448, 177, 14);
		panel.add(lblCadastrarNovaCidade);

		JLabel lblNovaCidade = new JLabel("Nova Cidade:");
		lblNovaCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNovaCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNovaCidade.setBounds(15, 501, 89, 14);
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

		comboBoxEstado.setBounds(114, 473, 148, 22);
		panel.add(comboBoxEstado);

		textFieldNovaCidade = new JTextField();
		textFieldNovaCidade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearmsg();

			}
		});
		textFieldNovaCidade.setColumns(10);
		textFieldNovaCidade.setBounds(114, 498, 148, 20);
		panel.add(textFieldNovaCidade);
		lblCadastroMsgCidade.setHorizontalAlignment(SwingConstants.CENTER);

		lblCadastroMsgCidade.setBounds(45, 563, 320, 14);
		panel.add(lblCadastroMsgCidade);

		for (Estado e : estadobo.estados()) {
			comboBoxEstado.addItem(e);

		}

		JButton btnNovaCidade = new JButton("Cadastrar");
		btnNovaCidade.setFont(new Font("Arial Black", Font.BOLD, 12));
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
		btnNovaCidade.setBounds(129, 529, 124, 23);
		panel.add(btnNovaCidade);

		JLabel lblSelecioneEstado = new JLabel("Selecione Estado:");
		lblSelecioneEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSelecioneEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSelecioneEstado.setBounds(0, 474, 106, 14);
		panel.add(lblSelecioneEstado);

		JLabel lblAdicionarInforamesCerveja = new JLabel("Adicionar Novo Estado e Cidade");
		lblAdicionarInforamesCerveja.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionarInforamesCerveja.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAdicionarInforamesCerveja.setBounds(10, 272, 318, 30);
		panel.add(lblAdicionarInforamesCerveja);

		ImageIcon grogos = new ImageIcon(
				TelaAdmManterCadastroCervejeiroCervejaria.class.getResource("/Grogos_Final_Edition.png"));
		JLabel lblGrogosImg = new JLabel(grogos);
		lblGrogosImg.setBounds(242, 90, 632, 452);
		panel.add(lblGrogosImg);
		frameMain.setVisible(true);
	}

	protected static void clearmsg() {

		lblCadastroMsgCidade.setText("");
		lblCadastroMsgEstado.setText("");
		lblCadastroMsgColoracao.setText("");
		lblCadastroMsgLupulo.setText("");
		lblCadastroMsgFermento.setText("");
		lblCadastroMsgMalte.setText("");
		lblCadastroMsgSabor.setText("");

	}
}
