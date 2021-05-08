package br.edu.unifacear.validators;

public class UsuarioValidator {

	private static String regex = "[0-9]+";
	private static String regexFields = "^[a-zA-Z0-9_.-]+$";
	private static String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

	public static boolean validar(String nome, String idade, String email, String senha) {

		
		if(nome == null || !nome.matches(regexFields)) {
			return false;
		}
		if(idade == null || !idade.matches(regex)) {
			return false;
		}
		if(email == null || !email.matches(regexEmail)) {
			return false;
		}
		if(senha == null || !senha.matches(regexFields)) {
			return false;
		}

		return true;

	}

}
