package uppgift5_Daniel_Nagy;

import java.io.FileWriter;
import java.io.IOException;

public class Save {

	public void SaveAcc() {
		try {
			FileWriter myWriter = new FileWriter("kvitto.txt");
			for (int i = 0; i < CreateAccountPage.list.size(); i++) {
				myWriter.write(CreateAccountPage.list.get(i).getUserName() + " " + CreateAccountPage.list.get(i).getPassword() + " "
						+ CreateAccountPage.list.get(i).getDate() + " " + CreateAccountPage.list.get(i).getBalance());
				myWriter.close();
				System.out.println("Successfully wrote to the file.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
