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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.edu.unifacear.bo.ApreciadorBO;
import br.edu.unifacear.bo.CervejaBO;
import br.edu.unifacear.classes.Apreciador;
import br.edu.unifacear.classes.Cerveja;
import javax.swing.SwingConstants;

public class TelaCervejasFavoritas {
	private static JFrame frameCervejasFavoritas;
	private static JTable tblCervejas;
	private static JLabel lblCerveja;
	private static JButton btnVerDetalhes;
	private static JButton btnRemoverFavoritos;
	private static JLabel lblMsgRemover;

	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public void telaCervejasFavoritas() throws Exception {

		JPanel contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBackground(new Color(244, 164, 96));
		frameCervejasFavoritas = new JFrame();
		frameCervejasFavoritas
				.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\leo4_\\Desktop\\GrogosPesq.jpg"));
		frameCervejasFavoritas.setSize(971, 772);
		frameCervejasFavoritas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameCervejasFavoritas.setLocation(500, 250);

		frameCervejasFavoritas.getContentPane().add(contentPane);
		contentPane.setLayout(null);

		lblCerveja = new JLabel("Suas Cervejas Favoritas");
		lblCerveja.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCerveja.setBounds(40, 78, 206, 14);
		contentPane.add(lblCerveja);

		tblCervejas = new JTable();
		tblCervejas.setFont(new Font("Tahoma", Font.BOLD, 11));
		tblCervejas.getTableHeader().setReorderingAllowed(false);

		tblCervejas.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Tipo", "Coloração", "Sabor", "País" }) {
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
		contentPane.add(tblCervejas);
		JScrollPane scroll = new JScrollPane(tblCervejas);
		scroll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMsgRemover.setText("");
			}
		});
		scroll.setBounds(40, 103, 645, 410);
		contentPane.add(scroll);

		btnVerDetalhes = new JButton("Ver Detalhes");
		btnVerDetalhes.setFont(new Font("Arial Black", Font.BOLD, 12));

		btnVerDetalhes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cerveja cerveja = new Cerveja();
				CervejaBO cbo = new CervejaBO();
				if (tblCervejas.getSelectedRow() == -1) {
					lblMsgRemover.setForeground(Color.RED);
					lblMsgRemover.setText("Nenhuma Cerveja Selecionada");
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
		});
		btnVerDetalhes.setBounds(695, 136, 142, 23);
		contentPane.add(btnVerDetalhes);

		btnRemoverFavoritos = new JButton("Remover");
		btnRemoverFavoritos.setFont(new Font("Arial Black", Font.BOLD, 12));

		btnRemoverFavoritos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerCerveja();
			}
		});
		btnRemoverFavoritos.setBounds(695, 170, 142, 23);
		contentPane.add(btnRemoverFavoritos);

		JLabel lblNewLabel = new JLabel("Gerenciar Cervejas Favoritas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setBounds(296, 20, 237, 14);
		contentPane.add(lblNewLabel);

		lblMsgRemover = new JLabel("");
		lblMsgRemover.setBounds(695, 204, 190, 14);
		contentPane.add(lblMsgRemover);

		frameCervejasFavoritas.setVisible(true);
		cervejasFavoritas();
	}

	private void removerCerveja() {
		Cerveja cerveja = new Cerveja();
		CervejaBO cbo = new CervejaBO();
		ApreciadorBO abo = new ApreciadorBO();
		if (tblCervejas.getSelectedRow() == -1) {
			lblMsgRemover.setForeground(Color.RED);
			lblMsgRemover.setText("Nenhuma Cerveja Selecionada");
			return;
		}

		int linha = tblCervejas.getSelectedRow();
		String nome = (String) tblCervejas.getValueAt(linha, 0);
		cerveja.setNome(nome);

		try {
			cerveja = cbo.findByName(nome);
		} catch (Exception e2) {
			lblMsgRemover.setForeground(Color.RED);
			lblMsgRemover.setText("Erro ao buscar Cerveja");
			e2.printStackTrace();
			return;
		}

		Apreciador apreLogado = (Apreciador) TelaLogin.usuarioLogado;
		apreLogado.removeCervejaFavoritas(cerveja);

		try {
			abo.alterar(apreLogado);
		} catch (Exception e1) {
			lblMsgRemover.setForeground(Color.RED);
			lblMsgRemover.setText("Erro ao remover Cerveja");

			e1.printStackTrace();
			return;
		}
		lblMsgRemover.setForeground(Color.GREEN.darker());
		lblMsgRemover.setText("Cerveja Removida!!!");
		cervejasFavoritas();
	}

	private static void cervejasFavoritas() {

		DefaultTableModel modelo = (DefaultTableModel) tblCervejas.getModel();
		modelo.setRowCount(0);
		tblCervejas.setModel(modelo);
		Apreciador apreLogado = (Apreciador) TelaLogin.usuarioLogado;

		try {
			List<Cerveja> lista = apreLogado.getCervejasFavoritas();

			for (Cerveja c : lista) {
				modelo.addRow(new Object[] { c.getNome(), c.getType(), c.getColoracao(), c.getFlavor(),
						c.getCountryOrigin() });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao consultar Cerveja: " + e.getMessage());
		}
	}

}
