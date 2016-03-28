package rest.textui.restaurants;

/**
 * Messages.
 */
@SuppressWarnings("nls")
public class Message {

	/**
	 * @return prompt for restaurant key
	 */
	public static final String reqKey() {
		return "Identificador do restaurante (nome): ";
	}

	/**
	 * @return prompt for restaurant name
	 */
	public static final String reqName() {
		return "Nome do restaurante: ";
	}

	/**
	 * @return prompt for e-mail
	 */
	public static final String reqEmail() {
		return "E-mail do restaurante: ";
	}

}