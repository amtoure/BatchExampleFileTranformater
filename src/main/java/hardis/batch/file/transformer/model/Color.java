package hardis.batch.file.transformer.model;

public enum Color {

	R("Rouge"),
	G ("Vert"),
    B ("Bleu");
	  private String code ;
	/**
	 * @param code
	 * @param valeur
	 */
	private Color(String code) {
		this.code =code;
 	}
	public String toString(){

	    return code;

	  }

}
