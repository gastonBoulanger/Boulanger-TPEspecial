package TPE;

import java.util.ArrayList;
import java.util.Date;

public class UserLinkedListLast extends UserLinkedList {

	@Override
	public void insertUser(User user) {// INSERTA AL FINAL
		if (first == null) {
			first = user;
			last = first;
		} else {
			last.setNext(user);
			last = user;
		}
		super.size++;
	}
}
