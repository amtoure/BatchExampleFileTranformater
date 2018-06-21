package hardis.batch.file.transformer;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import hardis.batch.file.transformer.model.Report;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class BatchFileTransformerApplicationTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public BatchFileTransformerApplicationTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(BatchFileTransformerApplicationTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}

	@org.junit.Test
	public void whenJavaSerializedToXmlFile_thenCorrect() throws IOException {
		XmlMapper xmlMapper = new XmlMapper();
		xmlMapper.writeValue(new File("simple_bean.xml"), new Report());
		File file = new File("simple_bean.xml");
		assertNotNull(file);
	}
}
