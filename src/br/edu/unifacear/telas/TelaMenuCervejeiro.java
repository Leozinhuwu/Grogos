package br.edu.unifacear.telas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TelaMenuCervejeiro extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JFrame frameMenuUser;

	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public static void telaMenuCervejeiro() throws Exception {

		// labels e botoes do jFrame
		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(Color.WHITE);
		frameMenuUser = new JFrame();
		frameMenuUser.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\leo4_\\Desktop\\GrogosPesq.jpg"));
		frameMenuUser.setSize(750, 500);
		frameMenuUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameMenuUser.setLocation(500, 250);

		frameMenuUser.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnGerenciarDados = new JButton("Gerenciar Dados");
		btnGerenciarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaGerenciarDadosCervejeiro.telaGerenciarDadosCervejeiro();
				} catch (Exception e1) {
				
					e1.printStackTrace();
				}
				frameMenuUser.dispose();
			}
		});
		btnGerenciarDados.setBounds(98, 115, 172, 23);
		panel.add(btnGerenciarDados);

		JButton btnMinhasCerveja = new JButton("Minhas Cervejas");
		btnMinhasCerveja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaCervejasCervejeiro.telaMinhasCervejas();
				} catch (Exception e1) {
					System.out.println("ye");
					e1.printStackTrace();
					return;
				}
				frameMenuUser.dispose();
					
			}
		});
		btnMinhasCerveja.setBounds(98, 149, 172, 23);
		panel.add(btnMinhasCerveja);

		JButton btnCadastrarCerveja = new JButton("Cadastrar Cervejas");
		btnCadastrarCerveja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaCadastroCerveja.telaCadastro();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frameMenuUser.dispose();
			}
		});
		btnCadastrarCerveja.setBounds(98, 183, 172, 23);
		panel.add(btnCadastrarCerveja);

		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaLogin.telaInicial();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frameMenuUser.dispose();

			}
		});
		btnLogout.setBounds(23, 27, 89, 23);
		panel.add(btnLogout);
		
		ImageIcon grogos = new ImageIcon(TelaMenuCervejeiro.class.getResource("/Grogos_Final_Edition.png"));
		JLabel lblGrogosImg = new JLabel(grogos);
		lblGrogosImg.setBounds(395, 100, 204, 263);
		panel.add(lblGrogosImg);
		
		JLabel lblBemvindoCervejeiro = new JLabel("Bem-vindo Cervejeiro");
		lblBemvindoCervejeiro.setForeground(new Color(255, 102, 51));
		lblBemvindoCervejeiro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBemvindoCervejeiro.setBounds(431, 31, 228, 14);
		panel.add(lblBemvindoCervejeiro);

		frameMenuUser.setVisible(true);

	}
}
