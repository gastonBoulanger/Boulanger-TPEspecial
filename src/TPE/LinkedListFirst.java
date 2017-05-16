package TPE;

public class LinkedListFirst extends LinkedList {

	public void insertUser(User user) {
		user.setNext(first);
		first = user;
		size++;
	}

	@Override
	public void saveResult(User user, int size, boolean exists, long result) {
		// TODO Auto-generated method stub
		if (size <= 500000) {
			user.setExists("500k", exists);
			user.setTimeFirst("500k", result);
		} else if (size <= 1000000) {
			user.setExists("1m", exists);
			user.setTimeFirst("1m", result);
		} else {
			user.setExists("3m", exists);
			user.setTimeFirst("3m", result);
		}
	}
}
