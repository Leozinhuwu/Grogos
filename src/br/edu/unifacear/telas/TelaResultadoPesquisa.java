package br.edu.unifacear.telas;

import java.awt.Color;
import java.awt.Toolkit;
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
import br.edu.unifacear.classes.TipoCerveja;

import java.awt.Font;

public class TelaResultadoPesquisa {
	private static JFrame frameResultadoPesquisa;
	private static JTable tblCervejas;
	private static JLabel lblCerveja;
	private static JButton btnVerDetalhes;
	private static JLabel lblResultadosDaSua;

	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public static void telaResultadoPesquisa(String nome, String tipo, String sabor, String coloracao, String pais) throws Exception {
		
		
		
		
		// labels e botoes do jFrame
		JPanel contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBackground(Color.WHITE);
		frameResultadoPesquisa = new JFrame();
		frameResultadoPesquisa.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\leo4_\\Desktop\\GrogosPesq.jpg"));
		frameResultadoPesquisa.setSize(1000, 700);
		frameResultadoPesquisa.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frameResultadoPesquisa.setLocation(500, 150);
		frameResultadoPesquisa.getContentPane().add(contentPane);

		
		
	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		lblCerveja = new JLabel("Suas Cervejas");
		lblCerveja.setBounds(40, 78, 206, 14);
		contentPane.add(lblCerveja);
		
		tblCervejas = new JTable();
		tblCervejas.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Nome", "Tipo" , "Coloração", "Sabor" , "Pais"
				}
			) {
			/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		});

		tblCervejas.setBounds(40, 121, 191, 112);
		
		contentPane.add(tblCervejas);
		JScrollPane scroll = new JScrollPane(tblCervejas);
		scroll.setBounds(40, 103, 645, 410);
		contentPane.add(scroll);

		btnVerDetalhes = new JButton("Ver Detalhes");
		btnVerDetalhes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cerveja cerveja = new Cerveja();
				CervejaBO cbo = new CervejaBO();
				if(tblCervejas.getSelectedRow() == -1) {
					System.out.println("uwu");
					return;
				}
				
				int linha = tblCervejas.getSelectedRow();
				String nome = (String)tblCervejas.getValueAt(linha, 0);
				System.out.println(nome);
				cerveja.setNome(nome);
				try {
					cerveja = cbo.findByName(nome);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					TelaDetalhesCerveja.telaDetalhesCerveja(cerveja);
				} catch (Exception e1) {
					
					e1.printStackTrace();
					return;
				}
			}
		});
		btnVerDetalhes.setBounds(696, 175, 115, 23);
		contentPane.add(btnVerDetalhes);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaPesquisa.telaPesquisa();
				} catch (Exception e1) {
					System.out.println("erro ao voltar");
					e1.printStackTrace();
					return;
				}
				frameResultadoPesquisa.dispose();
			}
		});
		btnVoltar.setBounds(10, 11, 89, 23);
		contentPane.add(btnVoltar);
		
		lblResultadosDaSua = new JLabel("Resultados da sua pesquisa!");
		lblResultadosDaSua.setForeground(new Color(255, 102, 51));
		lblResultadosDaSua.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblResultadosDaSua.setBounds(299, 20, 265, 14);
		contentPane.add(lblResultadosDaSua);
		
		frameResultadoPesquisa.setVisible(true);
		pesquisarGrupo(nome, tipo, sabor, coloracao, pais);
	}
	


	private static void pesquisarGrupo(String nome, String tipo, String sabor, String coloracao, String pais) {
	
	
		DefaultTableModel modelo = (DefaultTableModel)tblCervejas.getModel();
		modelo.setRowCount(0);
		tblCervejas.setModel(modelo);
		

		try {
			List<Cerveja>  lista  = pesquisarCervejas(nome, tipo, sabor, coloracao, pais);
			
			for (Cerveja c : lista) {
				modelo.addRow(
						new Object[] {
								c.getNome(),
								c.getType(),
								c.getColoracao(),
								c.getFlavor(),
								c.getCountryOrigin()
								
						}
					);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,  "Erro consultando: "+e.getMessage());
		}
	}


	

	private static List<Cerveja> pesquisarCervejas(String nome, String tipo, String sabor, String coloracao, String pais) throws Exception {
		CervejaBO cbo = new CervejaBO();
		
		return cbo.pesquisaCervejas(nome, tipo, sabor, coloracao, pais);
	}
}
