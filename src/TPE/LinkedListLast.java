package TPE;

public class LinkedListLast extends LinkedList {

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

	@Override
	public void saveResult(User user, int size, boolean exists, long result) {
		// TODO Auto-generated method stub
		if (size <= 500000) {
			user.setExists("500k", exists);
			user.setTimeLast("500k", result);
		} else if (size <= 1000000) {
			user.setExists("1m", exists);
			user.setTimeLast("1m", result);
		} else {
			user.setExists("3m", exists);
			user.setTimeLast("3m", result);
		}
	}
}
