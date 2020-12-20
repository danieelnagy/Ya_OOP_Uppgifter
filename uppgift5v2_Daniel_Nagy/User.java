package uppgift5v2_Daniel_Nagy;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

class User {
	private final ReadOnlyStringWrapper userName; // Kommer inte kunna ändras iom final och ReadOnly
	private StringProperty password;

	public User() {
		userName = new ReadOnlyStringWrapper(this, "userName", "JOZSI");
		password = new SimpleStringProperty(this, "password", "");
	}

	public final String getUserName() {
		return userName.get();
	}

	public ReadOnlyStringProperty userNameProperty() {
		return userName.getReadOnlyProperty();
	}

	public final String getPassword() {
		return password.get();
	}

	public StringProperty passwordProperty() {
		return password;
	}
}
