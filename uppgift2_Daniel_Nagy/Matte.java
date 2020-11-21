package uppgift2_Daniel_Nagy;

public class Matte {
	
	String name;
	String catName = "HisCat";
	Cat mattesCat = new Cat(catName, "Perser");
	public Matte(String name)
	{
		this.name = name;
	}
	String GetCatName()
	{
		return catName;
	}
	String GetInfo()
	{
		return name + " " + mattesCat.GetName() + " " + mattesCat.GetBreed();
	}
}
