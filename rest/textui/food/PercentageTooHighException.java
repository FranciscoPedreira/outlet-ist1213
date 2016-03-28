package rest.textui.food;

import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Launched when the sum of all percentages is greater than 100.
 */
public class PercentageTooHighException extends InvalidOperation {
	/**
	 * Class serial number (serialization).
	 */
	private static final long serialVersionUID = 201207120943L;

	/** The wrong number */
	private final int _sum;

	/**
	 * @param sum
	 *            sum of all percentages
	 */
	public PercentageTooHighException(int sum) {
		_sum = sum;
	}

	/**
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	@SuppressWarnings("nls")
	public String getMessage() {
		return "A soma das percentagens introduzidas é '" + _sum + "' (excede o máximo permitido que é 100).";
	}
}
