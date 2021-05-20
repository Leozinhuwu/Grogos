package br.edu.unifacear.telas;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class TelaPrincipalApreciador {
	
	private static JFrame framePrincipal;
	public static String usuarioLogado;

	
	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public static void telaPrincipal() throws Exception {

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

		framePrincipal.setVisible(true);

	}
}
