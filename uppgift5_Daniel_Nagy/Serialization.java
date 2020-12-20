package uppgift5_Daniel_Nagy;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

class Serialization {

	private static final String SERIALIZED_FILE_NAME="readfile";
	
	void serializeToXML(String string) throws IOException {
		
		XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(SERIALIZED_FILE_NAME)));
		e.writeObject(string);
		e.close();
	}
	void deserializeFromXML(String string) throws IOException {
		/* FUNKAR EJ bortse */
		FileInputStream fis = new FileInputStream(SERIALIZED_FILE_NAME);
	    XMLDecoder decoder = new XMLDecoder(fis);
	    ArrayList<String> list = (ArrayList<String>) decoder.readObject();
	    for(var i : list) {
	    	System.out.println(i);
	    }
	    decoder.close();
	    fis.close();
	}
}