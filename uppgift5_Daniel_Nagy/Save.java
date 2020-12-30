package uppgift5_Daniel_Nagy;

import java.io.FileWriter;
import java.io.IOException;

public class Save {

	public void SaveAcc() {
		try {
			FileWriter myWriter = new FileWriter("kvitto.txt");
			for (int i = 0; i < SceneTwo.list.size(); i++) {
				myWriter.write(SceneTwo.list.get(i).getUserName() + " " + SceneTwo.list.get(i).getPassword() + " "
						+ SceneTwo.list.get(i).getDate() + " " + SceneTwo.list.get(i).getBalance());
				myWriter.close();
				System.out.println("Successfully wrote to the file.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
