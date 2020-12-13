package uppgift4_Daniel_Nagy;

import java.io.Serializable;

class Person implements Serializable {

	private static final long serialVersionUID = -8430765870555791111L;
	private String firstName;
	private String lastName;
	private String age;

	public Person(String firstName, String lastName, String age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String GetFirstName() {
		return firstName;
	}

	public void setName(String newFirstName) {
		this.firstName = newFirstName;
	}

	public String GetLastName() {
		return lastName;
	}

	public void setLastName(String newLastName) {
		this.lastName = newLastName;
	}

	public String GetAge() {
		return age;
	}

	public void setAge(String newAge) {
		this.age = newAge;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}
	
	
}
