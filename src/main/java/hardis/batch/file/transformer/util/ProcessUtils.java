package hardis.batch.file.transformer.util;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * composant utilitaire de process
 * 
 *
 *
 */
public class ProcessUtils {

	static Logger logger = LoggerFactory.getLogger(ProcessUtils.class);

	private static final String DATE_PATTERN = "yyyy-MM-dd-HH-mm-ss-SSS-";

	private ProcessUtils() {

	}

	/**
	 * 
	 * @param suffixe
	 *            suffixe du nom du fichier
	 * @return retourne le nom du fichier : suffixe
	 */
	public static String generateFileName(String suffixe) {

		SimpleDateFormat formatDate = new SimpleDateFormat(DATE_PATTERN);

		StringBuilder stringBuilder = new StringBuilder();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		stringBuilder.append(formatDate.format(timestamp));
		stringBuilder.append(Thread.currentThread().getId());
		stringBuilder.append("-");
		stringBuilder.append(suffixe);

		return stringBuilder.toString();
	}

	/**
	 * permet de dire si le repetoire contient un fichier
	 * 
	 * @param directoryPath
	 *            repertoire
	 * @return retourne true si il y un fichier
	 */
	public static boolean hasContext(String directoryPath) {
		File directory = new File(directoryPath);

		if (!directory.exists() || !directory.isDirectory()) {
			return false;
		} else if (directory.listFiles() != null && directory.listFiles().length > 0) {
			return true;
		}
		return false;
	}

}
