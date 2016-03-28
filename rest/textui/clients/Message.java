package rest.textui.clients;

/**
 * Messages.
 */
@SuppressWarnings("nls")
public class Message {

	/**
	 * @return prompt for key
	 */
	public static final String reqKey() {
		return "Identificador do cliente (e-mail): ";
	}

	/**
	 * @return prompt for client type
	 */
	public static final String reqType() {
		return "Tipo de cliente (OMNIVOROUS ou VEGETARIAN): ";
	}

	/**
	 * @return prompt for name
	 */
	public static final String reqName() {
		return "Nome do cliente: ";
	}
	
	/**
	 * @return prompt for email
	 */
	public static final String reqEmail() {
		return "Email do cliente: ";
	}
	
	/**
	 * @return prompt for pretended alert type
	 */
	public static final String reqJoinAlertType() {
		return "Tipo de alerta pretendido (DISCOUNT ou NOVELTY): ";
	}
	
	/**
	 * @return prompt for pretended alert type
	 */
	public static final String reqLeaveAlertType() {
		return "Tipo de alerta não pretendido (DISCOUNT ou NOVELTY): ";
	}
	
	/**
	 * @return tag for normal clients
	 */
	public static final String clientTypeOmnivorous() {
		return "OMNIVOROUS";
	}
	
	/**
	 * @return tag for vegetarian clients
	 */
	public static final String clientTypeVegetarian() {
		return "VEGETARIAN";
	}
	
	/**
	 * @return tag for normal clients
	 */
	public static final String alertTypeDiscount() {
		return "DISCOUNT";
	}
	
	/**
	 * @return tag for vegetarian clients
	 */
	public static final String alertTypeNovelty() {
		return "NOVELTY";
	}
	
	/**
	 * @param dotd 
	 * @return message for DISCOUNT alert messages
	 */
	public static final String alertDiscount(String dotd) {
		return "O prato do dia +++" + dotd + "+++ tem um novo desconto. Aproveite agora!!!";
	}
	
	/**
	 * @param dotd 
	 * @return message for NOVELTY alert messages
	 */
	public static final String alertNovelty(String dotd) {
		return "Está disponível um novo prato do dia: +++" + dotd + "+++. Não quer experimentar hoje?";
	}
}
