package fr.aumjaud.antoine.services.filesearch;

import static spark.Spark.post;

import java.util.Properties;

import fr.aumjaud.antoine.services.common.server.SparkImplementation;
import fr.aumjaud.antoine.services.common.server.SparkLauncher;
import fr.aumjaud.antoine.services.filesearch.requesthandler.FileSearchResource;

public class LaunchServer {

	public static void main(String... args) {

		new SparkLauncher(new SparkImplementation() {

			private FileSearchResource fileSearchResource  = new FileSearchResource();

			@Override
			public String getAppConfigName() {
				return "api-docker.properties";
			}

			@Override
			public void setConfig(Properties appProperties) {
				fileSearchResource.setConfig(appProperties);
			}

			@Override
			public void initSpark(String securePath) {
				post(securePath + "/secure/fileSearchResource/:fileName", fileSearchResource::search);
			} 
		});

	}
}
