package fr.aumjaud.antoine.services.secrets;

import static spark.Spark.get;

import java.util.Properties;

import fr.aumjaud.antoine.services.common.server.spark.SparkImplementation;
import fr.aumjaud.antoine.services.common.server.spark.SparkLauncher;
import fr.aumjaud.antoine.services.secrets.requesthandler.FileResource;
import fr.aumjaud.antoine.services.secrets.requesthandler.PropertyResource;

public class LaunchServer {

	public static void main(String... args) {

		new SparkLauncher(new SparkImplementation() {

			private FileResource fileResource  = new FileResource();
			private PropertyResource propertyResource  = new PropertyResource();

			@Override
			public String getAppConfigName() {
				return "api-secrets.properties";
			}

			@Override
			public String getApiName() {
				return "api-secrets";
			}

			@Override
			public void setConfig(Properties appProperties) {
				fileResource.setConfig(appProperties);
				propertyResource.setConfig(appProperties);
			}

			@Override
			public void initSpark(String securePath) {
				get(securePath + "/files/:fileId", fileResource::search);
				get(securePath + "/properties/:propertyName", propertyResource::get);
			} 
		});

	}
}
