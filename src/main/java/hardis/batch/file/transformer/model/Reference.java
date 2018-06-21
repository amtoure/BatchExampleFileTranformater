package hardis.batch.file.transformer.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "reference")
public class Reference {

	private Long numReference;
	private String color;
	private Integer size;
	private Double prix;

	public Reference() {
		super();

	}

	/**
	 * @param numReference
	 * @param color
	 * @param size
	 * @param prix
	 */
	public Reference(Long numReference, String color, Integer size, Double prix) {
		super();
		this.numReference = numReference;
		this.color = color;
		this.size = size;
		this.prix = prix;
	}

	/**
	 * @return the numReference
	 */
	public Long getNumReference() {
		return numReference;
	}

	/**
	 * @param numReference
	 *            the numReference to set
	 */
	public void setNumReference(Long numReference) {
		this.numReference = numReference;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the size
	 */
	public Integer getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(Integer size) {
		this.size = size;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Article [numReference=" + numReference + ", color=" + color + ", size=" + size + "]";
	}
}
