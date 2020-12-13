package uppgift4_Daniel_Nagy;

class Person implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
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
	 public void setName(String newFirstName) {
		    this.firstName = newFirstName;
		  }
	String GetLastName() {
		return lastName;
	}
	 public void setLastName(String newLastName) {
		    this.lastName = newLastName;
		  }
	String GetAge() {
		return age;
	}
	 public void setAge(String newAge) {
		    this.age = newAge;
		  }
}
