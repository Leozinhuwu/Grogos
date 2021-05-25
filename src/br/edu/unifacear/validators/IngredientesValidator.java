package br.edu.unifacear.validators;

public class IngredientesValidator {

	private static String regex = "[0-9.]+";

	public static boolean validar(String teorAlcoolico, String cevada, String especiarias) {

		if(teorAlcoolico == null || !teorAlcoolico.matches(regex)) {
			return false;
		}
		if(cevada == null || !cevada.matches(regex)) {
			return false;
		}
		
		if(especiarias == null) {
			return false;
		}

		return true;

	}

}
