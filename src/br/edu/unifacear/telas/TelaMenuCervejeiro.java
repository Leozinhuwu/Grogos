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

	public static void telaMenuUser() throws Exception {

		// labels e botoes do jFrame
		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(Color.WHITE);
		frameMenuUser = new JFrame();
		frameMenuUser.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\leo4_\\Desktop\\GrogosPesq.jpg"));
		frameMenuUser.setSize(750, 500);
		frameMenuUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMenuUser.setLocation(500, 250);

		frameMenuUser.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnGerenciarDados = new JButton("Gerenciar Dados");
		btnGerenciarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaCervejasCervejeiro.telaPerfil();
				} catch (Exception e1) {
				
					e1.printStackTrace();
				}
				frameMenuUser.dispose();
			}
		});
		btnGerenciarDados.setBounds(98, 115, 172, 23);
		panel.add(btnGerenciarDados);

		JButton btnPesquisar = new JButton("Minhas Cervejas");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// chamar tela de pesquisa de cervejas
			}
		});
		btnPesquisar.setBounds(98, 149, 172, 23);
		panel.add(btnPesquisar);

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

		JLabel lblGrogosImg = new JLabel("");
		lblGrogosImg.setIcon(new ImageIcon("C:\\Users\\leo4_\\Desktop\\gragas.png"));
		lblGrogosImg.setBounds(395, 100, 204, 263);
		panel.add(lblGrogosImg);

		frameMenuUser.setVisible(true);

	}
}
