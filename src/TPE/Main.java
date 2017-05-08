package TPE;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "";
		CSVReader csvr = new CSVReader();
		ArrayList<User> users = csvr.reader("C:/Users/USER/Documents/Universidad/Tudai/2017/Programacion3/Boulanger-TPEspecial/datasets/dataset_3000000.csv");
		//String[] newUsers = csvr.reader(path);
		//String[] searchUsers = csvr.reader(path);
		//Working with array
		UserLinkedListLast ull = new UserLinkedListLast();
		ull.addUsers(users);
		CSVWritter csvw = new CSVWritter();
		csvw.createWritter("C:/Users/USER/Documents/Universidad/Tudai/2017/Programacion3/Boulanger-TPEspecial/datasets/result.csv");
		csvw.write(users);
		//UserListArray ula = new UserListArray();
		//ula.importUserList(users);
		//UserLinkedList lista = new UserLinkedList();
		//lista.importUserList(users);
		//ula.addUsers(newUsers);
	}

}
