package fr.aumjaud.antoine.services.fileSearch.requesthandler;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.aumjaud.antoine.services.common.security.NoAccessException;
import fr.aumjaud.antoine.services.common.security.WrongRequestException;
import spark.Request;
import spark.Response;

public class FileSearchResource {
	private static final Logger logger = LoggerFactory.getLogger(FileSearchResource.class);

	private Properties properties;

	/**
	 * Set config 
	 * @param properties the config to set
	 */
	public void setConfig(Properties properties) {
		this.properties = properties;
		fileSearchService.setConfig(properties);
	}

	/**
	 * Search for something in a file
	 */
	public String search(Request request, Response response) {
		return null;
	}
}
