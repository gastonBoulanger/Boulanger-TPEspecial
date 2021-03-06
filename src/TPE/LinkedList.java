package TPE;

import java.util.ArrayList;
import java.util.Date;

public abstract class LinkedList implements IList {
	protected User first;
	protected User last;
	protected int size = 0;
	
	public void insertUser(User user){
		// TODO Auto-generated method stub
		
	};
	
	@Override
	public void addUsers(ArrayList<User> users) {
		// TODO Auto-generated method stub
		Date init = new Date();
		for(User user : users){
			Date initU = new Date();
			insertUser(user);
			Date end = new Date();
			long result = end.getTime() - initU.getTime();
			saveResult(user, size, false, result);
		}
		Date end = new Date();
		long result = end.getTime() - init.getTime();
		System.out.println(result);
	}

	@Override
	public void searchUsers(ArrayList<User> usersQuery) {
		for (User user : usersQuery) {
			boolean found = false;
			User userTemp = first;
			Date init = new Date();
			int i = 0;
			while(!found && (i < size)){
				if(userTemp.getUserId().equals(user.getUserId())){
					found = true;
				}
				else{
					if(userTemp.hasNext()){
						userTemp = userTemp.getNext();
					}
				}
				i++;
			}
			Date end = new Date();
			long result = end.getTime() - init.getTime();
			saveResult(user, size, found, result);
		}
	}

	@Override
	public void saveResult(User user, int size, boolean exists, long result) {
		// TODO Auto-generated method stub
		
	}

}
