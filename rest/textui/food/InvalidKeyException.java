package rest.textui.food;

import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Launched when a type of food is of the wrong type.
 */
public class InvalidKeyException extends InvalidOperation {
	/**
	 * Class serial number (serialization).
	 */
	private static final long serialVersionUID = 201207120943L;

	/** The key */
	private final String _key;

	/**
	 * @param key
	 *            food key
	 */
	public InvalidKeyException(String key) {
		_key = key;
	}

	/**
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	@SuppressWarnings("nls")
	public String getMessage() {
		return "O alimento '" + _key + "' não é um alimento agregado.";
	}
}
