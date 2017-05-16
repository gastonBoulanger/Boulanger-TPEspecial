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
		String k500 = "500k";
		String m1 = "1m";
		String m3 = "3m";
		String head = "ID;Exist in 500k;Time in Array 500;Time in ListFirst 500;Time in list last 500;Exist in 1M;Time in Array 1M;Time in ListFirst 1M;Time in list last 1M;Exist in 3M;Time in Array 3M;Time in ListFirst 3M;Time in list last 3M ";
		int i= 0;
		for (User user : users) {
			try {
				if(i == 0){
					bw.write(head);
					bw.newLine();
					i++;
				}
				String time500k= user.exists(k500) + ";" + user.getTimeArray(k500)+ ";" + user.getTimeFirst(k500) + ";" +  user.getTimeLast(k500);
				String time1m = user.exists(m1) + ";" + user.getTimeArray(m1)+ ";" + user.getTimeFirst(m1) + ";" +  user.getTimeLast(m1);
				String time3m = user.exists(m3) + ";" + user.getTimeArray(m3)+ ";" + user.getTimeFirst(m3) + ";" +  user.getTimeLast(m3);
				String contenidoLinea = user.getUserId().toString() + ";" + time500k + ";" + time1m + ";" + time3m;
				bw.write(contenidoLinea);
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