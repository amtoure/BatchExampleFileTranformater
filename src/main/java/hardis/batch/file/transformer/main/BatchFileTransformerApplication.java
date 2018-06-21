package hardis.batch.file.transformer.main;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import hardis.batch.file.transformer.config.ProcessSpringConfiguration;
import hardis.batch.file.transformer.process.BatchFileTransformerProcess;

/**
 * Le classe d'entrée du traitement
 *
 */
@Component
public class BatchFileTransformerApplication {
	@Autowired
	static BatchFileTransformerProcess batchFileTransformerProcess;

	public static void main(String[] args) throws IOException {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(ProcessSpringConfiguration.class);
		ctx.refresh();

		BatchFileTransformerProcess app = ctx.getBean(BatchFileTransformerProcess.class);

		String input = args[0];
		String output = args[1];
		String format = args[2];

		// Exemle de test
		/*
		 * app.readTranformerFile(new File("D:\\batch\\in.txt").getAbsolutePath(), new
		 * File("D:\\batch").getAbsolutePath(), "JSON");
		 */

		app.readTranformerFile(input, output, format);

		System.out.println("Fin du Traitement!");
	}
}
