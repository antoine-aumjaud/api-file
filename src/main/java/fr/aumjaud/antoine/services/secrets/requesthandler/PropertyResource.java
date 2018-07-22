package fr.aumjaud.antoine.services.secrets.requesthandler;

import java.util.Properties;

import fr.aumjaud.antoine.services.common.security.WrongRequestException;
import fr.aumjaud.antoine.services.secrets.service.PropertyService;
import spark.Request;
import spark.Response;

public class PropertyResource {
	//private static final Logger logger = LoggerFactory.getLogger(PropertyResource.class);

	private PropertyService propertyService = new PropertyService();

	/**
	 * Set config 
	 * @param properties the config to set
	 */
	public void setConfig(Properties properties) {
		propertyService.setConfig(properties);
	}

	/**
	 * Get a property
	 */
	public String get(Request request, Response response) {
		String propertyName = request.params("propertyName");
		if(propertyName == null)
			throw new WrongRequestException("propertyName not defined", "The propertyName paramater is mandatory");
		
		return propertyService.get(propertyName);
	}
}
