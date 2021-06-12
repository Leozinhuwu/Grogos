package br.edu.unifacear.telas;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class TelaAdm {

	private static JFrame frameMain;


	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public static void telaAdm() throws Exception {

		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(Color.WHITE);
		frameMain = new JFrame();
		frameMain.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\leo4_\\Desktop\\GrogosPesq.jpg"));
		frameMain.setSize(923, 574);
		frameMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameMain.setLocation(500, 100);

		frameMain.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblTitle = new JLabel("Gerenciamento do Sistema");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(255, 102, 0));
		lblTitle.setBounds(302, 11, 286, 14);
		panel.add(lblTitle);

	

		JLabel lblDadosCervejaria = new JLabel("Adicionar Dados de Cadastro");
		lblDadosCervejaria.setHorizontalAlignment(SwingConstants.CENTER);
		lblDadosCervejaria.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDadosCervejaria.setBounds(10, 145, 286, 20);
		panel.add(lblDadosCervejaria);
		
		JButton btnNewButton = new JButton("Cerveja e Ingredientes");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaAdmManterCadastroCerveja.telaAdmCerveja();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(60, 210, 210, 23);
		panel.add(btnNewButton);
		
		JButton btnCervejeiroECervejaria = new JButton("Cervejeiro e Cervejaria");
		btnCervejeiroECervejaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaAdmManterCadastroCervejeiroCervejaria.telaManterCervejeiro();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCervejeiroECervejaria.setForeground(Color.BLACK);
		btnCervejeiroECervejaria.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCervejeiroECervejaria.setBounds(60, 176, 210, 23);
		panel.add(btnCervejeiroECervejaria);
		
		JLabel lblBanimentoCervejeiroE = new JLabel("Desativar Contas");
		lblBanimentoCervejeiroE.setHorizontalAlignment(SwingConstants.CENTER);
		lblBanimentoCervejeiroE.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBanimentoCervejeiroE.setBounds(10, 298, 286, 20);
		panel.add(lblBanimentoCervejeiroE);
		
		JButton btnCervejeiroEApreciador = new JButton("Cervejeiro e Apreciador");
		btnCervejeiroEApreciador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaAdmGerenciarBanimentos.telaAdmDesativarCervejeiroApreciador();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCervejeiroEApreciador.setForeground(Color.BLACK);
		btnCervejeiroEApreciador.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCervejeiroEApreciador.setBounds(60, 322, 210, 23);
		panel.add(btnCervejeiroEApreciador);
		
		ImageIcon grogos = new ImageIcon(TelaAdmManterCadastroCervejeiroCervejaria.class.getResource("/Grogos_Final_Edition.png")); 
		JLabel lblGrogosImg = new JLabel(grogos);
		lblGrogosImg.setBounds(265, 51, 632, 452);
		panel.add(lblGrogosImg);
		frameMain.setVisible(true);
	}
}
