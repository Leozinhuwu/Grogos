package br.edu.unifacear.telas;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import br.edu.unifacear.bo.ApreciadorBO;
import br.edu.unifacear.bo.CervejeiroBO;
import br.edu.unifacear.classes.Apreciador;
import br.edu.unifacear.classes.Cerveja;
import br.edu.unifacear.classes.Cervejeiro;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;
import javax.swing.BorderFactory;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaDetalhesCerveja {
	private static JFrame framePrincipal;
	public static String usuarioLogado;

	/**
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */

	public static void telaDetalhesCerveja(Cerveja cerveja) throws Exception {
		ApreciadorBO aprebo = new ApreciadorBO();
	

		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(Color.WHITE);
		framePrincipal = new JFrame();
		framePrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\leo4_\\Desktop\\GrogosPesq.jpg"));
		framePrincipal.setSize(996, 789);
		framePrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		framePrincipal.setLocation(500, 250);

		framePrincipal.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblDetalhesCerveja = new JLabel("Detalhes " + cerveja.getNome());
		lblDetalhesCerveja.setBounds(348, 44, 389, 14);
		panel.add(lblDetalhesCerveja);


		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo.setBounds(94, 147, 46, 14);
		panel.add(lblTipo);

		JLabel lblSabor = new JLabel("Sabor:");
		lblSabor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSabor.setBounds(94, 168, 46, 14);
		panel.add(lblSabor);

		JLabel lblPais = new JLabel("Pais de Origem:");
		lblPais.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPais.setBounds(31, 193, 109, 14);
		panel.add(lblPais);

		JLabel lblColorao = new JLabel("Colora\u00E7\u00E3o:");
		lblColorao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblColorao.setBounds(67, 218, 73, 14);
		panel.add(lblColorao);

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescricao.setBounds(51, 243, 89, 14);
		panel.add(lblDescricao);

		JEditorPane dtrpnDinamic_1 = new JEditorPane();
		dtrpnDinamic_1.setText(cerveja.getDescription());
		dtrpnDinamic_1.setEditable(false);
		dtrpnDinamic_1.setBorder(BorderFactory.createLineBorder(Color.black));
		dtrpnDinamic_1.setBackground(Color.WHITE);
		dtrpnDinamic_1.setBounds(150, 243, 252, 141);
		panel.add(dtrpnDinamic_1);

		JLabel lblTipoCerveja = new JLabel(cerveja.getType().getNome());
		lblTipoCerveja.setBounds(150, 147, 180, 14);
		panel.add(lblTipoCerveja);

		JLabel lblSaborCerveja = new JLabel(cerveja.getFlavor().getNome());
		lblSaborCerveja.setBounds(150, 168, 180, 14);
		panel.add(lblSaborCerveja);

		JLabel lblPaisCerveja = new JLabel(cerveja.getCountryOrigin().getNome());
		lblPaisCerveja.setBounds(150, 193, 180, 14);
		panel.add(lblPaisCerveja);

		JLabel lblColoracaoCerveja = new JLabel(cerveja.getColoracao().getNome());
		lblColoracaoCerveja.setBounds(150, 218, 180, 14);
		panel.add(lblColoracaoCerveja);

		JLabel lblIngredientes = new JLabel("Ingredientes");
		lblIngredientes.setBounds(727, 108, 178, 14);
		panel.add(lblIngredientes);

		JLabel lblAlchool = new JLabel("Teor Alco\u00F3lico:");
		lblAlchool.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlchool.setBounds(648, 147, 89, 14);
		panel.add(lblAlchool);

		JLabel lblCevada = new JLabel("Cevada:");
		lblCevada.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCevada.setBounds(690, 172, 46, 14);
		panel.add(lblCevada);

		JLabel lblMalte = new JLabel("Puro Malte:");
		lblMalte.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMalte.setBounds(627, 199, 109, 14);
		panel.add(lblMalte);

		JLabel lblLupo = new JLabel("Tipo de Lupulo:");
		lblLupo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLupo.setBounds(647, 234, 89, 14);
		panel.add(lblLupo);

		JLabel lblTipoDeFermento = new JLabel("Tipo de Fermento:");
		lblTipoDeFermento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoDeFermento.setBounds(627, 265, 109, 14);
		panel.add(lblTipoDeFermento);

		JLabel lblTipoDeMalte = new JLabel("Tipo de Malte:");
		lblTipoDeMalte.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoDeMalte.setBounds(627, 299, 109, 14);
		panel.add(lblTipoDeMalte);

		JLabel lblEspeciariasAdicionais = new JLabel("Especiarias Adicionais:");
		lblEspeciariasAdicionais.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEspeciariasAdicionais.setBounds(535, 335, 145, 14);
		panel.add(lblEspeciariasAdicionais);

		JEditorPane dtrpnDinamic = new JEditorPane();
		dtrpnDinamic.setEditable(false);
		dtrpnDinamic.setText(cerveja.getIngredientes().getEspeciarias());
		dtrpnDinamic.setBorder(BorderFactory.createLineBorder(Color.black));
		dtrpnDinamic.setBackground(Color.WHITE);
		dtrpnDinamic.setBounds(690, 335, 269, 141);
		panel.add(dtrpnDinamic);

		JLabel lblPorcentagem_1 = new JLabel("%");
		lblPorcentagem_1.setBounds(777, 147, 22, 14);
		panel.add(lblPorcentagem_1);

		JLabel lblPorcentagem = new JLabel("%");
		lblPorcentagem.setBounds(777, 168, 22, 14);
		panel.add(lblPorcentagem);

		JLabel lblAlcoolCerveja = new JLabel(String.valueOf(cerveja.getIngredientes().getTeorAlcoolico()));
		lblAlcoolCerveja.setBounds(749, 147, 46, 14);
		panel.add(lblAlcoolCerveja);

		JLabel lblCevadaCerveja = new JLabel(String.valueOf(cerveja.getIngredientes().getCevada()));
		lblCevadaCerveja.setBounds(746, 172, 46, 14);
		panel.add(lblCevadaCerveja);
		String malte;
		if (cerveja.getIngredientes().getPuroMalte()) {
			malte = "Sim";
		} else {
			malte = "Não";
		}
		JLabel lblPuroMalte = new JLabel(malte);
		lblPuroMalte.setBounds(748, 199, 127, 14);
		panel.add(lblPuroMalte);

		JLabel lblLupuloCerveja = new JLabel(cerveja.getIngredientes().getLupulo().getNome());
		lblLupuloCerveja.setBounds(748, 234, 127, 14);
		panel.add(lblLupuloCerveja);

		JLabel lblFermentoCerveja = new JLabel(cerveja.getIngredientes().getFermento().getNome());
		lblFermentoCerveja.setBounds(748, 265, 127, 14);
		panel.add(lblFermentoCerveja);

		JLabel lblMalteCerveja = new JLabel(cerveja.getIngredientes().getMalte().getNome());
		lblMalteCerveja.setBounds(748, 299, 127, 14);
		panel.add(lblMalteCerveja);

		JLabel lblCaracteristicas = new JLabel("Caracter\u00EDsticas");
		lblCaracteristicas.setBounds(130, 108, 127, 14);
		panel.add(lblCaracteristicas);

		JLabel lblCervejeiro = new JLabel("Cervejeiro");
		lblCervejeiro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCervejeiro.setBounds(94, 473, 102, 14);
		panel.add(lblCervejeiro);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(64, 498, 46, 14);
		panel.add(lblNome);

		JLabel lblNomeCervejeiro = new JLabel(cerveja.getCervejeiro().getNome());
		lblNomeCervejeiro.setBounds(120, 498, 226, 14);
		panel.add(lblNomeCervejeiro);
		
		JLabel lblMsgFavoritar = new JLabel("");
		lblMsgFavoritar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsgFavoritar.setBounds(403, 486, 186, 14);
		panel.add(lblMsgFavoritar);
		

	
		
		if(TelaLogin.usuarioLogado.getClass().getSimpleName().contentEquals("Apreciador")) {
			JButton btnFavoritar = new JButton("Favoritar");
			btnFavoritar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Apreciador apreLogado = (Apreciador) TelaLogin.usuarioLogado;
					
					if(apreLogado.getCervejasFavoritas().contains(cerveja)) {
						lblMsgFavoritar.setForeground(Color.ORANGE);
						lblMsgFavoritar.setText("Cerveja já favoritada");
						return;
					}
					
					apreLogado.addCervejaFavoritas(cerveja);
					
					try {
						aprebo.alterar(apreLogado);
					} catch (Exception e1) {
						lblMsgFavoritar.setForeground(Color.RED);
						lblMsgFavoritar.setText("erro ao favoritar");
						e1.printStackTrace();
						return;
					}
					
					lblMsgFavoritar.setForeground(Color.GREEN);
					lblMsgFavoritar.setText("Cerveja Favoritada");
				
					return;
				}
			});
			btnFavoritar.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnFavoritar.setBackground(new Color(255, 255, 102));
			btnFavoritar.setForeground(new Color(204, 51, 0));
			btnFavoritar.setBounds(416, 452, 157, 23);
			panel.add(btnFavoritar);
		}
		
		
		
		
		
		if(cerveja.getCervejeiro().getCervejaria() != null) {
			
		

		JLabel lblCervejaria = new JLabel("Cervejaria \r");
		lblCervejaria.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCervejaria.setBounds(94, 536, 160, 14);
		panel.add(lblCervejaria);

		JLabel lblCervejariaNome = new JLabel("Nome Cervejaria:");
		lblCervejariaNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCervejariaNome.setBounds(0, 561, 103, 14);
		panel.add(lblCervejariaNome);

		JLabel lblCervejariaEmail = new JLabel("Email:");
		lblCervejariaEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCervejariaEmail.setBounds(59, 593, 46, 14);
		panel.add(lblCervejariaEmail);

		JLabel lblCervejariaTelefone = new JLabel("Telefone:");
		lblCervejariaTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCervejariaTelefone.setBounds(34, 621, 71, 14);
		panel.add(lblCervejariaTelefone);

		JLabel lblCervejariaEndereco = new JLabel("Endere\u00E7o:");
		lblCervejariaEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCervejariaEndereco.setBounds(31, 646, 71, 14);
		panel.add(lblCervejariaEndereco);

		JLabel lblNomeCervejaria = new JLabel(cerveja.getCervejeiro().getCervejaria().getNome());
		lblNomeCervejaria.setBounds(120, 561, 269, 14);
		panel.add(lblNomeCervejaria);

		JLabel lblEmailCervejaria = new JLabel(cerveja.getCervejeiro().getCervejaria().getEmail());
		lblEmailCervejaria.setBounds(120, 593, 269, 14);
		panel.add(lblEmailCervejaria);

		JLabel lblTelefoneCervejaria = new JLabel(cerveja.getCervejeiro().getCervejaria().getTelefone());
		lblTelefoneCervejaria.setBounds(120, 621, 269, 14);
		panel.add(lblTelefoneCervejaria);

		JLabel lblEnderecoCervejaria = new JLabel(cerveja.getCervejeiro().getCervejaria().getEndereco().getNome() + ", "
				+ cerveja.getCervejeiro().getCervejaria().getEndereco().getCidade().getNome() + ", "
				+ cerveja.getCervejeiro().getCervejaria().getEndereco().getCidade().getEstado().getNome());
		lblEnderecoCervejaria.setBounds(117, 646, 485, 14);
		panel.add(lblEnderecoCervejaria);
		}

		framePrincipal.setVisible(true);

	}
}
