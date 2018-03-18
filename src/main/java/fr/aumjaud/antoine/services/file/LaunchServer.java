package fr.aumjaud.antoine.services.file;

import static spark.Spark.get;

import java.util.Properties;

import fr.aumjaud.antoine.services.common.server.SparkImplementation;
import fr.aumjaud.antoine.services.common.server.SparkLauncher;
import fr.aumjaud.antoine.services.file.requesthandler.FileResource;

public class LaunchServer {

	public static void main(String... args) {

		new SparkLauncher(new SparkImplementation() {

			private FileResource fileResource  = new FileResource();

			@Override
			public String getAppConfigName() {
				return "api-file.properties";
			}

			@Override
			public String getApiName() {
				return "api-file";
			}

			@Override
			public void setConfig(Properties appProperties) {
				fileResource.setConfig(appProperties);
			}

			@Override
			public void initSpark(String securePath) {
				get(securePath + "/search/:fileId", fileResource::search);
			} 
		});

	}
}
