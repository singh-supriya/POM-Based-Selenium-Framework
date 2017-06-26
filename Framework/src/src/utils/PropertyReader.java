package src.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	String path = getFilePath();

	public String readApplicationFile(final String key) {
		String value = "";
		try {
			final Properties prop = new Properties();
			final File f = new File(path
					+ "//resources//application.properties");

			if (f.exists()) {
				prop.load(new FileInputStream(f));
				value = prop.getProperty(key);
			}
		} catch (final Exception e) {
			System.out
					.println("Failed to read from application.properties file.");
		}
		return value;
	}

	public String getFilePath() {
		String filepath = "";
		final File file = new File("");
		final String absolutePathOfFirstFile = file.getAbsolutePath();
		filepath = absolutePathOfFirstFile.replaceAll("\\\\+", "/");

		return filepath;
	}

	/*
	 * public void updateProperty(final String key, final String value) { final
	 * Properties props = new Properties(); final String propsFileName = path +
	 * "//src//test//resources//config//" + env + "//storeHosueHold.properties";
	 * try { // first load old property file: final FileInputStream configStream
	 * = new FileInputStream( propsFileName); props.load(configStream);
	 * configStream.close();
	 * 
	 * // modifies new property props.setProperty(key, value);
	 * 
	 * // save modified property file final FileOutputStream output = new
	 * FileOutputStream(propsFileName); props.store(output, ""); output.close();
	 * 
	 * } catch (final IOException ex) { System.out.println(ex); } }
	 */

	public String readTestData(final String key) {
		String value = "";
		try {
			final Properties prop = new Properties();
			final File f = new File(path + "//resources//testData.properties//");
			if (f.exists()) {
				prop.load(new FileInputStream(f));
				value = prop.getProperty(key);
			}
		} catch (final Exception e) {
			System.out
					.println("Failed to read from application.properties file.");
		}
		return value;
	}

	public void updatePropertyTestData(final String key, final String value) {
		final Properties props = new Properties();
		final String propsFileName = path
				+ "//resources//testData.properties//";
		try {
			// first load old property file:
			final FileInputStream configStream = new FileInputStream(
					propsFileName);
			props.load(configStream);
			configStream.close();

			// modifies new property
			props.setProperty(key, value);

			// save modified property file
			final FileOutputStream output = new FileOutputStream(propsFileName);
			props.store(output, "");
			output.close();

		} catch (final IOException ex) {
			System.out.println(ex);
		}
	}

}
