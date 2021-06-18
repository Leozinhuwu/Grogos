package br.edu.unifacear.telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.unifacear.bo.ColoracaoBO;
import br.edu.unifacear.bo.FermentoBO;
import br.edu.unifacear.bo.LupuloBO;
import br.edu.unifacear.bo.MalteBO;
import br.edu.unifacear.bo.PaisBO;
import br.edu.unifacear.bo.SaborBO;
import br.edu.unifacear.bo.TipoCervejaBO;
import br.edu.unifacear.classes.Coloracao;
import br.edu.unifacear.classes.Fermento;
import br.edu.unifacear.classes.Lupulo;
import br.edu.unifacear.classes.Malte;
import br.edu.unifacear.classes.Pais;
import br.edu.unifacear.classes.Sabor;
import br.edu.unifacear.classes.TipoCerveja;

import javax.swing.SwingConstants;
import java.awt.Font;

public class TelaAdmManterCadastroCerveja {

	private static JFrame frameMain;
	private static JTextField textFieldPais;
	private static JLabel lblCadastroMsgPais = new JLabel("");
	private static JTextField textFieldColoracao;
	private static JTextField textFieldSabor;
	private static JLabel lblCadastroMsgColoracao = new JLabel("");
	private static JLabel lblCadastroMsgSabor = new JLabel("");

	private static JTextField textFieldMalte;
	private static JTextField textFieldFermento;
	private static JTextField textFieldLupulo;

	private static JLabel lblCadastroMsgLupulo = new JLabel("");
	private static JLabel lblCadastroMsgFermento = new JLabel("");
	private static JLabel lblCadastroMsgMalte = new JLabel("");
	private static JLabel lblCadastroMsgTipo = new JLabel("");
	private JTextField textFieldTipo;

	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public void telaAdmCerveja() throws Exception {

		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(new Color(244, 164, 96));
		frameMain = new JFrame();
		frameMain.setSize(936, 776);
		frameMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameMain.setLocation(500, 150);

		frameMain.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblTitle = new JLabel("Gerenciamento");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(255, 102, 0));
		lblTitle.setBounds(336, 11, 183, 14);
		panel.add(lblTitle);

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
		btnNovoPais.setBounds(182, 335, 120, 23);
		panel.add(btnNovoPais);

