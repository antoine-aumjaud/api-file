package fr.aumjaud.antoine.services.secrets.service;

import java.util.Properties;

public class PropertyService {
	//private static final Logger logger = LoggerFactory.getLogger(PropertyService.class);

	private Properties properties;

	/**
	 * Set config 
	 * @param properties the config to set
	 */
	public void setConfig(Properties properties) {
		this.properties = properties;
	}

	/**
	 * Get the value of a property
	 * @param propertyName the property used to get value from property file
	 * @return the value of the property
	 */
	public String get(String propertyName) {
		return properties.getProperty("property." + propertyName);
	}
}
