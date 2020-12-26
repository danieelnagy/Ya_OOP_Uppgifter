package uppgift5_Daniel_Nagy;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

class Serialization {

	private static final String SERIALIZED_FILE_NAME="readfileUppgift5";
	
	void serializeToXML(ArrayList<Konto> s) throws IOException {
		
		XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(SERIALIZED_FILE_NAME)));
		e.writeObject(s);
		e.close();
	}
	
	ArrayList<Konto> deserializeFromXML() {
		XMLDecoder decoder = null;
			try {
				decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(SERIALIZED_FILE_NAME)));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println("File stream opened and XMLDecoder created");
			System.out.println("Reading Object...");
			ArrayList<Konto> getAccAndPw = (ArrayList<Konto>) decoder.readObject();
			System.out.println("Reading Object Done!");
			decoder.close();
			return getAccAndPw;
	}
}