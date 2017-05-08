package TPE;

import java.util.ArrayList;
import java.util.Date;

public class UserLinkedListLast extends UserLinkedList {

	public void insertFinal(User user) {// INSERTA AL FINAL
		if (super.first == null) {
			super.first = user;
			super.last = first;
		} else {
			super.last.setNext(user);
			super.last = user;
		}
		super.size++;
	}
	
	@Override
	public void addUsers(ArrayList<User> users) {
		// TODO Auto-generated method stub
		System.out.println("hola!");
		Date init = new Date();
		for(User user : users){
			insertFinal(user);
			Date end = new Date();
			long result = end.getTime() - init.getTime();
			user.setTimeLast(result);
		}
		Date end = new Date();
		long result = end.getTime() - init.getTime();
		System.out.println("chau");
		System.out.println(result);
	}
}
