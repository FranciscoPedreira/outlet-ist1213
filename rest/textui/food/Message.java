package rest.textui.food;

/**
 * Messages.
 */
@SuppressWarnings("nls")
public class Message {

	/**
	 * @return prompt for food key
	 */
	public static final String reqKey() {
		return "Identificador do alimento (nome): ";
	}

	/**
	 * @return prompt for food type
	 */
	public static final String reqType() {
		return "Tipo de alimento (MEAT, FISH ou VEGETABLE): ";
	}

	/**
	 * @return prompt for food name
	 */
	public static final String reqName() {
		return "Nome a dar ao alimento: ";
	}

	/**
	 * @return prompt for percentage
	 */
	public static final String reqPercentage() {
		return "Percentagem do alimento (inteiro entre 0 e 100): ";
	}

	/**
	 * @return prompt for calories
	 */
	public static final String reqCalories() {
		return "Calorias por grama a associar ao alimento (inteiro): ";
	}

	/**
	 * @return "MEAT" tag
	 */
	public static final String typeMeat() {
		return "MEAT";
	}
	
	/**
	 * @return FISH tag
	 */
	public static final String typeFish() {
		return "FISH";
	}

	/**
	 * @return VEGETABLE tag
	 */
	public static final String typeVegetable() {
		return "VEGETABLE";
	}
	
	/**
	 * @return VEG tag
	 */
	public static final String typeVeg() {
		return "VEG";
	}
	
	/**
	 * @return NOVEG tag
	 */
	public static final String typeNoVeg() {
		return "NOVEG";
	}

	/**
	 * @return VEG tag
	 */
	public static final String available() {
		return "AVAILABLE";
	}
	
	/**
	 * @return NOVEG tag
	 */
	public static final String unavailable() {
		return "UNAVAILABLE";
	}
	

}
