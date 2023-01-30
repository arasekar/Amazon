package com.Property;

import java.io.IOException;

public class ConfigurationHealper {
	
	private ConfigurationHealper() {
	}
	
	public static ConfigurationReader getInstance() throws IOException {
	ConfigurationReader reader=new ConfigurationReader();
	return reader;

	}

}
