package br.edu.unifacear.telas;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

import br.edu.unifacear.bo.CervejaBO;
import br.edu.unifacear.classes.Apreciador;
import br.edu.unifacear.classes.Cerveja;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TelaPrincipalApreciador {
	
	private static JFrame framePrincipal;
	public static String usuarioLogado;

	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public static void telaPrincipal() throws Exception {
		
		Apreciador apreLogado = (Apreciador) TelaLogin.usuarioLogado;
		List<Cerveja> aprelike = getCervejasLiked();
		System.out.println(aprelike.size());
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(Color.WHITE);
		framePrincipal = new JFrame();
		framePrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\leo4_\\Desktop\\GrogosPesq.jpg"));
		framePrincipal.setSize(1052, 768);
		framePrincipal.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		framePrincipal.setLocation(500, 250);

		framePrincipal.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					TelaLogin.telaInicial();
				} catch (Exception e1) {
					// erro ao voltar
					e1.printStackTrace();
					return;
				}
				framePrincipal.dispose();
			}
		});
		btnLogout.setBounds(21, 11, 89, 23);
		panel.add(btnLogout);
		
		JLabel lblBemVindo = new JLabel("Bem vindo " + apreLogado.getNome() );
		lblBemVindo.setBounds(423, 15, 362, 14);
		panel.add(lblBemVindo);
		
		
		JButton btnPesquisar = new JButton("Realizar uma pesquisa");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					TelaPesquisa.telaPesquisa();
				} catch (Exception e1) {
					//mensagem erro
					return;
				}
				framePrincipal.dispose();
			}
		});
		btnPesquisar.setBounds(72, 119, 208, 23);
		panel.add(btnPesquisar);
		
		JButton btnGerenciarDados = new JButton("Gerenciar meus Dados");
		btnGerenciarDados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					TelaGerenciarDadosApreciador.telaGerenciarDadosApreciador();
				} catch (Exception e1) {
					e1.printStackTrace();
					return;
				}
				framePrincipal.dispose();
			}
		});
		btnGerenciarDados.setBounds(818, 11, 208, 23);
		panel.add(btnGerenciarDados);
		
		JLabel lblCervejasGosto = new JLabel("Algumas Cervejas que talvez voc\u00EA goste!");
		lblCervejasGosto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCervejasGosto.setBounds(50, 187, 296, 14);
		panel.add(lblCervejasGosto);
		
		JLabel lblNomeCerveja1 = new JLabel();
		lblNomeCerveja1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCerveja1.setBounds(64, 233, 308, 14);
		panel.add(lblNomeCerveja1);
		lblNomeCerveja1.setText(aprelike.get(0).getNome());
		
		JEditorPane descricao1 = new JEditorPane();
		descricao1.setEditable(false);
		descricao1.setText(" " + aprelike.get(0).getDescription());
		descricao1.setBorder(new LineBorder(new Color(210, 105, 30)));
		descricao1.setBackground(Color.WHITE);
		descricao1.setBounds(120, 271, 252, 141);
		panel.add(descricao1);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescricao.setBounds(21, 271, 89, 14);
		panel.add(lblDescricao);
		
		JLabel lblNomeCerveja2 = new JLabel();
		lblNomeCerveja2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCerveja2.setBounds(64, 486, 308, 14);
		panel.add(lblNomeCerveja2);
		lblNomeCerveja2.setText(aprelike.get(1).getNome());
		JLabel lblDescricao_1 = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescricao_1.setBounds(21, 510, 89, 14);
		panel.add(lblDescricao_1);
		
		JEditorPane descricao2 = new JEditorPane();
		descricao2.setForeground(new Color(0, 0, 0));
		descricao2.setText(" " + aprelike.get(1).getDescription());
		descricao2.setEditable(false);
		descricao2.setBorder(new LineBorder(new Color(210, 105, 30)));
		descricao2.setBackground(new Color(255, 255, 255));
		descricao2.setBounds(120, 510, 252, 141);
		panel.add(descricao2);
		
		JLabel lblNomeCerveja3 = new JLabel();
		lblNomeCerveja3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCerveja3.setBounds(625, 233, 331, 14);
		panel.add(lblNomeCerveja3);
		lblNomeCerveja3.setText(aprelike.get(2).getNome());
		
		JLabel lblDescricao_2 = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescricao_2.setBounds(582, 271, 89, 14);
		panel.add(lblDescricao_2);
		
		JEditorPane descricao3 = new JEditorPane();
		descricao3.setText(" " + aprelike.get(2).getDescription());
		descricao3.setEditable(false);
		descricao3.setBorder(new LineBorder(new Color(210, 105, 30)));
		descricao3.setBackground(Color.WHITE);
		descricao3.setBounds(681, 271, 252, 141);
		panel.add(descricao3);
		
		JLabel lblNomeCerveja4 = new JLabel();
		lblNomeCerveja4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCerveja4.setBounds(625, 486, 331, 14);
		panel.add(lblNomeCerveja4);
		lblNomeCerveja4.setText(aprelike.get(3).getNome());
		
		JLabel lblDescricao_3 = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescricao_3.setBounds(582, 510, 89, 14);
		panel.add(lblDescricao_3);
		
		JEditorPane descricao4 = new JEditorPane();
		descricao4.setText(" " + aprelike.get(3).getDescription());
		descricao4.setEditable(false);
		descricao4.setBorder(new LineBorder(new Color(210, 105, 30)));
		descricao4.setBackground(Color.WHITE);
		descricao4.setBounds(681, 510, 252, 141);
		panel.add(descricao4);
		
		JButton btnDetalhesCerveja1 = new JButton("Ver Detalhes");
		btnDetalhesCerveja1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

				try {
					TelaDetalhesCerveja.telaDetalhesCerveja(aprelike.get(0));
				} catch (Exception e1) {
					
					e1.printStackTrace();
					return;
				}
			}
		});
		btnDetalhesCerveja1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDetalhesCerveja1.setBounds(263, 430, 109, 23);
		panel.add(btnDetalhesCerveja1);
		
		JPanel panelCerveja1 = new JPanel();
		panelCerveja1.setBackground(new Color(255, 218, 185));
		panelCerveja1.setBorder(new LineBorder(new Color(255, 165, 0)));
		panelCerveja1.setBounds(50, 212, 393, 253);
		panel.add(panelCerveja1);
		
		JButton btnDetalhesCerveja2 = new JButton("Ver Detalhes");
		btnDetalhesCerveja2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaDetalhesCerveja.telaDetalhesCerveja(aprelike.get(1));
				} catch (Exception e1) {
					
					e1.printStackTrace();
					return;
				}
			}
		});
		btnDetalhesCerveja2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDetalhesCerveja2.setBounds(263, 667, 109, 23);
		panel.add(btnDetalhesCerveja2);
		
		JPanel panelCerveja2 = new JPanel();
		panelCerveja2.setBorder(new LineBorder(new Color(255, 140, 0)));
		panelCerveja2.setBackground(new Color(255, 218, 185));
		panelCerveja2.setBounds(50, 476, 393, 230);
		panel.add(panelCerveja2);
		
		JButton btnDetalhesCerveja4 = new JButton("Ver Detalhes");
		btnDetalhesCerveja4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaDetalhesCerveja.telaDetalhesCerveja(aprelike.get(3));
				} catch (Exception e1) {
					
					e1.printStackTrace();
					return;
				}
			}
		});
		btnDetalhesCerveja4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDetalhesCerveja4.setBounds(824, 667, 109, 23);
		panel.add(btnDetalhesCerveja4);
		
		JButton btnDetalhesCerveja3 = new JButton("Ver Detalhes");
		btnDetalhesCerveja3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaDetalhesCerveja.telaDetalhesCerveja(aprelike.get(2));
				} catch (Exception e1) {
					
					e1.printStackTrace();
					return;
				}
			}
		});
		btnDetalhesCerveja3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDetalhesCerveja3.setBounds(824, 430, 109, 23);
		panel.add(btnDetalhesCerveja3);
		
		JPanel panelCerveja4 = new JPanel();
		panelCerveja4.setBorder(new LineBorder(new Color(255, 140, 0)));
		panelCerveja4.setBackground(new Color(255, 218, 185));
		panelCerveja4.setBounds(602, 476, 393, 230);
		panel.add(panelCerveja4);
		
		JPanel panelCerveja3 = new JPanel();
		panelCerveja3.setBorder(new LineBorder(new Color(255, 140, 0)));
		panelCerveja3.setBackground(new Color(255, 218, 185));
		panelCerveja3.setBounds(602, 212, 393, 253);
		panel.add(panelCerveja3);

		framePrincipal.setVisible(true);

	}
	
	protected static List<Cerveja> getCervejasLiked(){
		Apreciador apreLogado = (Apreciador) TelaLogin.usuarioLogado;
		CervejaBO cbo = new CervejaBO();
		return cbo.findLikedCervejas(apreLogado.getTipoCervejas());
	}
}
