package br.edu.unifacear.validators;

public class ApreciadorValidator {

	private static String regexNumeros = "[0-9]+";
	private static String regexFields = "^[a-zA-Z0-9 ]+$";
	private static String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

	public static boolean validar(String nome, String idade, String email, String senha) {

		if (nome == null || !nome.matches(regexFields)) {
			return false;
		}
		if (idade == null || !idade.matches(regexNumeros)) {
			return false;
		}
		if (email == null || !email.matches(regexEmail)) {
			return false;
		}
		if (senha == null || !senha.matches(regexFields) || senha.length() < 6) {
			return false;
		}

		return true;

	}

}
