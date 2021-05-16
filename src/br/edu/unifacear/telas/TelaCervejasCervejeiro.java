package br.edu.unifacear.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.unifacear.bo.CervejaBO;
import br.edu.unifacear.bo.ApreciadorBO;
import br.edu.unifacear.classes.Cerveja;
import br.edu.unifacear.classes.Apreciador;


public class TelaCervejasCervejeiro {

	private static final long serialVersionUID = 1L;
	private static JFrame framePerfil;
	private static JTextField textFieldDC1;
	private static JTextField textDC2;
	private static JTextField textFieldDC3;
	private static JTextField textFieldDC4;
	private static JLabel lblNomeCerveja1; 

	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public static void telaPerfil() throws Exception {
		ApreciadorBO userBo = new ApreciadorBO();
		Apreciador user = new Apreciador();
		user.setEmail(TelaLogin.usuarioLogado);
		user.setNome(userBo.findUserName(user));
		
		
		// labels e botoes do jFrame
		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(Color.WHITE);
		framePerfil = new JFrame();
		framePerfil.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\leo4_\\Desktop\\GrogosPesq.jpg"));
		framePerfil.setSize(1000, 700);
		framePerfil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePerfil.setLocation(500, 150);

		framePerfil.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnVolta = new JButton("Voltar");
		btnVolta.setForeground(Color.BLACK);
		btnVolta.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		btnVolta.setBackground(Color.LIGHT_GRAY);
		btnVolta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaMenuCervejeiro.telaMenuUser();

				} catch (Exception e1) {

					e1.printStackTrace();
				}
				framePerfil.dispose();

			}
		});
		btnVolta.setBounds(10, 21, 89, 23);
		panel.add(btnVolta);
		
		JLabel lblNomeUsuario = new JLabel("Nome do Usuario");
		lblNomeUsuario.setBounds(389, 25, 129, 14);
		lblNomeUsuario.setText(user.getNome());
		panel.add(lblNomeUsuario);
		
		JLabel lblMinhasCervejas = new JLabel("Minhas Cervejas");
		lblMinhasCervejas.setBounds(62, 104, 122, 14);
		panel.add(lblMinhasCervejas);
		
		lblNomeCerveja1 = new JLabel();
		List <Cerveja> nomeCerveja1 = getCervejas(user);
		lblNomeCerveja1.setText(nomeCerveja1.get(0).getNome());
		lblNomeCerveja1.setBounds(62, 129, 101, 14);
		panel.add(lblNomeCerveja1);
		
		JLabel lblDC1 = new JLabel("Descri\u00E7\u00E3o");
		lblDC1.setBounds(62, 154, 62, 14);
		panel.add(lblDC1);
		
		textFieldDC1 = new JTextField();
		textFieldDC1.setText(nomeCerveja1.get(0).getDescription());
		textFieldDC1.setBounds(62, 179, 261, 167);
		panel.add(textFieldDC1);
		textFieldDC1.setColumns(10);
		
		textDC2 = new JTextField();
		textDC2.setColumns(10);
		textDC2.setBounds(62, 442, 261, 167);
		panel.add(textDC2);
		
		JLabel lblDC2 = new JLabel("Descri\u00E7\u00E3o");
		lblDC2.setBounds(62, 417, 62, 14);
		panel.add(lblDC2);
		
		JLabel lblNomeCerveja2 = new JLabel("nome Cerveja 2");
		lblNomeCerveja2.setBounds(62, 395, 101, 14);
		panel.add(lblNomeCerveja2);
		
		textFieldDC3 = new JTextField();
		textFieldDC3.setColumns(10);
		textFieldDC3.setBounds(668, 179, 261, 167);
		panel.add(textFieldDC3);
		
		JLabel lblDC3 = new JLabel("Descri\u00E7\u00E3o");
		lblDC3.setBounds(668, 154, 62, 14);
		panel.add(lblDC3);
		
		JLabel lblNomeCerveja3 = new JLabel("nome Cerveja 3");
		lblNomeCerveja3.setBounds(668, 129, 101, 14);
		panel.add(lblNomeCerveja3);
		
		textFieldDC4 = new JTextField();
		textFieldDC4.setColumns(10);
		textFieldDC4.setBounds(668, 442, 261, 167);
		panel.add(textFieldDC4);
		
		JLabel lblDC4 = new JLabel("Descri\u00E7\u00E3o");
		lblDC4.setBounds(668, 417, 62, 14);
		panel.add(lblDC4);
		
		JLabel lblNomeCerveja4 = new JLabel("nome Cerveja 4");
		lblNomeCerveja4.setBounds(668, 395, 101, 14);
		panel.add(lblNomeCerveja4);
		
		JLabel lblGrogosImg = new JLabel("");
		lblGrogosImg.setIcon(new ImageIcon("C:\\Users\\leo4_\\Desktop\\gragas.png"));
		lblGrogosImg.setBounds(374, 154, 235, 313);
		panel.add(lblGrogosImg);

		framePerfil.setVisible(true);

	}

	private static List<Cerveja> getCervejas(Apreciador user) throws Exception {
		CervejaBO cbo = new CervejaBO();
		
		return cbo.findByUser(user);
	}
}
