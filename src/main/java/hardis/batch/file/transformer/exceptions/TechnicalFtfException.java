package hardis.batch.file.transformer.exceptions;

public class TechnicalFtfException extends FtfException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructeur pour une exception technique maîtrisée par l'application
     *
     * 
     */
    public TechnicalFtfException(int ligne ,String  message ,String valeur) {
        super(ligne,message,valeur);
}

}