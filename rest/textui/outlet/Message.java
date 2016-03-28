package rest.textui.outlet;

/**
 * Messages.
 */
@SuppressWarnings("nls")
public class Message {

	/**
	 * @return string with prompt for filename to open.
	 */
	public static final String openFile() {
		return "Ficheiro a abrir: ";
	}

	/**
	 * @return string with prompt for filename to save.
	 */
	public static final String saveFile() {
		return "Ficheiro a guardar: ";
	}

	/**
	 * @return string with "file not found" message.
	 */
	public static final String fileNotFound() {
		return "O ficheiro não existe.";
	}

	/**
	 * @return prompt for client email
	 */
	public static final String reqClientId() {
		return "Identificador do cliente (e-mail): ";
	}

	/**
	 * @return prompt for main course
	 */
	public static final String reqDishOfTheDayName() {
		return "Prato do dia a encomendar (nome): ";
	}

	/**
	 * @return prompt for main course
	 */
	public static final String reqQuantity() {
		return "Número de doses a encomendar: ";
	}

	/**
	 * @return prompt for restaurant choice
	 */
	public static final String reqRestId() {
		return "Em que restaurante pretende efetuar a encomenda (nome): ";
	}

	/**
	 * @return tag for vegetarian dishes of the day
	 */
	public static final String typeVeg() {
		return "VEG";
	}

	/**
	 * @return tag for non vegetarian dishes of the day
	 */
	public static final String typeNoVeg() {
		return "NOVEG";
	}

}