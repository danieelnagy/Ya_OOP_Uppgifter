package uppgift4_Daniel_Nagy;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


class Serialization {

	private static final String SERIALIZED_FILE_NAME="readfile";
	/*List<Person> pers;

	public List<Person> getPers() {
		return pers;
	}

	public void setPers(List<Person> pers) {
		this.pers = pers;
	}*/
	
	void serializeToXML(ArrayList<String> s) throws IOException {
		
		XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(SERIALIZED_FILE_NAME)));
		e.writeObject(s);
		e.close();
	}
	
	void deserializeFromXML() throws IOException {
		
		FileInputStream fis = new FileInputStream(SERIALIZED_FILE_NAME);
	    XMLDecoder decoder = new XMLDecoder(fis);
	    Person person = (Person) decoder.readObject();
	    decoder.close();
	    fis.close();
	}
}
