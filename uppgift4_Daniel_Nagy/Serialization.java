package uppgift4_Daniel_Nagy;

import java.beans.ExceptionListener;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;

class Serialization {

	
	/*List<Person> pers;

	public List<Person> getPers() {
		return pers;
	}

	public void setPers(List<Person> pers) {
		this.pers = pers;
	}*/
	
	void serializeToXML(ArrayList<String> s) throws IOException {
		
		XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Test.xml")));
		e.writeObject(s);
		e.close();
		
	}
}
