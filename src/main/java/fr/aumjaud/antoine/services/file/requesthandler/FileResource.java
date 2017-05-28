package fr.aumjaud.antoine.services.file.requesthandler;

import java.util.Properties;

import fr.aumjaud.antoine.services.common.security.WrongRequestException;
import fr.aumjaud.antoine.services.file.service.FileService;
import spark.Request;
import spark.Response;

public class FileResource {
	//private static final Logger logger = LoggerFactory.getLogger(FileResource.class);

	private FileService fileService = new FileService();

	/**
	 * Set config 
	 * @param properties the config to set
	 */
	public void setConfig(Properties properties) {
		fileService.setConfig(properties);
	}

	/**
	 * Search for something in a file
	 */
	public String search(Request request, Response response) {
		String fileId = request.params("fileId");
		if(fileId == null)
			throw new WrongRequestException("fieldId not defined", "The filedId path paramater is mandatory");

		String searchValue = request.queryParams("search");
		if(searchValue == null)
			throw new WrongRequestException("value to search not defined", "The search value query paramater is mandatory");
		
		return fileService.search(fileId, searchValue);
	}
}
