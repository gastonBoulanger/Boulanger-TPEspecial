package TPE;

import java.util.ArrayList;
import java.util.Date;

public class UserLinkedListFirst extends UserLinkedList {
	
	public void insertUser(User user){
		user.setNext(first);
		first = user;
		size++;
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
