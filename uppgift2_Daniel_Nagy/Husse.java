package uppgift2_Daniel_Nagy;

import java.util.ArrayList;

public class Husse {
	
	String husseName;
	static ArrayList<Dog> dog = new ArrayList<Dog>();
	
	public Husse(String _husseName)
	{
		husseName = _husseName;
	}
	
	void SetAttributes()
	{
		for(int i = 0;i < 5;i++)
		{
			Dog doggy = new Dog("Goodboi", "Doggos");
			dog.add(doggy);
		}
	}
	void PrintAnimal()
	{
		for(var i : dog)
		{
			System.out.println(husseName + " has some " + i.GetName() + " " + i.GetBreed());
		}
	}
}
