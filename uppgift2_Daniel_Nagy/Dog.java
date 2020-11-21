package uppgift2_Daniel_Nagy;

public class Dog {
	private String name;
	private String breed;

	public Dog(String name, String breed) {
		this.name = name;
		this.breed = breed;
	}

	String GetName() {
		return name;
	}

	public void setName(String Name) {
		this.name = Name;
	}

	String GetBreed() {
		return breed;
	}

	public void setBreed(String Breed) {
		this.breed = Breed;
	}

	public String toString() {
		return String.format(name, breed);
	}
}
