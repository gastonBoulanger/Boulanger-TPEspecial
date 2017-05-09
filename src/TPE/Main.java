package TPE;

import java.util.ArrayList;

public class Main {
	private final static String pathPrevious = "C:/Users/USER/Documents/Universidad/Tudai/2017/Programacion3/Boulanger-TPEspecial/datasets/dataset_500000.csv";
	private final static String pathNew = "C:/Users/USER/Documents/Universidad/Tudai/2017/Programacion3/Boulanger-TPEspecial/datasets/dataset_insert_10000.csv";
	private final static String pathSearch = "C:/Users/USER/Documents/Universidad/Tudai/2017/Programacion3/Boulanger-TPEspecial/datasets/dataset_busqueda_10000.csv";
	private final static String resultSearch = "C:/Users/USER/Documents/Universidad/Tudai/2017/Programacion3/Boulanger-TPEspecial/datasets/salidabusqueda.csv";
	private final static String resultUploading = "C:/Users/USER/Documents/Universidad/Tudai/2017/Programacion3/Boulanger-TPEspecial/datasets/salidaalta.csv";
	private ArrayList<User> loadUsers = new ArrayList<User>();
	private ArrayList<User> searchUsers = new ArrayList<User>();
	private ArrayList<User> newUsers = new ArrayList<User>();
	private UserLinkedListFirst ullf;
	private UserLinkedListLast ulll;
	private UserArray ua;
	
	public static void main(String[] args) {
		//Load previous users
		readUsers(pathPrevious, loadUsers);
		ullf = new UserLinkedListFirst();
		ullf.addUsers(loadUsers);
		ulll = new UserLinkedListLast();
		ulll.addUsers(loadUsers);
		ua = new UserArray();
		ua.addUsers(loadUsers);
		loadUsers();
		searchUsers();
	}
	private void loadUsers(){
		readUsers(pathNew, newUsers);
		ullf.addUsers(newUsers);
		ulll.addUsers(newUsers);
		ua.addUsers(newUsers);
		saveResult(resultUploading, newUsers);
	}
	
	private void searchUsers(){
		readUsers(pathSearch, searchUsers);
		ullf.searchUsers(searchUsers);
		ulll.searchUsers(searchUsers);
		ua.searchUsers(searchUsers);
		saveResult(resultSearch, searchUsers);
	}
	
	private void readUsers(String path, ArrayList<User> users){
		CSVReader csvr = new CSVReader();
		users = csvr.reader(path);
	}
	
	private void saveResult(String path, ArrayList<User> users){
		CSVWritter csvw = new CSVWritter();
		csvw.createWritter(path);
		csvw.write(users);
	}
}
