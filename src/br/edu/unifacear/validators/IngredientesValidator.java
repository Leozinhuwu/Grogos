package br.edu.unifacear.validators;

public class IngredientesValidator {

	private static String regexFields = "^[a-zA-Z0-9_.-]+$";
	private static String regex = "[0-9]+";

	public static boolean validar(String teorAlcoolico, String cevada, String lupulo, String fermento, String especiarias) {

		if(teorAlcoolico == null || !teorAlcoolico.matches(regex)) {
			return false;
		}
		if(cevada == null || !cevada.matches(regex)) {
			return false;
		}
		if(lupulo == null || !lupulo.matches(regexFields)) {
			return false;
		}
		if(fermento == null || !fermento.matches(regexFields)) {
			return false;
		}
		if(especiarias == null) {
			return false;
		}

		return true;

	}

}
