package com.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestBase {

	
	public Properties prop;
	public int Status_code_200=200;
	
	public TestBase()
	{
		String path_to_prop_file="C:\\Users\\Sreyoshi\\eclipse-workspace\\RestAPI_RestAssured\\RestApi_TEST\\src\\main\\java\\com\\qa\\configuration\\config.properties";
		
		try (InputStream input = new FileInputStream(path_to_prop_file)) {

            prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("URL"));
            System.out.println(prop.getProperty("Api"));
            

        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
	
}
