package hardis.batch.file.transformer.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import hardis.batch.file.transformer.exceptions.Error;

@JacksonXmlRootElement(localName = "report")
public class Report implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String inputFile;
	@JacksonXmlElementWrapper(localName = "references")
	private ArrayList<Reference> reference;
	@JacksonXmlElementWrapper(localName = "errors")
	private ArrayList<Error> error;

	/**
	 * @return the inputFile
	 */
	public String getInputFile() {
		return inputFile;
	}

	/**
	 * @param inputFile
	 *            the inputFile to set
	 */
	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	/**
	 * @return the reference
	 */
	public ArrayList<Reference> getReference() {
		return reference;
	}

	/**
	 * @param reference
	 *            the reference to set
	 */
	public void setReference(ArrayList<Reference> reference) {
		this.reference = reference;
	}

	public ArrayList<Error> getError() {
		return error;
	}

	public void setError(ArrayList<Error> error) {
		this.error = error;
	}

}
