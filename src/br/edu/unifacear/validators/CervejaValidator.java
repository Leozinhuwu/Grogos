package br.edu.unifacear.validators;



public class CervejaValidator {
	private static String regexFields = "^[a-zA-Z0-9 ]+$";

	public static boolean validar(String nome,
			String descricao) {

		if (nome == null || !nome.matches(regexFields)) {
			return false;
		}
	
		
		if (descricao == null) {
			return false;
		}

		return true;

	}
}
