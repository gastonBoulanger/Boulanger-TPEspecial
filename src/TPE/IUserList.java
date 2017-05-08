package TPE;

import java.util.ArrayList;

public interface IUserList {

	public void importUserList(ArrayList<User> users);
	
	public void addUsers(ArrayList<User> users);
	
	public void searchUsers(ArrayList<User> users);
	
	public void saveResult();
}
