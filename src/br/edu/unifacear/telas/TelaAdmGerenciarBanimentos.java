package br.edu.unifacear.telas;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.unifacear.bo.ApreciadorBO;
import br.edu.unifacear.bo.CervejeiroBO;
import br.edu.unifacear.classes.Apreciador;
import br.edu.unifacear.classes.Cervejeiro;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;

public class TelaAdmGerenciarBanimentos {

	private static JFrame frameMain;
	private static JLabel lblMsgCervejeiro = new JLabel("");
	private static JLabel lblMsgApreciador = new JLabel("");
	private static JTextField textField;
	private static JTextField textFieldApreciador;

	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public void telaAdmDesativarCervejeiroApreciador() throws Exception {
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(new Color(244, 164, 96));
		frameMain = new JFrame();
		frameMain.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\leo4_\\Desktop\\GrogosPesq.jpg"));
		frameMain.setSize(977, 636);
		frameMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameMain.setLocation(500, 100);

		frameMain.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblTitle = new JLabel("Gerenciamento de Contas");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(255, 69, 0));
		lblTitle.setBounds(336, 11, 238, 23);
		panel.add(lblTitle);

		JLabel lblGerenciarStatusCervejeiro = new JLabel("Gerenciar Status Cervejeiro");
		lblGerenciarStatusCervejeiro.setHorizontalAlignment(SwingConstants.CENTER);
		lblGerenciarStatusCervejeiro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGerenciarStatusCervejeiro.setBounds(124, 139, 396, 14);
		panel.add(lblGerenciarStatusCervejeiro);

		JLabel lblEmailCervejeiro = new JLabel("Selecionar Cervejeiro:");
		lblEmailCervejeiro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmailCervejeiro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailCervejeiro.setBounds(26, 181, 159, 14);
		panel.add(lblEmailCervejeiro);
		lblMsgCervejeiro.setHorizontalAlignment(SwingConstants.CENTER);

		lblMsgCervejeiro.setBounds(167, 246, 301, 14);
		panel.add(lblMsgCervejeiro);
		lblMsgApreciador.setHorizontalAlignment(SwingConstants.CENTER);

		

		lblMsgApreciador.setBounds(167, 495, 301, 14);
		panel.add(lblMsgApreciador);
		
		JLabel lblCervejeiroSelecionado = new JLabel("Cervejeiro Selecionado:");
		lblCervejeiroSelecionado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCervejeiroSelecionado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCervejeiroSelecionado.setBounds(26, 219, 159, 14);
		panel.add(lblCervejeiroSelecionado);
		
		JComboBox<Cervejeiro> comboBox = new JComboBox<Cervejeiro>();
		CervejeiroBO cbo = new CervejeiroBO();
		
