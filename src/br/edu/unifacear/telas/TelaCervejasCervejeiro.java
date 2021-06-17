package br.edu.unifacear.telas;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.edu.unifacear.bo.CervejaBO;

import br.edu.unifacear.classes.Cerveja;
import br.edu.unifacear.classes.Cervejeiro;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TelaCervejasCervejeiro {

	private static JFrame frameMinhasCervejas;
	private static JTable tblCervejas;
	private static JLabel lblCerveja;
	private static JButton btnVerDetalhes;
	private static JButton btnExcluir;

	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public void telaMinhasCervejas() throws Exception {

		// labels e botoes do jFrame
		JPanel contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBackground(new Color(244, 164, 96));
		frameMinhasCervejas = new JFrame();
		frameMinhasCervejas.setSize(1000, 700);
		frameMinhasCervejas.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frameMinhasCervejas.setLocation(500, 150);
		frameMinhasCervejas.getContentPane().add(contentPane);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		lblCerveja = new JLabel("Cervejas Adicionadas");
		lblCerveja.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCerveja.setBounds(40, 78, 206, 14);
		contentPane.add(lblCerveja);

		tblCervejas = new JTable();
		tblCervejas.getTableHeader().setReorderingAllowed(false);

		tblCervejas.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Código", "Nome" }) {
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
		scroll.setBounds(40, 103, 645, 410);
		contentPane.add(scroll);

		btnVerDetalhes = new JButton("Ver Detalhes");
		btnVerDetalhes.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnVerDetalhes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cerveja cerveja = new Cerveja();
				CervejaBO cbo = new CervejaBO();
				if (tblCervejas.getSelectedRow() == -1) {

					return;
				}

				int linha = tblCervejas.getSelectedRow();
				int codigo = (int) tblCervejas.getValueAt(linha, 0);

				cerveja.setId(codigo);
				cerveja = cbo.findById(cerveja);
				try {
					TelaDetalhesCerveja detalhesCerveja = new TelaDetalhesCerveja();
					detalhesCerveja.telaDetalhesCerveja(cerveja);
				} catch (Exception e1) {

					e1.printStackTrace();
					return;
				}
			}
		});
		btnVerDetalhes.setBounds(695, 136, 139, 23);
		contentPane.add(btnVerDetalhes);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cerveja cerveja = new Cerveja();
				CervejaBO cbo = new CervejaBO();
				if (tblCervejas.getSelectedRow() == -1) {

					return;
				}

				int linha = tblCervejas.getSelectedRow();
				int codigo = (int) tblCervejas.getValueAt(linha, 0);

				cerveja.setId(codigo);
				cerveja = cbo.findById(cerveja);
				try {
					cbo.deletar(cerveja);
				} catch (Exception e1) {

					e1.printStackTrace();
					return;
				}
				pesquisarCervejas();
			}
		});
		btnExcluir.setBounds(695, 170, 139, 23);
		contentPane.add(btnExcluir);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaMenuCervejeiro telaMenuCervejeiros = new TelaMenuCervejeiro();
					telaMenuCervejeiros.telaMenuCervejeiro();
				} catch (Exception e1) {
					e1.printStackTrace();
					return;
				}
				frameMinhasCervejas.dispose();
			}
		});
		btnVoltar.setBounds(10, 11, 89, 23);
		contentPane.add(btnVoltar);

		JLabel lblNewLabel = new JLabel("Suas Cervejas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setBounds(325, 15, 206, 19);
		contentPane.add(lblNewLabel);

		frameMinhasCervejas.setVisible(true);
		pesquisarCervejas();
	}

	private static void pesquisarCervejas() {

		Cervejeiro user = (Cervejeiro) TelaLogin.usuarioLogado;
		DefaultTableModel modelo = (DefaultTableModel) tblCervejas.getModel();
		modelo.setRowCount(0);
		tblCervejas.setModel(modelo);

		try {
			List<Cerveja> lista = getCervejas(user);

			for (Cerveja c : lista) {
				modelo.addRow(new Object[] { c.getId(), c.getNome() });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro consultando: " + e.getMessage());
		}
	}

	private static List<Cerveja> getCervejas(Cervejeiro user) throws Exception {
		CervejaBO cbo = new CervejaBO();

		return cbo.findByUser(user);
	}
}