		textFieldPais = new JTextField();
		textFieldPais.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearmsg();
			}
		});
		textFieldPais.setColumns(10);
		textFieldPais.setBounds(165, 304, 148, 20);
		panel.add(textFieldPais);

		JLabel lblNovoPais = new JLabel("Novo Pa\u00EDs:");
		lblNovoPais.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNovoPais.setBounds(66, 304, 89, 14);
		panel.add(lblNovoPais);

		JLabel lblCadastrarNovoPais = new JLabel("Cadastrar novo Pa\u00EDs");
		lblCadastrarNovoPais.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarNovoPais.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastrarNovoPais.setBounds(147, 278, 177, 14);
		panel.add(lblCadastrarNovoPais);
		lblCadastroMsgPais.setHorizontalAlignment(SwingConstants.CENTER);

		lblCadastroMsgPais.setBounds(147, 369, 177, 14);
		panel.add(lblCadastroMsgPais);

		JLabel lblCadastrarNovaColoracao = new JLabel("Cadastrar nova Colora\u00E7\u00E3o");
		lblCadastrarNovaColoracao.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarNovaColoracao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastrarNovaColoracao.setBounds(134, 415, 204, 14);
		panel.add(lblCadastrarNovaColoracao);

		JLabel lblNovaColorao = new JLabel("Nova Colora\u00E7\u00E3o:");
		lblNovaColorao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNovaColorao.setBounds(33, 440, 124, 14);
		panel.add(lblNovaColorao);

		textFieldColoracao = new JTextField();
		textFieldColoracao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearmsg();
			}
		});
		textFieldColoracao.setColumns(10);
		textFieldColoracao.setBounds(165, 437, 148, 20);
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
					lblCadastroMsgColoracao.setText("Essa Coloraçao já existe");
				}
			}
		});
		btnColoracao.setBounds(179, 471, 120, 23);
		panel.add(btnColoracao);

		lblCadastroMsgColoracao = new JLabel("");
		lblCadastroMsgColoracao.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroMsgColoracao.setBounds(143, 505, 177, 14);
		panel.add(lblCadastroMsgColoracao);

		JLabel lblCadastrarNovoSabor = new JLabel("Cadastrar novo Sabor");
		lblCadastrarNovoSabor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarNovoSabor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastrarNovoSabor.setBounds(134, 555, 204, 14);
		panel.add(lblCadastrarNovoSabor);

		JLabel lblNovoSabor = new JLabel("Novo Sabor:");
		lblNovoSabor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNovoSabor.setBounds(33, 580, 124, 14);
		panel.add(lblNovoSabor);

		textFieldSabor = new JTextField();
		textFieldSabor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearmsg();
			}
		});
		textFieldSabor.setColumns(10);
		textFieldSabor.setBounds(165, 577, 148, 20);
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
		btnSabor.setBounds(179, 611, 120, 23);
		panel.add(btnSabor);

		lblCadastroMsgSabor = new JLabel("");
		lblCadastroMsgSabor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroMsgSabor.setBounds(147, 645, 177, 14);
		panel.add(lblCadastroMsgSabor);

		JLabel lblDadosCerveja = new JLabel("Adicionar informa\u00E7\u00F5es para cadastro de Cerveja e Ingredientes");
		lblDadosCerveja.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDadosCerveja.setHorizontalAlignment(SwingConstants.CENTER);
		lblDadosCerveja.setBounds(214, 36, 507, 20);
		panel.add(lblDadosCerveja);

		JLabel lblNewLabel = new JLabel("Inforam\u00E7\u00F5es Cerveja");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(92, 95, 241, 30);
		panel.add(lblNewLabel);

		JLabel lblCadastrarNovoTipo = new JLabel("Cadastrar novo Tipo L\u00FApulo ");
		lblCadastrarNovoTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarNovoTipo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastrarNovoTipo.setBounds(721, 151, 177, 14);
		panel.add(lblCadastrarNovoTipo);

		JLabel lblCadastrarNovoFermento = new JLabel("Cadastrar novo Fermento");
		lblCadastrarNovoFermento.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarNovoFermento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastrarNovoFermento.setBounds(706, 278, 204, 14);
		panel.add(lblCadastrarNovoFermento);

		JLabel lblCadastrarNovoMalte = new JLabel("Cadastrar novo Malte");
		lblCadastrarNovoMalte.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarNovoMalte.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastrarNovoMalte.setBounds(706, 418, 204, 14);
		panel.add(lblCadastrarNovoMalte);

		textFieldMalte = new JTextField();
		textFieldMalte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearmsg();
			}
		});
		textFieldMalte.setColumns(10);
		textFieldMalte.setBounds(731, 440, 148, 20);
		panel.add(textFieldMalte);

		JLabel lblNovoMalte = new JLabel("Novo Malte:");
		lblNovoMalte.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNovoMalte.setBounds(597, 443, 124, 14);
		panel.add(lblNovoMalte);

		textFieldFermento = new JTextField();
		textFieldFermento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearmsg();
			}
		});
		textFieldFermento.setColumns(10);
		textFieldFermento.setBounds(731, 300, 148, 20);
		panel.add(textFieldFermento);

		JLabel lblNovoFermento = new JLabel("Novo Fermento:");
		lblNovoFermento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNovoFermento.setBounds(597, 303, 124, 14);
		panel.add(lblNovoFermento);

		textFieldLupulo = new JTextField();
		textFieldLupulo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearmsg();
			}
		});
		textFieldLupulo.setColumns(10);
		textFieldLupulo.setBounds(731, 177, 148, 20);
		panel.add(textFieldLupulo);

		JLabel lblNovoLupulo = new JLabel("Novo L\u00FApulo:");
		lblNovoLupulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNovoLupulo.setBounds(632, 180, 89, 14);
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
		btnNovoLupulo.setBounds(749, 208, 120, 23);
		panel.add(btnNovoLupulo);

		lblCadastroMsgLupulo = new JLabel("");
		lblCadastroMsgLupulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroMsgLupulo.setBounds(714, 242, 177, 14);
		panel.add(lblCadastroMsgLupulo);

		lblCadastroMsgFermento = new JLabel("");
		lblCadastroMsgFermento.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroMsgFermento.setBounds(721, 368, 177, 14);
		panel.add(lblCadastroMsgFermento);

		lblCadastroMsgMalte = new JLabel("");
		lblCadastroMsgMalte.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroMsgMalte.setBounds(729, 509, 177, 14);
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
		btnFermento.setBounds(748, 334, 120, 23);
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
		btnMalte.setBounds(749, 474, 120, 23);
		panel.add(btnMalte);

		JLabel lblInforamesIngredientes = new JLabel("Inforam\u00E7\u00F5es Ingredientes");
		lblInforamesIngredientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblInforamesIngredientes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInforamesIngredientes.setBounds(669, 95, 241, 30);
		panel.add(lblInforamesIngredientes);

		JLabel lblCadastrarNovoTipo_1 = new JLabel("Cadastrar novo Tipo");
		lblCadastrarNovoTipo_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarNovoTipo_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastrarNovoTipo_1.setBounds(147, 151, 177, 14);
		panel.add(lblCadastrarNovoTipo_1);

		JLabel lblNovoTipo = new JLabel("Novo Tipo:");
		lblNovoTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNovoTipo.setBounds(66, 177, 89, 14);
		panel.add(lblNovoTipo);

		textFieldTipo = new JTextField();
		textFieldTipo.setColumns(10);
		textFieldTipo.setBounds(165, 177, 148, 20);
		panel.add(textFieldTipo);

		JButton btnNovoTipo = new JButton("Cadastrar");
		btnNovoTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TipoCervejaBO tcbo = new TipoCervejaBO();
				TipoCerveja novoTipo = new TipoCerveja();
				Boolean cadastrar = false;
				if (textFieldTipo.getText().isBlank()) {
					lblCadastroMsgTipo.setText("Campo TIPO CERVEJA em Branco");
					return;
				}

				novoTipo.setNome(textFieldTipo.getText());
				try {
					cadastrar = tcbo.saveTipoCerveja(novoTipo);
				} catch (Exception e1) {
					lblCadastroMsgTipo.setText("Erro ao cadastrar");
					e1.printStackTrace();
					return;
				}

				if (cadastrar == true) {
					lblCadastroMsgTipo.setText("Cadastrado com Sucesso");
				} else {
					lblCadastroMsgTipo.setText("Esse Tipo já existe");
				}

			}
		});
		btnNovoTipo.setBounds(182, 208, 120, 23);
		panel.add(btnNovoTipo);

		lblCadastroMsgTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroMsgTipo.setBounds(147, 242, 177, 14);
		panel.add(lblCadastroMsgTipo);

		frameMain.setVisible(true);
	}

	protected static void clearmsg() {

		lblCadastroMsgColoracao.setText("");
		lblCadastroMsgLupulo.setText("");
		lblCadastroMsgFermento.setText("");
		lblCadastroMsgMalte.setText("");
		lblCadastroMsgSabor.setText("");
		lblCadastroMsgTipo.setText("");
	}
}
