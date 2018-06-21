package hardis.batch.file.transformer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * configuration spring
 * 
 * @author AN35826N
 *
 */
@Configuration
@ComponentScan(basePackages = { "hardis.batch.file.transformer" })
public class ProcessSpringConfiguration {

	@Bean("FtfJsonObjectMapper")
	@Primary
	public ObjectMapper getObjectMapper() {

		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		return mapper;
	}

	@Bean("FtfXmlObjectMapper")
	public XmlMapper getObjectMapperXml() {

		XmlMapper xmlMapper = new XmlMapper();

		xmlMapper.setSerializationInclusion(Include.NON_NULL);
		xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

		return xmlMapper;
	}

}
