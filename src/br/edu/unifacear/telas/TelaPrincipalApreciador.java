package br.edu.unifacear.telas;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

import br.edu.unifacear.classes.Apreciador;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;


public class TelaPrincipalApreciador {
	
	private static JFrame framePrincipal;
	public static String usuarioLogado;

	
	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public static void telaPrincipal() throws Exception {
		
		Apreciador apreLogado = (Apreciador) TelaLogin.usuarioLogado;
		
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(Color.WHITE);
		framePrincipal = new JFrame();
		framePrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\leo4_\\Desktop\\GrogosPesq.jpg"));
		framePrincipal.setSize(971, 772);
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
		lblBemVindo.setBounds(72, 55, 362, 14);
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
					//mensagem erro
					return;
				}
				framePrincipal.dispose();
			}
		});
		btnGerenciarDados.setBounds(725, 25, 208, 23);
		panel.add(btnGerenciarDados);

		framePrincipal.setVisible(true);

	}
}
