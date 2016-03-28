package rest.textui.outlet;

import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Launched when a unknown key is used.
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
	 *            publication key
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
		return "O prato pretendido com a chave '" + _key + "' não está disponível.";
	}
}
