package uppgift4_Daniel_Nagy;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = -8430765870555791111L;
	private String firstName;
    private String lastName;
    private String age;

    public Person() {
    }

    public Person(String firstName, String lastName, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}
