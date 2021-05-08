package br.edu.unifacear.validators;



public class CervejaValidator {
	private static String regexFields = "^[a-zA-Z0-9_.-]+$";

	public static boolean validar(String nome, String tipo, String sabor, String pais, String criador,
			String descricao) {

		if (nome == null || !nome.matches(regexFields)) {
			return false;
		}
		if (tipo == null || !tipo.matches(regexFields)) {
			return false;
		}
		if (sabor == null || !sabor.matches(regexFields)) {
			return false;
		}
		if (pais == null || !pais.matches(regexFields)) {
			return false;
		}
		if (criador == null || !criador.matches(regexFields)) {
			return false;
		}
		if (descricao == null) {
			return false;
		}

		return true;

	}
}
