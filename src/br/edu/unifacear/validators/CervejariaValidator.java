package br.edu.unifacear.validators;

public class CervejariaValidator {
	private static String regexNumeros = "[0-9]+";
	private static String regexFields = "^[a-zA-Z0-9 ]+$";
	private static String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

	public static boolean validar(String nome, String email, String telefone, String endereco) {

		if (nome == null || !nome.matches(regexFields)) {
			return false;
		}

		if (email == null || !email.matches(regexEmail)) {
			return false;
		}

		if (telefone == null || !telefone.matches(regexNumeros)) {
			return false;
		}

		if (endereco == null || endereco.isBlank()) {
			return false;
		}

		return true;

	}

}
