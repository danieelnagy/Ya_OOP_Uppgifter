package uppgift4_Daniel_Nagy;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.ObservableList;

class Serialization {

	private static final String SERIALIZED_FILE_NAME = "list.xml";

	void serializeToXML(ArrayList<Person> s) throws IOException {

		XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(SERIALIZED_FILE_NAME)));
		e.writeObject(s);
		e.flush();
		e.close();
	}

	ArrayList<Person> deserializeFromXML() {
		XMLDecoder decoder = null;

		try {
			decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(SERIALIZED_FILE_NAME)));

			System.out.println("File stream opened and XMLDecoder created");
			System.out.println("Reading Object...");
			ArrayList<Person> personList = (ArrayList<Person>) decoder.readObject();
			System.out.println("Reading Object Done!");
			decoder.close();
			return personList;
		} catch (FileNotFoundException fileNotFound) {
			System.out.println(SERIALIZED_FILE_NAME + " not found");
		}
		return null;
	}
}
