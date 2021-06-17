package br.edu.unifacear.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import br.edu.unifacear.bo.CervejaBO;
import br.edu.unifacear.bo.ColoracaoBO;
import br.edu.unifacear.bo.PaisBO;
import br.edu.unifacear.bo.SaborBO;
import br.edu.unifacear.bo.TipoCervejaBO;
import br.edu.unifacear.classes.Cerveja;
import br.edu.unifacear.classes.Coloracao;
import br.edu.unifacear.classes.Pais;
import br.edu.unifacear.classes.Sabor;
import br.edu.unifacear.classes.TipoCerveja;
import javax.swing.JComboBox;

public class TelaPesquisa {

	private static JFrame framePesquisa;
	private static JTextField textFieldNome;
	private static JTable tblCervejas;
	private static JButton btnVerDetalhes;
	private static JLabel lblMsgPesquisar = new JLabel("Selecione pelo menos 1 campo para realizar a pesquisa");

	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public void telaPesquisa() throws Exception {

		// labels e botoes do jFrame
		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(new Color(244, 164, 96));
		framePesquisa = new JFrame();
		framePesquisa.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\leo4_\\Desktop\\GrogosPesq.jpg"));
		framePesquisa.setSize(1000, 893);
		framePesquisa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePesquisa.setLocation(500, 150);

		framePesquisa.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnVolta = new JButton("Voltar");
		btnVolta.setForeground(Color.BLACK);
		btnVolta.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnVolta.setBackground(Color.LIGHT_GRAY);
		btnVolta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaPrincipalApreciador tPrincipal = new TelaPrincipalApreciador();
					tPrincipal.telaPrincipal();

				} catch (Exception e1) {

					e1.printStackTrace();
					return;
				}
				framePesquisa.dispose();

			}
		});
		btnVolta.setBounds(10, 21, 89, 23);
		panel.add(btnVolta);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(10, 154, 60, 14);
		panel.add(lblNome);

		JCheckBox rdbtnPorNome = new JCheckBox("Por Nome");
		rdbtnPorNome.setFont(new Font("Arial", Font.BOLD, 11));
		rdbtnPorNome.setBounds(80, 107, 113, 23);
		panel.add(rdbtnPorNome);

		JCheckBox rdbtnPorTipo = new JCheckBox("Por Tipo");
		rdbtnPorTipo.setFont(new Font("Arial", Font.BOLD, 11));

		rdbtnPorTipo.setBounds(329, 107, 108, 23);
		panel.add(rdbtnPorTipo);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo.setBounds(256, 154, 60, 14);
		panel.add(lblTipo);

		JCheckBox rdbtnPorPais = new JCheckBox("Por Pa\u00EDs");
		rdbtnPorPais.setFont(new Font("Arial", Font.BOLD, 11));
		rdbtnPorPais.setBounds(594, 107, 108, 23);
		panel.add(rdbtnPorPais);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(80, 151, 113, 20);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);

		JComboBox<TipoCerveja> comboBoxTipo = new JComboBox<TipoCerveja>();
		comboBoxTipo.setBounds(329, 150, 118, 22);
		panel.add(comboBoxTipo);

		TipoCervejaBO tipocervejabo = new TipoCervejaBO();
		for (TipoCerveja tc : tipocervejabo.tipos()) {

			comboBoxTipo.addItem(tc);

		}

		JComboBox<Pais> comboBoxPais = new JComboBox<Pais>();
		comboBoxPais.setBounds(594, 150, 118, 22);
		panel.add(comboBoxPais);

		PaisBO paisbo = new PaisBO();
		for (Pais p : paisbo.paises()) {
			comboBoxPais.addItem(p);
		}

		JLabel lblPais = new JLabel("Pa\u00EDs:");
		lblPais.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblPais.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPais.setBounds(522, 154, 60, 14);
		panel.add(lblPais);

		JCheckBox rdbtnPorSabor = new JCheckBox("Por Sabor");
		rdbtnPorSabor.setFont(new Font("Arial", Font.BOLD, 11));
		rdbtnPorSabor.setBounds(80, 201, 108, 23);
		panel.add(rdbtnPorSabor);

		JComboBox<Sabor> comboBoxSabor = new JComboBox<Sabor>();
		comboBoxSabor.setBounds(80, 240, 118, 22);
		panel.add(comboBoxSabor);

		SaborBO saborbo = new SaborBO();
		for (Sabor s : saborbo.sabores()) {
			comboBoxSabor.addItem(s);
		}

		JLabel lblSabor = new JLabel("Sabor:");
		lblSabor.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblSabor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSabor.setBounds(10, 244, 60, 14);
		panel.add(lblSabor);

		JLabel lblColoracao = new JLabel("Colora\u00E7\u00E3o:");
		lblColoracao.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblColoracao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblColoracao.setBounds(230, 244, 89, 14);
		panel.add(lblColoracao);

		JComboBox<Coloracao> comboBoxColoracao = new JComboBox<Coloracao>();
		comboBoxColoracao.setBounds(329, 240, 118, 22);
		panel.add(comboBoxColoracao);

		ColoracaoBO coloracaobo = new ColoracaoBO();
		for (Coloracao c : coloracaobo.cores()) {
			comboBoxColoracao.addItem(c);
		}

		JCheckBox rdbtnPorColoracao = new JCheckBox("Por Colora\u00E7\u00E3o");
		rdbtnPorColoracao.setFont(new Font("Arial", Font.BOLD, 11));
		rdbtnPorColoracao.setBounds(329, 201, 108, 23);
		panel.add(rdbtnPorColoracao);
		lblMsgPesquisar.setFont(new Font("Tahoma", Font.BOLD, 10));

		lblMsgPesquisar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsgPesquisar.setBounds(298, 335, 363, 14);
		panel.add(lblMsgPesquisar);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblMsgPesquisar.setText("");
				String nome = null;
				String tipo = null;
				String sabor = null;
				String coloracao = null;
				String pais = null;

				if (textFieldNome.getText().isBlank() && rdbtnPorNome.isSelected()) {
					lblMsgPesquisar.setForeground(Color.RED);
					lblMsgPesquisar.setText("preencha o campo nome corretamente");
					return;
				}

				if (!textFieldNome.getText().isBlank() && rdbtnPorNome.isSelected()) {
					nome = textFieldNome.getText();
				}

				if (rdbtnPorTipo.isSelected()) {
					tipo = String.valueOf(((TipoCerveja) comboBoxTipo.getSelectedItem()).getId());
				}

				if (rdbtnPorSabor.isSelected()) {
					sabor = String.valueOf(((Sabor) comboBoxSabor.getSelectedItem()).getId());
				}

				if (rdbtnPorColoracao.isSelected()) {
					coloracao = String.valueOf(((Coloracao) comboBoxColoracao.getSelectedItem()).getId());
				}

				if (rdbtnPorPais.isSelected()) {
					pais = String.valueOf(((Pais) comboBoxPais.getSelectedItem()).getId());
				}

				if (nome == null && tipo == null && sabor == null && coloracao == null && pais == null) {
					lblMsgPesquisar.setForeground(Color.RED);
					lblMsgPesquisar.setText("selecione pelo menos 1 campo para realizar a pesquisa");
					return;
				}

				montarResultadoPesquisa(nome, tipo, sabor, coloracao, pais);
			}
		});
		btnPesquisar.setBounds(386, 301, 171, 23);
		panel.add(btnPesquisar);

		JLabel lblPesquiseUmaCerveja = new JLabel("Pesquise uma Cerveja!");
		lblPesquiseUmaCerveja.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesquiseUmaCerveja.setForeground(new Color(255, 69, 0));
		lblPesquiseUmaCerveja.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPesquiseUmaCerveja.setBounds(329, 25, 228, 14);
		panel.add(lblPesquiseUmaCerveja);

		tblCervejas = new JTable();
		tblCervejas.setBorder(new LineBorder(new Color(255, 102, 0)));
		tblCervejas.setBackground(new Color(255, 204, 153));
		tblCervejas.getTableHeader().setReorderingAllowed(false);
		tblCervejas.getTableHeader().setBackground(new Color(255, 204, 153));
		tblCervejas.getTableHeader().setForeground(Color.BLACK);
		tblCervejas.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Tipo", "Coloração", "Sabor", "Pais" }) {
			/**
				 * 
				 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		});

		tblCervejas.setBounds(40, 121, 191, 112);

		panel.add(tblCervejas);
		JScrollPane scroll = new JScrollPane(tblCervejas);
		scroll.setViewportBorder(new LineBorder(new Color(255, 102, 0)));
		scroll.setBounds(37, 416, 645, 410);
		panel.add(scroll);

		JLabel lblMsgPesquisar_1 = new JLabel("");
		lblMsgPesquisar_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsgPesquisar_1.setBounds(692, 495, 255, 14);
		panel.add(lblMsgPesquisar_1);

		btnVerDetalhes = new JButton("Ver Detalhes");
		btnVerDetalhes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMsgPesquisar_1.setText("");
			}
		});
		btnVerDetalhes.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnVerDetalhes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verDetalhesCerveja(lblMsgPesquisar_1);
			}
		});
		btnVerDetalhes.setBounds(692, 464, 161, 23);
		panel.add(btnVerDetalhes);

		framePesquisa.setVisible(true);

	}

	private void verDetalhesCerveja(JLabel lblMsgPesquisar_1) {
		Cerveja cerveja = new Cerveja();
		CervejaBO cbo = new CervejaBO();
		if (tblCervejas.getSelectedRow() == -1) {
			lblMsgPesquisar.setForeground(Color.RED);
			lblMsgPesquisar_1.setText("Selecione uma Cerveja!");
			return;
		}

		int linha = tblCervejas.getSelectedRow();
		String nome = (String) tblCervejas.getValueAt(linha, 0);
		cerveja.setNome(nome);
		try {
			cerveja = cbo.findByName(nome);
		} catch (Exception e2) {
			e2.printStackTrace();
			return;
		}
		try {
			TelaDetalhesCerveja detalhesCerveja = new TelaDetalhesCerveja();
			detalhesCerveja.telaDetalhesCerveja(cerveja);
		} catch (Exception e1) {

			e1.printStackTrace();
			return;
		}
	}

	private static void montarResultadoPesquisa(String nome, String tipo, String sabor, String coloracao, String pais) {

		DefaultTableModel modelo = (DefaultTableModel) tblCervejas.getModel();
		modelo.setRowCount(0);
		tblCervejas.setModel(modelo);

		try {
			List<Cerveja> lista = pesquisarCervejas(nome, tipo, sabor, coloracao, pais);
			if (lista.isEmpty()) {
				lblMsgPesquisar.setText("nenhuma Cerveja encontrada");
				return;
			}
			for (Cerveja c : lista) {

				if (c.getCervejeiro().getStatus().contentEquals("Ativo")) {
					modelo.addRow(new Object[] { c.getNome(), c.getType(), c.getColoracao(), c.getFlavor(),
							c.getCountryOrigin()

					});
				}

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao Pesquisar: " + e.getMessage());
		}
	}

	private static List<Cerveja> pesquisarCervejas(String nome, String tipo, String sabor, String coloracao,
			String pais) throws Exception {
		CervejaBO cbo = new CervejaBO();

		return cbo.pesquisaCervejas(nome, tipo, sabor, coloracao, pais);
	}
}
