package TPE;

import java.util.ArrayList;
import java.util.Date;

public class UserLinkedList implements IUserList {
	protected User first;
	protected User last;
	protected int size = 0;
	@Override
	public void importUserList(ArrayList<User> users) {
		first = users.get(0);
		
	}
	public void insertFirst(User user){
		user.setNext(first);
		first = user;
		size++;
	}
	
	@Override
	public void addUsers(ArrayList<User> users) {
		// TODO Auto-generated method stub
		System.out.println("hola!");
		Date init = new Date();
		for(User user : users){
			insertFirst(user);
			Date end = new Date();
			long result = end.getTime() - init.getTime();
			user.setTimeFirst(result);
		}
		Date end = new Date();
		long result = end.getTime() - init.getTime();
		System.out.println("chau");
		System.out.println(result);
	}
	public void insertOrdenado(User user) { //INSERTA ORDENADO 

		//User user = new User();
		if (first == null) {
			first = user;
		} else {
			if (user.compareTo(first) > 0) {
				user.setNext(first);
				first = user;
			} else {
				User currentUser = first;
				while ((currentUser.getNext() != null) && (user.compareTo(currentUser.getNext()) > 0)) {
					currentUser = currentUser.getNext();
				}
				user.setNext(currentUser.getNext());
				currentUser.setNext(user);
			}
		}
		size++;
	}
	@Override
	public void searchUsers(ArrayList<User> users) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveResult() {
		// TODO Auto-generated method stub
		
	}

}
