package fr.aumjaud.antoine.services.secrets.service;

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
	public void search_should_return_the_value_if_search_value_exists() {
		// Given
		properties.put("file.file1.path", "src/test/resources/file1.txt");
		properties.put("file.search.regexp", "(.*\\n){0,2}.*$VALUE(.*\\n){0,3}");
		
		// When
		String result = fileService.search("file1", "myvalue");

		// Then
		assertEquals("4  \n5  \nmyvalue  \n6  \n7  \n", result);
	}
	@Test
	public void search_should_return_null_if_searched_value_does_not_exists() {
		// Given
		properties.put("file.file1.path", "src/test/resources/file1.txt");
		properties.put("file.search.regexp", "(.*\\n){0,2}.*$VALUE(.*\\n){0,3}");
		
		// When
		String result = fileService.search("file1", "myvalue2");

		// Then
		assertEquals(null, result);
	}

}
