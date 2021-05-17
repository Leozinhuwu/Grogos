package br.edu.unifacear.telas;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.edu.unifacear.bo.ApreciadorBO;
import br.edu.unifacear.bo.CervejeiroBO;
import br.edu.unifacear.bo.Login;
import br.edu.unifacear.bo.TokenBO;
import br.edu.unifacear.classes.Apreciador;
import br.edu.unifacear.classes.Cervejeiro;
import br.edu.unifacear.classes.Token;

public class TelaAdm {
	private static final long serialVersionUID = 1L;
	private static JFrame frameMain;
	public static String usuarioLogado;
	private static JTextField textToken;
	private static JTextField textEmailCervejeiro;
	private static JTextField textEmailApreciador;
	
	
	
	
	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public static void telaAdm() throws Exception {

		
//		cadastro.registerUser(nome, senha, idade, email);

		// imagem

		// labels e botoes do jFrame
		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(Color.WHITE);
		frameMain = new JFrame();
		frameMain.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\leo4_\\Desktop\\GrogosPesq.jpg"));
		frameMain.setSize(857, 557);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.setLocation(500, 250);

		frameMain.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblTitle = new JLabel("Grogos");
		lblTitle.setForeground(Color.RED);
		lblTitle.setBounds(292, 25, 46, 14);
		panel.add(lblTitle);

		JLabel lblGrogosImg = new JLabel("");
		lblGrogosImg.setIcon(new ImageIcon("C:\\Users\\leo4_\\Desktop\\gragas.png"));
		lblGrogosImg.setBounds(453, 37, 204, 263);
		panel.add(lblGrogosImg);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frameMain.dispose();
			}
		});
		btnSair.setBounds(21, 37, 89, 23);
		panel.add(btnSair);
		
		JLabel lblDeletarCervejeiro = new JLabel("Deletar conta cervejeiro");
		lblDeletarCervejeiro.setBounds(78, 221, 177, 14);
		panel.add(lblDeletarCervejeiro);
		
		textToken = new JTextField();
		textToken.setBounds(78, 156, 148, 20);
		panel.add(textToken);
		textToken.setColumns(10);
		
		JButton btnGerar = new JButton("Gerar");
		btnGerar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Token tokenc = new Token();
				TokenBO tokenbo = new TokenBO();
				tokenc.setStatus("valido");
				tokenc.setNome(getGerarToken());
				
				try {
					tokenbo.salvar(tokenc);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				textToken.setText(tokenc.getNome());
				
			}

			private String getGerarToken() {
				Random rand = new Random(); //instance of random class
			    int upperbound = 99999;
			    Integer int_random = rand.nextInt(upperbound);
				String token = "grogosToken" + int_random.toString();
				
				return token;
				
			}
		});
		btnGerar.setBounds(78, 122, 124, 23);
		panel.add(btnGerar);
		
		JLabel lblTokenText = new JLabel("Token:");
		lblTokenText.setBounds(21, 156, 46, 14);
		panel.add(lblTokenText);
		
		JLabel lblGerarPasse_1 = new JLabel("Gerar passe para Cervejeiro");
		lblGerarPasse_1.setBounds(78, 97, 177, 14);
		panel.add(lblGerarPasse_1);
		
		JLabel lblEmailCervejeiro = new JLabel("Email Cervejeiro:");
		lblEmailCervejeiro.setBounds(21, 250, 106, 14);
		panel.add(lblEmailCervejeiro);
		
		textEmailCervejeiro = new JTextField();
		textEmailCervejeiro.setColumns(10);
		textEmailCervejeiro.setBounds(148, 247, 148, 20);
		panel.add(textEmailCervejeiro);
		
		JLabel lblMsgCervejeiro = new JLabel("");
		lblMsgCervejeiro.setBounds(39, 322, 204, 14);
		panel.add(lblMsgCervejeiro);
		
		
		JButton btnDeletarCervejeiro = new JButton("Deletar");
		btnDeletarCervejeiro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cervejeiro cervejeiro = new Cervejeiro();
				CervejeiroBO cbo = new CervejeiroBO();
				cervejeiro.setEmail(textEmailCervejeiro.getText());
				Cervejeiro cerv = (Cervejeiro) cbo.findCervejeiro(cervejeiro);
				
				if(cerv == null) {
					lblMsgCervejeiro.setText("Cervejeiro não encontrado");
				}else {
					try {
						
						cbo.deletar(cerv);
						lblMsgCervejeiro.setText("Cervejeiro deletado");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnDeletarCervejeiro.setBounds(78, 289, 124, 23);
		panel.add(btnDeletarCervejeiro);
		
		JLabel lblMsgApreciador = new JLabel("");
		lblMsgApreciador.setBounds(51, 439, 204, 14);
		panel.add(lblMsgApreciador);
		
		JButton btnDeletarApreciador = new JButton("Deletar");
		btnDeletarApreciador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Apreciador apreciador = new Apreciador();
				ApreciadorBO abo = new ApreciadorBO();
				apreciador.setEmail(textEmailApreciador.getText());
				Apreciador apre = (Apreciador) abo.findApreciador(apreciador);
				
				if(apre == null) {
					lblMsgApreciador.setText("Apreciador não encontrado");
				}else {
					try {
						
						abo.deletar(apre);
						lblMsgApreciador.setText("Apreciador deletado");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnDeletarApreciador.setBounds(78, 405, 124, 23);
		panel.add(btnDeletarApreciador);
		
		textEmailApreciador = new JTextField();
		textEmailApreciador.setColumns(10);
		textEmailApreciador.setBounds(148, 363, 148, 20);
		panel.add(textEmailApreciador);
		
		JLabel lblEmailApreciador = new JLabel("Email Apreciador:");
		lblEmailApreciador.setBounds(21, 366, 106, 14);
		panel.add(lblEmailApreciador);
		
		JLabel lblDeletarContaApreciador = new JLabel("Deletar conta apreciador");
		lblDeletarContaApreciador.setBounds(78, 337, 177, 14);
		panel.add(lblDeletarContaApreciador);
		
		frameMain.setVisible(true);

	}
}
