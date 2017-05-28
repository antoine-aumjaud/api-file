package fr.aumjaud.antoine.services.file.service;

import static org.junit.Assert.assertEquals;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

public class FileServiceTest {

	private Properties properties;
	private FileService fileService = new FileService();

	@Before
	public void init() {
		properties = new Properties();
		fileService.setConfig(properties);
	}

	@Test
	public void search_should_return__the_value_get_container_command_if_exists() {
		// Given
		properties.put("file.file1.path", "src/test/resources/file1.txt");
		properties.put("file.search.regexp", "(.*\\n)?(.*\\n)?.*$VALUE.*(.*\\n)?(.*\\n)?(.*\\n)?");
		
		// When
		String result = fileService.search("file1", "myvalue");
		//(.*\n)?(.*\n)?.*myvalue.*(.*\n)?(.*\n)?(.*\n)?

		// Then
		assertEquals("4\n5\nmyvalue\n6\n7\n", result);
	}

}
