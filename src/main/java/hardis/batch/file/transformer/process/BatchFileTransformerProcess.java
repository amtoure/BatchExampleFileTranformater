package hardis.batch.file.transformer.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import hardis.batch.file.transformer.exceptions.Error;
import hardis.batch.file.transformer.exceptions.TechnicalFtfException;
import hardis.batch.file.transformer.model.Color;
import hardis.batch.file.transformer.model.Reference;
import hardis.batch.file.transformer.model.Report;
import hardis.batch.file.transformer.util.ProcessUtils;

/**
 * 
 * @author at2be29n
 *
 */
@Component("BatchFileTransformerProcess")
public class BatchFileTransformerProcess {

	@Autowired
	ObjectMapper ftfJsonObjectMapper;

	@Autowired
	XmlMapper ftfXmlObjectMapper;

	Logger logger = LoggerFactory.getLogger(BatchFileTransformerProcess.class);

	/**
	 * Methode qui permet de lire un ficher en entré et de tranformer en json ou xml
	 * 
	 * @param input
	 * @param output
	 * @param format
	 * @throws IOException
	 */
	public void readTranformerFile(String input, String output, String format) throws IOException {
		String lineItem;
		BufferedReader brint = null;
		int nbreLigne = 0;
		try {

			File inputFile = new File(input);
			brint = new BufferedReader(new FileReader(inputFile));
			Report report = new Report();
			ArrayList<Reference> referenceList = new ArrayList<Reference>();
			ArrayList<Error> erreurList = new ArrayList<Error>();

			report.setInputFile(inputFile.getName());
			while ((lineItem = brint.readLine()) != null) {
				nbreLigne++;
				Reference reference = null;
				try {
					reference = this.lineValidator(lineItem, nbreLigne);
				} catch (TechnicalFtfException e) {
					Error erreur = new Error(nbreLigne, e.getMessage(), lineItem);

					erreurList.add(erreur);

					logger.error(e.getMessage());
					e.printStackTrace();
				} finally {
					if (reference != null)
						referenceList.add(reference);

				}

			}
			report.setReference(referenceList);
			report.setError(erreurList);

			if ("XML".equals(format)) {
				this.lineTransformtoXml(report, output);
			} else if ("JSON".equals(format)) {
				this.lineTransformtoJson(report, output);
			}

		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally {
			if (brint != null)
				brint.close();

		}

	}

	/**
	 * Methode qui permet de valider la ligne du fichier
	 * 
	 * @param lineItem
	 * @param nbreLigne
	 * @return
	 * @throws TechnicalFtfException
	 */
	private Reference lineValidator(String lineItem, int nbreLigne) throws TechnicalFtfException {
		String valueItems[] = lineItem.split(";");
		Long numReference = Long.parseLong(valueItems[0]);

		String color;
		Integer size;
		Double prix;

		Reference reference = new Reference();
		try {
			numReference = Long.parseLong(valueItems[0]);

			if (valueItems[0].length() > 10 || valueItems[0].length() < 10) {
				throw new TechnicalFtfException(nbreLigne, " Incorect Value for numReference ", lineItem);
			}

			reference.setNumReference(numReference);

		} catch (ParseException e) {
			throw new TechnicalFtfException(nbreLigne, "Incorect Value for numReference ", lineItem);

		}

		color = valueItems[1];

		try {
			Color.valueOf(color);

			reference.setColor(color);

		} catch (IllegalArgumentException e) {
			throw new TechnicalFtfException(nbreLigne, "Incorect Value for color ", lineItem);

		}

		try {
			prix = Double.parseDouble(valueItems[2]);

			reference.setPrix(prix);

		} catch (NumberFormatException e) {
			throw new TechnicalFtfException(nbreLigne, "Incorect Value for prix ", lineItem);

		}

		try {
			size = Integer.parseInt(valueItems[3]);

			reference.setSize(size);

		} catch (NumberFormatException e) {
			throw new TechnicalFtfException(nbreLigne, "Incorect Value for size ", lineItem);

		}

		return reference;
	}

	private void lineTransformtoXml(Report report, String output) {
		try {

			ftfXmlObjectMapper.writeValue(new File(output + "/" + ProcessUtils.generateFileName("resultat.xml")),
					report);
		} catch (Exception e) {

			logger.error(e.getMessage());

		}
	}

	private void lineTransformtoJson(Report report, String output) {

		try {
			ftfJsonObjectMapper.writeValue(new File(output + "/" + ProcessUtils.generateFileName("resultat.json")),
					report);
		} catch (Exception e) {

			logger.error(e.getMessage());

		}
	}

}
