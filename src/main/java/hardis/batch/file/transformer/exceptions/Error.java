package hardis.batch.file.transformer.exceptions;

import java.io.Serializable;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 
 * @author AT2BE29N
 *
 */
@JacksonXmlRootElement(localName = "error")
public class Error implements Serializable {

	private static final long serialVersionUID = -3168204673839742346L;

	private int ligne;
	private String message;
	private String valeur;

	/**
	 * 
	 * @param code
	 * @param libelle
	 */
	public Error(int ligne, String message, String valeur) {
		super();
		this.setLigne(ligne);
		this.message = message;
		this.valeur = valeur;
	}

	/**
	 * CodeLibelleErreur
	 */
	public Error() {
		super();
	}

	public String getCode() {
		return message;
	}

	public void setCode(String code) {
		this.message = code;
	}

	public String getLibelle() {
		return valeur;
	}

	public void setLibelle(String libelle) {
		this.valeur = libelle;
	}

	public int getLigne() {
		return ligne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

}
