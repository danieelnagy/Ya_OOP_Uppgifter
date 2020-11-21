package uppgift2_Daniel_Nagy;

public class DemoDogCat {

	public static void main(String[] args) {

		// Uppgift 1
		Cat cat = new Cat("Aloy", "Grumpy");
		Dog dog = new Dog("Daisy", "Yorkie");
		System.out.println("Uppgift 1:\n");
		System.out.println(cat.GetName() + " " + cat.GetBreed() + "\n" + dog.GetName() + " " + dog.GetBreed() + "\n");

		// Uppgift 2
		Matte matte = new Matte("Jonas");
		System.out.println("Uppgift 2:\n");
		System.out.println(matte.GetInfo() + "\n");

		// Uppgift 3
		System.out.println("Uppgift 3:\n");
		Husse husse = new Husse("HusseFarmBoss");
		husse.SetAttributes();
		husse.PrintAnimal();

		// Uppgift 4
		System.out.println("\nUppgift 4:\n");
		System.out.println(matte.name + " is the owner of " + matte.catName);
	}

}
