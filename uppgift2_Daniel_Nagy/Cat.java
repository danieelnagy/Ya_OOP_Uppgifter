package uppgift2_Daniel_Nagy;

public class Cat {

	String name;
	String breed;

	public Cat(String _name, String _breed) {
		name = _name;
		breed = _breed;
	}

	String getName() {
		return name;
	}

	String getBreed() {
		return breed;
	}

	String getOwnerName() {
		Matte matteInCat = new Matte("Owner");
		return matteInCat.name;
	}
}
