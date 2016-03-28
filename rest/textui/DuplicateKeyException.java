package rest.textui;

import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Launched when a duplicate key is used.
 */
public class DuplicateKeyException extends InvalidOperation {
	/**
	 * Class serial number (serialization).
	 */
	private static final long serialVersionUID = 201207120943L;

	/** The key */
	private final String _key;

	/**
	 * @param key
	 *            object key
	 */
	public DuplicateKeyException(String key) {
		_key = key;
	}

	/**
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	@SuppressWarnings("nls")
	public String getMessage() {
		return "A entidade com o identificador '" + _key + "' já existe.";
	}
}
