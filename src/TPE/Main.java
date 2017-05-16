package TPE;

import java.util.ArrayList;
import java.util.Date;

public class Main {
	final static String pathEje = "C:/Users/USER/Documents/Universidad/Tudai/2017/Programacion3/Boulanger-TPEspecial/datasets/dataset_eje.csv";
	final static String path500k = "C:/Users/USER/Documents/Universidad/Tudai/2017/Programacion3/Boulanger-TPEspecial/datasets/dataset_500000.csv";
	final static String path1m = "C:/Users/USER/Documents/Universidad/Tudai/2017/Programacion3/Boulanger-TPEspecial/datasets/dataset_1000000.csv";
	final static String path3m = "C:/Users/USER/Documents/Universidad/Tudai/2017/Programacion3/Boulanger-TPEspecial/datasets/dataset_3000000.csv";
	final static String pathNew = "C:/Users/USER/Documents/Universidad/Tudai/2017/Programacion3/Boulanger-TPEspecial/datasets/dataset_insert_10000.csv";
	final static String pathSearch = "C:/Users/USER/Documents/Universidad/Tudai/2017/Programacion3/Boulanger-TPEspecial/datasets/dataset_busqueda_10000.csv";
	final static String resultSearch = "C:/Users/USER/Documents/Universidad/Tudai/2017/Programacion3/Boulanger-TPEspecial/datasets/salidabusqueda.csv";
	final static String resultInsert = "C:/Users/USER/Documents/Universidad/Tudai/2017/Programacion3/Boulanger-TPEspecial/datasets/salidaalta.csv";

	public static void main(String[] args) {

		ArrayList<User> load500k = new ArrayList<User>();
		ArrayList<User> load1m = new ArrayList<User>();
		ArrayList<User> load3m = new ArrayList<User>();
		ArrayList<User> searchUsers = new ArrayList<User>();
		ArrayList<User> insertUsers = new ArrayList<User>();
		Date init = new Date();
		// Read scv
		CSVReader csvr = new CSVReader();
		load500k = csvr.reader(path500k);
		CSVReader csvr1 = new CSVReader();
		load1m = csvr1.reader(path1m);
		CSVReader csvr3 = new CSVReader();
		load3m = csvr3.reader(path3m);
		CSVReader csvrsSearch = new CSVReader();
		searchUsers = csvrsSearch.reader(pathSearch);
		CSVReader csvrsInsert = new CSVReader();
		insertUsers = csvrsInsert.reader(pathNew);
		System.out.println("End read csv");
		// execute in 500k
		execute(load500k, searchUsers, insertUsers);
		// Execute in 1m
		execute(load1m, searchUsers, insertUsers);
		// Execute in 1m
		execute(load3m, searchUsers, insertUsers);
		// Generate csv with results
		// Generate csv results searchs
		CSVWritter csvw = new CSVWritter();
		csvw.createWritter(resultSearch);
		csvw.write(searchUsers);
		System.out.println("termino");
		// Generate csv with result insert
		CSVWritter csvwIn = new CSVWritter();
		csvwIn.createWritter(resultInsert);
		csvwIn.write(insertUsers);
		printTime(init);
		System.out.println("termino");
	}

	private static void execute(ArrayList<User> load, ArrayList<User> searchUsers, ArrayList<User> insertUsers) {
		// TODO Auto-generated method stub

		// UserLinkedListFist
		Date init = new Date();
		// Preload
		LinkedListFirst ullf;
		ullf = new LinkedListFirst();
		ullf.addUsers(load);
		// Insert
		ullf.addUsers(insertUsers);
		// Search
		ullf.searchUsers(searchUsers);
		printTime(init);
		System.out.println("end search ullf");

		// User linked list last
		Date init2 = new Date();
		LinkedListLast ulll;
		//Preload
		ulll = new LinkedListLast();
		ulll.addUsers(load);
		// Insert New
		ulll.addUsers(insertUsers);
		// Search
		ulll.searchUsers(searchUsers);
		printTime(init2);
		System.out.println("end search ulll");

		// User array
		Date init3 = new Date();
		ArrayL ua;
		// Preload
		ua = new ArrayL();
		ua.addUsers(load);
		// Insert new
		ua.insertUsers(insertUsers);
		// Search
		ua.searchUsers(searchUsers);
		printTime(init3);
		System.out.println("end search array");

	}

	private static void printTime(Date init) {
		Date end = new Date();
		long result = end.getTime() - init.getTime();
		System.out.println(result);
	}
}