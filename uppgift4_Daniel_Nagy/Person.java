package uppgift4_Daniel_Nagy;

class Person {
	
	private String firstName;
	private String lastName;
	private String age;
	
	public Person(String firstName, String lastName, String age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	String GetFirstName() {
		return firstName;
	}
	String GetLastName() {
		return lastName;
	}
	String GetAge() {
		return age;
	}
}
