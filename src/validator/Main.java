package validator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Main {
	public final static void main(String args[]) throws ParserConfigurationException,
			FileNotFoundException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		DocumentBuilder builder;
		builder = factory.newDocumentBuilder();
		long startTime = 0;
		long endTime = 0;

		InputStream is;

		Document doc;
		try {
			for (int i = 0; i < 21; i++) {
				is = new FileInputStream(args[0]);
				startTime = System.currentTimeMillis();
				doc = builder.parse(is);
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
	}
}
