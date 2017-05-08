package TPE;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVWritter {
	BufferedWriter bw = null;

	public void createWritter(String path) {
		try {
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void write(ArrayList<User> users) {
		for (User user : users) {
			try {
				// Escribo la primer linea del archivo
				String contenidoLinea1 = user.getUserId().toString() +/* ";" + String.valueOf(user.getTimeArray()) + ";" + String.valueOf(user.getTimeFirst()) + */ ";" + String.valueOf(user.getTimeLast());
				bw.write(contenidoLinea1);
				bw.newLine();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}