package hardis.batch.file.transformer.exceptions;

public abstract class FtfException extends Exception {
	private static final long serialVersionUID = 1L;
	private int ligne;
	private String value;

	/**
	 * Constructeur
	 * 
	 * @param ligne
	 *            numero de la ligne
	 * @param message
	 *            message d'erreur
	 * @param value
	 *            valuer de la ligne
	 */
	public FtfException(int ligne, String message, String value) {
		super(message);
		this.ligne = ligne;
		this.value = value;
	}

	/**
	 * @return the ligne
	 */
	public int getLigne() {
		return ligne;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

}
