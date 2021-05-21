package br.edu.unifacear.telas;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaGerenciarDadosApreciador {
	private static JFrame framePrincipal;
	public static String usuarioLogado;

	
	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public static void telaGerenciarDadosApreciador() throws Exception {

//		cadastro.registerUser(nome, senha, idade, email);

		// imagem

		// labels e botoes do jFrame
		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(Color.WHITE);
		framePrincipal = new JFrame();
		framePrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\leo4_\\Desktop\\GrogosPesq.jpg"));
		framePrincipal.setSize(971, 772);
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrincipal.setLocation(500, 250);

		framePrincipal.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					TelaPrincipalApreciador.telaPrincipal();
				} catch (Exception e1) {
					// erro ao voltar
					e1.printStackTrace();
					return;
				}
				framePrincipal.dispose();
			}
		});
		btnVoltar.setBounds(21, 11, 89, 23);
		panel.add(btnVoltar);
		
		JLabel lblBemVindo = new JLabel("Bem vindo ");
		lblBemVindo.setBounds(72, 55, 76, 14);
		panel.add(lblBemVindo);
		
		JLabel lblNomeApreciadorLogado = new JLabel("Nome Apreciador");
		lblNomeApreciadorLogado.setBounds(132, 55, 148, 14);
		panel.add(lblNomeApreciadorLogado);

		framePrincipal.setVisible(true);

	}


}
