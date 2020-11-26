package uppgift2_Daniel_Nagy;

public class Matte {

	String name;
	Cat mattesCat = new Cat("HisCat", "Perser");

	public Matte(String name) {
		this.name = name;
	}

	String GetCatName() {
		return mattesCat.name;
	}

	String GetInfo() {
		return name + " " + mattesCat.getName() + " " + mattesCat.getBreed();
	}
}
