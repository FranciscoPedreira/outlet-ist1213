package rest.textui.restaurant;

import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Launched when an operation cannot be aplied to a main course.
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
		return "A operação não pode ser executada no prato '" + _key + "'.";
	}
}
