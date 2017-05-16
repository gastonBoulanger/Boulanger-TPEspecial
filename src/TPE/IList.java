package TPE;

import java.util.ArrayList;

public interface IList {
	
	public void addUsers(ArrayList<User> users);
	
	public void searchUsers(ArrayList<User> users);
	
	public void saveResult(User user, int size, boolean exists, long result);
}
