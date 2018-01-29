package part1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.tika.Tika;
import org.apache.tika.detect.CompositeDetector;
import org.apache.tika.detect.Detector;
import org.apache.tika.mime.MimeTypes;

/**
 * Utility class for common functionality used accross application
 * 
 * @author Suprabha
 *
 */
public class FileUtil {

	/**
	 * Method used to extract extension from a filename
	 * @param name
	 * @return
	 */

	public static String getFileExtension(String name) {
		return name.substring(name.indexOf('.') + 1);
	}

	/**
	 * To get the Mime type of a file using Apache tika API
	 * @param file
	 * @return String
	 */
	public static String getContentType(File file) {
		try {
			return new Tika(getDefaultDectector()).detect(file);
		} catch (IOException e) {
			e.getStackTrace();
			return null;
		}

	}

	/**
	 * Setting default detectors for tika to give specific mime types
	 * @return Detector
	 */
	private static Detector getDefaultDectector() {
		List<Detector> detectors = new ArrayList<>();
		detectors.add(MimeTypes.getDefaultMimeTypes());
		return new CompositeDetector(detectors);
	}

	/**
	 * Load specific property from properties file
	 * @param key
	 * @return
	 */
	public static String loadProperty(String key) {
		Properties props = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./fileconfig.properties");
			props.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props.getProperty(key);

	}

	/**
	 * Load all the properties from properties file
	 * @param substringKey
	 * @return
	 */
	public static Object[] loadAllProperties(String substringKey) {
		Properties props = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("fileconfig.properties");
			props.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props.keySet().stream().filter(key -> key.toString().contains(substringKey)).toArray();

	}
}