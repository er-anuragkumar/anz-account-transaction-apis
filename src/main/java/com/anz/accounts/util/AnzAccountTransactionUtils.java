package com.anz.accounts.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;

import com.anz.account.constants.AnzAccountTransactionConstants;

/**
 * 
 * @author Kumar, Anurag
 *
 */
public class AnzAccountTransactionUtils {

	public static String getProperty(String propertyName) {

		Properties prop = new Properties();
		try {
			Resource resource = new ClassPathResource(AnzAccountTransactionConstants.PROPERTIES_FILE_NAME);

			InputStream input = resource.getInputStream();
			prop.load(input);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();

		}
		return prop.getProperty(propertyName);
	}

}
