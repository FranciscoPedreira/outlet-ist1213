package rest.textui.outlet;

import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Launched when inappropriate keys are used.
 */
public class NotAdequateException extends InvalidOperation {
	/**
	 * Class serial number (serialization).
	 */
	private static final long serialVersionUID = 201207120943L;

	/** The food key. */
	private final String _foodKey;

	/** The client key. */
	private final String _clientKey;

	/**
	 * @param foodKey 
	 * @param clientKey 
	 */
	public NotAdequateException(String foodKey, String clientKey) {
		_foodKey = foodKey;
		_clientKey = clientKey;
	}

	/**
	 * @return the food key
	 */
	public String getFoodKey() {
		return _foodKey;
	}

	/**
	 * @return the client key
	 */
	public String getClientKey() {
		return _clientKey;
	}

	/**
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	@SuppressWarnings("nls")
	public String getMessage() {
		return "O prato pretendido com o nome '" + _foodKey + "' não é apropriado para o client '" + _clientKey + "'.";
	}
}