		for(Cervejeiro c: cbo.listar()) {
			comboBox.addItem(c);
		}
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(((Cervejeiro) comboBox.getSelectedItem()).getEmail());
				lblMsgCervejeiro.setText("");
			}
		});
		comboBox.setBounds(200, 177, 227, 22);
		panel.add(comboBox);
		
		JButton btnReativar = new JButton("Reativar");
		btnReativar.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnReativar.setForeground(new Color(0, 128, 0));
		btnReativar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CervejeiroBO cbo = new CervejeiroBO();
				Cervejeiro cerv = (Cervejeiro) comboBox.getSelectedItem();
				
				if(cerv.getStatus().contentEquals("Ativo")) {
					lblMsgCervejeiro.setText("Este Cervejeiro já está Ativo");
					return;
				}
				
				cerv.setStatus("Ativo");
				
				try {
					cbo.alterar(cerv);
				} catch (Exception e1) {
					lblMsgCervejeiro.setText("Erro ao Reativar Cervejeiro");
					e1.printStackTrace();
					return;
				}
				
				lblMsgCervejeiro.setText("Cervejeiro Reativado com Sucesso!!!");

			}
		});
		btnReativar.setBounds(439, 177, 124, 23);
		panel.add(btnReativar);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(199, 212, 230, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		
		
		
		JButton btnDeletarCervejeiro = new JButton("Desativar");
		btnDeletarCervejeiro.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnDeletarCervejeiro.setForeground(new Color(255, 0, 0));
		btnDeletarCervejeiro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				CervejeiroBO cbo = new CervejeiroBO();
				Cervejeiro cerv = (Cervejeiro) comboBox.getSelectedItem();
				
				if(cerv.getStatus().contentEquals("Desativado")) {
					lblMsgCervejeiro.setText("Este Cervejeiro já está Desativado");
					return;
				}
				
				cerv.setStatus("Desativado");
				
				try {
					cbo.alterar(cerv);
				} catch (Exception e1) {
					lblMsgCervejeiro.setText("Erro ao Desativar Cervejeiro");
					e1.printStackTrace();
					return;
				}
				
				lblMsgCervejeiro.setText("Cervejeiro Desativado com Sucesso!!!");

			}
		});
		btnDeletarCervejeiro.setBounds(439, 211, 124, 23);
		panel.add(btnDeletarCervejeiro);
		
		JLabel lblGerenciarStatusApreciador = new JLabel("Gerenciar Status Apreciador");
		lblGerenciarStatusApreciador.setHorizontalAlignment(SwingConstants.CENTER);
		lblGerenciarStatusApreciador.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGerenciarStatusApreciador.setBounds(135, 378, 396, 14);
		panel.add(lblGerenciarStatusApreciador);
		
		JLabel lblEmailApreciador = new JLabel("Selecionar Apreciador:");
		lblEmailApreciador.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmailApreciador.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailApreciador.setBounds(48, 420, 148, 14);
		panel.add(lblEmailApreciador);
		
		
		
		JComboBox<Apreciador> comboBoxApreciador = new JComboBox<Apreciador>();
		ApreciadorBO abo = new ApreciadorBO();
		
		for(Apreciador a: abo.listar()) {
			comboBoxApreciador.addItem(a);
		}
		
		comboBoxApreciador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMsgApreciador.setText("");
				textFieldApreciador.setText(((Apreciador) comboBoxApreciador.getSelectedItem()).getEmail());
			}
		});
		comboBoxApreciador.setBounds(211, 416, 227, 22);
		panel.add(comboBoxApreciador);

		
		JButton btnReativarApreciador = new JButton("Reativar");
		btnReativarApreciador.setForeground(new Color(0, 128, 0));
		btnReativarApreciador.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnReativarApreciador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApreciadorBO abo = new ApreciadorBO();
				Apreciador apre = (Apreciador) comboBoxApreciador.getSelectedItem();
				
				if(apre.getStatus().contentEquals("Ativo")) {
					lblMsgApreciador.setText("Este Apreciador já está Ativo");
					return;
				}
				
				apre.setStatus("Ativo");
				
				try {
					abo.alterar(apre);
				} catch (Exception e1) {
					lblMsgApreciador.setText("Erro ao Reativar Apreciador");
					e1.printStackTrace();
					return;
				}
				
				lblMsgApreciador.setText("Apreciador Reativado com Sucesso!!!");
			}
		});
		btnReativarApreciador.setBounds(450, 416, 124, 23);
		panel.add(btnReativarApreciador);
	
		
		JButton btnDesativarApreciador = new JButton("Desativar");
		btnDesativarApreciador.setForeground(new Color(255, 0, 0));
		btnDesativarApreciador.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnDesativarApreciador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApreciadorBO abo = new ApreciadorBO();
				Apreciador apre = (Apreciador) comboBoxApreciador.getSelectedItem();
				
				if(apre.getStatus().contentEquals("Desativado")) {
					lblMsgApreciador.setText("Este Apreciador já está Desativado");
					return;
				}
				
				apre.setStatus("Desativado");
				
				try {
					abo.alterar(apre);
				} catch (Exception e1) {
					lblMsgApreciador.setText("Erro ao Desativar Apreciador");
					e1.printStackTrace();
					return;
				}
				
				lblMsgApreciador.setText("Apreciador Desativado com Sucesso!!!");
				
			}
		});
		btnDesativarApreciador.setBounds(450, 450, 124, 23);
		panel.add(btnDesativarApreciador);
		
		textFieldApreciador = new JTextField();
		textFieldApreciador.setEditable(false);
		textFieldApreciador.setColumns(10);
		textFieldApreciador.setBounds(210, 451, 230, 23);
		panel.add(textFieldApreciador);
		
		JLabel lblApreciadorSelecionado = new JLabel("Apreciador Selecionado:");
		lblApreciadorSelecionado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApreciadorSelecionado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApreciadorSelecionado.setBounds(37, 458, 159, 14);
		panel.add(lblApreciadorSelecionado);
		
		
		
		frameMain.setVisible(true);
		
	}
}
