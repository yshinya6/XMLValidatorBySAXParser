package validator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

public class Main {
	public final static void main(String args[]) throws ParserConfigurationException,
			FileNotFoundException {
		try {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		XMLReader xmlReader = parser.getXMLReader();
			try {
				xmlReader
						.setFeature("http://xml.org/sax/features/validation", true);
			} catch (SAXNotRecognizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SAXNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		long startTime = 0;
		long endTime = 0;

		InputStream is;

		try {
			for (int i = 0; i < 10; i++) {
				is = new FileInputStream(args[0]);
				startTime = System.currentTimeMillis();
				xmlReader.parse(new InputSource(is));
				endTime = System.currentTimeMillis();
				System.out.println(endTime - startTime + "[ms]");
				is.close();
			}
		} catch (SAXException e) {
			System.out.println("INVALID XML FILE");
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
		System.out.println("VALID XML FILE");
		System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
