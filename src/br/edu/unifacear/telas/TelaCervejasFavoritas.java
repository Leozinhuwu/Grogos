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

	public static void telaCervejasFavoritas() throws Exception {

		JPanel contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBackground(Color.WHITE);
		frameCervejasFavoritas = new JFrame();
		frameCervejasFavoritas
				.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\leo4_\\Desktop\\GrogosPesq.jpg"));
		frameCervejasFavoritas.setSize(971, 772);
		frameCervejasFavoritas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameCervejasFavoritas.setLocation(500, 250);

		frameCervejasFavoritas.getContentPane().add(contentPane);
		contentPane.setLayout(null);

		lblCerveja = new JLabel("Cervejas Favoritas");
		lblCerveja.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCerveja.setBounds(40, 78, 206, 14);
		contentPane.add(lblCerveja);

		tblCervejas = new JTable();
		tblCervejas.getTableHeader().setReorderingAllowed(false);

		tblCervejas.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Tipo" , "Coloração", "Sabor" , "Pais" }) {
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
				String nome = (String)tblCervejas.getValueAt(linha, 0);
				System.out.println(nome);
				cerveja.setNome(nome);
				try {
					cerveja = cbo.findByName(nome);
				} catch (Exception e2) {
					
					e2.printStackTrace();
					return;
				}
				try {
					TelaDetalhesCerveja.telaDetalhesCerveja(cerveja);
				} catch (Exception e1) {

					e1.printStackTrace();
					return;
				}
			}
		});
		btnVerDetalhes.setBounds(695, 136, 115, 23);
		contentPane.add(btnVerDetalhes);

		btnRemoverFavoritos = new JButton("Remover");
		
		btnRemoverFavoritos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cerveja cerveja = new Cerveja();
				CervejaBO cbo = new CervejaBO();
				ApreciadorBO abo = new ApreciadorBO();
				if (tblCervejas.getSelectedRow() == -1) {
					lblMsgRemover.setForeground(Color.RED);
					lblMsgRemover.setText("Nenhuma Cerveja Selecionada");
					return;
				}

				int linha = tblCervejas.getSelectedRow();
				String nome = (String)tblCervejas.getValueAt(linha, 0);
				System.out.println(nome);
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
				lblMsgRemover.setForeground(Color.GREEN);
				lblMsgRemover.setText("Cerveja Removida!!!");
				cervejasFavoritas();
			}
		});
		btnRemoverFavoritos.setBounds(695, 170, 115, 23);
		contentPane.add(btnRemoverFavoritos);

		JLabel lblNewLabel = new JLabel("Suas Cervejas Favoritas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(new Color(255, 102, 51));
		lblNewLabel.setBounds(343, 20, 190, 14);
		contentPane.add(lblNewLabel);
		
		lblMsgRemover = new JLabel("");
		lblMsgRemover.setBounds(695, 204, 190, 14);
		contentPane.add(lblMsgRemover);

		frameCervejasFavoritas.setVisible(true);
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
				modelo.addRow(new Object[] { c.getNome(),
						c.getType(),
						c.getColoracao(),
						c.getFlavor(),
						c.getCountryOrigin() });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro consultando: " + e.getMessage());
		}
	}

}
