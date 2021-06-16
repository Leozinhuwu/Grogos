package br.edu.unifacear.telas;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import br.edu.unifacear.bo.ApreciadorBO;
import br.edu.unifacear.classes.Apreciador;
import br.edu.unifacear.classes.Cerveja;
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

	public void telaDetalhesCerveja(Cerveja cerveja) throws Exception {
		ApreciadorBO aprebo = new ApreciadorBO();

		JPanel panel = new JPanel();
		panel.setForeground(Color.RED);
		panel.setBackground(new Color(244, 164, 96));
		framePrincipal = new JFrame();
		framePrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\leo4_\\Desktop\\GrogosPesq.jpg"));
		framePrincipal.setSize(996, 789);
		framePrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		framePrincipal.setLocation(500, 250);

		framePrincipal.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblDetalhesCerveja = new JLabel("Detalhes " + cerveja.getNome());
		lblDetalhesCerveja.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblDetalhesCerveja.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetalhesCerveja.setBounds(297, 25, 389, 14);
		panel.add(lblDetalhesCerveja);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo.setBounds(73, 147, 46, 14);
		panel.add(lblTipo);

		JLabel lblSabor = new JLabel("Sabor:");
		lblSabor.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblSabor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSabor.setBounds(73, 186, 46, 14);
		panel.add(lblSabor);

		JLabel lblPais = new JLabel("Pa\u00EDs de Origem:");
		lblPais.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblPais.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPais.setBounds(10, 223, 109, 14);
		panel.add(lblPais);

		JLabel lblColorao = new JLabel("Colora\u00E7\u00E3o:");
		lblColorao.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblColorao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblColorao.setBounds(30, 265, 89, 14);
		panel.add(lblColorao);

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblDescricao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescricao.setBounds(10, 335, 89, 14);
		panel.add(lblDescricao);

		JEditorPane dtrpnDinamic_1 = new JEditorPane();
		dtrpnDinamic_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		dtrpnDinamic_1.setText(cerveja.getDescription());
		dtrpnDinamic_1.setEditable(false);
		dtrpnDinamic_1.setBorder(BorderFactory.createLineBorder(Color.black));
		dtrpnDinamic_1.setBackground(Color.WHITE);
		dtrpnDinamic_1.setBounds(105, 335, 252, 141);
		panel.add(dtrpnDinamic_1);

		JLabel lblTipoCerveja = new JLabel(cerveja.getType().getNome());
		lblTipoCerveja.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipoCerveja.setBounds(129, 147, 180, 14);
		panel.add(lblTipoCerveja);

		JLabel lblSaborCerveja = new JLabel(cerveja.getFlavor().getNome());
		lblSaborCerveja.setHorizontalAlignment(SwingConstants.LEFT);
		lblSaborCerveja.setBounds(129, 186, 180, 14);
		panel.add(lblSaborCerveja);

		JLabel lblPaisCerveja = new JLabel(cerveja.getCountryOrigin().getNome());
		lblPaisCerveja.setHorizontalAlignment(SwingConstants.LEFT);
		lblPaisCerveja.setBounds(129, 223, 180, 14);
		panel.add(lblPaisCerveja);

		JLabel lblColoracaoCerveja = new JLabel(cerveja.getColoracao().getNome());
		lblColoracaoCerveja.setHorizontalAlignment(SwingConstants.LEFT);
		lblColoracaoCerveja.setBounds(130, 265, 180, 14);
		panel.add(lblColoracaoCerveja);

		JLabel lblIngredientes = new JLabel("Ingredientes");
		lblIngredientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngredientes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIngredientes.setBounds(648, 108, 178, 14);
		panel.add(lblIngredientes);

		JLabel lblAlchool = new JLabel("Teor Alco\u00F3lico:");
		lblAlchool.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblAlchool.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlchool.setBounds(609, 147, 128, 14);
		panel.add(lblAlchool);

		JLabel lblCevada = new JLabel("Cevada:");
		lblCevada.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblCevada.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCevada.setBounds(658, 172, 78, 14);
		panel.add(lblCevada);

		JLabel lblMalte = new JLabel("Puro Malte:");
		lblMalte.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblMalte.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMalte.setBounds(627, 199, 109, 14);
		panel.add(lblMalte);

		JLabel lblLupo = new JLabel("Tipo de Lupulo:");
		lblLupo.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblLupo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLupo.setBounds(609, 234, 127, 14);
		panel.add(lblLupo);

		JLabel lblTipoDeFermento = new JLabel("Tipo de Fermento:");
		lblTipoDeFermento.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblTipoDeFermento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoDeFermento.setBounds(609, 265, 127, 14);
		panel.add(lblTipoDeFermento);

		JLabel lblTipoDeMalte = new JLabel("Tipo de Malte:");
		lblTipoDeMalte.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblTipoDeMalte.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoDeMalte.setBounds(627, 299, 109, 14);
		panel.add(lblTipoDeMalte);

		JLabel lblEspeciariasAdicionais = new JLabel("Especiarias Adicionais:");
		lblEspeciariasAdicionais.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblEspeciariasAdicionais.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEspeciariasAdicionais.setBounds(509, 335, 171, 14);
		panel.add(lblEspeciariasAdicionais);

		JEditorPane dtrpnDinamic = new JEditorPane();
		dtrpnDinamic.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		dtrpnDinamic.setEditable(false);
		dtrpnDinamic.setText(cerveja.getIngredientes().getEspeciarias());
		dtrpnDinamic.setBorder(BorderFactory.createLineBorder(Color.black));
		dtrpnDinamic.setBackground(Color.WHITE);
		dtrpnDinamic.setBounds(690, 335, 269, 141);
		panel.add(dtrpnDinamic);

		JLabel lblPorcentagem_1 = new JLabel("%");
		lblPorcentagem_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPorcentagem_1.setBounds(777, 147, 22, 14);
		panel.add(lblPorcentagem_1);

		JLabel lblPorcentagem = new JLabel("%");
		lblPorcentagem.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPorcentagem.setBounds(777, 172, 22, 14);
		panel.add(lblPorcentagem);

		JLabel lblAlcoolCerveja = new JLabel(String.valueOf(cerveja.getIngredientes().getTeorAlcoolico()));
		lblAlcoolCerveja.setHorizontalAlignment(SwingConstants.LEFT);
		lblAlcoolCerveja.setBounds(747, 147, 35, 14);
		panel.add(lblAlcoolCerveja);

		JLabel lblCevadaCerveja = new JLabel(String.valueOf(cerveja.getIngredientes().getCevada()));
		lblCevadaCerveja.setHorizontalAlignment(SwingConstants.LEFT);
		lblCevadaCerveja.setBounds(747, 172, 35, 14);
		panel.add(lblCevadaCerveja);
		String malte;
		if (cerveja.getIngredientes().getPuroMalte()) {
			malte = "Sim";
		} else {
			malte = "Não";
		}
		JLabel lblPuroMalte = new JLabel(malte);
		lblPuroMalte.setBounds(748, 199, 200, 14);
		panel.add(lblPuroMalte);

		JLabel lblLupuloCerveja = new JLabel(cerveja.getIngredientes().getLupulo().getNome());
		lblLupuloCerveja.setHorizontalAlignment(SwingConstants.LEFT);
		lblLupuloCerveja.setBounds(748, 234, 200, 14);
		panel.add(lblLupuloCerveja);

		JLabel lblFermentoCerveja = new JLabel(cerveja.getIngredientes().getFermento().getNome());
		lblFermentoCerveja.setHorizontalAlignment(SwingConstants.LEFT);
		lblFermentoCerveja.setBounds(748, 265, 200, 14);
		panel.add(lblFermentoCerveja);

		JLabel lblMalteCerveja = new JLabel(cerveja.getIngredientes().getMalte().getNome());
		lblMalteCerveja.setHorizontalAlignment(SwingConstants.LEFT);
		lblMalteCerveja.setBounds(748, 299, 200, 14);
		panel.add(lblMalteCerveja);

		JLabel lblCaracteristicas = new JLabel("Caracter\u00EDsticas");
		lblCaracteristicas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaracteristicas.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCaracteristicas.setBounds(73, 107, 136, 14);
		panel.add(lblCaracteristicas);

		JLabel lblCervejeiro = new JLabel("Informa\u00E7\u00F5es Cervejeiro");
		lblCervejeiro.setHorizontalAlignment(SwingConstants.CENTER);
		lblCervejeiro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCervejeiro.setBounds(67, 508, 190, 14);
		panel.add(lblCervejeiro);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(49, 533, 64, 14);
		panel.add(lblNome);

		JLabel lblNomeCervejeiro = new JLabel(cerveja.getCervejeiro().getNome());
		lblNomeCervejeiro.setBounds(119, 533, 226, 14);
		panel.add(lblNomeCervejeiro);

		JLabel lblMsgFavoritar = new JLabel("");
		lblMsgFavoritar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsgFavoritar.setBounds(747, 563, 186, 14);
		panel.add(lblMsgFavoritar);

		if (TelaLogin.usuarioLogado.getClass().getSimpleName().contentEquals("Apreciador")) {
			JButton btnFavoritar = new JButton("Favoritar");
			btnFavoritar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Apreciador apreLogado = (Apreciador) TelaLogin.usuarioLogado;

					if (apreLogado.getCervejasFavoritas().contains(cerveja)) {
						lblMsgFavoritar.setForeground(Color.RED.darker());
						lblMsgFavoritar.setText("Cerveja já favoritada");
						return;
					}

					apreLogado.addCervejaFavoritas(cerveja);

					try {
						aprebo.alterar(apreLogado);
					} catch (Exception e1) {
						lblMsgFavoritar.setForeground(Color.RED.darker());
						lblMsgFavoritar.setText("erro ao favoritar");
						e1.printStackTrace();
						return;
					}

					lblMsgFavoritar.setForeground(Color.GREEN.darker());
					lblMsgFavoritar.setText("Cerveja Favoritada");

					return;
				}
			});
			btnFavoritar.setFont(new Font("Arial Black", Font.BOLD, 12));
			btnFavoritar.setBackground(new Color(255, 69, 0));
			btnFavoritar.setForeground(new Color(0, 0, 0));
			btnFavoritar.setBounds(747, 529, 169, 23);
			panel.add(btnFavoritar);
		}

		if (cerveja.getCervejeiro().getCervejaria() != null) {

			JLabel lblCervejaria = new JLabel("Informa\u00E7\u00F5es Cervejaria \r");
			lblCervejaria.setHorizontalAlignment(SwingConstants.CENTER);
			lblCervejaria.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblCervejaria.setBounds(73, 571, 184, 14);
			panel.add(lblCervejaria);

			JLabel lblCervejariaNome = new JLabel("Nome Cervejaria:");
			lblCervejariaNome.setFont(new Font("Arial Black", Font.BOLD, 11));
			lblCervejariaNome.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCervejariaNome.setBounds(0, 596, 113, 14);
			panel.add(lblCervejariaNome);

			JLabel lblCervejariaEmail = new JLabel("Email:");
			lblCervejariaEmail.setFont(new Font("Arial Black", Font.BOLD, 11));
			lblCervejariaEmail.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCervejariaEmail.setBounds(49, 621, 64, 14);
			panel.add(lblCervejariaEmail);

			JLabel lblCervejariaTelefone = new JLabel("Telefone:");
			lblCervejariaTelefone.setFont(new Font("Arial Black", Font.BOLD, 11));
			lblCervejariaTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCervejariaTelefone.setBounds(42, 646, 71, 14);
			panel.add(lblCervejariaTelefone);

			JLabel lblCervejariaEndereco = new JLabel("Endere\u00E7o:");
			lblCervejariaEndereco.setFont(new Font("Arial Black", Font.BOLD, 11));
			lblCervejariaEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCervejariaEndereco.setBounds(30, 671, 83, 14);
			panel.add(lblCervejariaEndereco);

			JLabel lblNomeCervejaria = new JLabel(cerveja.getCervejeiro().getCervejaria().getNome());
			lblNomeCervejaria.setBounds(119, 596, 269, 14);
			panel.add(lblNomeCervejaria);

			JLabel lblEmailCervejaria = new JLabel(cerveja.getCervejeiro().getCervejaria().getEmail());
			lblEmailCervejaria.setBounds(119, 621, 269, 14);
			panel.add(lblEmailCervejaria);

			JLabel lblTelefoneCervejaria = new JLabel(cerveja.getCervejeiro().getCervejaria().getTelefone());
			lblTelefoneCervejaria.setBounds(119, 646, 269, 14);
			panel.add(lblTelefoneCervejaria);

			JLabel lblEnderecoCervejaria = new JLabel(cerveja.getCervejeiro().getCervejaria().getEndereco().getNome()
					+ ", " + cerveja.getCervejeiro().getCervejaria().getEndereco().getCidade().getNome() + ", "
					+ cerveja.getCervejeiro().getCervejaria().getEndereco().getCidade().getEstado().getNome());
			lblEnderecoCervejaria.setBounds(118, 671, 485, 14);
			panel.add(lblEnderecoCervejaria);
		}

		framePrincipal.setVisible(true);

	}
}
